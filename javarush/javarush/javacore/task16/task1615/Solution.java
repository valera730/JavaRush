package com.javarush.task.task16.task1615;

/* 
Аэропорт
*/
//1. Разберись, что делает программа.
//2. Исправь метод takingOff(взлет) — сейчас он работает оооочень долго. Взлет должен занимать 100 миллисекунд.
//3. Реализуй метод waiting по аналогии с методом takingOff. Время ожидания не должно превышать время взлета.

public class Solution {
    public static volatile Runway RUNWAY = new Runway();   //1 взлетная полоса

    public static void main(String[] args) throws InterruptedException {
        Plane plane1 = new Plane("Самолет #1");
        Plane plane2 = new Plane("Самолет #2");
        Plane plane3 = new Plane("Самолет #3");
    }

    private static void waiting() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }

    }

    private static void takingOff() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }

    public static class Plane extends Thread {
        public Plane(String name) {
            super(name);
            start();
        }

        public void run() {
            boolean isAlreadyTakenOff = false;
            while (!isAlreadyTakenOff) {
                if (RUNWAY.trySetTakingOffPlane(this)) {
                    System.out.println(getName() + " взлетает");
                    takingOff();
                    System.out.println(getName() + " уже в небе");
                    isAlreadyTakenOff = true;
                    RUNWAY.setTakingOffPlane(null);
                } else if (!this.equals(RUNWAY.getTakingOffPlane())) {
                    System.out.println(getName() + " ожидает");
                    waiting();
                }
            }
        }
    }

    public static class Runway {
        private Thread t;

        public Thread getTakingOffPlane() {
            return t;
        }

        public void setTakingOffPlane(Thread t) {
            synchronized (this) {
                this.t = t;
            }
        }

        public boolean trySetTakingOffPlane(Thread t) {
            synchronized (this) {
                if (this.t == null) {
                    this.t = t;
                    return true;
                }
                return false;
            }
        }
    }
}