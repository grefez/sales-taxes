package com.hal9000.salestaxes.domain;

import static java.lang.Math.ceil;
import static java.util.Arrays.asList;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Item {

    private static List<String> TAX_EXEMPTIONS = asList("CHOCOLATE", "BOOK" , "HEADACHE PILL");

    private static final String IMPORTED = "IMPORTED";

    private String description;
    private Double price;

    public double getTaxAmountApplied() {
        double taxRateApplied = getRegularTaxRateApplied() + getImportedTaxRateApplied();
        return ceil(price * taxRateApplied / 0.05) / 20;
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
        return TAX_EXEMPTIONS.stream().anyMatch(exemption -> description.toUpperCase().contains(exemption));

    }

}
