package com.hal9000.salestaxes.application;

import static java.util.stream.Collectors.toList;

import com.hal9000.salestaxes.domain.Item;
import com.hal9000.salestaxes.domain.Order;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.List;
import java.util.Objects;

public class OrderReader {

    public Order readItems (String input) {

        List<Item> items = new BufferedReader(new StringReader(input)).lines()
            .map(this::getItem)
            .filter (Objects::nonNull)
            .collect(toList());

        return new Order(items);
    }

    private Item getItem(String line) {
        String[] orderFields = line.split(" at ");
        return orderFields.length != 2 ? null : new Item(orderFields[0], Double.valueOf(orderFields [1]));
    }

}
