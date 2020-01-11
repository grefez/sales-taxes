package com.hal9000.salestaxes.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.hal9000.salestaxes.domain.Order;
import org.junit.jupiter.api.Test;

class OrderReaderTest {

    private static final String INPUT = ""
        + "1 book at 2.30\n"
        + "1 music CD at 7.20\n"
        + "1 chocolate bar at 1.50\n";
    private OrderReader underTest = new OrderReader();

    @Test

    public void test() {

        Order order = underTest.readItems(INPUT);

        assertEquals(11, order.getItemsTotal());

    }

}