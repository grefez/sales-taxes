package com.hal9000.salestaxes.application;

import static com.hal9000.salestaxes.application.Application.ARGUMENTS_ERROR;
import static com.hal9000.salestaxes.application.Application.FILE_ERROR_PREFIX;
import static com.hal9000.salestaxes.application.Application.readFile;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ApplicationTest {

    public static final String BASE_PATH = "src/test/resources";

    @Test
    @DisplayName("validate input 1")
    public void testInput1 () {
        validate(1);
    }

    @Test
    @DisplayName("validate input 2")
    public void testInput2 () {
        validate(2);
    }

    @Test
    @DisplayName("validate input 3")
    public void testInput3 () {
        validate(3);
    }

    @Test
    @DisplayName("Should return error message when invalid number of arguments")
    public void testWrongArguments () {
        assertEquals(ARGUMENTS_ERROR, Application.getOutput(new String[]{}));
        assertEquals(ARGUMENTS_ERROR, Application.getOutput(new String[]{"1","2"}));
    }

    @Test
    @DisplayName("Should return error message when file could not be read")
    public void testInputFileNotRead () {
        assertTrue(Application.getOutput(new String[]{"NonExistent.txt"}).startsWith(FILE_ERROR_PREFIX));
    }

    private void validate (int exampleNumber) {

        assertEquals(readFile(format(BASE_PATH + "/output%s.txt", exampleNumber)).orElse("not found"),
                Application.getOutput(new String[]{format(BASE_PATH + "/input%s.txt", exampleNumber)}));

    }

}