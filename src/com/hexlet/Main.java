package com.hexlet;
import com.hexlet.global.*;
import com.hexlet.local.*;

import java.util.Random;

public class Main {

    private static boolean nextStepPlayer = false;

    public static void main(String[] args) {


        System.out.println("Игра «Крестики-Нолики»");
        System.out.println();

        /* Необходимо реализовить ввод размера поля */
        //System.out.println("Введите размер поля и нажминте Enter");

        Field field = new Field(3);
        System.out.println();

        System.out.print("Жеребьевка: ");
        tossRandom();
        printWhoNextStep();
        System.out.println();
    }

    private static void tossRandom() {
        Random random = new Random();
        if (random.nextInt(10) % 2 == 0) {
            nextStepPlayer = true;
        } else {
            nextStepPlayer = false;
        }

    }

    private void setNextStep () {
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
}
