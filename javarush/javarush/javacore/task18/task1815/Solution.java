package com.javarush.task.task18.task1815;

import javax.smartcardio.ATR;
import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements ATableInterface {

        ATableInterface component;

        TableInterfaceWrapper (ATableInterface atable) {
            this.component = atable;
        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            this.component.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return this.component.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            this.component.setHeaderText(newHeaderText);
        }
    }

    public interface ATableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}