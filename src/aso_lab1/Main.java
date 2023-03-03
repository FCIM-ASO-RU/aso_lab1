package aso_lab1;

import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {
        final Timer timer = new Timer();
        TimerTask taskPrisacari = new PrisacariSerghei();
        timer.schedule(taskPrisacari, 10000);

    }
    
}
