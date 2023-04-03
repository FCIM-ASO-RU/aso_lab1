package aso_lab1;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.TimerTask;

public class PrintTimestampTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("Current date and time is: " +
                ZonedDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
    }
}