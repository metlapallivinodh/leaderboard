package com.test.leaderboard.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@DisplayName("Testing 1st LeaderBoard variant")
class LeaderBoardTest {

    @Test
    @DisplayName("When all players have 4 scores")
    void testAllPlayerWith4Scores() {
        LeaderBoard leaderBoard = new LeaderBoard();
        final List<Player> players = Arrays.asList(
                new Player("A", new int[]{7, 10, 2, 6}),
                new Player("B", new int[]{2, 9, 8, 9}),
                new Player("C", new int[]{2, 10, 1, 2})
        );
        final Map<Integer, List<String>> lb = leaderBoard.calculate(players);

        System.out.println(lb);
        Assertions.assertEquals(2, lb.size());

        final List<String> rank1 = lb.get(10);
        Assertions.assertEquals(2, rank1.size());
        Assertions.assertTrue(rank1.containsAll(Arrays.asList("A", "C")));

        final List<String> rank2 = lb.get(9);
        Assertions.assertEquals(1, rank2.size());
        Assertions.assertTrue(rank2.contains("B"));
    }

    @Test
    @DisplayName("When non of the players have scores")
    void testAllPlayerWithNoScores() {
        Assertions.assertThrows(RuntimeException.class, () -> Arrays.asList(
                new Player("A", new int[]{}),
                new Player("B", new int[]{}),
                new Player("C", new int[]{})
        ));
    }

}