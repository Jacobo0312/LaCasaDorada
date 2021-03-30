package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class ClockThread extends Thread {

    
    private Label clock;

    // Utilizar el metodo setDaemon en true

    public ClockThread(Label clock) {
        setDaemon(true);
        this.clock=clock;
    }

    @Override
    public void run() {
        boolean condition = true;
        while (condition) {



            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm:ss");

            LocalDateTime locaDate = LocalDateTime.now();

            Platform.runLater(()->{
                clock.setText(formatter.format(locaDate));
            }

            );
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
