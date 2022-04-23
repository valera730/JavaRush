package com.zetcode;

import java.awt.Image;
import java.awt.Rectangle;

public class Sprite {
    int x;
    int y;
    int imageWidth;
    int imageHeight;
    Image image;
    
    protected void setX(int x) {
        this.x = x;
    }

    int getX() {
        return x;
    }
}