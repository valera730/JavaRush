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

    private void loadImage() {
        var ii = new ImageIcon("src/resources/paddle.png");
        image = ii.getImage();        
    }    

    void move() {
        x += dx;

        if (x <= 0) {
            x = 0;
        }

        if (x >= Commons.WIDTH - imageWidth) {
            x = Commons.WIDTH - imageWidth;
        }
    }
}