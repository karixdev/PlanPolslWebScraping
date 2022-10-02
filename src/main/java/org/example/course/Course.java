package org.example.course;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record Course(
        String description,
        LocalTime startsAt,
        LocalTime endsAt,
        DayOfWeek dayOfWeek,
        Weeks weeks
) {
}
