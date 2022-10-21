package org.example.webscraper;

import org.example.course.Course;
import org.example.helpers.DocumentHelper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class CoursesWebScraperTest {
    private CoursesWebScraper coursesWebScraper;

    @BeforeEach
    public void setup() {
        coursesWebScraper = new CoursesWebScraper(
                new ElementToCourseMapper(7));
    }

    @Test
    public void shouldReturnEmptyListWithNoCourseElements() {
        // given
        Document document = Jsoup.parse("""
                <div class="cd">07:00-08:00</div>
                """);

        // when
        List<Course> result = coursesWebScraper.getCourses(document);

        // then
        Assertions.assertEquals(0, result.size());
    }

    @Test
    public void shouldReturnCorrectListWithProvidedDocument() throws IOException {
        // given
        Document document = DocumentHelper.loadDocumentFromFile();

        // when
        List<Course> result = coursesWebScraper.getCourses(document);

        // then
        Assertions.assertEquals(DocumentHelper.getCoursesFromExampleFile(), result);
    }
}
