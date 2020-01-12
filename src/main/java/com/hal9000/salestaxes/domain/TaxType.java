package com.hal9000.salestaxes.domain;

public enum TaxType {

    REGULAR (0.1), IMPORTED (0.05);

    double value;

    TaxType(double value) {
        this.value = value;
    }
}
