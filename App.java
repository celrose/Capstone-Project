import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class App extends JPanel {

    //changing these values will change the size of the game, while still remaining functional
    //within the size limit specified.
    String songTitle;
    Lyrics l = new Lyrics();

    static int windowWidth = 600;
    static int windowHeight = 900;

    int randNumb = 0;
    int squareWidth = 25;
    int squareHeight = 25;
    int squareYLocation = -squareWidth;
    int count = 0;
    boolean numberCreated = false;

    static boolean gameRunning = false;


    //generates a random Y value inside the window for the square to spawn at
    public void generateRandomNumber() {
        Random rand = new Random();
        randNumb = rand.nextInt(windowWidth - squareWidth);
        numberCreated = true;
    }

    //paints a black screen, then paints a rectangle on top of the black screen
    public void paint(Graphics g) {
        /*
        g.setColor(Color.black);
        g.fillRect(0, 0, windowWidth, windowHeight);
        g.setColor(Color.WHITE);
        //g.fillRect(randNumb, squareYLocation, squareWidth, squareHeight);
        //String word = 
        //g.setFont(new Font("TimesNewRoman", Font.PLAIN, 18)); 
        g.drawString("hello", squareHeight, squareYLocation);
        */
        g.setColor(Color.black);
        g.fillRect(0, 0, windowWidth, windowHeight);
        g.setColor(Color.GREEN);
        g.fillRect(randNumb, squareYLocation, squareWidth, squareHeight);
        g.setColor(Color.BLUE);
        g.drawString("YOW", randNumb + 60, squareYLocation + 25);
    }

    public void update() {

        //calls the generateRandomNumber() method which gives the square a random x value inside the screen
        if (!numberCreated) {
            generateRandomNumber();
        }
        //moves the squares y coordinate towards the bottom of the screen and stops once it hits the bottom
        if (squareYLocation <= windowHeight) {
            squareYLocation++;

            //resets the x and y location to a new position
        } else {
            numberCreated = false;
            squareYLocation = -squareHeight;
        }
    }

    //sets the while loop to true to start the game
    public void start() {
        Sound.SONG.play();
        gameRunning = true;
    }

    public void init() throws InterruptedException {

        App game = new App();
        JFrame frame = new JFrame();
        frame.add(game);
        frame.setVisible(true);
        frame.setSize(windowWidth, windowHeight);
        frame.setResizable(false);
        frame.setLocation(600, 30);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("AKKYKSTN");

        game.start();

        //updates square position, repaints square, and slows down update and paint speed.
        while (gameRunning) {
            game.update();
            Thread.sleep(4);
            game.repaint();
            
        }
    }
}