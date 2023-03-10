package aso_lab1;

import TeamE.PruteanStanislav;

import java.util.Timer;

public class Main {

    public static void main(String[] args) {
        final Timer timer = new Timer();

        PruteanStanislav pruteanTimerImpl = new PruteanStanislav();

        timer.schedule(pruteanTimerImpl, 0, 1000);
    }
    
}
