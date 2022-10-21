package org.example.webscraper;

import org.example.exception.EmptyTimeCellListException;
import org.example.helpers.DocumentHelper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ScheduleTimeWebScraperTest {

    private ScheduleTimeWebScraper scheduleTimeWebScraper;

    @BeforeEach
    public void setup() throws IOException {
        scheduleTimeWebScraper = new ScheduleTimeWebScraper(DocumentHelper.loadDocumentFromFile());
    }

    @Test
    public void shouldReturnTrueGivenValidTimeFormatText() {
        // given
        String text = "07:00-08:00";

        // when
        boolean result = scheduleTimeWebScraper.isValidTimeCell(text);

        // then
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldReturnFalseGivenNotValidTimeFormatText() {
        // given
        String text = "random text";

        // when
        boolean result = scheduleTimeWebScraper.isValidTimeCell(text);

        // then
        Assertions.assertFalse(result);
    }

    @Test
    public void shouldThrowExceptionWhenNotFoundAnyTimeCell() {
        // given
        Document document = Jsoup.parse("");

        // when
        scheduleTimeWebScraper.setDocument(document);

        // then
        Assertions.assertThrows(EmptyTimeCellListException.class, () -> scheduleTimeWebScraper.getScheduleStartTime());
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
        int result = scheduleTimeWebScraper.getScheduleStartTime();

        // then
        Assertions.assertEquals(7, result);
    }
}
