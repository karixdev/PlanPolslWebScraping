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
        return switch(dayOfWeek.compareTo(course.dayOfWeek)) {
            case 1 -> 1;
            case 0 -> (-1) * startsAt.compareTo(course.startsAt);
            default -> -1;
        };
    }
}
