package com.test.leaderboard.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@DisplayName("Testing 2nd LeaderBoard variant")
class LeaderBoardTest {

    @Test
    @DisplayName("When all players have 4 scores")
    void testAllPlayerWith4Scores() {

        LeaderBoard leaderBoard = new LeaderBoard();
        ScoreCard scoreCard = new ScoreCard();

        scoreCard.addScores(new Player("A"), 7, 10, 2, 6);
        scoreCard.addScores(new Player("B"), 2, 9, 8, 9);
        scoreCard.addScores(new Player("C"), 2, 10, 1, 2);

        final Map<Integer, List<Player>> lb = leaderBoard.calculate(scoreCard);

        System.out.println(lb);
        Assertions.assertEquals(2, lb.size());

        final List<Player> rank1 = lb.get(10);
        Assertions.assertEquals(2, rank1.size());
        Assertions.assertTrue(rank1.containsAll(Arrays.asList(new Player("A"), new Player("C"))));

        final List<Player> rank2 = lb.get(9);
        Assertions.assertEquals(1, rank2.size());
        Assertions.assertTrue(rank2.contains(new Player("B")));
    }


    @Test
    @DisplayName("When none of the players have scores")
    void testAllPlayerWithNoScores() {

        LeaderBoard leaderBoard = new LeaderBoard();
        ScoreCard scoreCard = new ScoreCard();

        scoreCard.addScores(new Player("A"));
        scoreCard.addScores(new Player("B"));
        scoreCard.addScores(new Player("C"));

        final Map<Integer, List<Player>> lb = leaderBoard.calculate(scoreCard);

        System.out.println(lb);
        Assertions.assertTrue(lb.isEmpty());
    }

    @Test
    @DisplayName("When only few players have scores")
    void testFewPlayerWithScores() {

        LeaderBoard leaderBoard = new LeaderBoard();
        ScoreCard scoreCard = new ScoreCard();

        scoreCard.addScores(new Player("A"), 7, 10, 2, 6);
        scoreCard.addScores(new Player("B"), 2, 9, 8, 9);
        scoreCard.addScores(new Player("C"));

        final Map<Integer, List<Player>> lb = leaderBoard.calculate(scoreCard);

        System.out.println(lb);
        Assertions.assertEquals(2, lb.size());

        final List<Player> rank1 = lb.get(10);
        Assertions.assertEquals(1, rank1.size());
        Assertions.assertTrue(rank1.containsAll(Arrays.asList(new Player("A"))));

        final List<Player> rank2 = lb.get(9);
        Assertions.assertEquals(1, rank2.size());
        Assertions.assertTrue(rank2.contains(new Player("B")));
    }

    @Test
    @DisplayName("When only one player has scores")
    void testOnlyOnePlayerHasScores() {

        LeaderBoard leaderBoard = new LeaderBoard();
        ScoreCard scoreCard = new ScoreCard();

        scoreCard.addScores(new Player("A"), 7, 10, 2, 6);
        scoreCard.addScores(new Player("B"));
        scoreCard.addScores(new Player("C"));

        final Map<Integer, List<Player>> lb = leaderBoard.calculate(scoreCard);

        System.out.println(lb);
        Assertions.assertEquals(1, lb.size());

        final List<Player> rank1 = lb.get(10);
        Assertions.assertEquals(1, rank1.size());
        Assertions.assertTrue(rank1.containsAll(Arrays.asList(new Player("A"))));

    }

}