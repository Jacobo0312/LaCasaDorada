package model;

import java.time.LocalDateTime;

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

            LocalDateTime locaDate = LocalDateTime.now();
            int hours = locaDate.getHour();
            int minutes = locaDate.getMinute();
            int seconds = locaDate.getSecond();
            Platform.runLater(()->{
                clock.setText("Hora actual : " + hours + ":" + minutes + ":" + seconds);
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
