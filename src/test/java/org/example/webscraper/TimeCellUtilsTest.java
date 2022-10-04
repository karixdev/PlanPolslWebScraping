package org.example.webscraper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TimeCellUtilsTest {
    @Test
    public void shouldReturnTrueGivenValidTimeFormatText() {
        // given
        String text = "07:00-08:00";

        // when
        boolean result = TimeCellUtils.isValidTimeCell(text);

        // then
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldReturnFalseGivenNotValidTimeFormatText() {
        // given
        String text = "random text";

        // when
        boolean result = TimeCellUtils.isValidTimeCell(text);

        // then
        Assertions.assertFalse(result);
    }
}
