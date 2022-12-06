package years.days.day02;

import java.util.HashMap;

public class Game {

    String player1;
    String player2;

    private static final int  draw= 3;
    private static final int  win= 6;
    private static final int  rock= 1;
    private static final int  scissors= 3;
    private static final int  paper= 2;



    public Game (String line) {

        HashMap<String,String> toWin = new HashMap<String,String>();
        toWin.put("A","Y");
        toWin.put("B","Z");
        toWin.put("C","X");


        HashMap<String,String> toLose = new HashMap<String,String>();
        toLose.put("A","Z");
        toLose.put("B","X");
        toLose.put("C","Y");

        HashMap<String,String> toDraw = new HashMap<String,String>();
        toDraw.put("A","X");
        toDraw.put("B","Y");
        toDraw.put("C","Z");

        this.player1 = line.substring(0,1);
        String strategy = line.substring(2,3);

        if (strategy.equalsIgnoreCase("X")) this.player2 = toLose.get(player1);
        if (strategy.equalsIgnoreCase("Y")) this.player2 = toDraw.get(player1);
        if (strategy.equalsIgnoreCase("Z")) this.player2 = toWin.get(player1);


    }

    public int score() {
        int score = 0;

        if (
                (player1.equalsIgnoreCase("A") && player2.equalsIgnoreCase("X")) ||
                        (player1.equalsIgnoreCase("B") && player2.equalsIgnoreCase("Y")) ||
                        (player1.equalsIgnoreCase("C") && player2.equalsIgnoreCase("Z"))
        ) {
            score += draw;
        }

        if (
                (player1.equalsIgnoreCase("A") && player2.equalsIgnoreCase("Y")) ||
                        (player1.equalsIgnoreCase("B") && player2.equalsIgnoreCase("Z")) ||
                        (player1.equalsIgnoreCase("C") && player2.equalsIgnoreCase("X"))
        ) {
          score+=win;
        }

        if (player2.equalsIgnoreCase("X")) score += rock;
        if (player2.equalsIgnoreCase("Y")) score += paper;
        if (player2.equalsIgnoreCase("Z")) score += scissors;

        return score;

    }

    public String toString() {
        return "Player 1:"+player1+" Player 2:"+player2+" Score:"+this.score();
    }
}
