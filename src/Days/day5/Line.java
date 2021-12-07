package Days.day5;

public class Line {

	int startX;
	int startY;
	
	int endX;
	int endY;
	
	
	public Line (String inputLine) {
		String start = inputLine.split(" -> ")[0];
		String end = inputLine.split(" -> ")[1];

		this.startX = Integer.parseInt(start.split(",")[0]);
		this.startY = Integer.parseInt(start.split(",")[1]);
		this.endX = Integer.parseInt(end.split(",")[0]);
		this.endY = Integer.parseInt(end.split(",")[1]);
		
	}
	
	public Line (int newStartX, int newStartY, int newEndX, int newEndY) {
		this.startX = newStartX;
		this.startY = newStartY;
		this.endX = newEndX;
		this.endY = newEndY;
	}
	
	
	public boolean isVerticalLine ( ) {
		if (this.startX == this.endX && this.startY != this.endY) 
			return true;
		else
			return false;
	}
	
	public boolean isHorizontalLine() {
		if (this.startX != this.endX && this.startY == this.endY) 
			return true;
		else
			return false;		
	}

	public boolean isDiagonaRisinglLine() {
		if (this.startX != this.endX && this.startY < this.endY) 
			return true;
		else
			return false;		
	}

	public boolean isDiagonaFallingLine() {
		if (this.startX != this.endX && this.startY > this.endY) 
			return true;
		else
			return false;		
	}

	
	
	
	public int furthestPointLeft() {
		if (startX < endX) {
			return startX;
		} else {
			return endX;
		}
	}

	public int furthestPointRight() {
		if (startX > endX) {
			return startX;
		} else {
			return endX;
		}
	}
	
	
	
	public int furthestPointUp() {
		if (startY < endY) {
			return startY;
		} else {
			return endY;
		}
	}

	public int furthestPointDown() {
		if (startY > endY) {
			return startY;
		} else {
			return endY;
		}
	}
	
	
	public int horizontalLength() {
		return Math.abs(startX-endX);
	}

	public int verticalLength() {
		return Math.abs(startY-endY);
	}
	
}
