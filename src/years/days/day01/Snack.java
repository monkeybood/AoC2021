package years.days.day01;

public class Snack {

    int calories;

    public Snack(int caloriesIn) {
        this.calories = caloriesIn;
    }

    public Snack(String caloriesIn) {
        this.calories = Integer.parseInt(caloriesIn);
    }
}
