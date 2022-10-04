package org.example.webscraper;

import org.example.course.Course;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class CoursesWebScraper {

    private final static String COURSE_ELEMENT_CLASS = ".coursediv";

    public final Document document;

    public List<Course> courses;

    public CoursesWebScraper(Document document) {
        this.document = document;
        this.courses = new ArrayList<>();
    }
}
