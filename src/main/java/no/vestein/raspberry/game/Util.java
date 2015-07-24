package no.vestein.raspberry.game;

import java.util.Random;

public class Util {

    private static Random rand = new Random();

    public static int randInt(int min, int max) {
        return rand.nextInt(max - min + 1) + min;
    }

    public static int randInt(int max) {
        return randInt(0, max);
    }

}
