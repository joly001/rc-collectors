package com.zcsoft.rc.collectors.rc.service;

import com.zcsoft.rc.collectors.app.components.websocket.Rc;

public interface RcService {

    /**
     * 收集数据
     * @param rc
     */
    void collect(Rc rc);

}
