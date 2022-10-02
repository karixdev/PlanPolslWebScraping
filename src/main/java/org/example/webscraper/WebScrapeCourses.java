package org.example.webscraper;

import org.example.course.Course;
import org.example.course.CourseDateAndTimeCalculator;
import org.example.course.Weeks;
import org.example.css.CssPropertyExtractor;
import org.example.html.HtmlAttributeValueExtractor;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WebScrapeCourses {
    public final static String COURSE_DIV_SELECTOR = ".coursediv";

    public static List<Course> getCoursesFromDocument(Document document) {
        List<Course> courseList = new LinkedList<>();

        Elements elements = document.select(COURSE_DIV_SELECTOR);

        return elements.stream()
                .filter(WebScrapeCourses::isNotBlankCourse)
                .map(WebScrapeCourses::transformElementIntoCourse)
                .collect(Collectors.toList());
    }

    public static boolean isNotBlankCourse(Element element) {
        int ch = HtmlAttributeValueExtractor.getSizeAttribute(element, "ch");
        int cw = HtmlAttributeValueExtractor.getSizeAttribute(element, "cw");

        return ch != 0 && cw != 0;
    }

    public static Course transformElementIntoCourse(Element element) {
        Map<String, String> styles = HtmlAttributeValueExtractor.getStyles(element);

        int top = CssPropertyExtractor.getSizeProperty(styles, "top");
        int left = CssPropertyExtractor.getSizeProperty(styles, "left");

        int ch = HtmlAttributeValueExtractor.getSizeAttribute(element, "ch");
        int cw = HtmlAttributeValueExtractor.getSizeAttribute(element, "cw");

        LocalTime startsAt = CourseDateAndTimeCalculator.getTime(top, 7, false);
        LocalTime endsAt = CourseDateAndTimeCalculator.getTime(top + ch, 7, true);
        DayOfWeek dayOfWeek = CourseDateAndTimeCalculator.getDayOfWeek(left);
        Weeks weeks = CourseDateAndTimeCalculator.getWeeks(left, cw, dayOfWeek);

        return new Course(
                element.text(),
                startsAt,
                endsAt,
                dayOfWeek,
                weeks
        );
    }
}
