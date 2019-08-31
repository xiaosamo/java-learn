package com.yuanshijia.javalearn.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author yuan
 * @date 2019/8/31
 * @description
 */
public class NettyServer {
    public static final int port = 8000;
    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        NioEventLoopGroup boss = new NioEventLoopGroup();         // 接受新连接线程，主要负责创建新连接
        NioEventLoopGroup worker = new NioEventLoopGroup();    // 读取数据的线程，主要用于读取数据以及业务逻辑处理
        serverBootstrap
                // 1.指定线程模型
                .group(boss, worker)
                // 2.指定 IO 类型为 NIO
                .channel(NioServerSocketChannel.class)
                // 3.IO 处理逻辑
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
                            @Override
                            protected void channelRead0(ChannelHandlerContext channelHandlerContext, String msg) throws Exception {
                                System.out.println("服务端收到消息：" + msg);
                            }
                        });
                    }
                })
                .bind(port);
        System.out.println("服务端启动，端口:"+port);
    }
}
