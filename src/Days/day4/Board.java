package Days.day4;

import java.util.Iterator;
import java.util.Vector;

public class Board {

	Vector<String> allNumbers;
	Vector <String> checkedNumbers;
	Vector<String> remainingNumbers;	
	
	String lastNumber;
	
	String[][] matrix;
	
	boolean won;
	
	
	public Board (int boardSize, String[] rows) {
		this.won = false;
		this.allNumbers = new Vector<String>();
		this.checkedNumbers = new Vector<String>();
		this.remainingNumbers = new Vector<String>();
		
		this.matrix = new String[boardSize][boardSize];
		
		
		for (int times = 0; times < rows.length; times++) {
			String[] currentRow = rows[times].stripLeading().replace("  "," ").split(" ");
			for (int column = 0; column < currentRow.length; column++) {
				this.matrix[times][column] = currentRow[column];
				this.allNumbers.add(currentRow[column]);
				this.remainingNumbers.add(currentRow[column]);
			}
		}
	}
	
	public void removeNumber (String number) {
		if (allNumbers.contains(number)) { 
			this.checkedNumbers.add(number);
			this.remainingNumbers.remove(number);
			this.lastNumber = number;
			for (int row = 0; row < matrix.length; row++) {
				for (int column = 0; column < matrix.length; column++) {
					if (matrix[row][column].equals(number)) matrix[row][column] = "";
				}
			}
		}
	}
	
	
	public boolean checkRows() {
		for (int rows = 0; rows < matrix.length; rows++) {
			int checkCount = 0;
			for (int column = 0; column < matrix.length; column++) {
				
				if (matrix[rows][column].equals("")) checkCount++;
			}
			if (checkCount == matrix.length) return true;
		}
		return false;
	}

	
	
	public boolean checkColumns() {
		for (int column = 0; column < matrix.length; column++) {
			int checkCount = 0;
			for (int rows = 0; rows < matrix.length; rows++) {
				if (matrix[rows][column].equals("")) checkCount++;
			}
			if (checkCount == matrix.length) return true;
		}
		return false;
	}

	public int score() {
		int score = 0;
		Iterator<String> remainIter = this.remainingNumbers.iterator();
		while (remainIter.hasNext()) {
			score += Integer.parseInt(remainIter.next());
		}
		
		return score * Integer.parseInt(lastNumber);
	}
	
	public boolean winner() {
		if (this.won || this.checkRows() || this.checkColumns()) {
			this.won = true;
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		
		
		StringBuilder builder = new StringBuilder();
		for (int rows = 0; rows < matrix.length; rows++) {
			for (int columns = 0; columns < matrix[rows].length; columns++) {
				builder.append(this.matrix[rows][columns]);
				builder.append("|");
			}
			builder.append("\n");
		}
		return builder.toString();
	}
	
}
