package org.example.schedule;

import org.example.course.Course;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Objects;

public class SchoolDay {
    private DayOfWeek dayOfWeek;
    private List<Course> courses;

    public SchoolDay(DayOfWeek dayOfWeek, List<Course> courses) {
        this.dayOfWeek = dayOfWeek;
        this.courses = courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolDay schoolDay = (SchoolDay) o;
        return dayOfWeek == schoolDay.dayOfWeek && Objects.equals(courses, schoolDay.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dayOfWeek, courses);
    }
}
