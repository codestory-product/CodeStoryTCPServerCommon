package io.github.codestory_product.converter;

import io.netty.buffer.ByteBuf;

public class ShortConverter extends MessageConverter<ByteBuf, Short> {

    public ShortConverter() {
        super.setEncoder(byteBuf -> byteBuf.readShortLE());
        super.setDecoder((byteBuf, value) -> byteBuf.writeShortLE(value));
    }

}
