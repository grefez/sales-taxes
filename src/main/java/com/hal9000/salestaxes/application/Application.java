package com.hal9000.salestaxes.application;

import com.hal9000.salestaxes.domain.Order;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Application {

    public static void main (String[] args) {
        System.out.println(getOutput(args));
    }

    static String getOutput(String[] args) {

        if (args.length != 1) {
            return "Please add shopping basket file name as argument";
        } else {
            String shoppingBasket = "";
            String fileName = args[0];
            try {
                shoppingBasket = readFile(fileName);
            } catch (IOException e) {
                return "Error reading " + fileName + e.getMessage();
            }

            Order order = new OrderReader().readItems(shoppingBasket);
            return new ReceiptGenerator().generateReceipt(order);
        }
    }

    static String readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

}
