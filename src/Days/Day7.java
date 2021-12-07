package Days;

import java.io.IOException;
import java.util.Vector;

import utils.FileToVector;

public class Day7 {

	int [] crabPositions;

	int minPosition;
	int maxPosition;
	
	public Day7(String[] input) {
		this.crabPositions = new int[input.length];
		this.minPosition =  Integer.parseInt ( input[0]);
		this.maxPosition =  Integer.parseInt ( input[0]);
		
		for (int times = 0; times < input.length; times++) {
			this.crabPositions[times] = Integer.parseInt ( input[times]);
			
			if (Integer.parseInt ( input[times]) < this.minPosition) this.minPosition = Integer.parseInt ( input[times]);
			if (Integer.parseInt ( input[times]) > this.maxPosition) this.maxPosition = Integer.parseInt ( input[times]);
		}
		
	}
	
	public long calculateFuelCost(int position) {
		long fuelCost = 0;
		
		for (int times = 0; times < this.crabPositions.length; times++) {
			fuelCost = fuelCost + (Math.abs(this.crabPositions[times]-position));
		}
		
		return fuelCost;
	}

	

	
	public long calculateCheapest() {
		long cheapest = this.calculateFuelCost(this.minPosition);
		
		for (int times = this.minPosition; times < this.maxPosition; times++) {
			long cost = this.calculateFuelCost(times);
			if (cost < cheapest) cheapest = cost;
		}
		return cheapest;
	}
	
	
	public long calculateFuelCost2(int position) {
		long fuelCost = 0;
		
		for (int times = 0; times < this.crabPositions.length; times++) {
			long linearCost = Math.abs(this.crabPositions[times]-position);
			long exponentialCost = 0;
			for (long times2 = 1; times2 <= linearCost; times2++) {
				exponentialCost = exponentialCost + times2;
			}
			fuelCost = fuelCost + exponentialCost;
		}
		
		return fuelCost;
	}

	
	public long calculateCheapest2() {
		long cheapest = this.calculateFuelCost2(this.minPosition);
		
		for (int times = this.minPosition; times < this.maxPosition; times++) {
			long cost = this.calculateFuelCost2(times);
			if (cost < cheapest) cheapest = cost;
		}
		return cheapest;
	}
	
	public static void main(String[] args) {
		try {
			Vector<String> input = (new FileToVector()).toVector("/Users/richdavidson/eclipse-workspace/AoC2021/input/Day7");
			String [] crabs = input.elementAt(0).split(",");
			Day7 day7 = new Day7(crabs);
			
			System.out.println ("Fuel cost at 2:"+day7.calculateFuelCost(2));
			System.out.println ("Fuel cost at 1:"+day7.calculateFuelCost(1));
			System.out.println ("Fuel cost at 3:"+day7.calculateFuelCost(3));
			System.out.println ("Fuel cost at 10:"+day7.calculateFuelCost(10));
			System.out.println ("----");
			
			
//			System.out.println ("Fuel cost2 at 2:"+day7.calculateFuelCost2(2));
//			System.out.println ("Fuel cost2 at 1:"+day7.calculateFuelCost2(1));
//			System.out.println ("Fuel cost2 at 3:"+day7.calculateFuelCost2(3));
//			System.out.println ("Fuel cost2 at 10:"+day7.calculateFuelCost2(10));
			System.out.println ("Fuel cost2 at 5:"+day7.calculateFuelCost2(5));			
			System.out.println ("----");

			
			System.out.println ("Cheapest:"+day7.calculateCheapest2());
			
			
		} catch (IOException e) {
			System.out.println("Bad:"+e);
		}
	}

}
