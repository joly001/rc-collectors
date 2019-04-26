package com.zcsoft.rc.collectors.app.components.tcp;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
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
public class TcpServer implements InitializingBean {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private int port;
    private TcpServerChannelInitializer tcpServerChannelInitializer;

    @Value("${tcp.port}")
    public void setPort(int port) {
        this.port = port;
    }
    @Resource
    public void setTcpServerChannelInitializer(TcpServerChannelInitializer tcpServerChannelInitializer) {
        this.tcpServerChannelInitializer = tcpServerChannelInitializer;
    }

    public void start() throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try{
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.DEBUG))
                    .childHandler(tcpServerChannelInitializer)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .option(ChannelOption.SO_BACKLOG, 128);

            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            logger.info("Started server tcp");
            channelFuture.channel().closeFuture().sync();
        }finally{
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("Starting server tcp");
                try {
                    start();
                } catch (InterruptedException e) {
                    logger.error("Started server tcp error");
                }
                logger.info("Closed server tcp");
            }
        }).start();
    }

}
