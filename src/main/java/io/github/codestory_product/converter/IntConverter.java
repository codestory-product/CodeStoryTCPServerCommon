package io.github.codestory_product.converter;

import io.netty.buffer.ByteBuf;

public class IntConverter extends MessageConverter<ByteBuf, Integer> {

    public IntConverter() {
        super.setEncoder(byteBuf -> byteBuf.readIntLE());
        super.setDecoder((byteBuf, value) -> byteBuf.writeIntLE(value));
    }

}
