package com.src;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Sokoban extends JFrame {
    private final int OFFSET = 30;

    public Sokoban() {
        initUI();
    }

    private void initUI() {
        Board board = new Board();
        add(board);

        setTitle("Сокобан");
        
        setSize(board.getBoardWidth() + OFFSET, board.getBoardHeight() + 2 * OFFSET);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}