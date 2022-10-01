package org.example.course;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record Course(
        String name,
        String room,
        String teacher,
        LocalTime startsAt,
        LocalTime endsAt,
        DayOfWeek dayOfWeek,
        Weeks weeks
) {
    public Course(String name, LocalTime startsAt, LocalTime endsAt, DayOfWeek dayOfWeek, Weeks weeks) {
        this(name, null, null, startsAt, endsAt, dayOfWeek, weeks);
    }
}
