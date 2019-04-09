package com.zcsoft.rc.collectors.rc.service.impl;

import com.zcsoft.rc.collectors.app.components.websocket.Rc;
import com.zcsoft.rc.collectors.app.components.websocket.WebSocketMessageApplication;
import com.zcsoft.rc.collectors.rc.service.CurrentRcService;
import com.zcsoft.rc.collectors.rc.service.RcService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RcServiceImpl implements RcService {

    private CurrentRcService currentRcService;

    @Resource
    public void setCurrentRcService(CurrentRcService currentRcService) {
        this.currentRcService = currentRcService;
    }

    @Override
    public void collect(Rc rc) {
        currentRcService.add(rc);

        WebSocketMessageApplication.sendMessage(rc);
    }
}
