package org.example.schedule;

import org.example.course.Course;
import org.example.url.Url;
import org.example.webscraper.CoursesWebScraper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public class Schedule {
    private String id;

    private List<Course> courses;

    public Schedule(String id) {
        this.id = id;
    }

    public void download() throws IOException {
        ScheduleUrlBuilder urlBuilder = new ScheduleUrlBuilder(id);
        Url url = urlBuilder.build();

        Document document = Jsoup.connect(url.toString()).get();

        courses = CoursesWebScraper.getCourses(document)
                .stream()
                .sorted()
                .toList();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
