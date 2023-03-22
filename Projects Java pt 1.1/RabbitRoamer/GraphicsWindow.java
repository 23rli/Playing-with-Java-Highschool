import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Provides a window for buttons, entry boxes and displaying of grahpics 1. Sets
 * up all imporant control variable values, 2. makes a Window for buttons and
 * graphics and timer control 3. and makes a Display to show graphics 4. starts
 * the timer to start animation
 * 
 * @author Beckwith & (your name here)
 * @version 1.2.0
 */
public class GraphicsWindow extends JFrame implements ActionListener {
   int TIMER_DELAY; // milliseconds for updating graphics/motion
   Timer t;

   // components and objects:
   JButton accel, deccel, pause;
   JPanel topPanel, displayPanel;
   JTextField info;
   Display display;
   Rabbit bunny, carrot, farmer;

   // size of window:
   int WIDTH;
   int HEIGHT;

   int numSquaresAcross;
   int middleX, middleY;
   int squareSize;

   // For the Pause button
   boolean running;

   /**
    * Constructor for Window
    */
   public GraphicsWindow() {
      // calls constructor of the "super class"- JFrame - arg is titlebar name
      super("Bunny Simulation");

      // the JFrame/Graphics Window size:
      WIDTH = 950;
      HEIGHT = 700;

      /******** NUMBERS YOU MIGHT CHANGE: **********/

      TIMER_DELAY = 501; // SPEED of graphics, lower number = faster
      // (# of milliseconds between updates to graphics)

      numSquaresAcross = 36; // will establish size of each square
      // (you could ask the user what size they want)

      /*********************************************/

      middleX = numSquaresAcross / 2; // starting point for bunny - middle
      middleY = numSquaresAcross / 2;

      // size of 1 Bunny or 1 blank square - change 600 for larger or smaller grid
      squareSize = 600 / numSquaresAcross;

      // make blue bunny at middle:
      bunny = new Rabbit(middleX, middleY, squareSize);
      carrot = new Rabbit(middleX + 5, middleY + 5, squareSize);
      farmer = new Rabbit(numSquaresAcross - 10, numSquaresAcross - 10, squareSize);

      // make display for showing all drawings and animation in:
      display = new Display(bunny, carrot, farmer, WIDTH, HEIGHT, numSquaresAcross);

      // save bunny from Display object
      this.bunny = this.display.bunny;
      this.carrot = this.display.carrot;
      this.farmer = this.display.farmer;

      // allows you to place things where you want them (see this.add() below)
      this.setLayout(new BorderLayout());

      // make a button for possible future use, booleans for buttons:
      accel = new JButton("Speed Up");
      accel.addActionListener(this);
      accel.setActionCommand("fast");
      deccel = new JButton("Slow Down");
      deccel.addActionListener(this);
      deccel.setActionCommand("slow");
      pause = new JButton("Pause");
      pause.addActionListener(this);
      pause.setActionCommand("pause");
      running = false;

      // panel to buttons and textfields in:
      topPanel = new JPanel();
      topPanel.setBackground(Color.BLACK);
      topPanel.add(accel);
      topPanel.add(deccel);
      topPanel.add(pause);

      // add the display to this JFrame:
      this.add(topPanel, BorderLayout.NORTH);
      this.add(display, BorderLayout.CENTER);

      // final setup
      this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.pack();
      this.setVisible(true);
   }

   /**
    * Creates a Timer object and starts timer
    */
   public void startTimer() {
      t = new Timer(TIMER_DELAY, this);
      t.setActionCommand("timerFired");
      t.start();
      running = true;
   }

   /**
    * Called automatically when a button is pressed
    * 
    * @param e contains information about button that was pressed/sent
    *          automatically
    */
   public void actionPerformed(ActionEvent e) {

      if (e.getActionCommand().equals("fast")) // button has been pressed
      {
         if (TIMER_DELAY > 1)
            TIMER_DELAY -= 50;
         t.setDelay(TIMER_DELAY);
      }
      if (e.getActionCommand().equals("slow")) // button has been pressed
      {
         TIMER_DELAY += 50;
         t.setDelay(TIMER_DELAY);

      }
      if (e.getActionCommand().equals("pause")) // button has been pressed
      {
         if (running)
            t.stop();
         else
            t.start();
         running = !running;
      }
      if (e.getActionCommand().equals("timerFired")) // timer has fired
      {
         updateAll(); // does all motion and checking and logic (see below)
         display.repaint(); // calls paintComponent to redraw everything
      }
   }

   /**
    * Called by the timer. You'll do all altering of bunnies here - this is
    * followed by a repaint of everything
    */
   public void updateAll() {
      if (!display.field[bunny.xLoc][bunny.yLoc]) {
         display.field[bunny.xLoc][bunny.yLoc] = true;

      }
      if (display.field[farmer.xLoc][farmer.yLoc]) {
         display.field[farmer.xLoc][farmer.yLoc] = false;
      }

      int moveCode = (int) (Math.random() * 8); // choose direction to move
      bunny.move(moveCode); // update location
      bunny.checkForRecenter(numSquaresAcross); // if off edge, recenter

      int moveCode2 = (int) (Math.random() * 8);
      carrot.move(moveCode2);
      carrot.checkForRecenter(numSquaresAcross);

      int moveCode3 = (int) (Math.random() * 8);
      farmer.move(moveCode3);
      farmer.checkForRecenter(numSquaresAcross);

      // DO ALL OTHER LOGIC HERE: MAYBE CHECKING OTHER BUNNIES OR FOR COLLISION, ETC.
      // Recenter bunny if bunny and farmer on the same square
      if (farmer.xLoc == bunny.xLoc && farmer.yLoc == bunny.yLoc) {
         bunny.xLoc = middleX;
         bunny.yLoc = middleY;
      }

      // Recenter carrot if farmer and carrot on the same square
      if (farmer.xLoc == carrot.xLoc && farmer.yLoc == carrot.yLoc) {
         carrot.xLoc = middleX;
         carrot.yLoc = middleY;
      }

      // Recenter carrot if bunny and carrot on the same square
      if (bunny.xLoc == carrot.xLoc && bunny.yLoc == carrot.yLoc) {
         carrot.xLoc = middleX;
         carrot.yLoc = middleY;
      }
   }
}
