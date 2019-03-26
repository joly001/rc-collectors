package com.zcsoft.rc.collectors.zc.service;

import com.zcsoft.rc.collectors.zc.model.entity.Zc;

public interface ZcService {

    /**
     * 施工人员数据收集
     * @param zc
     */
    void collectBuilder(Zc zc);

    /**
     * 司机数据收集
     * @param zc
     */
    void collectDriver(Zc zc);

}
