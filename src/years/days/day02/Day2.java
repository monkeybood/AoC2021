package years.days.day02;

import utils.FileToVector;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

public class Day2 {

    public static void main(String[] args) {
        try {
            Vector<String> input = (new FileToVector()).toVector("/Users/richard.davidson/IdeaProjects/AoC2021/input/2022/Day2.txt");

            int score = 0;
            Iterator<String> gamesIter = input.iterator();
            while (gamesIter.hasNext()) {
                Game game = new Game(gamesIter.next());
                System.out.println(game);
                score += game.score();
            }

            System.out.println("Score total:"+score);

        } catch (
                IOException e) {
            System.out.println("File Bad:" + e);
        }

    }
}
