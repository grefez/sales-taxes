package com.hal9000.salestaxes.domain;

import static com.hal9000.salestaxes.domain.TaxType.IMPORTED;
import static com.hal9000.salestaxes.domain.TaxType.REGULAR;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ItemTest {

    @Test
    @DisplayName("Should apply no taxes to non imported, exempt items")
    public void testNonImportedExempt () {
        Item item = new Item("xxxxx boOk xxx", 12.23);
        assertEquals(0.0, item.getRegularTaxRateApplied());
        assertEquals(0.0, item.getImportedTaxRateApplied());
    }

    @Test
    @DisplayName("Should apply correct taxes to imported, non exempt items")
    public void tesImportedNonExempt () {
        Item item = new Item("xxxxx ImPOrted xxxx", 12.23);
        assertEquals(REGULAR.value, item.getRegularTaxRateApplied());
        assertEquals(IMPORTED.value, item.getImportedTaxRateApplied());
    }

    @Test
    @DisplayName("Should apply correct taxes to imported, exempt items")
    public void testImportedExempt () {
        Item item = new Item("xxxxx ImPOrted chocoLAte xxxx", 12.23);
        assertEquals(0.0, item.getRegularTaxRateApplied());
        assertEquals(IMPORTED.value, item.getImportedTaxRateApplied());
    }

    @Test
    @DisplayName("Should apply correct taxes to non imported, non exempt items")
    public void testNonImportedNonExempt () {
        Item item = new Item("xxxxx xxxx", 12.23);
        assertEquals(REGULAR.value, item.getRegularTaxRateApplied());
        assertEquals(0.0, item.getImportedTaxRateApplied());
    }

    @Test
    @DisplayName("Should adjust taxes rates to minimum greater rate multiple of 0.05")
    public void testAdjust () {
        Item item = new Item("xxxxx xxxx", 12.23);
        assertEquals(1.25, item.getTaxAmountApplied());
    }

}