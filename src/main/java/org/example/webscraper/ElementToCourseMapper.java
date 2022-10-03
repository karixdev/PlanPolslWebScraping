package org.example.webscraper;

import org.example.course.Course;
import org.example.course.CourseDateAndTimeCalculator;
import org.example.course.Weeks;
import org.example.css.CssPropertyExtractor;
import org.example.exception.EmptyCourseElementException;
import org.example.html.HtmlAttributeValueExtractor;
import org.jsoup.nodes.Element;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Map;
import java.util.Objects;

public class ElementToCourseMapper {
    public static Course map(Element element,  int scheduleStartTime) {
        Map<String, String> styles = HtmlAttributeValueExtractor.getStyles(element);

        int top = CssPropertyExtractor.getSizeProperty(styles, "top");
        int left = CssPropertyExtractor.getSizeProperty(styles, "left");

        int ch = HtmlAttributeValueExtractor.getSizeAttribute(element, "ch");
        int cw = HtmlAttributeValueExtractor.getSizeAttribute(element, "cw");

        if (top <= 0 || left <= 0 || ch <= 0 || cw <= 0 || styles.isEmpty() || element.text().equals("")) {
            throw new EmptyCourseElementException("Provided data is not valid course element");
        }

        LocalTime startsAt = CourseDateAndTimeCalculator.getTime(top, scheduleStartTime, false);
        LocalTime endsAt = CourseDateAndTimeCalculator.getTime(top + ch, scheduleStartTime, true);
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
