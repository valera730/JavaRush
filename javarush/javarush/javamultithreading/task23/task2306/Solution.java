package com.javarush.task.task23.task2306;

/* 
Inner 2
В классе SuperUser метод getDescription должен учитывать страну и город, т.е.
возвращать результат аналогичный следующему:
My name is George. I'm from the USA, Seattle.
Используй возможности иннер класса.
Требования:
1. Класс SuperUser должен быть приватным.
2. Класс SuperUser должен содержать метод getDescription.
3. Метод getDescription в классе SuperUser должен быть публичным.
4. Метод getDescription в классе SuperUser должен возвращать строку учитывающую имя,
страну и город пользователя форматированную согласно условию задачи.
5. Метод getTrickyUser должен возвращать объект типа SuperUser.
*/

public class Solution {
    private String country;
    private String city;

    public Solution(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getDescriptionOfUser(String name) {
        return getTrickyUser(name).getDescription();
    }

    public SuperUser getTrickyUser(String name) {
        return new SuperUser(name);
    }

    private class SuperUser {
        private String name;

        public SuperUser(String name) {
            this.name = name;
        }

        public String getDescription() {
            return String.format("My name is %s. I'm from %s, %s.", this.name, country, city);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution("the USA", "Seattle");
        System.out.println(solution.getTrickyUser("George").getDescription());
        System.out.println(solution.getDescriptionOfUser("George"));
    }
}