import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame {

	JFrame mainFrame = new JFrame("AKKYKSTN");
	JPanel mainPanel = new JPanel();
	//possibly add "SAVED GAMES" button
	JButton startButton = new JButton("START");
	JButton instruct = new JButton("HOW TO PLAY");
	JButton exitButton = new JButton("EXIT");

	
	public Frame(){

		mainFrame.setSize(600, 900);
		mainFrame.setResizable(false);
		mainFrame.setLayout(new GridLayout());
		mainFrame.setLocation(600, 30);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Color orangeColor = Color.decode("#f09348");
		mainPanel.setBackground(orangeColor);
		mainPanel.setLayout(null);

		startButton.setBounds(165, 120, 265, 50);
		instruct.setBounds(165, 200, 265, 50);
		exitButton.setBounds(165, 280, 265, 50);

		//start game
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent a) {
				App game = new App();
				try{
					game.init();	
				}
				catch (InterruptedException ie) {
					System.out.println("Error. Interrupted!");
					System.exit(0);
				}
				//Sound.SONG.play();
			}
		});

		//how to play
		instruct.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent a) {
				JFrame how = new JFrame();
				how.setSize(600, 900);
				how.setResizable(false);
				how.setLayout(new GridLayout());
				how.setLocation(600, 30);
				how.setVisible(true);

				//make back button aron cleaner
			}
		});

		//exit
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent a) {
				System.exit(0);
			}
		});

        mainPanel.add(startButton);
        mainPanel.add(instruct);
        mainPanel.add(exitButton);

		mainFrame.add(mainPanel);
		mainFrame.setVisible(true);

	}
	
	public static void main(String[] args) {
		Frame f = new Frame()
;	}
}