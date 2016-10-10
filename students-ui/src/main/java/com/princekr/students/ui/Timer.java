package com.princekr.students.ui;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by prince on 10/8/16.
 */
public class Timer extends Thread {

    private boolean isRunning;
    private JLabel timeLabel;
    private SimpleDateFormat simpleDateFormat;

    public Timer(JLabel timeLabel) {
        initializeVariables(timeLabel);
    }

    private void initializeVariables(JLabel timeLabel) {
        this.timeLabel = timeLabel;
        this.simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        this.isRunning = true;
    }

    @Override
    public void run() {

        while (isRunning) {
            Calendar calendar = Calendar.getInstance();
            Date currentTime = calendar.getTime();
            timeLabel.setText(simpleDateFormat.format(currentTime));
        }

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRunning(boolean isRunning){
        this.isRunning = isRunning;
    }
}
