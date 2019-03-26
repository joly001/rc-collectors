package com.zcsoft.rc.collectors.zc.service.impl;

import com.zcsoft.rc.collectors.app.components.websocket.Rc;
import com.zcsoft.rc.collectors.app.components.websocket.WebSocketMessageApplication;
import com.zcsoft.rc.collectors.zc.model.entity.Zc;
import com.zcsoft.rc.collectors.zc.service.ZcService;
import org.springframework.stereotype.Service;

@Service
public class ZcServiceImpl implements ZcService {

    protected void collect(Rc rc) {
        WebSocketMessageApplication.sendMessage(rc);
    }

    @Override
    public void collectBuilder(Zc zc) {
        Rc rc = zc.convertToRc();
        rc.setType(Rc.TYPE_BUILDER);

        collect(rc);
    }

    @Override
    public void collectDriver(Zc zc) {
        Rc rc = zc.convertToRc();
        rc.setType(Rc.TYPE_TRAIN);

        collect(rc);
    }
}
