package aso_lab1;

import java.util.TimerTask;

public class TimerTaskJasmina extends TimerTask {
    @Override
    public void run() {
        for (int i = 0;i<10;i++){
            System.out.println("Несу журнал");
        }
    }
}
