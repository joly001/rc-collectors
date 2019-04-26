package com.zcsoft.rc.collectors.rtk.service.impl;

import com.zcsoft.rc.collectors.api.rtk.entity.RtkCollectReq;
import com.zcsoft.rc.collectors.app.components.tcp.TcpServerApplication;
import com.zcsoft.rc.collectors.app.components.websocket.Rc;
import com.zcsoft.rc.collectors.machinery.service.MachineryService;
import com.zcsoft.rc.collectors.rc.service.RcService;
import com.zcsoft.rc.collectors.rtk.service.RtkService;
import com.zcsoft.rc.collectors.user.service.UserService;
import com.zcsoft.rc.machinery.model.entity.Machinery;
import com.zcsoft.rc.user.model.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RtkServiceImpl implements RtkService, InitializingBean {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    private Map<String, String> machineryMap = new ConcurrentHashMap<>(200);

    private UserService userService;
    private RcService rcService;
    private MachineryService machineryService;

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Resource
    public void setRcService(RcService rcService) {
        this.rcService = rcService;
    }
    @Resource
    public void setMachineryService(MachineryService machineryService) {
        this.machineryService = machineryService;
    }

    protected boolean collectUser(RtkCollectReq req) {
        User user = userService.getUserByWristStrapCode(req.getId());

        if(user == null) {
            return false;
        }

        Rc rc = new Rc();
        rc.setId(user.getId());
        rc.setType(user.getBuilderUserType());
        rc.setWristStrapCode(user.getWristStrapCode());
        rc.setLongitude(req.getLongitude());
        rc.setLatitude(req.getLatitude());

        rcService.collect(rc);

        return true;
    }

    protected boolean collectMachinery(RtkCollectReq req) {
        Machinery machinery = machineryService.getMachineryByWristStrapCode(req.getId());

        if(machinery == null) {
            return false;
        }

        Rc rc = new Rc();
        rc.setId(machinery.getId());
        rc.setType(User.BUILDER_USER_TYPE_LOCOMOTIVE);
        rc.setWristStrapCode(req.getId());
        rc.setLongitude(req.getLongitude());
        rc.setLatitude(req.getLatitude());

        rcService.collect(rc);

        machineryMap.put(req.getId(), req.getId());

        return true;
    }

    @Override
    public void collect(RtkCollectReq req) {

        if(machineryMap.get(req.getId()) != null) {
            collectMachinery(req);

            return;
        }

        boolean collectFlag = collectUser(req);
        if(collectFlag) {
            return;
        }

        collectFlag = collectMachinery(req);
        if(collectFlag) {
            return;
        }

        logger.error("Equipment not registered, equipment:{}", req);

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        TcpServerApplication.setRtkService(this);
    }
}
