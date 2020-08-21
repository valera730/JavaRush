package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/
/Собираем файл из кусочков.
//Считывать с консоли имена файлов.
//Каждый файл имеет имя: [someName].partN.
//Например, Lion.avi.part1, Lion.avi.part2, …, Lion.avi.part37.
//Имена файлов подаются в произвольном порядке. Ввод заканчивается словом «end«.
//В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].
//Например, Lion.avi.
//В него переписать все байты из файлов-частей используя буфер.
//Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, …, в конце — последнюю.
//Закрыть потоки.

import java.io.*;
import java.util.*;
import java.io.File;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> parts = new ArrayList<String>();
        FileInputStream fileInputStream = null;
        String nextFileName = null;
        while (true) {
            if ("end".equals(nextFileName = scanner.nextLine())) break;
            else parts.add(nextFileName);
        }
        scanner.close();
        Collections.sort(parts, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
        String outputFileName = parts.get(0).split(".part")[0];
        FileOutputStream fileOutputStream = new FileOutputStream(outputFileName);
        for (String partsFileNames : parts) {
            fileInputStream = new FileInputStream(partsFileNames);
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            fileOutputStream.write(buffer);
            fileInputStream.close();
        }
        fileOutputStream.close();
        System.out.println("Объединение файлов выполнено!");
    }
}