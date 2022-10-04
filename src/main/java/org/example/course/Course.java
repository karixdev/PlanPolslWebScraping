package org.example.course;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record Course(
        String description,
        LocalTime startsAt,
        LocalTime endsAt,
        DayOfWeek dayOfWeek,
        Weeks weeks
) implements Comparable<Course>{
    @Override
    public int compareTo(Course course) {
        if (dayOfWeek.compareTo(course.dayOfWeek) != 0) {
            return dayOfWeek.compareTo(course.dayOfWeek);
        }

        return startsAt.compareTo(course.startsAt);
    }
}
