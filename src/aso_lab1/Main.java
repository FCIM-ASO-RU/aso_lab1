package aso_lab1;

import aso_lab1.team_rocket.ChiurcciuIvan;
import aso_lab1.team_rocket.CosneanuValeriuImpl;
import aso_lab1.team_rocket.RaminGashimovImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import java.util.Timer;

import static java.sql.Timestamp.valueOf;

public class Main {
    private static final String AUDIO_FILE_PATH = ".//Resources/static/audio/INSTASAMKA.wav";
    private static final String IMAGE_PATH = ".//Resources/static/images/INSTASAMKA.jpg";

    public static void main(String[] args) {
        final Timer timer = new Timer();
        final LocalDateTime necessaryTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        final CosneanuValeriuImpl valeryImpl = new CosneanuValeriuImpl(AUDIO_FILE_PATH, timer);
        final RaminGashimovImpl raminImpl = new RaminGashimovImpl(IMAGE_PATH);
        final ChiurcciuIvan vaneaImpl = new ChiurcciuIvan();


        timer.schedule(raminImpl, valueOf(necessaryTime), valeryImpl.getDuration());
        timer.schedule(valeryImpl, valueOf(necessaryTime));
        timer.schedule(vaneaImpl, valueOf(necessaryTime.plusSeconds(18)));

    }
}
