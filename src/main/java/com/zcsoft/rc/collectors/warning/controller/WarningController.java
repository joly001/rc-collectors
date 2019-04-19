package com.zcsoft.rc.collectors.warning.controller;


import com.zcsoft.rc.collectors.api.warning.entity.WarningCollectReq;
import com.zcsoft.rc.collectors.api.warning.entity.WarningDeleteReq;
import com.zcsoft.rc.collectors.warning.service.WarningService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;


@Controller
@RequestMapping(value="warning")
public class WarningController {
	
    private WarningService warningService;

    @Resource
    public void setWarningService(WarningService warningService) {
        this.warningService = warningService;
    }

    /**
     * 警告信息收集安全红线
     */
    @RequestMapping(value="collectCordon", method= RequestMethod.POST)
    public void collectCordon(WarningCollectReq req) {
        warningService.collectCordon(req);
    }

    /**
     * 警告信息删除安全红线
     */
    @RequestMapping(value="deleteCordon", method= RequestMethod.POST)
    public void deleteCordon(WarningDeleteReq req) {
        warningService.deleteCordon(req);
    }

    /**
     * 警告信息收集列车临站警告
     */
    @RequestMapping(value="collectTemporaryStation", method= RequestMethod.POST)
    public void collectTemporaryStation(WarningCollectReq req) {
        warningService.collectTemporaryStation(req);
    }

    /**
     * 警告信息删除列车临站警告
     */
    @RequestMapping(value="deleteTemporaryStation", method= RequestMethod.POST)
    public void deleteTemporaryStation(WarningDeleteReq req) {
        warningService.deleteTemporaryStation(req);
    }

    /**
     * 警告信息收集列车接近警告
     */
    @RequestMapping(value="collectTrainApproaching", method= RequestMethod.POST)
    public void collectTrainApproaching(WarningCollectReq req) {
        warningService.collectTrainApproaching(req);
    }

    /**
     * 警告信息删除列车接近警告
     */
    @RequestMapping(value="deleteTrainApproaching", method= RequestMethod.POST)
    public void deleteTrainApproaching(WarningDeleteReq req) {
        warningService.deleteTrainApproaching(req);
    }
}
