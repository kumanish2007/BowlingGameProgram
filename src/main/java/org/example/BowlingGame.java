package org.example;

public class BowlingGame {
    private int[] rolls = new int[21];
    private int currentRoll = 0;

    public void throwBall(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int getScore() {
        int totalScore = 0;
        int index = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(index)) {
                totalScore += 10 + strikeBonus(index);
                index++;
            } else if (isSpare(index)) {
                totalScore += 10 + spareBonus(index);
                index += 2;
            } else {
                totalScore += sumOfPinsInFrame(index);
                index += 2;
            }
        }
        return totalScore;
    }

    private boolean isStrike(int index) {
        return rolls[index] == 10;
    }

    private boolean isSpare(int index) {
        return rolls[index] + rolls[index + 1] == 10;
    }

    private int sumOfPinsInFrame(int index) {
        return rolls[index] + rolls[index + 1];
    }

    private int strikeBonus(int index) {
        return rolls[index + 1] + rolls[index + 2];
    }

    private int spareBonus(int index) {
        return rolls[index + 2];
    }

    public static void main(String[] args) {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.throwBall(10);
        int score = bowlingGame.getScore();
        System.out.println(score);
    }
}