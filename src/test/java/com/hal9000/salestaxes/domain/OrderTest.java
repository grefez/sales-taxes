package com.hal9000.salestaxes.domain;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    @DisplayName ("Should return correct values for empty orders")
    public void testForEmptyOrder () {
        Order emptyOrder = new Order();
        assertEquals(0, emptyOrder.getNumItems());
        assertEquals(0, emptyOrder.getItemsTotal());
        assertEquals(0, emptyOrder.getOrderTaxes());
    }

    @Test
    @DisplayName ("Should return correct values for non empty orders")
    public void testForNonImportedItems () {
        Item item1 = new Item("item 1", 12.0);
        Item item2 = new Item("item 2", 8.0);
        Order order = new Order(asList(item1, item2));
        assertEquals(2, order.getNumItems());
        assertEquals(item1.getPrice() + item2.getPrice(), order.getItemsTotal());
        assertEquals(item1.getTaxAmountApplied() + item2.getTaxAmountApplied(), order.getOrderTaxes());
    }



}