package com.codestory.tcp.common.message;

import com.codestory.tcp.common.converter.MessageConverterFactory;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;

public class ProtocolMessage<T> {

    private ProtocolMessageHeader header;
    private T payload;

    public ProtocolMessage(ProtocolMessageHeader header, T payload) {
        this.header = header;
        this.payload = payload;
    }

    public ProtocolMessageHeader getHeader() {
        return header;
    }

    public T getPayload() {
        return payload;
    }

    @Override
    public String toString() {
        return "ProtocolMessage{" +
                "header=" + header +
                ", payload=" + payload +
                '}';
    }

    public ByteBuf toBytes() {
        ByteBuf buf = PooledByteBufAllocator.DEFAULT.heapBuffer(header.getSizeOfPayload() + 12);

        buf.writeShortLE(header.getChannelId());
        buf.writeShortLE(header.getEventId());
        buf.writeIntLE(header.getSizeOfPayload());
        buf.writeIntLE(header.getPayloadType().id());
        MessageConverterFactory.getFactory().getConverter(header.getPayloadType()).decode(buf, payload);

        return buf;
    }

    public static ProtocolMessage toMessageObject(ByteBuf buf, ProtocolMessageHeader header) {
        return new ProtocolMessage(
                header,
                MessageConverterFactory.getFactory().getConverter(header.getPayloadType()).encode(buf)
        );
    }

}
