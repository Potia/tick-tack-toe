package com.hexlet.global;

public class Field {


    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final int DEFAULT_FIELD_SIZE = 3;
    private static final char DEFAULT_CHAR = ' ';

    private final char fields [][];


    public Field() {
        this (DEFAULT_FIELD_SIZE);
    }

    public Field (int newFieldSize) {
        if (newFieldSize < MIN_FIELD_SIZE || newFieldSize >= MAX_FIELD_SIZE) {
            newFieldSize = DEFAULT_FIELD_SIZE;
        }
        fields = new char [newFieldSize][newFieldSize];
        resetField();
        System.out.println("Игровое поле " + newFieldSize + " на " + newFieldSize);
    }

    public void printField() {
        for (int i=0;i <fields.length;i++)
        {
            for (int j=0; j<fields.length;j++) {
                System.out.print("[" + fields[i][j] + "]");
            }
            System.out.println();
        }
    }

    public  void resetField() {
        for (int i=0;i <fields.length;i++)
        {
            for (int j=0; j<fields.length;j++) {
                fields[i][j] = DEFAULT_CHAR;
            }
        }
    }

}
