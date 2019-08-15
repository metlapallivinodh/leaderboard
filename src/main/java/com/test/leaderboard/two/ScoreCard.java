package com.test.leaderboard.two;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class ScoreCard {

    private Multimap<Player, Integer> scores = null;

    boolean addScore(Player p, Integer score) {
        if (this.scores == null) {
            this.scores = LinkedListMultimap.create();
        }
        return this.scores.put(p, score);
    }

    boolean addScores(Player p, Integer... scores) {
        if (this.scores == null) {
            this.scores = LinkedListMultimap.create();
        }
        return this.scores.putAll(p, Arrays.asList(scores));
    }

    boolean addScores(Player p, Iterable<Integer> scores) {
        if (this.scores == null) {
            this.scores = LinkedListMultimap.create();
        }
        return this.scores.putAll(p, scores);
    }

    public Map<Player, Collection<Integer>> getScores() {
        return scores.asMap();
    }
}
