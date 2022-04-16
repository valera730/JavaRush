package com.src;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Paddle extends Sprite  {
    private int dx;

    public Paddle() {
        initPaddle();        
    }
    
    private void initPaddle() {
        loadImage();
        getImageDimensions();

        resetState();
    }
}