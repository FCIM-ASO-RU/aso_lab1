package aso_lab1;

import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {
        final Timer timer = new Timer();
        TimerTask moneyTree = new Money(timer);
        timer.scheduleAtFixedRate(moneyTree, 0, 2000);
        
        
    }
    
}
