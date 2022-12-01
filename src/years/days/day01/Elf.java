package years.days.day01;


import java.util.Iterator;
import java.util.Vector;

public class Elf implements Comparable {

    private Vector<Snack> snackVector = new Vector<Snack>();

    public Elf() {
        super();
    }

    public void addSnack (Snack snack) {
    this.snackVector.add(snack);
    }

    public int calorieCount() {
        int calories = 0;
        Iterator<Snack> iter = snackVector.iterator();
        while (iter.hasNext()) {
            calories += iter.next().calories;
        }
        return calories;
    }


    @Override
    public int compareTo(Object o) {
        Elf e2 = (Elf)  o;

        if(this.calorieCount()==e2.calorieCount())
            return 0;
        else if(this.calorieCount()>e2.calorieCount())
            return 1;
        else
            return -1;
    }
}
