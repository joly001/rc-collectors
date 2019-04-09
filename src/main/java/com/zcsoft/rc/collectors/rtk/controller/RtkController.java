package com.zcsoft.rc.collectors.rtk.controller;


import com.zcsoft.rc.collectors.api.rtk.entity.RtkCollectReq;
import com.zcsoft.rc.collectors.rtk.service.RtkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping(value="rtk")
public class RtkController {

    private RtkService rtkService;

    @Resource
    public void setRtkService(RtkService rtkService) {
        this.rtkService = rtkService;
    }

    /**
     * rtk数据收集
     */
    @RequestMapping(value="collect", method= RequestMethod.POST)
    public void collect(@Valid RtkCollectReq req) {
        rtkService.collect(req);
    }

}
