package org.example.schedule;

import org.example.course.Course;

import java.util.List;

public class Schedule {
    private String id;

    private List<Course> courses;

    public Schedule(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
