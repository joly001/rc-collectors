package com.zcsoft.rc.collectors.warning.service;

import com.zcsoft.rc.collectors.api.warning.entity.WarningCollectReq;
import com.zcsoft.rc.collectors.api.warning.entity.WarningDeleteReq;

public interface WarningService {

    /**
     * 根据id获取警告信息
     * @param id
     * @return
     */
    String getWarning(String id);

    /**
     * 警告信息收集
     * @param req
     */
    void collect(WarningCollectReq req);

    /**
     * 警告信息删除
     */
    void delete(WarningDeleteReq req);

}
