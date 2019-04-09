package com.zcsoft.rc.collectors.rc.service;

import com.zcsoft.rc.collectors.api.rc.entity.CurrentRcMapRsp;
import com.zcsoft.rc.collectors.app.components.websocket.Rc;

public interface CurrentRcService {

    /**
     * 添加rc
     * @param rc
     */
    void add(Rc rc);

    /**
     * 返回当前rc信息
     */
    CurrentRcMapRsp all();

}
