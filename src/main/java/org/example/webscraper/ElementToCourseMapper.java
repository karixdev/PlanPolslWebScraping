package org.example.webscraper;

import lombok.*;
import org.example.course.Course;
import org.example.course.CourseDateAndTimeCalculator;
import org.example.course.Weeks;
import org.example.css.CssPropertyExtractor;
import org.example.html.HtmlAttributeValueExtractor;
import org.jsoup.nodes.Element;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class ElementToCourseMapper {

    private int scheduleStartTime;

    public Course map(Element element) {
        Map<String, String> styles = HtmlAttributeValueExtractor.getStyles(element);

        int top = CssPropertyExtractor.getSizeProperty(styles, "top");
        int left = CssPropertyExtractor.getSizeProperty(styles, "left");

        int ch = HtmlAttributeValueExtractor.getSizeAttribute(element, "ch");
        int cw = HtmlAttributeValueExtractor.getSizeAttribute(element, "cw");

        if (!isValidCourseElement(element, styles, top, left, ch, cw)) {
            return null;
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

    private boolean isValidCourseElement(
            Element element,
            Map<String, String> styles,
            int top,
            int left,
            int ch,
            int cw) {
        return !element.text().equals("") &&
                !styles.isEmpty() &&
                top > 0 &&
                left > 0 &&
                ch > 0 &&
                cw > 0;
    }
}
