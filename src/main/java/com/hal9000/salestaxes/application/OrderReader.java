package com.hal9000.salestaxes.application;

import static java.util.stream.Collectors.toList;

import com.hal9000.salestaxes.domain.Item;
import com.hal9000.salestaxes.domain.Order;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.List;
import java.util.Objects;

public class OrderReader {

    private static final int DESCRIPTION = 0;
    private static final int PRICE = 1;
    private static final String ITEM_FIELDS_SEPARATOR = " at ";

    public Order readItems (String shoppingBasket) {

        List<Item> items = new BufferedReader(new StringReader(shoppingBasket)).lines()
            .map(this::getItem)
            .filter (Objects::nonNull)
            .collect(toList());

        return new Order(items);
    }

    private Item getItem(String line) {
        String[] itemFields = line.split(ITEM_FIELDS_SEPARATOR);
        return itemFields.length != 2 ? null : getItemFromFields(itemFields);
    }

    private Item getItemFromFields(String[] orderFields) {
        try {
            return orderFields[DESCRIPTION].length() == 0 ?
                null : new Item(orderFields[DESCRIPTION], Double.valueOf(orderFields [PRICE]));
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
