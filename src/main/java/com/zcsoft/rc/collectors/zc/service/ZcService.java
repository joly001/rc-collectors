package com.zcsoft.rc.collectors.zc.service;

import com.zcsoft.rc.collectors.api.zc.entity.ZcReq;

public interface ZcService {

    /**
     * 数据收集
     * @param req
     */
    void collect(ZcReq req);

}
