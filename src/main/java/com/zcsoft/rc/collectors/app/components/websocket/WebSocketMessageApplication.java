package com.zcsoft.rc.collectors.app.components.websocket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sharingif.cube.core.exception.UnknownCubeException;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebSocketMessageApplication {

    private static Logger logger = LoggerFactory.getLogger(WebSocketMessageApplication.class);

    private static ObjectMapper objectMapper = new ObjectMapper();

    private static Channel channel;

    public static void addChannel(Channel channel){
        WebSocketMessageApplication.channel = channel;
    }

    public static void removeChannel() {
        WebSocketMessageApplication.channel = null;
    }

    public static boolean sendMessage(Object obj) {
        if(channel == null) {
            logger.error("channel is null");
            return false;
        }

        String objString;
        try {
            objString = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error("json format errer", e);

            throw new UnknownCubeException(e);
        }
        channel.writeAndFlush(new TextWebSocketFrame(objString));

        return true;
    }

}
