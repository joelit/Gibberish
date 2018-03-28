package reader;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

public class TextFileReader {

	private String buffer, inputFilePath;
	private HashMap<String, Vector<Character>> map;
	private int bufferLength;
	private Random r = new Random();
	
	public TextFileReader(int bufferSize)  {
		this.bufferLength = bufferSize;
		this.map = new HashMap<String, Vector<Character>>();
		this.buffer="";
		
		this.inputFilePath = "sample.txt";
		
	}
	
	public void readSample() throws IOException {
		FileReader fr = new FileReader(this.inputFilePath);
		int c;
		this.buffer= this.initializeEmptyBuffer();
		while ((c = fr.read()) != -1) {
            addChar((char) c);
         }
		fr.close();
		
	}
	
	private String initializeEmptyBuffer() {
		String ret ="";
		for (int i = 0; i<this.bufferLength; i++) {
			ret += " ";
		}
		return ret;
		
	}
	
	private void addChar(char c) {
		this.buffer += c;
		
		String key = this.buffer.substring(0, this.buffer.length() - 1);
		Character val = Character.valueOf(this.buffer.charAt(this.buffer.length()-1));
		
		if (this.map.containsKey(key)) {
			this.map.get(key).add(val);
			
		} else {
			Vector<Character> v = new Vector<Character>();
			v.add(val);
			this.map.put(key, v);
		}

		this.buffer = this.buffer.substring(1);
	}
	
	public char randomizeNextChar(String seed) {
	

		Vector<Character> possibleNext = this.map.get(seed);
		if (possibleNext == null) {
			return ' ';
			
		}
		int index = this.r.nextInt(possibleNext.size());
		Character randomNext = possibleNext.get(index);

		return randomNext.charValue();

	}
	
	
}
