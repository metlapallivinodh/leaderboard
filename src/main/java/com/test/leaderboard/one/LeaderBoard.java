package com.test.leaderboard.one;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LeaderBoard {

    Map<Integer, List<String>> calculate(List<Player> players) {
        return players.stream()
                .collect(
                        Collectors.groupingBy(
                                (Player p) -> Arrays.stream(p.getScores()).parallel().max().getAsInt(),
                                () -> new TreeMap<>(Comparator.reverseOrder()),
                                Collectors.mapping(Player::getName, Collectors.toList()))
                );
    }
}
