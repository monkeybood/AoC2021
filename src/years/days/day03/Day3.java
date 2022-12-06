package years.days.day03;

import utils.FileToVector;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

public class Day3 {


    public static void main(String[] args) {
        try {
            Vector<String> input = (new FileToVector()).toVector("/Users/richard.davidson/IdeaProjects/AoC2021/input/2022/Day3.txt");

            int upperCaseAdjust = 38;
            int lowerCaseAdjust = 96;


            Iterator<String> iter = input.iterator();
            int priorityTotal = 0;
            while (iter.hasNext()) {
                Backpack backpack = new Backpack(iter.next());
                char duplicate = backpack.duplicateItem().charAt(0);
                int ascii = (int) duplicate;
                if (ascii > 96) {
                    priorityTotal += (ascii - lowerCaseAdjust);
                } else {
                    priorityTotal += (ascii - upperCaseAdjust);
                }

            }

            System.out.println(priorityTotal);
            System.out.println("***********");

            Iterator<String> iter2 = input.iterator();
            int priorityTotal2 = 0;
            while (iter2.hasNext()) {
                Group group = new Group(iter2.next(),
                        iter2.next(),
                        iter2.next());
                char badge = group.duplicateItem().charAt(0);
                int ascii = (int) badge;
                if (ascii > 96) {
                    priorityTotal2 += (ascii - lowerCaseAdjust);
                } else {
                    priorityTotal2 += (ascii - upperCaseAdjust);
                }
            }
            System.out.println(priorityTotal2);


        } catch (
                IOException e) {
            System.out.println("File Bad:" + e);
        }

    }

}
