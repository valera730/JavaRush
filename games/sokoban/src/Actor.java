package com.src;

import java.awt.Image;

public class Actor {
    private final int SPACE = 20;
    private int x;
    private int y;
    private Image image;

    public Actor(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image img) {
        image = img;
    }

    public int x() {
        return x;
    }
}