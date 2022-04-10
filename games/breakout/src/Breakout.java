package com.zetcode;

import javax.swing.JFrame;
import java.awt.EventQueue;

public class Breakout extends JFrame {
    public Breakout() {
        initUI();
    }

    private void initUI() {
        add(new Board());
        setTitle("Breakout");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
    }
}