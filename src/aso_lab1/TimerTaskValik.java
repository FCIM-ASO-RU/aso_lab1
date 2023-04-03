package aso_lab1;

import java.time.LocalDate;
import java.util.TimerTask;
import java.util.stream.Stream;

public class TimerTaskValik extends TimerTask {
    @Override
    public void run() {
        Stream.iterate(LocalDate.of(2023,4,11), a-> a.plusYears(1))
                .limit(5)
                .map(LocalDate::getDayOfWeek)
                .forEach(System.out::println);
    }
}