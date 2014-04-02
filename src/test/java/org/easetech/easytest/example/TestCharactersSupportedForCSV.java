package org.easetech.easytest.example;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "supportedCharacters.csv")
public class TestCharactersSupportedForCSV {

    @Test
    public void single_quote_is_part_of_value_and_is_preserved(@Param(name = "value1") String value1, @Param(name = "value2") String value2) {
        assertEquals("'", value1);
        assertEquals("'value2'", value2);
    }

    @Test
    public void double_quote_encapsulates_value_and_is_stripped(@Param(name = "value1") String value1, @Param(name = "value2") String value2) {
        assertEquals("", value1);
        assertEquals("value2", value2);
    }

    /**
     * http://tools.ietf.org/html/rfc4180, point #7:
     * "If double-quotes are used to enclose fields, then a double-quote
     * appearing inside a field must be escaped by preceding it with
     * another double quote."
     */
    @Test
    public void double_quote_can_be_used_to_within_a_field(@Param(name = "value1") String value1,
                                                           @Param(name = "value2") String value2,
                                                           @Param(name = "value3") String value3
    ) {
        assertEquals("aaa", value1);
        assertEquals("b\"bb", value2);
        assertEquals("ccc", value3);
    }


    @Test
    public void alphanumeric_characters_are_supported(@Param(name = "lowercase") String lowercase,
                                                      @Param(name = "uppercase") String uppercase,
                                                      @Param(name = "numbers") String numbers) {
        String a2z = "abcdefghijklmnopqrstuvwxyz";

        assertEquals(a2z, lowercase);
        assertEquals(a2z.toUpperCase(), uppercase);
        assertEquals("0123456789", numbers);
    }

    @Test
    public void symbolic_characters_are_supported(@Param(name = "symbols") String symbols) {
        assertEquals("-=!@#$%^&*()_+/\\[]{}", symbols);
    }

    @Test
    public void punctuation_characters_are_supported(@Param(name = "punctuation") String punctuation, @Param(name = "comma") String comma) {
        assertEquals("`~.?;:'", punctuation);
        assertEquals(",", comma);
    }

    @Test
    public void line_breaks_are_supported(@Param(name = "value") String value) {
        assertEquals("line" + System.getProperty("line.separator") + "break", value);
    }

}
