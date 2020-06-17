package com.javarush.task.task07.task0706;

import java.util.Scanner;

/* 
Улицы и дома
*/

//1. Создать массив на 15 целых чисел.
//2. Ввести в него значения с клавиатуры.
//3. Пускай индекс элемента массива является номером дома, а значение — число жителей, проживающих в доме.
//Дома с нечетными номерами расположены на одной стороне улицы, с четными — на другой. Выяснить, на какой стороне улицы проживает больше жителей.
//4. Вывести на экран сообщение: «В домах с нечетными номерами проживает больше жителей.» или «В домах с четными номерами проживает больше жителей.»

//Примечание:
//дом с порядковым номером 0 считать четным.

public class Solution {
    public static void main(String[] args) throws Exception {
        int odd = 0;
        int even = 0;
        Scanner scanner = new Scanner(System.in);
        int[] massivOfHouses = new int[15];

        for (int i = 0; i < massivOfHouses.length; i++) {
            massivOfHouses[i] = scanner.nextInt();
        }
        scanner.close();

        for (int i = 0; i < massivOfHouses.length; i++) {
            if (i%2 == 0) {
                even += massivOfHouses[i];
            } else {
                odd += massivOfHouses[i];
            }
        }
        if (even > odd) {
            System.out.println("В домах с четными номерами проживает больше жителей.");
        } else {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }
    }
}