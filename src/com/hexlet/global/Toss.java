package com.hexlet.global;

import java.util.Random;


public class Toss {

    public static boolean Random() {
        Random random = new Random();
        if (random.nextInt(2) % 2 == 0) {
            return true;
        } else {
            return false;
        }

    }


}
