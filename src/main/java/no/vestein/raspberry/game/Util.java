package no.vestein.raspberry.game;

import java.util.Random;

public class Util {

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randNum = rand.nextInt(max - min + 1) + min;
        return randNum;
    }

    public static int randInt(int max) {
        return randInt(0, max);
    }

}
