package aso_lab1;

import static java.sql.Timestamp.valueOf;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

import aso_lab1.team_rocket.ChiurcciuIvan;
import aso_lab1.team_rocket.CosneanuValeriuImpl;
import aso_lab1.team_rocket.RaminGashimovImpl;
import TeamE.PruteanStanislav;

public class Main {
    static Timer timer;
    
    static void about() {
        System.out.println("FCIM ASO RU LAB 1");
        System.out.println();
        System.out.println("Done by:");
        System.out.println("Team A - Chiurcciu Ivan, Coşneanu Valeriu, Gaşimov Ramin");
        System.out.println("Team B - Fiodorov Vladimir, Malanciuc Dmitri, Prisacari Serghei");
        System.out.println("Team C - Gribencicov Maxim, Homenschi Valentin, Marcova Jasmina");
        System.out.println("Team D - Melnic Dmitri, Şveţ Vadim, Tomaşciuc Iaroslav");
        System.out.println("Team E - Neer Ecaterina, Prutean Stanislav");
        System.out.println("Team F - Bulat Alexandr, Dubovîi Mihail, Patraşco Serghei");
        System.out.println();
        System.out.println("Use launch arguments to run their code (e.g. Main -a)");
    }
    
    public static void main(String[] args) {
        if(args.length>0) {
            switch(args[0]){
                case "-a":  // Team A - Chiurcciu Ivan, Coşneanu Valeriu, Gaşimov Ramin
                    try{
                        String AUDIO_FILE_PATH = ".//Resources/static/audio/INSTASAMKA.wav";
                        String IMAGE_PATH = ".//Resources/static/images/INSTASAMKA.jpg";
                        
                        timer = new Timer();
                        LocalDateTime necessaryTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
                        CosneanuValeriuImpl valeryImpl = new CosneanuValeriuImpl(AUDIO_FILE_PATH, timer);
                        RaminGashimovImpl raminImpl = new RaminGashimovImpl(IMAGE_PATH);
                        ChiurcciuIvan vaneaImpl = new ChiurcciuIvan();
                        
                        timer.schedule(raminImpl, valueOf(necessaryTime), valeryImpl.getDuration());
                        timer.schedule(valeryImpl, valueOf(necessaryTime));
                        timer.schedule(vaneaImpl, valueOf(necessaryTime.plusSeconds(18)));
                        Thread.sleep(valeryImpl.getDuration());
                        valeryImpl.cancel();
                        raminImpl.cancel();
                        vaneaImpl.cancel();
                        timer.cancel();
                    }
                    catch(InterruptedException ex){
                        ex.printStackTrace();
                    }
                    break;
                case "-b":  // Team B - Fiodorov Vladimir, Malanciuc Dmitri, Prisacari Serghei
                    timer = new Timer();
                    TimerTask taskFiodorov = new Fiodorov();
                    TimerTask taskMalanciuc = new MalanciucDmitrii();
                    TimerTask taskPrisacari = new PrisacariSerghei();
                    
                    timer.schedule(taskPrisacari, 2000);
                    timer.schedule(taskFiodorov, 4000);
                    timer.schedule(taskMalanciuc, 6000);
                    break;
                case "-c":  // Team C - Gribencicov Maxim, Homenschi Valentin, Marcova Jasmina
                    timer = new Timer();
                    PrintTimestampTask printTimestampTask = new PrintTimestampTask();
                    TimerTaskJasmina timerTaskJasmina = new TimerTaskJasmina();
                    TimerTaskValik timerTaskValik = new TimerTaskValik();
                    
                    timer.schedule(printTimestampTask, 100,1000);
                    timer.schedule(timerTaskJasmina,50,500);
                    timer.schedule(timerTaskValik,20,800);
                    break;
                case "-d":  // Team D - Melnic Dmitri, Şveţ Vadim, Tomaşciuc Iaroslav
                    timer = new Timer();
                    TimerTask taskMelnic = new MelnicDmitri();
                    
                    timer.schedule(taskMelnic, 10000);
                    break;
                case "-e":  // Team E - Neer Ecaterina, Prutean Stanislav
                    timer = new Timer();
                    PruteanStanislav pruteanTimerImpl = new PruteanStanislav();
                    
                    timer.schedule(pruteanTimerImpl, 0, 1000);
                    break;
                case "-f": // Team F - Bulat Alexandr, Dubovîi Mihail, Patraşco Serghei
                    int GREEN_TIME_MS = 5000;
                    int YELLOW_TIME_MS = 2000;
                    int RED_TIME_MS = 5000;
                    
                    timer = new Timer();
                    Light greenLight = new Light("Green", GREEN_TIME_MS);
                    Light yellowLight = new Light("Yellow", YELLOW_TIME_MS);
                    Light redLight = new Light("Red", RED_TIME_MS);
                    TimerTask moneyTree = new Money(timer);    //создаем задачу и в него передаем таймер
                    
                    timer.scheduleAtFixedRate(greenLight, 0, GREEN_TIME_MS + YELLOW_TIME_MS + RED_TIME_MS);
                    timer.scheduleAtFixedRate(yellowLight, GREEN_TIME_MS, GREEN_TIME_MS + YELLOW_TIME_MS + RED_TIME_MS);
                    timer.scheduleAtFixedRate(redLight, GREEN_TIME_MS + YELLOW_TIME_MS, GREEN_TIME_MS + YELLOW_TIME_MS + RED_TIME_MS);
                    timer.scheduleAtFixedRate(moneyTree, 0, 2000);   //таймер вызывает задание moneyTree через каждые 2 сек
                    break;
                default:
                    about();
            }
        }
        else
            about();
    }
}