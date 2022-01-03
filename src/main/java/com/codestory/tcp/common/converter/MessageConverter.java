package com.codestory.tcp.common.converter;

import java.util.function.Function;

public class MessageConverter<P, R> {

    private Function<P, R> encode;
    private MessageConverterDecoderFunctional<P, R> decode;

    public R encode(P parameter) {
        return encode.apply(parameter);
    }

    public void decode(P source, R data) {
        decode.apply(source, data);
    }

    protected void setEncoder(Function<P, R> encode) {
        this.encode = encode;
    }

    protected void setDecoder(MessageConverterDecoderFunctional<P, R> decode) {
        this.decode = decode;
    }

}
