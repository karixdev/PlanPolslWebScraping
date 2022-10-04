package org.example.webscraper;

import org.example.course.Course;
import org.example.course.Weeks;
import org.example.exception.EmptyCourseElementException;
import org.example.helpers.CourseElementHelper;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Map;

public class ElementToCourseMapperTest {
    @Test
    public void shouldReturnNullWithNotValidElement() {
        // given
        Element element = CourseElementHelper.createCourseElement("", "0", "0", Map.of());

        // when
        Course result = ElementToCourseMapper.map(element, 7);

        // then
        Assertions.assertNull(result);
    }

    @Test
    public void shouldReturnCorrectCourseWithValidCredentials() {
        // given
        Element element = CourseElementHelper.createValidCourseElement();

        // when
        Course result = ElementToCourseMapper.map(element, CourseElementHelper.SCHEDULE_START_TIME);

        // then
        Assertions.assertEquals(CourseElementHelper.createCourse(), result);
    }
}
