import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Game implements Runnable{
	
	 AnimationPanel animation;
	 JToggleButton start;
	 Lyrics lyric;

	 @Override
    public void run() {

    	JFrame frame = new JFrame("AKKYKSTN");
        JPanel content = new JPanel(new BorderLayout());

        start = new JToggleButton("START / PAUSE");
        content.add(start, BorderLayout.NORTH);

        animation = new AnimationPanel(600, 900);
        content.add(animation, BorderLayout.CENTER);

		if(false) {
            start.addActionListener(new ThreadAnimator());
        } else {
            start.addActionListener(new TimerAnimator());
        }


    	frame.setContentPane(content);
    	frame.setBackground(Color.BLACK);
        frame.pack();
        frame.setLocationRelativeTo(null);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }

    abstract class Animator implements ActionListener {
    	final int period = ( 1000 / 60 );

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(start.isSelected()) {
            	Sound.SONG.play();
                start();
            } else {
            	//need to resume
            	//maybe make a customized stop() in Sound class?
            	Sound.SONG.stop();
                stop();
            }
        }

        abstract void start();
        abstract void stop();

        void animate() {
        	int workingPos = animation.startPosition;

            if(workingPos < animation.getHeight()) {
                workingPos ++;
            }

            animation.startPosition = workingPos;

            animation.repaint();
        }
       
   }
   class ThreadAnimator extends Animator {
        volatile boolean isRunning;

        Runnable loop = new Runnable() {
            @Override
            public void run() {
                try {
                    while(isRunning) {
                        animate();
                        Thread.sleep(period);
                    }
                } catch(InterruptedException e) {
                    throw new AssertionError(e);
                }
            }
        };

        @Override
        void start() {
            isRunning = true;

            new Thread(loop).start();
        }

        @Override
        void stop() {
            isRunning = false;
        }
    }

    class TimerAnimator extends Animator {
        Timer timer = new Timer(period, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                animate();
            }
        });

        @Override
        void start() {
            timer.start();
        }

        @Override
        void stop() {
            timer.stop();
        }
    }

	static class AnimationPanel extends JPanel {

		volatile int startPosition;


    	AnimationPanel(int width, int height) {
    		setPreferredSize(new Dimension(width, height));
        	setBackground(Color.BLACK);

        	startPosition = getHeight();
    	}

    	@Override
        protected void paintComponent(Graphics g) {
        	super.paintComponent(g);
        	String lyric = new String("soul");
        	int width = getWidth();
            int height = getHeight();

			g.setColor(Color.WHITE);

			//find a way to customize the string so dako2 cya
			int currentPosition = startPosition;
			if(currentPosition < height) {
				g.drawString(lyric, 30, startPosition);
				//g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			}

			
		}
    }

}
