package org.example.webscraper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.exception.EmptyTimeCellListException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.time.LocalTime;
import java.util.List;
import java.util.regex.Pattern;

@Getter
@Setter
@AllArgsConstructor
public class ScheduleTimeWebScraper {

    private final static String TIME_CELL_CLASS = "cd";

    private Document document;

    public int getScheduleStartTime() {
        List<Element> timeCellsList = document.getElementsByClass(TIME_CELL_CLASS).stream()
                .filter(element -> isValidTimeCell(element.text()))
                .toList();

        if (timeCellsList.size() == 0) {
            throw new EmptyTimeCellListException("Could not find any time cell");
        }

        return LocalTime.parse(timeCellsList.get(0).text().split("-")[0]).getHour();
    }

    public boolean isValidTimeCell(String text) {
        if (text.length() != 11) {
            return false;
        }

        Pattern regexPattern = Pattern.compile("[0-9]+:[0-9]+-[0-9]+:[0-9]+", Pattern.CASE_INSENSITIVE);
        return regexPattern.matcher(text).matches();
    }
}
