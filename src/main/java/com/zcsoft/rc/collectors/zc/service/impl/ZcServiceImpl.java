package com.zcsoft.rc.collectors.zc.service.impl;

import com.zcsoft.rc.collectors.api.zc.entity.ZcReq;
import com.zcsoft.rc.collectors.app.components.LocationComponent;
import com.zcsoft.rc.collectors.app.components.websocket.Rc;
import com.zcsoft.rc.collectors.rc.service.RcService;
import com.zcsoft.rc.collectors.zc.service.ZcService;
import com.zcsoft.rc.user.model.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ZcServiceImpl implements ZcService {

    private RcService rcService;
    private LocationComponent locationComponent;

    @Resource
    public void setRcService(RcService rcService) {
        this.rcService = rcService;
    }
    @Resource
    public void setLocationComponent(LocationComponent locationComponent) {
        this.locationComponent = locationComponent;
    }

    @Override
    public void collect(ZcReq req) {
        LocationComponent.Coordinate coordinate = locationComponent.gcj02To84(req.getLongitude(), req.getLatitude());
        req.setLongitude(coordinate.getLongitude());
        req.setLatitude(coordinate.getLatitude());

        Rc rc = new Rc();
        BeanUtils.copyProperties(req, rc);

        rcService.collect(rc);
    }

}
