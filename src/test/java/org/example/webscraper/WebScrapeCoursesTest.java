package org.example.webscraper;

import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
