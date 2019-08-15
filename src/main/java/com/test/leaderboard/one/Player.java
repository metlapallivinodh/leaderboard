package com.test.leaderboard.one;

import java.util.Arrays;
import java.util.StringJoiner;

public class Player {

    private String name;

    private int[] scores;

    public Player(String name, int[] scores) {
        if (scores == null || scores.length != 4) {
            throw new RuntimeException("There can be only 4 scores for a player.");
        }
        this.name = name;
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public int[] getScores() {
        return scores;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Player.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("scores=" + Arrays.toString(scores))
                .toString();
    }
}
