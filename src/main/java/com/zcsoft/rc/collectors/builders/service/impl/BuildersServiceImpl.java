package com.zcsoft.rc.collectors.builders.service.impl;

import com.zcsoft.rc.collectors.app.components.websocket.WebSocketMessageApplication;
import com.zcsoft.rc.collectors.builders.model.entity.Builder;
import com.zcsoft.rc.collectors.builders.service.BuildersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class BuildersServiceImpl implements BuildersService, InitializingBean {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void afterPropertiesSet() throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Builder builder = new Builder();
                    builder.setName("test1");
                    builder.setLongitude(0.12345678);
                    builder.setLatitude(0.87654321);

                    WebSocketMessageApplication.sendMessage(builder);

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        logger.error("thread sleep error", e);
                    }
                }
            }
        }).start();
    }
}
