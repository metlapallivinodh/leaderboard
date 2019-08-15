package com.test.leaderboard.two;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LeaderBoard {

    Map<Integer, List<Player>> calculate(ScoreCard scoreCard) {
        return scoreCard.getScores().entrySet().stream()
                .collect(
                        Collectors.groupingBy(
                                (Map.Entry<Player, Collection<Integer>> o) -> o.getValue().parallelStream().max(Comparator.naturalOrder()).get(),
                                () -> new TreeMap<>(Comparator.reverseOrder()),
                                Collectors.mapping((Map.Entry<Player, Collection<Integer>> o) -> o.getKey(), Collectors.toList())
                        )
                );
    }

}
