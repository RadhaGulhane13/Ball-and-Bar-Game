package ball.and.bar.game;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.text.StyledEditorKit.FontFamilyAction;

public class ScoreScreen extends Frame {

    int Score;

    @Override
    public void paint(Graphics g) {
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 100));
        ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 8 * 0.1f));

        g.setColor(Color.orange);
        g.drawString("SCORE : " + Score, 550, 500);

        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));

        g.setColor(Color.GREEN);
        g.drawString("Sorry....you loose !!! :) ", 700, 600);

    }

    public ScoreScreen(int Score) {
        this.Score = Score;
        this.setLayout(null);
        this.setTitle("MY GAME");
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setLocation(0, 0);
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

        });

    }

}
