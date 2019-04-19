package com.zcsoft.rc.collectors.rc.service.impl;

import com.sharingif.cube.core.util.StringUtils;
import com.zcsoft.rc.collectors.api.warning.entity.WarningCollectReq;
import com.zcsoft.rc.collectors.app.components.websocket.Rc;
import com.zcsoft.rc.collectors.app.components.websocket.WebSocketMessageApplication;
import com.zcsoft.rc.collectors.rc.service.CurrentRcService;
import com.zcsoft.rc.collectors.rc.service.RcService;
import com.zcsoft.rc.collectors.warning.service.WarningService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RcServiceImpl implements RcService {

    private CurrentRcService currentRcService;
    private WarningService warningService;

    @Resource
    public void setCurrentRcService(CurrentRcService currentRcService) {
        this.currentRcService = currentRcService;
    }
    @Resource
    public void setWarningService(WarningService warningService) {
        this.warningService = warningService;
    }

    @Override
    public void collect(Rc rc) {
        String warning =  warningService.getWarningCordon(rc.getId());

        if(StringUtils.isTrimEmpty(warning)) {
            rc.setWarningStatus(false);
        } else {
            rc.setWarningStatus(true);
            rc.setWarning(warning);
        }

        currentRcService.add(rc);

        WebSocketMessageApplication.sendMessage(rc);
    }
}
