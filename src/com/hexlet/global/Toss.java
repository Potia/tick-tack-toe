package com.hexlet.global;

import java.util.Random;


public class Toss {

    public static boolean Random() {

        Random random = new Random();
        return (random.nextInt(2) % 2 == 0);

    }


}
