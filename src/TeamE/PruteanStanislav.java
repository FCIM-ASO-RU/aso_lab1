package TeamE;

import java.util.Date;
import java.util.TimerTask;

public class PruteanStanislav extends TimerTask {
    int a = 0;
    int b = 0;

    @Override
    public void run() {
        System.out.println("Performing the task on: " + new Date());
        System.out.println("The multiplication  is: " + (a++ * b++));
    }
}
