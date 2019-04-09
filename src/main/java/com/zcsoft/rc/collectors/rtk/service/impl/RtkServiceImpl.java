package com.zcsoft.rc.collectors.rtk.service.impl;

import com.zcsoft.rc.collectors.api.rtk.entity.RtkCollectReq;
import com.zcsoft.rc.collectors.app.components.websocket.Rc;
import com.zcsoft.rc.collectors.rc.service.RcService;
import com.zcsoft.rc.collectors.rtk.service.RtkService;
import com.zcsoft.rc.collectors.user.service.UserService;
import com.zcsoft.rc.user.model.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RtkServiceImpl implements RtkService {

    private UserService userService;
    private RcService rcService;

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Resource
    public void setRcService(RcService rcService) {
        this.rcService = rcService;
    }

    @Override
    public void collect(RtkCollectReq req) {
        User user = userService.getUserByWristStrapCode(req.getId());

        Rc rc = new Rc();
        rc.setId(user.getId());
        rc.setType(user.getBuilderUserType());
        rc.setLongitude(req.getLongitude());
        rc.setLatitude(req.getLatitude());

        rcService.collect(rc);
    }
}
