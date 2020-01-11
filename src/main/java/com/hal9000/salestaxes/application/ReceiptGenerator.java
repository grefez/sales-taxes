package com.hal9000.salestaxes.application;

import static java.lang.String.format;

import com.hal9000.salestaxes.domain.Item;
import com.hal9000.salestaxes.domain.Order;
import java.util.List;

public class ReceiptGenerator {


    public String generateReceipt (Order order) {

        StringBuilder sb = new StringBuilder();
        addItems(order, sb);
        addTotals(order, sb);

        return sb.toString();

    }

    private void addTotals(Order order, StringBuilder sb) {
        addLine(sb, "Sales Taxes", order.getOrderTaxes());
        addLine(sb, "Total", order.getItemsTotal() + order.getOrderTaxes());
    }

    private void addLine(StringBuilder sb, String title, Double itemsTotal) {
        sb.append(format("%s: %.2f\n", title, itemsTotal));
    }

    private void addItems(Order order, StringBuilder sb) {
        order.iterator().forEachRemaining(item ->
            sb.append(format("%s: %.2f\n", item.getDescription(), item.getPrice())));
    }

    private Order createOrder(List<Item> items) {
        Order order = new Order();

        items.forEach(item -> order.add(item));

        return order;
    }

}
