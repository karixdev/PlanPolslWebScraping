package org.example.webscraper;

import org.example.course.Course;
import org.example.course.Weeks;
import org.example.exception.EmptyCourseElementException;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Map;

public class ElementToCourseMapperTest {

    private final static String VALID_CW_EXAMPLE = "154";
    private final static String VALID_CH_EXAMPLE = "56";
    private final static String VALID_TEXT_EXAMPLE = "some text";
    private final static String VALID_TOP_EXAMPLE = "304";
    private final static String VALID_LEFT_EXAMPLE = "420";

    @Test
    public void shouldThrowEmptyCourseElementWithNotValidElement() {
        // given
        Element element = createValidCourseElement("", "0", "0", Map.of());

        // when and then
        Assertions.assertThrows(EmptyCourseElementException.class, () -> ElementToCourseMapper.map(element, 7));
    }

    @Test
    public void shouldReturnCorrectCourseWithValidCredentials() {
        // given
        Element element = createValidCourseElement(VALID_TEXT_EXAMPLE, VALID_CW_EXAMPLE, VALID_CH_EXAMPLE, getValidStylesMap());

        // when
        Course result = ElementToCourseMapper.map(element, 7);

        // then
        Course target = new Course(
                VALID_TEXT_EXAMPLE,
                LocalTime.of(8, 30),
                LocalTime.of(10, 0),
                DayOfWeek.WEDNESDAY,
                Weeks.EVERY
        );
        Assertions.assertEquals(target, result);
    }

    public static Element createValidCourseElement(String text, String cw, String ch, Map<String, String> stylesMap) {
        Element element = new Element("div");

        // Set attributes
        element.attr("cw", cw);
        element.attr("ch", ch);

        // Set styles
        StringBuilder stylesBuilder = new StringBuilder();
        stylesMap.forEach((key, value) -> stylesBuilder
                .append(key)
                .append(":")
                .append(value)
                .append(";"));

        element.attr("style", stylesBuilder.toString());

        // Set text
        element.text(text);

        return element;
    }

    private static Map<String, String> getValidStylesMap() {
        return Map.of(
                "top", VALID_TOP_EXAMPLE,
                "left", VALID_LEFT_EXAMPLE
        );
    }
}
