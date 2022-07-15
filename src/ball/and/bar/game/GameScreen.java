package ball.and.bar.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.*;

public class GameScreen extends Frame implements Runnable {

    boolean isPause = false;
    int Score = -10;
    Thread t1;

    public GameScreen() {
        this.setLayout(null);
        this.setTitle("MY GAME");
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setLocation(0, 0);
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);
            }
        });
        this.addKeyListener(new KeyAdapter() {

            //boolean pause=false;
            @Override
            public void keyPressed(KeyEvent e) {

                switch (e.getKeyCode()) {
                    case 32:
                        if (!isPause) {
                            isPause = true;
                        } else {
                            isPause = false;
                            notifyt1();
                        }
                        /*System.out.println(Thread.currentThread().getName());
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}*/
                        break;
                    case 37:
                        if (x > 30) {
                            x -= 30;
                        }
                        break;
                    case 39:
                        if (x < 1700) {
                            x += 30;
                        }
                        break;

                }

            }
        });

        t1 = new Thread(this, "T1");

        t1.start();
    }

    static int x = 750;
    int xcircle = 835;
    int ycircle = 972;

    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        //super.paint(g);

        g.setColor(Color.GRAY);
        g.fillRoundRect(x, 1000, 200, 30, 30, 30);
        g.setColor(Color.CYAN);
        g.fillOval(xcircle, ycircle, 30, 30);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
        g.drawString("Score : " + Score, 1500, 100);
    }

    synchronized void notifyt1() {
        notifyAll();
    }

    /*public static void main(String[] args) {
		
		Test t =new Test();
		t.setLayout(null);
		t.setTitle("MY GAME");
		t.setSize(2000,1100);
		
		t.setLocation(0,0);
		t.setVisible(true);
		
		t.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		t.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				switch(e.getKeyCode())
				{
				case 37:
				if(x>30){
					x-=20;
				}
					break;
				case 39:
					if(x<1700){
					x+=20;
					}
					break;
					
				}
				
			}
		} );

	}*/
    int i = 10, flag = 0, flag2 = 0, flag3 = 0;

    @Override
    public void run() {
        //System.out.println("in run : "+Thread.currentThread().getName());
        try {
            while (true) {
                /*---------------For Moving ball-----------------*/
                if (isPause) {
                    synchronized (this) {

                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (xcircle > 1900) {
                    i = (int) ((Math.random() * 1000) % 30);
                    flag2 = 1;

                }
                if (xcircle < 20) {
                    i = (int) ((Math.random() * 1000) % 30);
                    flag2 = 0;
                }
                if (ycircle >= 972) {
                    /*i=(int) ((Math.random()*1000)%30);
				flag=0;*/
                    if (xcircle > x && xcircle < x + 200) {
                        /* ball hits bar !!! well done */
                        i = (int) ((Math.random() * 1000) % 30);
                        flag = 0;
                        Score += 10;
                    } else {
                        System.out.println("XCircle = " + xcircle + " and xbar = " + x);
                        System.out.println("Sorry ... You lose !!!");
                        new ScoreScreen(Score);
                        break;
                    }
                }
                if (ycircle < 60) {
                    i = (int) ((Math.random() * 1000) % 30);
                    flag = 1;
                }
                if (flag2 == 0) {
                    xcircle += i;
                } else {
                    xcircle -= i;
                }
                if (flag == 0) {
                    ycircle -= 30 - i;
                } else {
                    ycircle += 30 - i;
                }

                /*---------------For Moving bottom bar--------------
			if(x<30)
			{
				flag3=0;
			}
			if(x>1700){
				flag3=1;
			}
			if(flag3==0)
			{
				x+=10;	
			}
			else
			{
				x-=10;	
			}*/
                Thread.sleep(50);

                repaint();
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
