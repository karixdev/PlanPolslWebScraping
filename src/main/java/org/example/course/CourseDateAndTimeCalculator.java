package org.example.course;

import javax.swing.text.Element;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.*;

public class CourseDateAndTimeCalculator {

    // Weeks
    public static final int EVERY_WEEK_CW_VALUE = 154;

    public static LocalTime getTime(int top, double startsAt) {
        int difference = top - CourseDateAndTimeConfig.FIRST_CELL_TOP_VALUE;
        double ratio = difference / CourseDateAndTimeConfig.ONE_HOUR_BLOCK_HEIGHT;
        ratio /= 0.25;

        int totalNumOfQuarters = (int) Math.ceil(ratio);
        totalNumOfQuarters *= 15;

        double totalTime = totalNumOfQuarters / 60.0 + startsAt;
        int hours = (int) totalTime;
        int minutes = (int) ((totalTime - hours) * 60);

        return LocalTime.of(hours, minutes);
    }

    public static DayOfWeek getDayOfWeek(int left) {
        Map<Integer, DayOfWeek> leftValueMap = CourseDateAndTimeConfig.getDayOfWeekIntegerMap();
        if (leftValueMap.containsKey(left)) {
            return leftValueMap.get(left);
        }

        for (Integer key : leftValueMap.keySet()) {
            if (left == key + CourseDateAndTimeConfig.WEEK_CELL_HALF_OF_WIDTH) {
                return leftValueMap.get(key);
            }
        }

        throw new IllegalStateException("You should not be here");
    }
}
