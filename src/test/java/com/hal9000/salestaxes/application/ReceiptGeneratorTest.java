package com.hal9000.salestaxes.application;

import static java.util.Arrays.asList;

import com.hal9000.salestaxes.domain.Item;
import com.hal9000.salestaxes.domain.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReceiptGeneratorTest {

    private ReceiptGenerator underTest = new ReceiptGenerator();

    private String CORRECT_RECEIPT = ""
        + "1 item: 12.23\n"
        + "1 imported item: 14.12\n"
        + "Sales Taxes: 1.50\n"
        + "Total: 29.83\n";

    @BeforeEach
    public void init() {

    }

    @Test
    @DisplayName("Should generate receipt correctly")
    public void  test () {

        String output = underTest.generateReceipt(
            new Order(asList(
                new Item("1 item", 12.23),
                new Item("1 imported item", 14.12))));

        Assertions.assertEquals(CORRECT_RECEIPT, output);



    }

}