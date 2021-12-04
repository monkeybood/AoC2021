package Days;

import java.io.IOException;
import java.util.Vector;

import Days.day4.Board;
import utils.FileToVector;


public class Day4 {

	Vector<Board> boards;
	
	
	public Day4() {
		this.boards = new Vector<Board>();
	}
	
	public void loadBoards (String filename) throws IOException {
		Vector<String> strings = (new FileToVector()).toVector(filename); 
		
		
		for (int times = 0; times < strings.size(); times++) {
			
			
			String[] boardStrings = {strings.elementAt(times),
					strings.elementAt(times+1),
					strings.elementAt(times+2),
					strings.elementAt(times+3),
					strings.elementAt(times+4)};
			
			this.boards.add(new Board (5, boardStrings));
			
			
			times = times +4;
			
			
		}

		
	}
	
	public int playGame (String[] numbers) {
		
		boolean won = false;
		
		for (int times = 0; times < numbers.length && !won; times++) {
			for (int boardNumber = 0; boardNumber < this.boards.size(); boardNumber++) {
				Board board = this.boards.elementAt(boardNumber);
				board.removeNumber(numbers[times]);
				if (board.winner()) return board.score();
			}
		}
		
		return 0;
	}

	public int playToLoseGame (String[] numbers) {
		
		boolean won = false;
		
		int boardsRemaining = this.boards.size();
		
		for (int times = 0; times < numbers.length && !won; times++) {
			for (int boardNumber = 0; boardNumber < this.boards.size(); boardNumber++) {
				Board board = this.boards.elementAt(boardNumber);
				
				if (!board.winner()) {				
					board.removeNumber(numbers[times]);
					if (board.winner()) {
						boardsRemaining--;
						if (boardsRemaining == 1) {							
							return board.score();
						}
					}
				}
			}
		}
		
		return 0;
	}


	
	
	public static void main(String[] args) {
		
		try {
			String[] numbers = "31,50,79,59,39,53,58,95,92,55,40,97,81,22,69,26,6,23,3,29,83,48,18,75,47,49,62,45,35,34,1,88,54,16,56,77,28,94,52,15,0,87,93,90,60,67,68,85,80,51,20,96,61,66,63,91,8,99,70,13,71,17,7,38,44,43,5,25,72,2,57,33,82,78,89,21,30,11,73,84,4,46,14,19,12,10,42,32,64,98,9,74,86,27,24,65,37,41,76,36".split(",");
			
			Day4 day4 = new Day4();

			day4.loadBoards(args[0]);
			
			int score = day4.playGame(numbers);			
			System.out.println ("Score:"+score);
			
			score = day4.playToLoseGame(numbers);
			System.out.println ("Lose Score:"+score);
			
		} catch (IOException e) {
			System.out.println ("Bad:"+e);
		}
		
	}
			
}
