/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ball.and.bar.game;

import java.awt.AlphaComposite;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

import javax.swing.JButton;

/**
 *
 * @author Radha Gulhane
 */
public class BallAndBarGame extends Frame {

    static Button btn;

    BallAndBarGame() {
        this.setLayout(null);
        this.setTitle("MY GAME");
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        //this.setSize(2000,1100);
        this.setLocation(0, 0);
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                System.exit(0);
            }

        });
    }

    @Override
    public void paint(Graphics g) {
        /*g.setColor(Color.GRAY);
		g.fillRoundRect(50, 1000, 200, 30, 30, 30);
		g.setColor(Color.CYAN);
		g.fillOval(300, 400, 30, 30);*/
        // TODO Auto-generated method stub
        //super.paint(g);
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 200));

        g.setColor(Color.cyan);
        String GameName = "BALLAND BAR";
        int x_pos = 150;
        int y_pos = 300;
        int alpha = 8;
        for (int i = 0; i < GameName.length(); i++) {

            ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha * 0.1f));
            g.drawString(Character.toString(GameName.charAt(i)), x_pos, y_pos);
            x_pos += 150;
            // alpha -= 1;
        }

        g.setColor(Color.orange);
        GameName = "GAME";
        x_pos = 700;
        y_pos = 550;
        for (int i = 0; i < GameName.length(); i++) {
            ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha * 0.1f));
            g.drawString(Character.toString(GameName.charAt(i)), x_pos, y_pos);
            x_pos += 150;
            // alpha -= 1;
        }
        /*
        ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 7 * 0.1f));
        g.drawString("G", 650, 300);

        ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 6 * 0.1f));
        g.drawString("A", 800, 300);

        ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 5 * 0.1f));
        g.drawString("M", 950, 300);

        ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 4 * 0.1f));
        g.drawString("E", 1150, 300);

        g.setColor(Color.cyan);

        ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 4 * 0.1f));
        g.drawString("N", 650, 500);

        ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 5 * 0.1f));
        g.drawString("A", 800, 500);

        ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 6 * 0.1f));
        g.drawString("M", 950, 500);

        ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 7 * 0.1f));
        g.drawString("E", 1150, 500);
         */
    }

    public static void main(String[] args) {

        BallAndBarGame f = new BallAndBarGame();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        btn = new Button("LET'S PLAY :)");
        btn.setBounds(800, 700, 300, 100);
        f.add(btn);

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new GameScreen();

            }
        });

    }

}
