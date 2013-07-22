package com.hexlet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.hexlet.global.*;
import com.hexlet.local.*;

public class Main {

    private static final char CHAR_X = 'X';
    private static final char CHAR_0 = '0';

    private static boolean nextStepPlayer = false;
    private static boolean charOfPlayerX = false;
    private static boolean finish;



    public static void main(String[] args) {


        System.out.println("Игра «Крестики-Нолики»");
        System.out.println();

        /* Необходимо реализовить ввод размера поля */
        //System.out.println("Введите размер поля и нажминте Enter");

        Field field = new Field(3);
        finish = false;
        System.out.println();

        System.out.print("Жеребьевка: ");
        nextStepPlayer = Toss.Random();
        charOfPlayerX = Toss.Random();
        printWhoNextStep();
        System.out.println();


        while (!finish) {


            if (nextStepPlayer) {
                field.printField();
                System.out.println("Ваш ход, введите номер ячейки");
                int numberField = inputFieldNumber()-1;
                if (checkFieldsNumber(numberField, field)) {
                    if (charOfPlayerX) {
                        field.setCharToField(numberField,CHAR_X);
                    } else {
                        field.setCharToField(numberField,CHAR_0);
                    }
                }
                field.printField();
                if (field.checkWin() != 0) {
                    System.out.print(field.checkWin());    // Номер выйгрышной комбинации 3х3
                }   else {
                    setNextStep();
                }

            }   else {
                Opponent.step(field);
                break;
            }
        }
    }

    private static void setNextStep () {
        if (nextStepPlayer) {
            nextStepPlayer = false;
        } else {
            nextStepPlayer = true;
        }
    }

    private static void printWhoNextStep() {
        if (nextStepPlayer) {
            System.out.println("Ход игрока");
        } else {
            System.out.println("Ход оппонента");
        }
    }


    private static int readInt(BufferedReader reader) throws IOException {
        while (true) {
            try {
                return Integer.parseInt(reader.readLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Вы ввели не число!");
            }
        }
    }

    private static int inputFieldNumber() {

        InputStreamReader isReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isReader);
        try {
            return readInt(reader);
        } catch (IOException ioe) {
            System.err.println("An error occurred reading from the reader, "
                    + ioe);
        }
        return 0;
    }

    private static boolean checkFieldsNumber(int fieldNumber, Field field) {

        if (fieldNumber >= 0 && fieldNumber < field.numberOfFields()) {
            return true;
        }   else {
            return false;
        }

    }


}
