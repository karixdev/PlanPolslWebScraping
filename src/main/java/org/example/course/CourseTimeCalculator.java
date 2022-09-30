package org.example.course;

import java.time.LocalTime;

public class CourseTimeCalculator {
    public static final int FIRST_CELL_TOP_VALUE = 237;
    public static final double ONE_HOUR_BLOCK_HEIGHT = 45;

    public static LocalTime getTime(int top, double startsAt) {
        int difference = top - FIRST_CELL_TOP_VALUE;
        double ratio = difference / ONE_HOUR_BLOCK_HEIGHT;
        ratio /= 0.25;

        int totalNumOfQuarters = (int) Math.ceil(ratio);
        totalNumOfQuarters *= 15;

        double totalTime = totalNumOfQuarters / 60.0 + startsAt;
        int hours = (int) totalTime;
        int minutes = (int) ((totalTime - hours) * 60);

        return LocalTime.of(hours, minutes);
    }
}
