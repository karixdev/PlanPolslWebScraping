package org.example.webscraper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.course.Course;
import org.example.exception.EmptyTimeCellListException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
public class CoursesWebScraper {
    private final static String COURSE_ELEMENT_CLASS = "coursediv";

    private ElementToCourseMapper elementToCourseMapper;

    public List<Course> getCourses(Document document) {
        Elements coursesElements = document.getElementsByClass(COURSE_ELEMENT_CLASS);

        return coursesElements.stream()
                .map(elementToCourseMapper::map)
                .filter(Objects::nonNull)
                .toList();
    }
}
