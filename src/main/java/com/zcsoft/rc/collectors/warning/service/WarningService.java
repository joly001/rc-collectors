package com.zcsoft.rc.collectors.warning.service;

import com.zcsoft.rc.collectors.api.warning.entity.WarningCollectReq;
import com.zcsoft.rc.collectors.api.warning.entity.WarningDeleteReq;

public interface WarningService {

    /**
     * 根据id获取警告信息安全红线
     * @param id
     * @return
     */
    String getWarningCordon(String id);

    /**
     * 警告信息收集安全红线
     * @param req
     */
    void collectCordon(WarningCollectReq req);

    /**
     * 警告信息删除安全红线
     * @param req
     */
    void deleteCordon(WarningDeleteReq req);

    /**
     * 根据id获取警告信息列车临站警告
     * @param id
     * @return
     */
    String getWarningTemporaryStation(String id);

    /**
     * 警告信息收集列车临站警告
     * @param req
     */
    void collectTemporaryStation(WarningCollectReq req);

    /**
     * 警告信息删除列车临站警告
     * @param req
     */
    void deleteTemporaryStation(WarningDeleteReq req);

    /**
     * 根据id获取警告信息列车临站警告
     * @param id
     * @return
     */
    String getWarningTrainApproaching(String id);

    /**
     * 警告信息收集列车接近警告
     * @param req
     */
    void collectTrainApproaching(WarningCollectReq req);

    /**
     * 警告信息删除列车接近警告
     * @param req
     */
    void deleteTrainApproaching(WarningDeleteReq req);

}
