package com.hal9000.salestaxes.application;

import static com.hal9000.salestaxes.application.Application.readFile;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest {

    public static final String BASE_PATH = "src/test/resources";

    @Test
    @DisplayName("validate input 1")
    public void testInput1 () throws IOException {
        validate(1);
    }

    @Test
    @DisplayName("validate input 2")
    public void testInput2 () throws IOException {
        validate(2);
    }

    @Test
    @DisplayName("validate input 3")
    public void testInput3 () throws IOException {
        validate(3);
    }

    private void validate (int exampleNumber) {
        try {
            assertEquals(readFile(format(BASE_PATH + "/output%s.txt", exampleNumber)),
                Application.getOutput(new String[]{format(BASE_PATH + "/input%s.txt", exampleNumber)}));
        } catch (IOException e) {
            fail("Could not read files");
        }
    }

}