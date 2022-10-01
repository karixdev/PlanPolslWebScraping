package org.example.course;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

public class CourseDateAndTimeConfig {
    // Time
    public static final int FIRST_CELL_TOP_VALUE = 237;
    public static final double ONE_HOUR_BLOCK_HEIGHT = 45;

    // Weeks
    public static final int EVERY_WEEK_CW_VALUE = 154;
    public static final int WEEK_CELL_HALF_OF_WIDTH = 83;

    public static Map<Integer, DayOfWeek> getDayOfWeekIntegerMap() {
        Map<Integer, DayOfWeek> hashmap = new HashMap<>();
        hashmap.put(88, DayOfWeek.MONDAY);
        hashmap.put(254, DayOfWeek.TUESDAY);
        hashmap.put(420, DayOfWeek.WEDNESDAY);
        hashmap.put(586, DayOfWeek.THURSDAY);
        hashmap.put(752, DayOfWeek.FRIDAY);
        hashmap.put(918, DayOfWeek.SATURDAY);

        return hashmap;
    }
}
