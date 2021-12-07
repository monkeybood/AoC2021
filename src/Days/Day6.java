package Days;

import java.io.IOException;
import java.util.Vector;

import utils.FileToVector;

public class Day6 {

	long[] school;
	int newFish;
	int fishReset;
	int day;
	
	
	public Day6 (String[] newSchool, int maxAge) {
		this.day = 0;
		this.newFish = maxAge;
		this.fishReset = maxAge-2;
		this.school = new long[newFish+1];
		for (int times = 0; times <= newFish; times++) {
			this.school[times] = 0;
		}
		
		for (int fishNumber = 0; fishNumber < newSchool.length; fishNumber++) {
			int currentFish = Integer.parseInt(newSchool[fishNumber]);
			this.school[currentFish] = this.school[currentFish]+1;
		}
		
	}
	
	public void progressDay() {
		long fishToAdd = this.school[0];
		
		
		long[] newSchool = new long[this.newFish+1];
		
		
		for (int times = 0; times < newFish; times++) {
			newSchool[times] = this.school[times+1];
		}
		
		newSchool[fishReset] = newSchool[fishReset] + fishToAdd;
		newSchool[this.newFish] = newSchool[this.newFish] + fishToAdd; 
		
		this.school = newSchool;
	}
	
	public long totalFish() {
		long runningTotal = 0;
		for (int times = 0; times < this.school.length; times++) {
			runningTotal = this.school[times] + runningTotal;
		}
		return runningTotal;
	}
	
	
	public static void main(String[] args) {

		try {
			Vector<String> input = (new FileToVector()).toVector("/Users/richdavidson/eclipse-workspace/AoC2021/input/Day6");
			
			String[] fish = input.elementAt(0).split(",");
			Day6 day6 = new Day6(fish, 8);
			
			int numberOfDays = 256;
			
			for (int days = 1; days <= numberOfDays; days++) {
				day6.progressDay();
				System.out.println ("Day:"+days);
				System.out.println ("Fish total:"+day6.totalFish());
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
