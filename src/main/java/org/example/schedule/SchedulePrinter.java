package org.example.schedule;

import org.example.course.Course;
import org.example.course.Weeks;

import java.time.DayOfWeek;
import java.util.LinkedList;
import java.util.List;

public class SchedulePrinter {
    public static void print(Schedule schedule) {
        List<Course> courses = schedule.getCourses();
        DayOfWeek lastDayOfWeek = courses.get(0).dayOfWeek();

        for (int i = 0; i < schedule.getCourses().size(); i++) {
            Course course = courses.get(i);

            if (!lastDayOfWeek.equals(course.dayOfWeek()) || i == 0) {
                lastDayOfWeek = course.dayOfWeek();
                System.out.println("-----------");
                System.out.println(lastDayOfWeek);
                System.out.println("-----------");
            }

            System.out.println();
            System.out.println("Description: " + course.description());
            System.out.println("Starts at: " + course.startsAt());
            System.out.println("Ends at: " + course.endsAt());
            String weeks = "On: " +
                    course.weeks().getValue() +
                    " " +
                    (course.weeks().equals(Weeks.EVERY) ? "week" : "weeks");
            System.out.println(weeks);
            System.out.println();
        }
    }
}
