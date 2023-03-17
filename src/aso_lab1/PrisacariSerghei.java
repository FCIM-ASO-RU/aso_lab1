package aso_lab1;

import java.util.TimerTask;

public class PrisacariSerghei extends TimerTask {


    public void run() {
        String username = System.getProperty("user.name");
        System.out.println("First task by PrisacariSerghei");
        System.out.println("Hi "+ username + ", this task does nothing.");
        System.out.println("Next task will starts in 2 sec...");
        try {
            Thread.sleep(1000);
            System.out.println("Next task will starts in 1 sec...");
            Thread.sleep(1000);
            System.out.println("Next task start.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

}
