package org.example.webscraper;

import org.example.course.Course;
import org.example.exception.EmptyTimeCellListException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

public class CoursesWebScraper {

    private final static String COURSE_ELEMENT_CLASS = "coursediv";
    private final static String TIME_CELL_CLASS = "cd";

    public static int getScheduleStartTime(Document document) {
        List<Element> timeCellsList = document.getElementsByClass(TIME_CELL_CLASS).stream()
                .filter(element -> TimeCellUtils.isValidTimeCell(element.text()))
                .toList();

        if (timeCellsList.size() == 0) {
            throw new EmptyTimeCellListException("Could not find any time cell");
        }

        return LocalTime.parse(timeCellsList.get(0).text().split("-")[0]).getHour();
    }

    public static List<Course> getCourses(Document document) {
        int startTime = getScheduleStartTime(document);

        Elements coursesElements = document.getElementsByClass(COURSE_ELEMENT_CLASS);

        return coursesElements.stream()
                .map(element -> ElementToCourseMapper.map(element, startTime))
                .filter(Objects::nonNull)
                .toList();
    }
}
