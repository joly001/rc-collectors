package com.zcsoft.rc.collectors.rtk.service;

import com.zcsoft.rc.collectors.api.rtk.entity.RtkCollectReq;

public interface RtkService {

    /**
     * 数据收集
     * @param req
     */
    void collect(RtkCollectReq req);

}
