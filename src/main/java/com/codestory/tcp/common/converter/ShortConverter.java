package com.codestory.tcp.common.converter;

import io.netty.buffer.ByteBuf;

public class ShortConverter extends MessageConverter<ByteBuf, Short> {

    public ShortConverter() {
        super.setEncoder(byteBuf -> byteBuf.readShortLE());
        super.setDecoder((var byteBuf, var value) -> byteBuf.writeShortLE(value));
    }

}
