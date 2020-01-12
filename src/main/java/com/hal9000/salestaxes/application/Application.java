package com.hal9000.salestaxes.application;

import static java.lang.String.format;
import static java.util.Optional.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

public class Application {

    static final String ARGUMENTS_ERROR = "Please add shopping basket file name as argument";
    static final String FILE_ERROR_PREFIX = "Error reading";

    public static void main (String[] args) {
        System.out.println(getOutput(args));
    }

    static String getOutput(String[] args) {

        if (args.length != 1) {
            return ARGUMENTS_ERROR;
        } else {
            String fileName = args[0];

            return readFile(fileName)
                .map(shoppingBasket -> new ReceiptGenerator().generateReceipt(new OrderReader().readItems(shoppingBasket)))
                .orElseGet(() -> format("%s %s", FILE_ERROR_PREFIX, fileName));
        }
    }

    static Optional<String> readFile(String fileName) {
        try {
            return Optional.of(new String(Files.readAllBytes(Paths.get(fileName))));
        } catch (IOException e) {
            System.out.println (e);
            return empty();
        }
    }

}
