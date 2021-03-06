package com.github.taojintianxia.cornucopia.mysqlprotocal.clientexample.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Nianjun Sun
 * @date 2019/10/8 15:54
 */
@Slf4j
public class MySQLClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf byteBuf = (ByteBuf) msg;
        try {
            log.info("start to print out handshake from server");
            log.info(ByteBufUtil.prettyHexDump(byteBuf));
            ctx.close();
        } finally {
            byteBuf.release();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
