package com.hal9000.salestaxes.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Item {

    private static final String IMPORTED = "imported";

    private String description;
    private Double price;

    public TaxType getTaxType() {
        return description.toUpperCase().contains(IMPORTED)?
            TaxType.IMPORTED:
            TaxType.REGULAR;
    }

}
