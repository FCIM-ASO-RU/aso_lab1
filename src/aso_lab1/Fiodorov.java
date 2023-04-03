package aso_lab1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class Fiodorov extends TimerTask {
    private static final String CSV_FILE_PATH = "..\\aso_lab1\\src\\schedule.csv";
    private static final long MINUTES_15_IN_MILLIS = 900_000L;
    
    public void scheduleTasks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] taskData = line.split(",");
                String taskName = taskData[0].trim();
                LocalTime taskTime = LocalTime.parse(taskData[1].trim());
                String room = taskData[2].trim();
                String teacherName = taskData[3].trim();

                scheduleTask(taskName, taskTime, room, teacherName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void scheduleTask(String taskName, LocalTime taskTime, String room, String teacherName) {
        LocalTime alarmTime = taskTime.minusMinutes(15);
        long delayMillis = alarmTime.toNanoOfDay() - LocalTime.now().toNanoOfDay();
        if (delayMillis <= 0) {
            System.out.println("Skipping task " + taskName + " - already started");
            return;
        }

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Alarm for task " + taskName + " in room " + room + " with teacher " + teacherName);
                timer.cancel();
            }
        };
        timer.schedule(task, delayMillis - MINUTES_15_IN_MILLIS);
    }

    @Override
    public void run() {
        scheduleTasks();
    }
}