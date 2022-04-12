package com.src;

import javax.swing.ImageIcon;

public class Brick extends Sprite {
    private boolean destroyed;

    public Brick(int x, int y) {
        initBrick(x, y);
    }

    private void initBrick(int x, int y) {
        this.x = x;
        this.y = y;
        
        destroyed = false;

        loadImage();
        getImageDimensions();
    }
}