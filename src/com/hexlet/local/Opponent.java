package com.hexlet.local;
import com.hexlet.Main;
import com.hexlet.global.*;

import java.util.Random;

/**
 * Оппонент компьютер
 */
public class Opponent {

    public static void step(Field field) {

        System.out.println("Ход компьютера");

        // Если у Игрока есть 2 совпадение из 3
        if (countOfCharInLine(field, Main.charOfOpponent) != -1) {
            for (int i=0; i<3; i++) {
                if (field.getCharToField(Field.winCombinations[countOfCharInLine(field, Main.charOfOpponent)][i]) == Field.DEFAULT_CHAR) {
                    field.setCharToField(Field.winCombinations[countOfCharInLine(field, Main.charOfOpponent)][i],Main.charOfOpponent);
                    break;
                }
            }
        } else {

        // Если у компьютера есть 2 совпадения из 3

                if (countOfCharInLine(field, Main.charOfPlayer) != -1) {
                    for (int i=0; i<3; i++) {

                        if (field.getCharToField(Field.winCombinations[countOfCharInLine(field, Main.charOfPlayer)][i]) == Field.DEFAULT_CHAR) {
                            field.setCharToField(Field.winCombinations[countOfCharInLine(field, Main.charOfPlayer)][i],Main.charOfOpponent);
                            break;
                        }
                    }
            }   else {

                while (true) {
                    Random random = new Random();
                    int numberField = random.nextInt(8);
                    if (Field.checkFieldsNumber(numberField, field)) {
                        field.setCharToField(numberField,Main.charOfOpponent);
                        break;
                    }

                }
            }
        }

    }

    private static int countOfCharInLine(Field field, char currectChar) {

        for (int i=0; i<8; i++) {
            if (field.countCharCell(currectChar)[i] == 2) {
                return i;
            }
        }
        return -1;
    }


}
