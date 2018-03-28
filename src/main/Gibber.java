package main;

import java.io.IOException;

import reader.TextFileReader;

public class Gibber {

	int bufferSize = 10;
	
	public Gibber() {
		
	
		String output = "";		
		TextFileReader reader = new TextFileReader(bufferSize);
		try {
			
			
			reader.readSample();
			
			int wordCount = -1;
			char previousChar = ' ';
			int lkm = 200;
			
			while (wordCount < lkm) {
			
				char c = reader.randomizeNextChar(getSeed(output));
				
				if (Character.isWhitespace(previousChar) && !Character.isWhitespace(c)) {
					wordCount++;
					if (wordCount == lkm)
						break;
				}
				output += c;
				previousChar = c;
			
			}
			int i=0;
			char c = output.charAt(i);
			while (Character.isWhitespace(c)) {
				i++;
				c = output.charAt(i);
			}
			output = output.substring(i, output.length()-1);
			
			
			System.out.print(output);
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	private String getSeed(String sample) {
		String s = "";
			
		if (sample.length() < this.bufferSize)
			return s;
		else {
			s = sample.substring(sample.length()-this.bufferSize);
			
			return s;
		}
		
	}
	
	public static void main(String[] args) {
		Gibber gibber = new Gibber();
		
		
	}
	
	
}
