package com.zcsoft.rc.collectors.warning.service.impl;

import com.zcsoft.rc.collectors.api.warning.entity.WarningCollectReq;
import com.zcsoft.rc.collectors.api.warning.entity.WarningDeleteReq;
import com.zcsoft.rc.collectors.warning.service.WarningService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class WarningServiceImpl implements WarningService {

    private Map<String, String> warningCordonMap = new ConcurrentHashMap<>(200);
    private Map<String, String> warningtemporaryStation = new ConcurrentHashMap<>(200);
    private Map<String, String> warningTrainApproaching = new ConcurrentHashMap<>(200);

    @Override
    public String getWarningCordon(String id) {
        return warningCordonMap.get(id);
    }

    @Override
    public void collectCordon(WarningCollectReq req) {
        warningCordonMap.put(req.getId(), req.getWarning());
    }

    @Override
    public void deleteCordon(WarningDeleteReq req) {
        warningCordonMap.remove(req.getId());
    }

    @Override
    public String getWarningTemporaryStation(String id) {
        return warningtemporaryStation.get(id);
    }

    @Override
    public void collectTemporaryStation(WarningCollectReq req) {
        warningtemporaryStation.put(req.getId(), req.getWarning());
    }

    @Override
    public void deleteTemporaryStation(WarningDeleteReq req) {
        warningtemporaryStation.remove(req.getId());
    }

    @Override
    public String getWarningTrainApproaching(String id) {
        return warningTrainApproaching.get(id);
    }

    @Override
    public void collectTrainApproaching(WarningCollectReq req) {
        warningTrainApproaching.put(req.getId(), req.getWarning());
    }

    @Override
    public void deleteTrainApproaching(WarningDeleteReq req) {
        warningTrainApproaching.remove(req.getId());
    }
}
