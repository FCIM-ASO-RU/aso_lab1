package aso_lab1;

import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {
        final Timer timer = new Timer();      //создаем таймер
        TimerTask moneyTree = new Money(timer);    //создаем задачу и в него передаем таймер
        timer.scheduleAtFixedRate(moneyTree, 0, 2000);   //таймер вызывает задание moneyTree через каждые 2 сек


    }
    
}
