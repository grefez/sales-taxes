package com.hal9000.salestaxes.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Order {

    private final List<Item> items = new ArrayList<>();

    public Order (List<Item> items) {
        items.forEach(this::add);
    }

    @Getter
    private Double itemsTotal = 0.0;

    private Double taxesTotal = 0.0;

    public Double getOrderTaxes() {
        return taxesTotal;
    }

    public Double getOrderTotal () {
        return itemsTotal + getOrderTaxes();
    }

    public void add(Item item) {
        items.add(item);
        itemsTotal += item.getPrice();
        taxesTotal += item.getTaxType().value * item.getPrice();
    }


    public Iterator<Item> iterator() {
        return items.iterator();
    }

}
