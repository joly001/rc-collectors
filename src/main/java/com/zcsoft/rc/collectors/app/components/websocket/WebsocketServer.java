package com.zcsoft.rc.collectors.app.components.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class WebsocketServer implements InitializingBean {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private int port;
    private ChannelInboundHandler webSocketChannelInitializer;

    @Value("${websocket.port}")
    public void setPort(int port) {
        this.port = port;
    }
    @Resource
    public void setWebSocketChannelInitializer(ChannelInboundHandler webSocketChannelInitializer) {
        this.webSocketChannelInitializer = webSocketChannelInitializer;
    }

    public void start() throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();


        try{
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.DEBUG))
                    .childHandler(webSocketChannelInitializer);

            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            logger.info("Started server Websocket");
            channelFuture.channel().closeFuture().sync();
        }finally{
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        final WebsocketServer websocketServer = this;
        new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("Starting server Websocket");
                try {
                    websocketServer.start();
                } catch (InterruptedException e) {
                    logger.error("Started server Websocket error");
                }
                logger.error("Closed server Websocket error");
            }
        }).start();
    }
}
