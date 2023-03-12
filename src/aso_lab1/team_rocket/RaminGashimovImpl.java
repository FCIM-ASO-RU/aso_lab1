package aso_lab1.team_rocket;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.TimerTask;

import static aso_lab1.team_rocket.logger.Log.info;
import static aso_lab1.team_rocket.logger.Log.infoFormat;

public class RaminGashimovImpl extends TimerTask {
    private Frame frame;
    private Image image;


    public RaminGashimovImpl(final String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            infoFormat("[ CONSTRUCTOR THROW EXCEPTION: {%s}]", e.toString());
            e.printStackTrace();
        }

        frame = new Frame("Image Viewer");
        frame.setSize(670, 600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });
    }

    @Override
    public void run() {
        info("METHOD: {"+new Object(){}.getClass().getEnclosingMethod().getName()+"} IS RUNNING");
        Graphics g = frame.getGraphics();
        g.drawImage(image, 0, 0, null);
    }

    @Override
    public boolean cancel() {
        info("METHOD: {" + new Object() {
        }.getClass().getEnclosingMethod().getName() + "} FINISHED");
        return super.cancel();
    }
}
