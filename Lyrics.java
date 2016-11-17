import java.io.*;
import java.util.*;


public class Lyrics {
	
	String token;
	List<String> words = new ArrayList<String>();

	public Lyrics() {
		//open file then store or smthn
		try {
			Scanner newSong = new Scanner(new File("alone_together.txt")).useDelimiter(",\\s*");
			while(newSong.hasNext()) {
				token = newSong.next();
				token.trim();
				words.add(token);
			}

			newSong.close();
		}
		catch (FileNotFoundException e){
			System.out.println("Lyric file not found.");
		}

		//print out the words
		//System.out.println(words);
		//System.out.println(words.get(3));

	}

	// public String currentWord() {
	// 	return words.get(cu)
	// }


	//tester main
	//remove later
	public static void main(String[] args) {
		Lyrics l = new Lyrics();

	}
}