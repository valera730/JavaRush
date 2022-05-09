package com.src;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Baggage extends Actor {
    public Baggage(int x, int y) {
        super(x, y);
        initBaggage();
    }
    
    private void initBaggage() {
        ImageIcon iicon = new ImageIcon("src/resources/baggage.png");
        Image image = iicon.getImage();
        setImage(image);
    }
}