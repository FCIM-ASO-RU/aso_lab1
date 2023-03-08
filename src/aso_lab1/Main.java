package aso_lab1;

import aso_lab1.team_rocket.CosneanuValeriuImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Timer;

import static java.sql.Timestamp.valueOf;

public class Main {
    private static final String AUDIO_FILE_PATH = ".//Resources/static/audio/INSTASAMKA.wav";

    public static void main(String[] args) {
        final Timer timer = new Timer();
        final var valeryImpl = new CosneanuValeriuImpl(AUDIO_FILE_PATH, timer);

        final LocalDateTime necessaryTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());

        timer.schedule(valeryImpl, valueOf(necessaryTime));

    }

}
