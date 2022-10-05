package org.example;

import org.example.schedule.Schedule;
import org.example.schedule.SchedulePrinter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Schedule schedule = new Schedule("68299");
        try {
            schedule.download();
            SchedulePrinter.print(schedule);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
