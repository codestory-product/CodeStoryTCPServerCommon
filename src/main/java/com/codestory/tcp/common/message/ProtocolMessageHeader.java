package com.codestory.tcp.common.message;

public class ProtocolMessageHeader {

    private short channelId;
    private short eventId;
    private int sizeOfPayload;
    private PayloadDataType payloadType;

    public ProtocolMessageHeader(short channelId, short eventId, int sizeOfPayload, PayloadDataType payloadType) {
        this.channelId = channelId;
        this.eventId = eventId;
        this.sizeOfPayload = sizeOfPayload;
        this.payloadType = payloadType;
    }

    public short getChannelId() {
        return channelId;
    }

    public short getEventId() {
        return eventId;
    }

    public int getSizeOfPayload() {
        return sizeOfPayload;
    }

    public PayloadDataType getPayloadType() {
        return payloadType;
    }

    @Override
    public String toString() {
        return "ProtocolMessageHeader{" +
                "channelId=" + channelId +
                ", eventId=" + eventId +
                ", sizeOfPayload=" + sizeOfPayload +
                ", payloadType=" + payloadType +
                '}';
    }
}
