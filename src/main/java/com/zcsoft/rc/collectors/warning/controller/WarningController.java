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
     * 警告信息收集
     */
    @RequestMapping(value="collect", method= RequestMethod.POST)
    public void collect(WarningCollectReq req) {
        warningService.collect(req);
    }

    /**
     * 警告信息删除
     */
    @RequestMapping(value="delete", method= RequestMethod.POST)
    public void delete(WarningDeleteReq req) {
        warningService.delete(req);
    }
}
