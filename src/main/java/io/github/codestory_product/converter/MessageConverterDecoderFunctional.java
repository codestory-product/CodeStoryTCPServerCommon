package io.github.codestory_product.converter;

@FunctionalInterface
public interface MessageConverterDecoderFunctional<P, U> {
    void apply(P parameter1, U parameter2);
}
