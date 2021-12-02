package Days;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import utils.FileToVector;

public class Day2 {

	long depth;
	long forward;
	long aim; 
	
	public Day2 () {
		this.depth = 0;
		this.forward = 0;
		this.aim = 0;
	}
	
	
	
	public void executeInstructions (Iterator<String> iterator) {
		while (iterator.hasNext()) {
			String singleInstruction = iterator.next();
			this.execute(singleInstruction.substring(0, singleInstruction.indexOf(" ")), 
					Integer.parseInt(singleInstruction.substring(singleInstruction.indexOf(" ")+1, singleInstruction.length())));
		}
	}
	
	private void execute (String instruction, int distance) {
		switch (instruction) {
			case "forward":
				this.forward+=distance;
				this.depth += (this.aim*distance);
				break;
				
			case "up":
				this.aim-=distance;
				break;
				
			case "down":
				this.aim+=distance;
			default:
		}
	}
	
	public static void main(String[] args) {
		
		try {
			Vector<String> instructions =  (new FileToVector()).toVector(args[0]);
			Day2 day2 = new Day2();
			
			day2.executeInstructions(instructions.iterator());
			
			System.out.println ("Depth:"+day2.depth);
			System.out.println ("Forward:"+day2.forward);
			System.out.println("Multiply:"+(day2.depth*day2.forward));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Problem reading the input file");
			e.printStackTrace();
		}
	}
	
}
