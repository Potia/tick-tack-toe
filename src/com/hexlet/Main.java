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
    public static char charOfPlayer;
    public static char charOfOpponent;
    private static boolean finish = false;



    public static void main(String[] args) {


        System.out.println("Игра «Крестики-Нолики»");
        System.out.println();

        Field field = new Field();
        System.out.println();

        System.out.print("Жеребьевка: ");
        nextStepPlayer = Toss.Random();
        if (Toss.Random()) {
            charOfPlayer = CHAR_X;
            charOfOpponent = CHAR_0;
        } else {
            charOfPlayer = CHAR_0;
            charOfOpponent = CHAR_X;
        }
        printWhoNextStep();
        System.out.println();


        while (!finish) {

            if (field.checkTie(field) == 0) {
                System.out.print("Ничья!");
                finish = true;
                break;
            }   else {

                if (nextStepPlayer) {

                    //Ход игрока
                    field.printField();

                    //while ожидает верногономера ячейки
                    while (true) {
                    System.out.println("Ваш ход, введите номер ячейки");
                    int numberField = inputFieldNumber()-1;
                        if (Field.checkFieldsNumber(numberField, field)) {
                            field.setCharToField(numberField,charOfPlayer);
                            break;
                        }
                    }

                    if (field.checkWin() != -1) {
                        field.printField();
                        System.out.print("Победа: Игрока");
                        finish = true;
                    }   else {
                        System.out.println("Переход хода");
                        setNextStep();
                    }

                }   else {
                    Opponent.step(field);
                    if (field.checkWin() != -1) {
                        field.printField();
                        System.out.print("Победа: Оппонента");
                        finish = true;
                    }   else {
                        setNextStep();
                    }
                }
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




}
