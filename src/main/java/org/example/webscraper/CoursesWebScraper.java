package org.example.webscraper;

import org.example.course.Course;
import org.example.exception.EmptyTimeCellListException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CoursesWebScraper {

    private final static String COURSE_ELEMENT_CLASS = "coursediv";
    private final static String TIME_CELL_CLASS = "cd";

    public final Document document;

    public List<Course> courses;

    public CoursesWebScraper(Document document) {
        this.document = document;
        this.courses = new ArrayList<>();
    }

    public int getScheduleStartTime() {
        List<Element> timeCellsList = document.getElementsByClass(TIME_CELL_CLASS).stream()
                .filter(element -> TimeCellUtils.isValidTimeCell(element.text()))
                .toList();

        if (timeCellsList.size() == 0) {
            throw new EmptyTimeCellListException("Could not find any time cell");
        }

        return LocalTime.parse(timeCellsList.get(0).text().split("-")[0]).getHour();
    }
}
