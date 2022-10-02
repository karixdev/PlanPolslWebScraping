package org.example.webscraper;

import org.example.course.Course;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class WebScrapeCoursesTest {
    @Test
    public void shouldReturnFalseForEmptyCourse() {
        // given
        Element element = new Element("div");

        // when
        boolean result = WebScrapeCourses.isNotBlankCourse(element);

        // then
        Assertions.assertFalse(result);
    }

    @Test
    public void shouldReturnTrueForNotEmptyCourse() {
        // given
        Element element = new Element("div");
        element.attr("cw", "10");
        element.attr("ch", "10");

        // when
        boolean result = WebScrapeCourses.isNotBlankCourse(element);

        // then
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldReturnValidCourseObject() {
        // given
        Element element = createValidCourseElement("algebra course", "420", "304", "154");

        // when
        Course result = WebScrapeCourses.transformElementIntoCourse(element);

        // then
        Course course = new Course("algebra course", LocalTime.of());
    }

    public Element createValidCourseElement(String text, String left, String top, String cw) {
        Element element = new Element("div");

        // Set attributes
        element.attr("cw", cw);
        element.attr("ch", "56");

        // Set styles
        String styles = "top: " + top + "px; left: " + left + "px";
        element.attr("style", styles);

        // Set text
        element.text(text);

        return element;
    }
}
