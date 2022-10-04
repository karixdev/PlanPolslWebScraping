package org.example.webscraper;

import org.example.course.Course;
import org.example.exception.EmptyTimeCellListException;
import org.example.helpers.DocumentHelper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class CoursesWebScraperTest {
    @Test
    public void shouldThrowExceptionWhenNotFoundAnyTimeCell() {
        // given
        Document document = Jsoup.parse("");

        // when and then
        Assertions.assertThrows(EmptyTimeCellListException.class, () -> CoursesWebScraper.getScheduleStartTime(document));
    }

    @Test
    public void shouldReturnCorrectScheduleTimeStartProvidedValidDocument() {
        // given
        Document document = Jsoup.parse("""
                <div class="cd">07:00-08:00</div>
                <div class="cd">13:00-14:00</div>
                <div class="cd">20:00-21:00</div>
                """);

        // when
        int result = CoursesWebScraper.getScheduleStartTime(document);

        // then
        Assertions.assertEquals(7, result);
    }

    @Test
    public void shouldReturnEmptyListWithNoCourseElements() {
        // given
        Document document = Jsoup.parse("""
                <div class="cd">07:00-08:00</div>
                """);

        // when
        List<Course> result = CoursesWebScraper.getCourses(document);

        // then
        Assertions.assertEquals(0, result.size());
    }

    @Test
    public void shouldReturnCorrectListWithProvidedDocument() throws IOException {
        // given
        Document document = DocumentHelper.loadDocumentFromFile();

        // when
        List<Course> result = CoursesWebScraper.getCourses(document);

        // then
        Assertions.assertEquals(DocumentHelper.getCoursesFromExampleFile(), result);
    }
}
