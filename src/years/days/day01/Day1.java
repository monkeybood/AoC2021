package years.days.day01;

import Days.Day5;
import Days.day5.Line;
import utils.FileToVector;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;
import java.util.Collections;

public class Day1 {

    public Vector<Elf> elves;

    public Day1(Vector<String> input) {
        this.elves = new Vector<Elf>();
        Iterator<String> iter = input.iterator();
        Elf currentElf = new Elf();
        String newLine = "";
        while (iter.hasNext()) {
             newLine = iter.next();
            if (newLine.equals("")) {
                this.elves.add(currentElf);
                currentElf = new Elf();
            } else {
                currentElf.addSnack(new Snack(newLine));
            }
        }
        if (!newLine.equals(""))  currentElf.addSnack(new Snack(newLine));
        this.elves.add(currentElf);
    }

    public static void main(String[] args) {
        try {
            Vector<String> input = (new FileToVector()).toVector("/Users/richard.davidson/IdeaProjects/AoC2021/input/2022/Day1.txt");
            Day1 day1 = new Day1(input);

            int mostCalories = 0;
            Iterator<Elf> iter = day1.elves.iterator();
            while (iter.hasNext()) {
                Elf elf = iter.next();
                if (mostCalories < elf.calorieCount()) mostCalories = elf.calorieCount();
            }

            System.out.println("Most calories:"+mostCalories);

            Collections.sort(day1.elves);

            System.out.println ("Top three elves:"+(day1.elves.elementAt(day1.elves.size()-3).calorieCount()+day1.elves.elementAt(day1.elves.size()-2).calorieCount()+day1.elves.elementAt(day1.elves.size()-1).calorieCount()));

        } catch (IOException e) {
            System.out.println("File Bad:"+e);
        }
    }




}
