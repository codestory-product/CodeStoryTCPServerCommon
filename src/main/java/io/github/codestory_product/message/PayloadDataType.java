package io.github.codestory_product.message;

public enum PayloadDataType {

    STRING(0),
    INT(1),
    SHORT(2),
    FLOAT(3);

    private int id;

    PayloadDataType(int id) {
        this. id = id;
    }

    public int id() {
        return id;
    }
}
