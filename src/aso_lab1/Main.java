package aso_lab1;


import java.util.Timer;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        PrintTimestampTask printTimestampTask = new PrintTimestampTask();
        TimerTaskJasmina timerTaskJasmina = new TimerTaskJasmina();
        TimerTaskValik timerTaskValik = new TimerTaskValik();

        timer.schedule(printTimestampTask, 100,1000);
        timer.schedule(timerTaskJasmina,50,500);
        timer.schedule(timerTaskValik,20,800);
    }
    
}
