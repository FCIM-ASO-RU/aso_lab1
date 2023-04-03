package aso_lab1;

import java.util.Date;
import java.util.TimerTask;

public class Light extends TimerTask {
    private final String color;
    private final int time;

    public Light(String color, int time) {
        this.color = color;
        this.time = time;
    }

    @Override
    public void run() {
        Date now = new Date();
        System.out.println(now + " - " + color + " light is on.");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}