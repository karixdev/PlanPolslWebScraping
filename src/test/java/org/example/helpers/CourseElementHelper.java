package org.example.helpers;

import org.example.course.Course;
import org.example.course.Weeks;
import org.jsoup.nodes.Element;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Map;

public class CourseElementHelper {
    public final static String VALID_CW_EXAMPLE = "154";
    public final static String VALID_CH_EXAMPLE = "56";
    public final static String VALID_TEXT_EXAMPLE = "some text";
    public final static String VALID_TOP_EXAMPLE = "304";
    public final static String VALID_LEFT_EXAMPLE = "420";
    public static final int SCHEDULE_START_TIME = 7;

    public static Element createCourseElement(String text, String cw, String ch, Map<String, String> stylesMap) {
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

    public static Map<String, String> getValidStylesMap() {
        return Map.of(
                "top", VALID_TOP_EXAMPLE,
                "left", VALID_LEFT_EXAMPLE
        );
    }

    public static Element createValidCourseElement() {
        return createCourseElement(
                CourseElementHelper.VALID_TEXT_EXAMPLE,
                CourseElementHelper.VALID_CW_EXAMPLE,
                CourseElementHelper.VALID_CH_EXAMPLE,
                getValidStylesMap());
    }

    public static Course createCourse() {
        return new Course(
                CourseElementHelper.VALID_TEXT_EXAMPLE,
                LocalTime.of(SCHEDULE_START_TIME + 1, 30),
                LocalTime.of(SCHEDULE_START_TIME + 3, 0),
                DayOfWeek.WEDNESDAY,
                Weeks.EVERY
        );
    }
}
