package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import java.lang.String;

public class FileToVector {

	public FileToVector() {
		
	}

	public Vector<String> toVector (String filename) throws IOException {
		Vector<String> result = new Vector<String>();
		BufferedReader reader = new BufferedReader(new FileReader(
					filename));
			
		String line = reader.readLine();
			
		while (line != null) {
			if (!line.equals("")) {
				result.add(line);
			}
			line = reader.readLine();
		}

		return result;
	}
	
}
