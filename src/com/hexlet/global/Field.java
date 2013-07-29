package com.hexlet.global;

public class Field {


    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final int DEFAULT_FIELD_SIZE = 3;
    public static final char DEFAULT_CHAR = ' ';
    public static final int[][] winCombinations = new int[][] {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},                        //Горизонтальные комбинации
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},                        //Вертикальные комбинации
            {0, 4, 8}, {2, 4, 6}                                    //Диагональные комбинации
    };

    private final char fields [][];

    private int currectFieldSize;

    public Field() {
        this (DEFAULT_FIELD_SIZE);
    }

    public Field (int newFieldSize) {
        if (newFieldSize < MIN_FIELD_SIZE || newFieldSize >= MAX_FIELD_SIZE) {
            newFieldSize = DEFAULT_FIELD_SIZE;
        }
        fields = new char [newFieldSize][newFieldSize];
        currectFieldSize = newFieldSize;
        resetField();
        System.out.println("Игровое поле " + newFieldSize + " на " + newFieldSize);
    }

    public void printField() {
        printFieldLineHor();
        for (int i = 0; i < fields.length; i++) {
            System.out.print('|');
            for (int j=0; j<fields.length;j++) {
                System.out.print(" " + fields[i][j] + " |");
            }

            printFieldLineHor();
        }
    }

    public int getFieldLenth() {
        return fields.length;
    }

    private void printFieldLineHor() {
        System.out.println();

        for (int i=0;i<=fields.length*4;i++)
        {
            System.out.print("-");
        }
        System.out.println();

    }

    public  void resetField() {
        for (int i = 0 ; i < fields.length ; i++) {
            for (int j=0; j<fields.length;j++) {
                fields[i][j] = DEFAULT_CHAR;
            }
        }
    }

    public int numberOfFields () {
        return fields.length * fields.length;
    }

    public void setCharToField (int number, char charOfField) {
        int row = number / currectFieldSize;
        int column = number%currectFieldSize;
        fields[row] [column] = charOfField;
    }

    public char getCharToField (int number) {
        int row = number / currectFieldSize;
        int column = number%currectFieldSize;
        return fields[row] [column];
    }

    public boolean isFree (int number) {
        return (getCharToField(number) == DEFAULT_CHAR);
    }


    public int checkWin () {

        for (int i = 0 ; i < winCombinations.length ; i++)
        {
            if (getCharToField(winCombinations[i][0]) == getCharToField(winCombinations[i][1]) &&
                getCharToField(winCombinations[i][0]) == getCharToField(winCombinations[i][2]) &&
                getCharToField(winCombinations[i][0]) != ' ') {
                return i;
        }
        }

        return -1;
    }

    public int[] countCharCell(char currectChar) {

        int countLine;
        int countEmpty;
        int[] count = new int [winCombinations.length];
        for (int i=0; i<winCombinations.length;i++)
        {
            countLine = 0;
            countEmpty = 0;
            for (int j=0; j<winCombinations[0].length; j++)  {
                if (getCharToField(winCombinations[i][j]) == currectChar)
                {
                    countLine++;
                }
                if (getCharToField(winCombinations[i][j]) == DEFAULT_CHAR){
                    countEmpty++;
                }
            }
            if (countEmpty == 1)
            {
                count[i] = countLine;
            } else {
                count[i] = 0;
            }
        }

            return count;
    }

    public static boolean checkFieldsNumber(int fieldNumber, Field field) {

       return (fieldNumber >= 0 && fieldNumber < field.numberOfFields() && field.isFree(fieldNumber));

    }

    public static int checkTie (Field field) {

        int countFreeCell=0;
        for (int i=0; i<field.numberOfFields(); i++) {
            if (field.getCharToField(i) == DEFAULT_CHAR) {
                countFreeCell++;
            }
        }

        return countFreeCell;
    }


}
