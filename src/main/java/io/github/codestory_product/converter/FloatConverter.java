package io.github.codestory_product.converter;

import io.github.codestory_product.converter.*;
import io.netty.buffer.ByteBuf;

/**
 * float형 데이터를 convert 해주는 클래스입니다.
 * @author 남대영
 * */
public class FloatConverter extends MessageConverter<ByteBuf, Float> {

    public FloatConverter() {
        super.setEncoder(byteBuf -> byteBuf.readFloatLE());
        super.setDecoder((byteBuf, value) -> byteBuf.writeFloatLE(value));
    }

}
