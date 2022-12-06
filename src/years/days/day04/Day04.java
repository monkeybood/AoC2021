package years.days.day04;

import utils.FileToVector;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

public class Day04 {




    public static void main(String[] args) {
        try {
            Vector<String> input = (new FileToVector()).toVector("/Users/richard.davidson/IdeaProjects/AoC2021/input/2022/Day4.txt");

            int count = 0;
            int overlap = 0;

            Iterator<String> iter = input.iterator();
            while (iter.hasNext()) {
                String pair = iter.next();
                Range left = new Range(pair.substring(0,pair.indexOf(",")));
                Range right = new Range(pair.substring(pair.indexOf(",")+1, pair.length()));

                if (left.fullyContains(right) || right.fullyContains(left)) count++;
                if (left.overlap(right) || right.overlap(left)) overlap++;
            }

            System.out.println("Count:"+count);

            System.out.println("Overlap Count:"+overlap);




        } catch (
                IOException e) {
            System.out.println("File Bad:" + e);
        }

    }

}
