package br.com.supercloud.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class SortingComparator {
    // https://www.hackerrank.com/challenges/ctci-comparator-sorting/

    static class Player {
        public String name;
        public int score;

        public Player(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return String.format("%s - %d", name, score);
        }
    }

    static class Checker implements Comparator<Player> {
        public int compare(Player a, Player b) {
            int result = b.score - a.score;
            return result == 0 ? a.name.compareTo(b.name) : result;
        }
    }

    public static void main(String[] args) {
        Player[] player = new Player[] {
                new Player("thiago", 30),
                new Player("thiago", 40),
                new Player("rebeka", 40),
                new Player("talita", 50),
        };
        Checker checker = new Checker();

        Arrays.sort(player, checker);
        Stream.of(player).forEach(System.out::println);
        // talita - 50
        // rebeka - 40
        // thiago - 40
        // thiago - 30
    }
}
