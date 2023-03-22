
/**
 * The class that initializes java swing and paints the display that the player interacts with
 * 
 * @author Richard Li
 * @version 1.0.0
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

import javax.imageio.*;

public class Display extends JPanel {

    Font myFont;
    Card[] cards;
    Shuffler shuffler;
    int darken;

    /**
     * CONSTRUCTOR intializes cards, font, and window size
     */
    public Display(int w, int h, Card[] fullDeck) {
        // positions arrays
        cards = fullDeck;
        for (int x = 0; x < 52; x++) {
        }

        // Images for graphics
        darken = 0;
        this.myFont = new Font("Verdana", Font.BOLD, 16); // nice font for display purposes
        setPreferredSize(new Dimension(w, h)); // set size of display
    }

    /**
     * Draw text, background, and cards - anything else; called in GUI by mouse
     * listener
     * 
     * @param g the graphics object, automatically sent when repaint() is called
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // clear the old drawings

        background(g);
        cards(g);
        // drawString - can be used to show any updates or information:
        g.setFont(myFont);
        g.drawString("", 650, 15);

    }

    /**
     * This is a branch method of repaint, it displays the 52 cards
     * 
     * @param g the graphics object, automatically sent when repaint() is called
     */
    public void cards(Graphics g) {
        for (int col = 0; col < 7; col++) {
            boolean ended = false;
            for (int row = 0; row < 20; row++) {
                for (int x = 0; x < 52; x++) {
                    ended = true;
                    if (cards[x].loc.boardCol == col && cards[x].loc.boardRow == row) {
                        ended = false;
                        if (cards[x].flip) {
                            g.drawImage(cards[x].front, cards[x].loc.baseX, cards[x].loc.baseY, 80, 133, this);
                        } else {
                            g.drawImage(cards[x].backs[0], cards[x].loc.baseX, cards[x].loc.baseY, 80, 133, this);
                        }
                        break;
                    }
                }
                if (ended)
                    break;
            }
        }

    }

    /**
     * This is a branch method of repaint, it displays the background
     * 
     * @param g the graphics object, automatically sent when repaint() is called
     */
    public void background(Graphics g) {

        // creates background
        g.setColor(new Color(0, 80 - darken, 0));
        g.fillRect(0, 0, 1200, 800);

        // created sidebars
        g.setColor(new Color(0, 110 - darken, 0));
        g.fillRect(1100, 0, 100, 600);
        g.fillRect(0, 0, 100, 600);

        // creates card slots
        g.setColor(new Color(0, 70 - darken, 0));
        for (int x = 0; x < 4; x++) {
            g.fillRect(1110, 20 + 140 * x, 80, 133);
        }

    }

}
