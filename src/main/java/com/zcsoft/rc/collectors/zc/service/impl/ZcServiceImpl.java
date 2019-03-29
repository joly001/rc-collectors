package com.zcsoft.rc.collectors.zc.service.impl;

import com.zcsoft.rc.collectors.api.zc.entity.ZcReq;
import com.zcsoft.rc.collectors.app.components.websocket.Rc;
import com.zcsoft.rc.collectors.app.components.websocket.WebSocketMessageApplication;
import com.zcsoft.rc.collectors.zc.service.ZcService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ZcServiceImpl implements ZcService {

    protected void collect(Rc rc) {
        WebSocketMessageApplication.sendMessage(rc);
    }

    @Override
    public void collectBuilder(ZcReq req) {
        Rc rc = new Rc();
        BeanUtils.copyProperties(req, rc);

        rc.setType(Rc.TYPE_BUILDER);

        collect(rc);
    }

    @Override
    public void collectDriver(ZcReq req) {
        Rc rc = new Rc();
        BeanUtils.copyProperties(req, rc);

        collect(rc);
    }
}
