package org.example.schedule;

import org.example.course.Course;
import org.example.url.Url;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;

public class Schedule {
    private String id;

    private List<SchoolDay> schoolDays;

    public Schedule(String id) {
        this.id = id;
    }

    public void download() {
        // create url

        // web scrape

        // create list of course

        // group courses by day of week

        // add courses to schoolDays list
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SchoolDay> getSchoolDays() {
        return schoolDays;
    }

    public void setSchoolDays(List<SchoolDay> schoolDays) {
        this.schoolDays = schoolDays;
    }
}
