package com.princekr.students.ui;

import com.princekr.utils.StringConstants;

import javax.swing.*;
import java.awt.*;

/**
 * Created by prince on 10/8/16.
 */
public class StatusPanel extends JPanel {

    private JLabel statusLabel;
    private JLabel timeLabel;
    private Timer timer;

    public StatusPanel()  {
        initializeVariables();
        constructLayout();
        startTimer();
    }

    private void initializeVariables() {

        this.statusLabel = new JLabel();
        this.timeLabel = new JLabel();
        this.timer = new Timer(timeLabel);
        this.statusLabel.setText(StringConstants.STATUS_PANEL_TEXT);

    }

    public void startTimer(){
        this.timer.start();
    }

    public void stopTimer() {
        this.timer.setRunning(false);
    }


    private void constructLayout() {

        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(statusLabel);
        add(timeLabel);

    }


}
