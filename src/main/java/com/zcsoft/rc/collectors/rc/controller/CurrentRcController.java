package com.zcsoft.rc.collectors.rc.controller;


import com.zcsoft.rc.collectors.api.rc.entity.CurrentRcMapRsp;
import com.zcsoft.rc.collectors.rc.service.CurrentRcService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
@RequestMapping(value="currentRc")
public class CurrentRcController {

    private CurrentRcService currentRcService;

    @Resource
    public void setCurrentRcService(CurrentRcService currentRcService) {
        this.currentRcService = currentRcService;
    }

    /**
     * 返回当前rc信息
     */
    @RequestMapping(value="all", method= RequestMethod.POST)
    public CurrentRcMapRsp all() {
        return currentRcService.all();
    }

}
