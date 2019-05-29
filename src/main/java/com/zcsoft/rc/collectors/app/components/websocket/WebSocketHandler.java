package com.zcsoft.rc.collectors.app.components.websocket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame>  {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelActive();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();

        logger.info("added channel,channelId:{}", channel.id().asLongText());

        WebSocketMessageApplication.addChannel(channel);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();

        logger.info("removed channel,channelId:{}", channel.id().asLongText());

        WebSocketMessageApplication.removeChannel(channel);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Channel channel = ctx.channel();

        logger.error("channel connection error,channelId:{}", channel.id().asLongText(), cause);
        channel.close();

        WebSocketMessageApplication.removeChannel(channel);
    }
}
