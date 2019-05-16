package com.zcsoft.rc.collectors.app.autoconfigure.components;

import com.zcsoft.rc.collectors.app.components.tcp.P3duTcpServerChannelInitializer;
import com.zcsoft.rc.collectors.app.components.tcp.TcpServer;
import com.zcsoft.rc.collectors.app.components.tcp.Bx2TcpServerChannelInitializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComponentsAutoConfigure {

    @Bean("bx2TcpServer")
    public TcpServer createBx2TcpServer(@Value("${tcp.bx2.port}") int port, Bx2TcpServerChannelInitializer bx2TcpServerChannelInitializer) {
        TcpServer tcpServer = new TcpServer();
        tcpServer.setPort(port);
        tcpServer.setChannelInitializer(bx2TcpServerChannelInitializer);

        return tcpServer;
    }

    @Bean("p3duTcpServer")
    public TcpServer createP3duTcpServer(@Value("${tcp.p3du.port}") int port, P3duTcpServerChannelInitializer p3duTcpServerChannelInitializer) {
        TcpServer tcpServer = new TcpServer();
        tcpServer.setPort(port);
        tcpServer.setChannelInitializer(p3duTcpServerChannelInitializer);

        return tcpServer;
    }

}
