package aso_lab1.team_rocket;

import java.util.TimerTask;

import static aso_lab1.team_rocket.logger.Log.info;

public class ChiurcciuIvan extends TimerTask {
    private final String[] lyrics = {
            "Я вообще делаю что хочу",
            "Хочу импланты - звоню врачу",
            "Кто меня не любит, я вас не слышу",
            "Вы просто мне завидуете, я молчу",

            "Я не молчу, когда я хочу",
            "Я не продаюсь, но за деньги - да",
            "Мой продюсер говорит, ты поп звезда",
            "И кстати, мой продюсер это мой муж, да",

            "Я не скажу в ответ ничего на хейт",
            "Я не скажу - привет, если бабок нет",
            "Слышу любимый звук, это звон монет",
            "Они тянут сотни рук, это мой концерт",

            "Не завожу подруг, но за деньги - да",
            "Я не делаю фиты, даже за деньги - да",
            "Я подумаю потом, но скажу сразу - да",
            "За деньги - да, за деньги - да",

            "За деньги - да, день-день-день-деньги - да, да.",
            "За деньги - да, день-день-день-деньги - да, да…",
            "За деньги - да, день-день-день-деньги - да, да…",
            "За деньги - да, день-день-день-деньги - да, да…",

            "Это я в Дубае, я ща отдыхаю",
            "Да, я так богата, и я это не скрываю",
            "Все мои подруги за собой не замечают",
            "Видят мои шмотки и тупо повторяют",

            "Пусть не забывают, кто тут королева",
            "Я раскидываю бабки, направо и налево",
            "Это моя манера - жена миллионера",
            "Мне платят за концерты, я читаю под фанеру",

            "Эту сумку мне муж купил",
            "Эти ролексы муж купил",
            "Кольцо с бриллиантом мне муж купил",
            "Муж купил, мне муж купил",

            "Не завожу подруг, но за деньги - да",
            "Я не делаю фиты, даже за деньги - да",
            "Я подумаю потом, но скажу сразу - да",
            "За деньги - да, за деньги - да",

            "За деньги - да, день-день-день-деньги - да, да.",
            "За деньги - да, день-день-день-деньги - да, да…",
            "За деньги - да, день-день-день-деньги - да, да…",
            "За деньги - да, день-день-день-деньги - да, да…",
    };

//    private int currentLine;

//    public ChiurcciuIvan() {
//        this.currentLine = 0;
//    }

    @Override
    public void run() {
        info("METHOD: {" + new Object() {
        }.getClass().getEnclosingMethod().getName() + "} IS RUNNING");
        int currentLine = 0;
        while (currentLine < lyrics.length) {
            try {

                final String music = "За деньги - да, день-день-день-деньги - да, да…";
                if (music.equals(lyrics[currentLine]))
                    Thread.sleep(3800);

                final String afterMusic = "Это я в Дубае, я ща отдыхаю";

                if (afterMusic.equals(lyrics[currentLine]))
                    Thread.sleep(6050);
                System.out.println(lyrics[currentLine]);
                Thread.sleep(2050);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentLine++;
        }
    }
    @Override
    public boolean cancel() {
        info("METHOD: {" + new Object() {
        }.getClass().getEnclosingMethod().getName() + "} FINISHED");
        return super.cancel();
    }
}
