package org.example.course;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class CourseTimeCalculatorTest {
    @Test
    public void shouldReturnCorrectTimeWithProvidedTopValue() {
        // given
        int top = 259;

        // when
        LocalTime result = CourseDateAndTimeCalculator.getTime(top, 8);

        // then
        Assertions.assertEquals(LocalTime.of(8, 30), result);
    }

    @Test
    public void shouldReturnCorrectDayForCourseOnEveryWeek() {
        // given
        int left = 88;

        // when
        DayOfWeek result = CourseDateAndTimeCalculator.getDayOfWeek(left);

        // then
        Assertions.assertEquals(DayOfWeek.MONDAY, result);
    }

    @Test
    public void shouldReturnCorrectDayForCourseOnNotEveryWeek() {
        // given
        int left = 337;

        // when
        DayOfWeek result = CourseDateAndTimeCalculator.getDayOfWeek(left);

        // then
        Assertions.assertEquals(DayOfWeek.TUESDAY, result);
    }

    @Test
    public void shouldReturnOddWeeks() {
        // given
        int left = 337;
        int cw = 71;
        DayOfWeek dayOfWeek = DayOfWeek.TUESDAY;

        // when
        Weeks result = CourseDateAndTimeCalculator.getWeeks(left, cw, dayOfWeek);

        // then
        Assertions.assertEquals(Weeks.ODD, result);
    }

    @Test
    public void shouldReturnEvenWeeks() {
        // given
        int left = 254;
        int cw = 71;
        DayOfWeek dayOfWeek = DayOfWeek.TUESDAY;

        // when
        Weeks result = CourseDateAndTimeCalculator.getWeeks(left, cw, dayOfWeek);

        // then
        Assertions.assertEquals(Weeks.EVEN, result);
    }

    @Test
    public void shouldReturnEveryWeek() {
        // given
        int left = 254;
        int cw = 154;
        DayOfWeek dayOfWeek = DayOfWeek.TUESDAY;

        // when
        Weeks result = CourseDateAndTimeCalculator.getWeeks(left, cw, dayOfWeek);

        // then
        Assertions.assertEquals(Weeks.EVERY, result);
    }
}
