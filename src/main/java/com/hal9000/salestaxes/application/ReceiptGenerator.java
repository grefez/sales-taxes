package com.hal9000.salestaxes.application;

import static java.lang.String.format;

import com.hal9000.salestaxes.domain.Order;

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

    private void addItems(Order order, StringBuilder sb) {
        order.iterator().forEachRemaining(item -> addLine(sb, item.getDescription(), item.getPriceAfterTaxes()));
    }

    private void addLine(StringBuilder sb, String title, Double amount) {
        sb.append(format("%s: %.2f\n", title, amount));
    }


}
