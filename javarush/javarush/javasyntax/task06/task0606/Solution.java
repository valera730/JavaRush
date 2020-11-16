package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int a = 0;
        for (int i=0; i<s.length();i++){
            a = Integer.parseInt(Character.toString(s.charAt(i)));

            if ((a % 2) == 0)
                even += 1;
            else
                odd += 1;
        }
        System.out.println("Even: "+even+" Odd: "+odd);
    }
}