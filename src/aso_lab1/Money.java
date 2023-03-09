package aso_lab1;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.*;

public class Money extends TimerTask {
    private static final int GOAL = 5000; // Цель
    private int balance; // Баланс
    private final Timer timer; // Таймер

    public Money(Timer timer) {
        this.timer = timer;
    }

    public void run() {
        int amount = (int)(Math.random() * 1000);
        balance += amount;
        System.out.println("Dobavleno " + amount + " deneg. Balans: " + balance);
        if (balance >= GOAL) {
            playSound();
            System.out.println("Na dereviah rastut denigi!");
            cancel();
            timer.cancel();
        }
    }

    private void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Objects.requireNonNull(Money.class.getResourceAsStream("cash_register.wav")));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            while (!clip.isRunning()) {
                Thread.sleep(10);
            }
            while (clip.isRunning()) {
                Thread.sleep(10);
            }
            clip.close();
            audioInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}