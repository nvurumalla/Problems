package main;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorImpl {

    public static void main(String[] args) {
        Player p1 = new Player("amy", 100);
        Player p2 = new Player("denver", 100);
        Player p3 = new Player("nelson", 50);
        Player p4 = new Player("gildon", 150);
        Player p5 = new Player("rat", 200);
        Player p6 = new Player("bat", 75);

        Checker checker = new Checker();
        Player[] players = {p1, p2, p3, p4, p5, p6};
//        Arrays.sort(players, checker);
        Arrays.sort(players);
        for (Player p : players) {
            System.out.println(p.name + ", " + p.score);
        }
    }


}

class Checker implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        if (((Player)o1).score != ((Player)o2).score) {
            return ((Player)o2).score-((Player)o1).score;
        } else {
            return ((Player)o1).name.compareTo(((Player)o2).name);
        }
    }
}

class Player implements Comparable {
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Object o) {
        if (this.score != ((Player)o).score) {
            return ((Player)o).score-this.score;
        } else {
            return this.name.compareTo(((Player)o).name);
        }
    }
}