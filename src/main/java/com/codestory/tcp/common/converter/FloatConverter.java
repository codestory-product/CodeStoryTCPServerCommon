package com.codestory.tcp.common.converter;

import io.netty.buffer.ByteBuf;

public class FloatConverter extends MessageConverter<ByteBuf, Float> {

    public FloatConverter() {
        super.setEncoder(byteBuf -> byteBuf.readFloatLE());
        super.setDecoder((var byteBuf, var value) -> byteBuf.writeFloatLE(value));
    }

}
