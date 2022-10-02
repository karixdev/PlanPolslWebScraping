package org.example.css;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class CssPropertyExtractorClassTest {
    @Test
    public void shouldReturnZeroWithEmptyProperty() {
        // given
        Map<String, String> stylesMap = new HashMap<>();

        // when
        int result = CssPropertyExtractor.getTop(stylesMap);

        // then
        Assertions.assertEquals(0, result);
    }

    @Test
    public void shouldReturnNonZeroWithNotEmptyProperty() {
        // given
        Map<String, String> stylesMap = Map.of("top", "29px");

        // when
        int result = CssPropertyExtractor.getTop(stylesMap);

        // then
        Assertions.assertEquals(29, result);
    }
}
