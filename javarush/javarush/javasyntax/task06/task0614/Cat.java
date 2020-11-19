package com.javarush.task.task06.task0614;

import sun.util.resources.cldr.ar.CalendarData_ar_TN;
import java.util.ArrayList;

/* 
Статические коты
*/

public class Cat {
    public static ArrayList<Cat> cats = new ArrayList<>();

    public Cat() {
    }

    public static void main(String[] args) {
        for (int i=0; i < 10; i++) {
            Cat c= new Cat();
            Cat.cats.add(c);
        }

        printCats();
    }

    public static void printCats() {
        for (int i=0;i<cats.size();i++) {
            System.out.println(cats.get(i));
        }
    }
}