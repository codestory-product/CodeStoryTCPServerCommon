package com.codestory.tcp.common.converter;

@FunctionalInterface
public interface MessageConverterDecoderFunctional<P, U> {
    void apply(P parameter1, U parameter2);
}
