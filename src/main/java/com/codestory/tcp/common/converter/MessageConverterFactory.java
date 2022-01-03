package com.codestory.tcp.common.converter;

import com.codestory.tcp.common.message.PayloadDataType;
import io.netty.buffer.ByteBuf;

import java.util.HashMap;
import java.util.Map;

public class MessageConverterFactory {

    private static MessageConverterFactory factory;

    private MessageConverter<ByteBuf, Integer> integerConverter;
    private MessageConverter<ByteBuf, Short> shortConverter;
    private MessageConverter<ByteBuf, Float> floatConverter;
    private MessageConverter<ByteBuf, String> stringConverter;

    private Map<PayloadDataType, MessageConverter> messageConverterMap = new HashMap<>();

    private MessageConverterFactory() {
        this.integerConverter = new IntConverter();
        this.shortConverter = new ShortConverter();
        this.floatConverter = new FloatConverter();
        this.stringConverter = new StringConverter();

        messageConverterMap.put(PayloadDataType.INT, integerConverter);
        messageConverterMap.put(PayloadDataType.FLOAT, floatConverter);
        messageConverterMap.put(PayloadDataType.SHORT, shortConverter);
        messageConverterMap.put(PayloadDataType.STRING, stringConverter);
    }

    public static synchronized MessageConverterFactory getFactory() {
        if(factory == null) {
            factory = new MessageConverterFactory();
        }

        return factory;
    }

    public MessageConverter getConverter(PayloadDataType payloadDataType) {
        if (messageConverterMap.containsKey(payloadDataType)) {
            return messageConverterMap.get(payloadDataType);
        }
        else {
            throw new UnsupportedOperationException("이 타입의 Converter는 지원하지 않습니다.");
        }
    }

    public MessageConverter getConverter(Class clazz) {
        if(clazz.equals(Integer.class)) {
            return integerConverter;
        }
        else if(clazz.equals(Short.class)) {
            return shortConverter;
        }
        else if(clazz.equals(Float.class)) {
            return floatConverter;
        }
        else if(clazz.equals(String.class)) {
            return stringConverter;
        }
        else {
            throw new UnsupportedOperationException("이 타입의 Converter는 지원하지 않습니다.");
        }
    }

}
