package com.hal9000.salestaxes.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

    @Getter
    private Double orderTaxes = 0.0;

    public void add(Item item) {
        items.add(item);
        itemsTotal += item.getPrice();
        orderTaxes += item.getTaxAmountApplied();
    }


    public Iterator<Item> iterator() {
        return items.iterator();
    }

    public int getNumItems() {
        return items.size();
    }

}
