package com.hal9000.salestaxes.domain;

import static java.lang.Math.ceil;

import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Item {

    private static List<String> taxExemptions = Arrays.asList(
        "CHOCOLATE", "BOOK" , "HEADACHE PILL"
    );

    private static final String IMPORTED = "IMPORTED";

    private String description;
    private Double price;

    public double getTaxAmountApplied() {
        return ceil(price * (getRegularTaxRateApplied() + getImportedTaxRateApplied())*20)/20;
    }

    public double getPriceAfterTaxes () {
        return price + getTaxAmountApplied();
    }

    double getRegularTaxRateApplied() {
        return isExempt() ? 0.0 : TaxType.REGULAR.value;
    }

    double getImportedTaxRateApplied() {
        return description.toUpperCase().contains(IMPORTED) ? TaxType.IMPORTED.value : 0.0;
    }

    private boolean isExempt () {
        return taxExemptions.stream().anyMatch(exemption -> description.toUpperCase().contains(exemption));

    }

}
