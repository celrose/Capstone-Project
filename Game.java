import javax.swing.*;
import java.awt.*;

public class Game {
	
	String songTitle;
	Lyrics l = new Lyrics();

	public Game() {
		
		//edit title to be the song chosen
		songTitle = "Alone Together - FOB";
		JFrame game = new JFrame(songTitle);
		//add 3 seconds delay
		//possibly JTextArea that displays count down 3, 2, 1
		//thread(1 second)
		Sound.SONG.play();

		game.setSize(600, 900);
		game.setResizable(false);
		game.setLayout(new GridLayout());
		game.setLocation(600, 30);

		//game loop


		game.setVisible(true);
	}
}