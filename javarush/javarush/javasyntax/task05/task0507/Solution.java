package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

//Вводить с клавиатуры числа и вычислить среднее арифметическое.
//Если пользователь ввел -1, вывести на экран среднее арифметическое всех чисел и завершить программу.
//-1 не должно учитываться.

//Пример для чисел 1 2 2 4 5 -1:
//2.8

//Пример для чисел 4 3 2 1 -1:
//2.5

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList();
        while (true) {
            int temp = scanner.nextInt();
            if (temp != -1)
                numbers.add(temp);
            else
                break;
        }
        scanner.close();
        int summ = 0;
        for (int i: numbers) {
            summ += i;
        }
        System.out.println((double)summ/numbers.size());
    }
}