package io.github.codestory_product.converter;

import io.netty.buffer.ByteBuf;

import java.io.UnsupportedEncodingException;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

public class StringConverter extends MessageConverter<ByteBuf, String> {

    public StringConverter(){
        super.setEncoder(byteBuf -> {
            byteBuf.order(ByteOrder.LITTLE_ENDIAN);
            byte[] byteArray = new byte[byteBuf.readableBytes()];
            byteBuf.readBytes(byteArray);

            return StringConverter.bytesToStringSetCharsets(byteArray, "UTF-8");
        });
        super.setDecoder((byteBuf, value) -> {
            byteBuf.order(ByteOrder.LITTLE_ENDIAN);
            byteBuf.writeBytes(value.getBytes(StandardCharsets.UTF_8));
        });
    }

    private static String bytesToStringSetCharsets(byte[] bytes, String charsetName) {
        try {
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

}
