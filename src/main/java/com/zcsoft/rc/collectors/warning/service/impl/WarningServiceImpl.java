package com.zcsoft.rc.collectors.warning.service.impl;

import com.zcsoft.rc.collectors.api.warning.entity.WarningCollectReq;
import com.zcsoft.rc.collectors.warning.service.WarningService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class WarningServiceImpl implements WarningService {

    private Map<String, String> warningMap = new ConcurrentHashMap<>(200);

    @Override
    public String getWarning(String id) {
        return warningMap.get(id);
    }

    @Override
    public void collect(WarningCollectReq req) {
        warningMap.put(req.getId(), req.getWarning());
    }
}
