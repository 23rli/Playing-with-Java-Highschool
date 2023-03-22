import java.awt.*;
import javax.swing.*;

/**
 * Rabbit
 * 
 * @author Beckwith
 * @version 0.1
 */

public class Rabbit {
    /*
     * TO-DO!!!!! 1. create 4 instance variables below for xLoc, yLoc, color (of
     * type Color), squareSize, and numMoves.
     * 
     * 2. In the body of the constructor below, set those instance variables to the
     * args given - everything except numMoves is an argument - set nummoves to zero
     */
    int xLoc, yLoc;
    int squareSize;
    int numMoves;

    /**
     * Constructor for Graphics display
     */
    public Rabbit(int xLoc, int yLoc, int squareSize) {
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.squareSize = squareSize;
        this.numMoves = 0;

    }

    /**
     * Moves the Rabbit in any of 8 directions
     * 
     * @param moveCode 0-7 code, starts with 0 = Right and goes counter-clockwise
     */
    public void move(int moveCode) {
        /*
         * TO-DO: 1. complete the switch statement to move in 1 of 8 directions given a
         * moveCode value between 0 and 7 that is received as an argument from Window
         * 
         * To move, increment or decrement the xLoc and/or yLoc
         * 
         * 2. You'll also need to INCREMENT numMoves after the entire switch statement
         */

        // I've started it for you:
        switch (moveCode) {
            case 0: // moves right
                xLoc++;
                break;

            case 1: // moves diagonally up and right
                xLoc++;
                yLoc--;
                break;
            // YOU do the rest below!

            case 2: // moves up
                yLoc--;
                break;

            case 3: // moves diagonally up and left
                xLoc--;
                yLoc--;
                break;

            case 4: // moves left
                xLoc--;
                break;

            case 5: // moves diagonally down and left
                xLoc--;
                yLoc++;
                break;

            case 6: // moves down
                yLoc++;
                break;

            case 7: // moves diagonally down and right
                xLoc++;
                yLoc++;
                break;
        }
        numMoves++;
    }

    public void draw(Graphics g, Display d, boolean rab, boolean car, boolean farm) {

        // location of this Rabbit on grid:
        int x = (int) (squareSize * xLoc);
        int y = (int) (squareSize * yLoc);

        // draw the rabbit square:
        if (rab)
            g.drawImage(d.bunnyImg, x, y, squareSize, squareSize, d);
        if (car)
            g.drawImage(d.goldenCarrotImg, x, y, squareSize, squareSize, d);
        if (farm)
            g.drawImage(d.farmerImg, x, y, squareSize, squareSize, d);
    }

    public void checkForRecenter(int numSquaresAcross) {
        // if off an edge, recenter:
        if (xLoc < 0 // left
                || yLoc < 0 // top
                || xLoc >= numSquaresAcross // right
                || yLoc >= numSquaresAcross) // bottom
        {
            xLoc = numSquaresAcross / 2; // center coordinates
            yLoc = numSquaresAcross / 2;
        }
    }

}
