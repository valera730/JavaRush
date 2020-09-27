package com.javarush.task.task24.task2408;

import java.util.Date;

/*
В работе вам иногда будет нужно закастить класс к какому-нибудь другому классу, не интерфейсу :)))
Класс DogPet использует 2 класса - SuperDog и Dog, разберись с getName в классе DogPet
Так намного лучше, чем Copy+Paste!
*/

public class Dog implements Pet {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public Sayable toSayable(final int i) {
        class DogPet extends SuperDog implements Sayable {

            private String getName() {
                return getSuperQuotes() + Dog.this.name + getSuperQuotes();
            }

            @Override
            public String say() {
                if (i < 1)
                    return getName() + " спит.";
                else {
                    StringBuffer sbuf = new StringBuffer();
                    for (int j = 0; j < i; j++)
                        sbuf.append("а");
                    return getName() + " лает г" + sbuf + "в! " + formatter.format(new Date());
                }
            }
        }
        return new DogPet();
    }
}