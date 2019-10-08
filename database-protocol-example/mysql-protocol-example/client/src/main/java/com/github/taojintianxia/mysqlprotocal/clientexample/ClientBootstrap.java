package com.github.taojintianxia.mysqlprotocal.clientexample;

import com.github.taojintianxia.mysqlprotocal.clientexample.handler.MySQLClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.SneakyThrows;

/**
 * @author Nianjun Sun
 * @date 2019/10/8 15:33
 */
public class ClientBootstrap {

    private static final int DEFAULT_PORT = 13306;

    private static final String HOST = "127.0.0.1";

    @SneakyThrows
    public static void main(String... args) {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(workerGroup);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            public void initChannel(SocketChannel ch) {
                ch.pipeline().addLast(new MySQLClientHandler());
            }
        });

        // Start the client.
        ChannelFuture f = bootstrap.connect(HOST, DEFAULT_PORT).sync();

        // Wait until the connection is closed.
        f.channel().closeFuture().sync();
    }
}
