package org.example.html;

import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class HtmlAttributeValueExtractorTest {
    @Test
    public void returnsCorrectChValueWithNotEmptyAttribute() {
        // given
        int chValue = 10;
        Element el = new Element("div");
        el.attr("ch", String.valueOf(chValue));

        // when
        int result = HtmlAttributeValueExtractor.getCh(el);

        // then
        Assertions.assertEquals(chValue, result);
    }

    @Test
    public void returnsZeroWithEmptyAttribute() {
        // given
        int chValue = 0;
        Element el = new Element("div");

        // when
        int result = HtmlAttributeValueExtractor.getCh(el);

        // then
        Assertions.assertEquals(chValue, result);
    }

    @Test
    public void shouldReturnValidStylesMap() {
        // given
        Map<String, String> stylesMap = new HashMap<>();
        stylesMap.put("background-color", "blue");
        stylesMap.put("color", "white");
        stylesMap.put("padding", "10px 5px");

        Element el = new Element("div");

        StringBuilder stylesAttributeBuilder = new StringBuilder();
        stylesMap.forEach((key, value) -> stylesAttributeBuilder
                        .append(key)
                        .append(":")
                        .append(value)
                        .append(";"));
        el.attr("style", stylesAttributeBuilder.toString());


        // when
        Map<String, String> result = HtmlAttributeValueExtractor.getStyles(el);

        // then
        Assertions.assertEquals(stylesMap, result);
    }

    @Test
    public void shouldReturnZeroWithEmptyCwAttr() {
        // given
        Element el = new Element("div");
        int cwValue = 0;

        // when
        int result = HtmlAttributeValueExtractor.getCw(el);

        // then
        Assertions.assertEquals(cwValue, 0);
    }

    @Test
    public void shouldReturnNonZeroWithNotEmptyCwAttr() {
        // given
        Element el = new Element("div");
        int cwValue = 10;
        el.attr("cw", String.valueOf(cwValue));

        // when
        int result = HtmlAttributeValueExtractor.getCw(el);

        // then
        Assertions.assertEquals(cwValue, result);
    }
}
