import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Word implements KeyListener{

    Lyrics lyric = new Lyrics();
    int i = 0;
    int j = 0;
    String string = lyric.get(0);
    
    public void keyTyped(KeyEvent e) {
    	//e.getKeyChar()
    	//if else thingy
          System.out.println("Key typed: " + e.getKeyChar());
        if(e.getKeyChar() == string.charAt(i)){
          System.out.println("TYPED");  
          i++; 
        }
        if(i == string.length()){
          i = 0;
          string = lyric.get(++j);
        }
    }

    public void keyPressed(KeyEvent e) {
        
    }

    public void keyReleased(KeyEvent e) {
        
    }

    public static void main(String[] args) {
    	JFrame frame = new JFrame("Key Pressed");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        panel.addKeyListener(new Word());

        frame.add(panel);

        frame.setSize(500, 500);
        frame.setVisible(true);

      	
        panel.requestFocusInWindow();
    }
}

