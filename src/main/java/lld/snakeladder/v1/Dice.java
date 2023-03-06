package lld.snakeladder.v1;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private int noOfDice;
    private int min;
    private int max;

    public Dice(int noOfDice) {
        if (noOfDice <= 0) {
            throw new RuntimeException("Disc is invalid");
        }
        this.noOfDice = noOfDice;
    }

    public int roll() {
        int sum = 0;
        int i = 0;
        while (i++ < noOfDice) {
            int temp = ThreadLocalRandom.current().nextInt(min, max);
            sum += temp;
        }
        return sum;
    }

}
