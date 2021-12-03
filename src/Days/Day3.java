package Days;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import utils.FileToVector;

public class Day3 {

	Vector<String> input;
	Vector <String> words;
	
	String gamma;
	String epsilon;
	
	int wordLength;
	
	public Day3 (Vector<String> input) {
		this.input = input;
		this.words = this.generateWords(input);
		
		this.gammaEpsilonBinaryBuilder();
		
		this.wordLength = input.size();
		
	}
	
	private Vector<String> generateWords (Vector<String> input) {
		Vector<String> newWords = new Vector<String>();
		for (int wordLength = 0; wordLength < input.elementAt(0).length(); wordLength++) {
			
			StringBuilder word = new StringBuilder (input.elementAt(0).substring(wordLength,wordLength+1));
			for (int inputSize = 1; inputSize < input.size(); inputSize++) {
				word.append(input.elementAt(inputSize).substring(wordLength, wordLength+1));
			}
			newWords.add(word.toString());
		}		
		return newWords;
	}
	
	public void gammaEpsilonBinaryBuilder() {
		StringBuilder gammaBuilder = new StringBuilder();
		StringBuilder epsilonBuilder = new StringBuilder();		
		Iterator<String> iter = this.words.iterator();
		
		while (iter.hasNext()) {
			if (this.mostCommonBitIsOne(iter.next(),"1")) {
				gammaBuilder.append("1");
				epsilonBuilder.append("0");
			} else {
				gammaBuilder.append("0");
				epsilonBuilder.append("1");
			}
		}
		this.gamma = gammaBuilder.toString();
		this.epsilon = epsilonBuilder.toString();
		
	}
	
	private int countOnes(String input) {
		System.out.println("Ones:"+(input.length() - input.replace("1", "").length()));
		return input.length() - input.replace("1", "").length();
	}

	private int countZeroes(String input) {
		System.out.println("Zeroes:"+(input.length() - input.replace("0", "").length()));
		return input.length() - input.replace("0", "").length();
	}
	
	
	private boolean mostCommonBitIsOne (String input, String priorityBit) {
		if (priorityBit.equals("1"))
			return (input.replaceAll("0", "").length() >= input.replaceAll("1", "").length());
		else
			return (input.replaceAll("0", "").length() > input.replaceAll("1", "").length());
	}
	
	
	private Vector<String> reduceVector (Vector<String> startingVector, String bit, int index) {
		Vector<String> newVector = new Vector<String>();
		
		Iterator<String> iter = startingVector.iterator();
		
		while (iter.hasNext()) {
			String word = iter.next();			
			if (word.substring(index,index+1).equals(bit)) {
				newVector.add(word);
			}
		}
		
		return newVector;
	}
	
		
	public String generateMetric (String bit) {
		Vector<String> metricInputVector = this.input;
		int index = 0;
		while (metricInputVector.size() > 1) {
			System.out.println(index);
			metricInputVector = this.reduceMetric(metricInputVector, index, bit);
			index++;
		}
		return metricInputVector.elementAt(0);
	}
	
	public Vector<String> reduceMetric(Vector<String> input, int index, String metricBit) {
		if (input.size() == 1) return input;
		
		Vector<String> newInput = new Vector<String> ();
		StringBuilder word = new StringBuilder();
		Iterator<String> inputStrings = input.iterator();
		while (inputStrings.hasNext()) {
			word.append(inputStrings.next().substring(index, index+1));
		}

		
		int oneCount = this.countOnes(word.toString());
		int zeroCount = this.countZeroes(word.toString());
		
		if (metricBit.equals("1")) {
			if (oneCount >= zeroCount) {
				newInput = this.reduceVector(input, "1", index);
			} else {
				newInput = this.reduceVector(input, "0", index);
			}
		} else {
			if (zeroCount > oneCount) {
				newInput = this.reduceVector(input, "1", index);
			} else {
				newInput = this.reduceVector(input, "0", index);
			}
			
		}
		

		return newInput;
	}
	
	
	public static void main(String[] args) {
		
		try {
			Day3 day3 = (new Day3((new FileToVector()).toVector(args[0])));
			
			System.out.println ("Gamma:"+day3.gamma);
			System.out.println ("Epsilon:"+day3.epsilon);
			
			System.out.println (Integer.parseInt(day3.gamma,2)*Integer.parseInt(day3.epsilon,2));
			
			
			System.out.println("Generating oxygen");
			String oxygen = day3.generateMetric("1");

			
			System.out.println("Generating C02");
			String c02 = day3.generateMetric("0");

			
			System.out.println("oxygen:"+oxygen);
			System.out.println("oxygen:"+Integer.parseInt(oxygen,2));
			
			System.out.println("C02:"+c02);
			System.out.println("c02:"+Integer.parseInt(c02,2));
			int result = Integer.parseInt(oxygen,2)*Integer.parseInt(c02,2);
			System.out.println ("Result:"+result);

			
		} catch (IOException e) {
			System.out.println ("Bad:"+e);
		}
		
	}
	
	
	
}
