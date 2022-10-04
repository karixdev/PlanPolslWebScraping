package org.example.webscraper;

import org.example.exception.EmptyTimeCellListException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
