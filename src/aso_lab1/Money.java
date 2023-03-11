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
    } // конструктор который принимает объект таймера

    public void run() {
        int amount = (int)(Math.random() * 1000);   //Math.random() генерирует от 0 - 1 , умножаем на 1000 и получаем результат от 0 до 1000
        balance += amount; // добавляем к балансу деньги
        System.out.println("Dobavleno " + amount + " deneg. Balans: " + balance); // вывод на экран
        if (balance >= GOAL) { // если баланс достиг цели, то
            playSound(); // сыграть музыку
            System.out.println("Na dereviah rastut denigi!"); // финальный вывод
            cancel(); //закрыть задание
            timer.cancel(); // остановить таймер
        }
    }

    private void playSound() { // метод играть музыку
        try {
            // открываем файл музыки и стартуем аудипоток
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Objects.requireNonNull(Money.class.getResourceAsStream("cash_register.wav")));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();//стартуем аудипоток
            while (!clip.isRunning()) {   //ждет пока не начнет проигрывание
                Thread.sleep(10); // ждать 10 миллисекунд
            }
            while (clip.isRunning()) {    //ждет пока музыка закончится
                Thread.sleep(10); // ждать 10 миллисекунд
            }
            clip.close();             //закрыть аудиопоток
            audioInputStream.close();
        } catch (Exception e) { // ловим исключение
            e.printStackTrace();
        }
    }
}