
/**
 * The class used to create each unique card in the deck of 52 excluding the jokers
 * 
 * @author Richard Li
 * @version 1.0.0
 */
import java.awt.*;
import javax.swing.*;

import java.awt.image.BufferedImage;
import java.util.Arrays;

import javax.imageio.*;

public class Card {
    String suit;
    String number;
    boolean flip;
    boolean covered;
    Position loc;
    BufferedImage[] backs;
    BufferedImage front;

    /**
     * Constructor: Initializes the suit and number of the card, as well as the
     * image it will have
     * 
     * @param s   the suit of the card
     * @param num the number of the card
     */
    public Card(int s, int num) {
        String[] suits = { "C", "D", "H", "S" };
        suit = suits[s];

        if (num > 1 && num < 11)
            number = "" + num;
        else if (num == 1)
            number = "A";
        else if (num == 11)
            number = "J";
        else if (num == 12)
            number = "Q";
        else
            number = "K";
        flip = true;

        backs = new BufferedImage[1];
        try {
            front = ImageIO.read(this.getClass().getResourceAsStream("images/" + number + suit + ".png"));
            backs[0] = ImageIO.read(this.getClass().getResourceAsStream("images/gray_back.png"));
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Image " + number + suit + "not found");
        }

    }
}