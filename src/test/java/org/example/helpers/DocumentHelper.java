package org.example.helpers;

import org.example.course.Course;
import org.example.course.Weeks;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

public class DocumentHelper {
    private static final String EXAMPLE_FILE_RELATIVE_PATH = "src/test/java/org/example/helpers/schedule.html";

    public static Document loadDocumentFromFile() throws IOException {
        return Jsoup.parse(new File(EXAMPLE_FILE_RELATIVE_PATH), "UTF-8");
    }

    public static List<Course> getCoursesFromExampleFile() {
        return List.of(
                new Course("course_1", LocalTime.of(14, 0), LocalTime.of(15, 30), DayOfWeek.WEDNESDAY, Weeks.EVERY),
                new Course("course_2", LocalTime.of(10, 0), LocalTime.of(11, 30), DayOfWeek.MONDAY, Weeks.EVERY),
                new Course("course_3", LocalTime.of(12, 0), LocalTime.of(13, 30), DayOfWeek.THURSDAY, Weeks.EVERY),
                new Course("course_4", LocalTime.of(12, 15), LocalTime.of(13, 45), DayOfWeek.WEDNESDAY, Weeks.EVERY)
        );
    }
}
