package com.zcsoft.rc.collectors.rc.service.impl;

import com.zcsoft.rc.collectors.api.rc.entity.CurrentRcMapRsp;
import com.zcsoft.rc.collectors.api.rc.entity.CurrentRcRsp;
import com.zcsoft.rc.collectors.app.components.websocket.Rc;
import com.zcsoft.rc.collectors.rc.service.CurrentRcService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CurrentRcServiceImpl implements CurrentRcService {

    private Map<String, CurrentRcRsp> rcMap = new ConcurrentHashMap<>(200);

    public void add(Rc rc) {
        CurrentRcRsp currentRcRsp = new CurrentRcRsp();
        BeanUtils.copyProperties(rc, currentRcRsp);

        rcMap.put(currentRcRsp.getId(), currentRcRsp);
    }

    public CurrentRcMapRsp all() {
        Map<String, CurrentRcRsp> copyRcMap = new ConcurrentHashMap<>(200);
        copyRcMap.putAll(rcMap);

        CurrentRcMapRsp rsp = new CurrentRcMapRsp();
        rsp.setRcMap(copyRcMap);

        clear();

        return rsp;
    }

    public void clear() {
        rcMap.clear();
    }

}
