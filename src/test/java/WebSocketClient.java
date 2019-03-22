import com.zcsoft.rc.collectors.app.components.websocket.WebSocketMessageApplication;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

public class WebSocketClient {

    public static void main(String[] args) {

        //worker负责读写数据
        EventLoopGroup worker = new NioEventLoopGroup();

        try {
            //辅助启动类
            Bootstrap bootstrap = new Bootstrap();

            //设置线程池
            bootstrap.group(worker);

            //设置socket工厂
            bootstrap.channel(NioSocketChannel.class);

            //设置管道
            bootstrap.handler(new ChannelInitializer() {
                @Override
                protected void initChannel(Channel socketChannel) throws Exception {
                    //获取管道
                    ChannelPipeline pipeline = socketChannel.pipeline();

                    //处理类
                    pipeline.addLast(new ClientHandler4());
                }
            });

            //发起异步连接操作
            ChannelFuture futrue = bootstrap.connect(new InetSocketAddress("127.0.0.1",8893)).sync();

            //等待客户端链路关闭
            futrue.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //优雅的退出，释放NIO线程组
            worker.shutdownGracefully();
        }
    }

}

class ClientHandler4 extends SimpleChannelInboundHandler<Object> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelActive();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("message:{}", msg);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();

        logger.info("added channel,channelId:{}", channel.id().asLongText());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        logger.info("removed channel,channelId:{}", ctx.channel().id().asLongText());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.info("channel connection error,channelId:{}", ctx.channel().id().asLongText());
        ctx.channel().close();
    }

}
