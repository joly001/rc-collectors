package com.zcsoft.rc.collectors.app.components.tcp;

import com.zcsoft.rc.collectors.api.rtk.entity.RtkCollectReq;
import com.zcsoft.rc.collectors.rtk.service.RtkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TcpServerApplication {

    private static Logger logger = LoggerFactory.getLogger(TcpServerApplication.class);

    private static RtkService rtkService;

    public static void setRtkService(RtkService rtkService) {
        TcpServerApplication.rtkService = rtkService;
    }

    public static void collect(RtkCollectReq req) {
        if(rtkService == null) {
            logger.error("rtk service is null");
        }

        rtkService.collect(req);
    }
}
