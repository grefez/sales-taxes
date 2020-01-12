package com.hal9000.salestaxes.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.hal9000.salestaxes.domain.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderReaderTest {

    private static final String INPUT_ALL_VALID_ITEMS = ""
        + "1 book at 2.30\n"
        + "1 music CD at 7.20\n"
        + "1 candy at 0.10\n"
        + "1 chocolate bar at 1.40\n";

    private static final String INPUT_WITH_INVALID_ITEM = ""
        + " at 2.30\n"
        + "1 music CD ta 7.20\n"
        + "1 music CD at \n"
        + "1 music CD at error\n"
        + "1 chocolate bar at 1.50\n"
        + "   ";

    private OrderReader underTest = new OrderReader();

    @Test
    @DisplayName("Should read all correct items")
    public void testAllValidItems() {
        Order order = underTest.readItems(INPUT_ALL_VALID_ITEMS);

        assertEquals(11, order.getItemsTotal());
        assertEquals(4, order.getNumItems());

    }

    @Test
    @DisplayName("Should discard invalid items")
    public void testInvalidItems() {
        Order order = underTest.readItems(INPUT_WITH_INVALID_ITEM);

        assertEquals(1.50, order.getItemsTotal(), "Items total invalid");
        assertEquals(1, order.getNumItems(), "Num items invalid");

    }

}