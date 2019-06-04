package com.zcsoft.rc.collectors.rc.service.impl;

import com.sharingif.cube.core.util.StringUtils;
import com.zcsoft.rc.collectors.api.warning.entity.WarningCollectReq;
import com.zcsoft.rc.collectors.app.components.websocket.Rc;
import com.zcsoft.rc.collectors.app.components.websocket.WebSocketMessageApplication;
import com.zcsoft.rc.collectors.app.components.websocket.geojson.GeoJson;
import com.zcsoft.rc.collectors.app.components.websocket.geojson.Geometry;
import com.zcsoft.rc.collectors.app.components.websocket.geojson.Properties;
import com.zcsoft.rc.collectors.rc.service.CurrentRcService;
import com.zcsoft.rc.collectors.rc.service.RcService;
import com.zcsoft.rc.collectors.warning.service.WarningService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;

@Service
public class RcServiceImpl implements RcService {

    private CurrentRcService currentRcService;
    private WarningService warningService;

    @Resource
    public void setCurrentRcService(CurrentRcService currentRcService) {
        this.currentRcService = currentRcService;
    }
    @Resource
    public void setWarningService(WarningService warningService) {
        this.warningService = warningService;
    }

    @Override
    public void collect(Rc rc) {
        String warning =  warningService.getWarningCordon(rc.getId());
        if(warning == null) {
            warning = warningService.getWarningTrainApproaching(rc.getId());
            if(warning == null) {
                warning = warningService.getWarningTemporaryStation(rc.getId());
            }
        }

        if(StringUtils.isTrimEmpty(warning)) {
            rc.setWarningStatus(false);
        } else {
            rc.setWarningStatus(true);
            rc.setWarning(warning);
        }

        currentRcService.add(rc);

//        GeoJson geoJson = new GeoJson();
//        geoJson.setType("Feature");
//
//        Properties properties = new Properties();
//        properties.setId(rc.getId());
//        properties.setX(rc.getLongitude());
//        properties.setY(rc.getLatitude());
//        properties.setType(rc.getType());
//        properties.setWristStrapCode(rc.getWristStrapCode());
//        properties.setWarningStatus(rc.getWarningStatus().toString());
//        properties.setWarning(rc.getWarning());
//        geoJson.setProperties(properties);
//
//
//        Geometry geometry = new Geometry();
//        geometry.setType("Point");
//        geometry.setCoordinates(Arrays.asList(rc.getLongitude(),rc.getLatitude()));
//        geoJson.setGeometry(geometry);


        WebSocketMessageApplication.sendMessage(rc);
    }
}
