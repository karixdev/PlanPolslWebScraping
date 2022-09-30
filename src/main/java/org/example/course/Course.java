package org.example.course;

import java.time.LocalTime;

public record Course(
        String name,
        String room,
        String teacher,
        LocalTime startsAt,
        LocalTime endsAt,
        Weeks weeks
) {
    public Course(String name, LocalTime startsAt, LocalTime endsAt, Weeks weeks) {
        this(name, null, null, startsAt, endsAt, weeks);
    }
}
