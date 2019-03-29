package com.zcsoft.rc.collectors.zc.controller;

import com.zcsoft.rc.collectors.api.zc.entity.ZcReq;
import com.zcsoft.rc.collectors.zc.service.ZcService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping(value="zc")
public class ZcController {

    private ZcService zcService;

    @Resource
    public void setZcService(ZcService zcService) {
        this.zcService = zcService;
    }

    /**
     * 施工人员数据收集
     * @param req
     */
    @RequestMapping(value="collectBuilder", method= RequestMethod.POST)
    public void collectBuilder(@Valid ZcReq req) {
        zcService.collectBuilder(req);
    }

    /**
     * 司机数据收集
     * @param req
     */
    @RequestMapping(value="collectDriver", method= RequestMethod.POST)
    public void collectDriver(@Valid ZcReq req) {
        zcService.collectDriver(req);
    }

}
