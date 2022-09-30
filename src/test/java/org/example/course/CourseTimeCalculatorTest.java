package org.example.course;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class CourseTimeCalculatorTest {
    @Test
    public void shouldReturnCorrectTimeWithProvidedTopValue() {
        // given
        int top = 259;

        // when
        LocalTime result = CourseTimeCalculator.getTime(top, 8);

        // then
        Assertions.assertEquals(LocalTime.of(8, 30), result);
    }
}
