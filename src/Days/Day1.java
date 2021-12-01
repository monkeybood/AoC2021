package Days;

import java.util.Iterator;
import java.util.Vector;

import utils.FileToVector;

public class Day1 {

	
	private Vector<String> depths;
	
	public Day1 (Vector<String> depths) {
		this.depths = depths;
	}
	
	
	
	public int windowDepthIncreases() throws Exception {
		int increases = 0;
		for (int times = 0; times < this.depths.size()- 3; times++) {
			if (this.sumWindowAtPosition(times) < this.sumWindowAtPosition(times+1)) increases++;
		}
		return increases;
	}
	
	public int sumWindowAtPosition (int windowPosition) throws Exception {
		if (this.depths.size() >= windowPosition + 3) {
			return Integer.parseInt(this.depths.elementAt(windowPosition)) +
					Integer.parseInt(this.depths.elementAt(windowPosition+1)) +
					Integer.parseInt(this.depths.elementAt(windowPosition+2));
		} else {
			throw new Exception ("No window");
		}
		
	}
	
	public int depthIncreases() {
		Iterator<String> i = this.depths.iterator();
		int increases = 0;
		int previousRead =  Integer.parseInt(i.next());
		int currentRead = previousRead;
		
		while (i.hasNext()) {
			currentRead = Integer.parseInt(i.next());
			if (currentRead > previousRead) increases++;
			previousRead = currentRead;
		}
		
		
		return increases;
		
	}
	
	public static void main(String[] args) {
		
		String filename = args[0];
		
		FileToVector fileToVector = new FileToVector();
		try {
			Day1 day1 = new Day1(fileToVector.toVector(filename));
		
			System.out.println ("Depth increases:"+day1.depthIncreases());
			System.out.println ("Depth window increases:"+day1.windowDepthIncreases());			
		} catch (Exception e) {
			System.out.println("It broke");			
			e.printStackTrace();
		}
		
		
	}

}
