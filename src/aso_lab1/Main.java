package aso_lab1;

import java.util.Timer;

public class Main {
    private static final int GREEN_TIME_MS = 5000;
    private static final int YELLOW_TIME_MS = 2000;
    private static final int RED_TIME_MS = 5000;

    public static void main(String[] args) {
        Light greenLight = new Light("Green", GREEN_TIME_MS);
        Light yellowLight = new Light("Yellow", YELLOW_TIME_MS);
        Light redLight = new Light("Red", RED_TIME_MS);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(greenLight, 0, GREEN_TIME_MS + YELLOW_TIME_MS + RED_TIME_MS);
        timer.scheduleAtFixedRate(yellowLight, GREEN_TIME_MS, GREEN_TIME_MS + YELLOW_TIME_MS + RED_TIME_MS);
        timer.scheduleAtFixedRate(redLight, GREEN_TIME_MS + YELLOW_TIME_MS,
                GREEN_TIME_MS + YELLOW_TIME_MS + RED_TIME_MS);
    }
}
