import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;


import javax.imageio.*;

/**
 * 
 * @author Beckwith & (Richard li)
 * @version 1.2.0
 */
public class Display extends JPanel {
    Rabbit bunny, carrot, farmer;
    int numSquaresAcross;
    Font myFont;
    boolean[][] field;
    Color brown;
    BufferedImage carrotsImg;
    BufferedImage bunnyImg;
    BufferedImage farmerImg;
    BufferedImage goldenCarrotImg;
    BufferedImage holeImg;

    /**
     * CONSTRUCTOR saves bunny and number of squares and sets font and size of
     * display
     */
    public Display(Rabbit bunny, Rabbit carrot, Rabbit farmer, int w, int h, int numSquaresAcross) {
        this.bunny = bunny;
        this.carrot = carrot;
        this.farmer = farmer;
        this.numSquaresAcross = numSquaresAcross;
        this.field = new boolean[numSquaresAcross][numSquaresAcross]; // Boolean array that tracks if Bunny ate a carrot
                                                                      // on the field
        this.brown = new Color(133, 107, 76); // Background color

        // Images for graphics
        this.carrotsImg = null;
        this.bunnyImg = null;
        this.farmerImg = null;
        this.goldenCarrotImg = null;
        this.holeImg = null;
        try {
            carrotsImg = ImageIO.read(this.getClass().getResourceAsStream("images/Carrot.png")); // the name of the
                                                                                                 // image,
                                                                                                 // stored in an images
                                                                                                 // folder
            bunnyImg = ImageIO.read(this.getClass().getResourceAsStream("images/bunny.png"));
            farmerImg = ImageIO.read(this.getClass().getResourceAsStream("images/Farmer.png"));
            goldenCarrotImg = ImageIO.read(this.getClass().getResourceAsStream("images/goldenCarrot.png"));
            holeImg = ImageIO.read(this.getClass().getResourceAsStream("images/Hole.png"));

        } catch (Exception e) {
            System.out.println("Image Error");
        }
        this.myFont = new Font("Verdana", Font.BOLD, 16); // nice font for display purposes
        setPreferredSize(new Dimension(w, h)); // set size of display
    }

    /**
     * Draw text, grid, and rabbit - anything else; called in Window class by a
     * timer calling repaint()
     * 
     * @param g the graphics object, automatically sent when repaint() is called
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // clear the old drawings

        g.setColor(brown); // creates background color
        g.fillRect(0, 0, 950, 700);

        // draw the grid:
        for (int col = 0; col < numSquaresAcross; col++) {
            for (int row = 0; row < numSquaresAcross; row++) {
                // set location of where to draw current rectangle
                int x = (int) (bunny.squareSize * col);
                int y = (int) (bunny.squareSize * row);

                // hole or carrot drawn
                if (field[col][row] == false)
                    g.drawImage(carrotsImg, x, y, bunny.squareSize, bunny.squareSize, this);
                else
                    g.drawImage(holeImg, x, y, bunny.squareSize, bunny.squareSize, this);
            }
        }

        bunny.draw(g, this, true, false, false); // draw the bunny
        carrot.draw(g, this, false, true, false); // draw golden carrot
        farmer.draw(g, this, false, false, true); // draw the farmer

        // drawString - can be used to show any updates or information:
        g.setFont(myFont);
        g.drawString("" + bunny.numMoves, 650, 15);
    }
}
