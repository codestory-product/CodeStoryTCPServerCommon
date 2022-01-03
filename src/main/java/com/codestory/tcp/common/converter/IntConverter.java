package com.codestory.tcp.common.converter;

import io.netty.buffer.ByteBuf;

public class IntConverter extends MessageConverter<ByteBuf, Integer> {

    public IntConverter() {
        super.setEncoder(byteBuf -> byteBuf.readIntLE());
        super.setDecoder((var byteBuf, var value) -> byteBuf.writeIntLE(value));
    }

}
