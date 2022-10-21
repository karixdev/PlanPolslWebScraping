package org.example.schedule;

import org.example.course.Course;
import org.example.url.Url;
import org.example.webscraper.CoursesWebScraper;
import org.example.webscraper.ElementToCourseMapper;
import org.example.webscraper.ScheduleTimeWebScraper;
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

        // get schedule start time
        ScheduleTimeWebScraper scheduleTimeWebScraper = new ScheduleTimeWebScraper(document);
        int startTime = scheduleTimeWebScraper.getScheduleStartTime();

        // create mapper
        ElementToCourseMapper elementToCourseMapper = new ElementToCourseMapper(startTime);

        // create web scraper
        CoursesWebScraper coursesWebScraper = new CoursesWebScraper(elementToCourseMapper);

        courses = coursesWebScraper.getCourses(document)
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
