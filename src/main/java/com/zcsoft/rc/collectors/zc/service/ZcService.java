package com.zcsoft.rc.collectors.zc.service;

import com.zcsoft.rc.collectors.api.zc.entity.ZcReq;

public interface ZcService {

    /**
     * 施工人员数据收集
     * @param req
     */
    void collectBuilder(ZcReq req);

    /**
     * 司机数据收集
     * @param req
     */
    void collectDriver(ZcReq req);

}
