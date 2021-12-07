package Days;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import Days.day5.Line;
import utils.FileToVector;

public class Day5 {


	public Vector<Line> lines;
	
	int furthestPoint;
	int deepestPoint;
	
	int[][] map;
	
	public Day5(Vector<String> input) {
		this.lines = new Vector<Line>();
		
		this.deepestPoint = 0;
		this.furthestPoint = 0;
		
		Iterator<String> iter = input.iterator();
		while (iter.hasNext()) {
			Line newLine = new Line(iter.next());
			this.lines.add(newLine);
			
			if (newLine.furthestPointRight() > this.furthestPoint) this.furthestPoint = newLine.furthestPointRight();
			if (newLine.furthestPointDown() > this.deepestPoint) this.deepestPoint = newLine.furthestPointDown();
			
		}
		
		System.out.println("Lines:"+this.lines.size());
		System.out.println ("Horizontal:"+this.lines.elementAt(0).isHorizontalLine());
		System.out.println ("Vertical:"+this.lines.elementAt(0).isVerticalLine());
		
		System.out.println("FurthestPoint:"+this.furthestPoint);
		System.out.println("Deepest Point:"+this.deepestPoint);
		
		this.buildMap();
		
	}
	
	private void buildMap() {
		this.map = new int[this.furthestPoint+1][this.deepestPoint+1];
		
		for (int x = 0; x < this.furthestPoint; x++) {
			for (int y = 0; y < this.deepestPoint; y++) {
				this.map[x][y] = 0;
			}
		}
		
		Iterator<Line> iter = this.lines.iterator();
		while (iter.hasNext()) {
			Line line = iter.next();
			this.addThermalToMap(line);
		}
	}
	
	private void addThermalToMap (Line line) {
		
		
//		System.out.println ("Adding line");
//		System.out.println (line.isHorizontalLine());
//		System.out.println (line.isVerticalLine());
//		System.out.println (line.isDiagonaRisinglLine());
//		System.out.println (line.isDiagonaFallingLine());
		
		
		if (line.isHorizontalLine()) this.addHorizontalThermalToMap(line.furthestPointLeft(), line.furthestPointDown(), line.horizontalLength());
		if (line.isVerticalLine()) this.addVerticalThermalToMap(line.furthestPointLeft(), line.furthestPointUp(), line.verticalLength());
		
		if (line.isDiagonaRisinglLine())this.addDiagonalRisingToMap(line.furthestPointLeft(), line.furthestPointDown(), line.horizontalLength());
		if (line.isDiagonaFallingLine()) this.addDiagonalFallingToMap(line.furthestPointLeft(), line.furthestPointUp(), line.horizontalLength());
		
	}

	private void addHorizontalThermalToMap (int startX, int y, int distance) {
		for (int times = startX; times <= startX+distance; times++) {
			
			this.map[times][y] = this.map[times][y] + 1; 
		}
	}

	private void addVerticalThermalToMap (int x, int startY, int distance) {
		for (int times = startY; times <= startY+distance; times++) {
			this.map[x][times] = this.map[x][times] + 1; 
		}
	}

	private void addDiagonalRisingToMap  (int startX, int startY, int distance) {
		int timesY = startY;
		for (int times = startX; times <= startX+distance; times++) {
			this.map[times][timesY] = this.map[times][timesY] + 1;
			timesY--;
		}

	}

	private void addDiagonalFallingToMap  (int startX, int startY, int distance) {
		int timesY = startY;
		for (int times = startX; times <= startX+distance; times++) {
			this.map[times][timesY] = this.map[times][timesY] + 1;
			timesY++;
		}

	}

	
	public void printMap() {
		System.out.println("------  Map  ------");
		
		for (int y = 0; y <this.map[0].length; y++) {
			StringBuilder line = new StringBuilder();
			for (int x = 0; x < this.map.length; x++) {
				line.append(map[x][y]);
			}
			System.out.println(line.toString());
		}

		System.out.println("------  End Map  ------");
	}
	
	public int countOverlaps () {
		int overlaps = 0;
		for (int x = 0; x < this.map.length; x++) {
			for (int y = 0; y < this.map[x].length;y++) {
				if (map[x][y] > 1) overlaps++;
			}
		}
		return overlaps;
	}
	
	
	
	public static void main(String[] args) {
		try {
			Vector<String> input = (new FileToVector()).toVector("/Users/richdavidson/eclipse-workspace/AoC2021/input/Day5Test");
//			Vector<String> input = (new FileToVector()).toVector(args[0]);
			Day5 day5 = new Day5(input);
			day5.printMap();
			System.out.println ("Overlap count:"+day5.countOverlaps());
			
		} catch (IOException e) {
			System.out.println("File Bad:"+e);
		}
	}
	
}
