package com.javarush.task.task20.task2025;

import java.util.TreeSet;

/*
Алгоритмы-числа
Число S состоит из M цифр, например, S=370 и M (количество цифр) = 3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания.
Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8
На выполнение дается 10 секунд и 50 МБ памяти.
Требования:
1. В классе Solution должен присутствовать метод getNumbers c одним параметром типа long.
2. Метод getNumbers должен быть публичным.
3. Метод getNumbers должен быть статическим.
4. Метод getNumbers должен возвращать массив чисел удовлетворяющих условию задачи.
*/

public class Solution {
    public static long[] getNumbers(long N) {
        long[] result = null;
        TreeSet<Long> numbers = new TreeSet<>();

        final int SIZE = 12;
        long[][] powLst = new long[SIZE][SIZE];

        int[] lst = new int[20];


        label:
        for (long i = 1; i < N; i++) {
            long x = i;
            int lenCount = 0;
            int current;
            int last = Integer.MAX_VALUE;
            while (x != 0) {
                current = (int) (x % 10);
                if ((current != 0 && last != 0) && last < current)
                    continue label;
                last = current;
                lst[lenCount] = current;
                x = x / 10;
                lenCount++;
            }

            long summa1 = 0;
            for (int j = 0; j < lenCount; j++) {
                if (powLst[lst[j]][lenCount] == 0) {
                    long a1 = lst[j];
                    if (a1 != 0 && a1 != 1) {
                        long a2 = lst[j];
                        for (int jj = 1; jj < lenCount; jj++)
                            a1 *= a2;
                    }
                    powLst[lst[j]][lenCount] = a1;
                }
                summa1 += powLst[lst[j]][lenCount];
            }

            long xx = summa1;
            lenCount = 0;
            while (xx != 0) {
                lst[lenCount] = (int) (xx % 10);
                lenCount++;
                xx = xx / 10;
            }

            long summa2 = 0;
            for (int j = 0; j < lenCount; j++) {
                if (powLst[lst[j]][lenCount] == 0) {
                    long a1 = lst[j];
                    if (a1 != 0 && a1 != 1) {
                        long a2 = lst[j];
                        for (int jj = 1; jj < lenCount; jj++)
                            a1 *= a2;
                    }
                    powLst[lst[j]][lenCount] = a1;
                }
                summa2 += powLst[lst[j]][lenCount];
            }

            if (summa1 == summa2 && summa1 < N)
                numbers.add(summa1);
        }
        result = new long[numbers.size()];

        int count = 0;
        for (Long l : numbers) {
            result[count] = l;
            count++;
        }
        return result;
    }

    public static void main(String[] args) {
        Long t0 = System.currentTimeMillis();
        int n = 999999999;
        long[] lst = getNumbers(n);
        Long t1 = System.currentTimeMillis();
        System.out.println("time: " + (t1 - t0) / 1000d + " sec");
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
        for (int i = 0; i < lst.length; i++) {
            System.out.print(lst[i] + ", ");
        }
        System.out.println();
    }
}