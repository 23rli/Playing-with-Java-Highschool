
/**
 * Plays and interacts with the user to produce Solitaire.
 * Contains game rules, mouse lsitener, cards, board positions,
 * sets up Java Swing, and interactions 
 * 
 * @author Richard Li
 * @version 1.0.0
 */
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class GUI extends JFrame implements ActionListener, MouseListener {

    // Deck of Cards(52)
    Card[] deck;

    // Board positions, includeing main ground, deck, and slots
    Position posDeck;
    Position[] posSlots;
    Position[][] posBoard;

    // Timer for Game, and Animations (UNIMPLEMENTED)
    Timer t;
    int secondUnit;

    // Used to track user interaction, what card was clicked
    int cardClicked;

    // components and objects:
    JButton restartButton, undoButton, pauseButton;
    JPanel topPanel, displayPanel;
    JTextField info;
    Display display;

    // size of window:
    int WIDTH;
    int HEIGHT;

    GUI() {
        super("Solitaire");

        // Create Cards
        int num = 0; // Variable to set the cards to proper suit and number
        this.deck = new Card[52];
        for (int suit = 0; suit < 4; suit++) {
            for (int number = 1; number < 14; number++) {
                deck[num] = new Card(suit, number);
                num++;
            }
        }

        // Create Position arrays
        posDeck = new Position(10, 20, 100, 100);
        posBoard = new Position[7][20];
        posSlots = new Position[4];

        cardClicked = 100;

        // SET POSITIONS
        int height = 33;
        int space = 111;
        for (int col = 0; col < posBoard.length; col++) {
            for (int pos = 0; pos < posBoard[0].length; pos++) {
                posBoard[col][pos] = new Position(144 + space * col, 0 + height * pos, col, pos);
            }
        }
        for (int slot = 0; slot < posSlots.length; slot++) {
            posSlots[slot] = new Position(1110, 20 + 140 * slot, 50 + slot, 50);
        }

        // Mouse Listener
        addMouseListener(this);

        // Start Up Game
        startUp();

        // Create Displau
        display = new Display(WIDTH, HEIGHT, deck);

        WIDTH = 1200;
        HEIGHT = 900;

        // allows you to place things where you want them (see this.add() below)
        this.setLayout(new BorderLayout());

        // make a button for possible future use, booleans for buttons:
        restartButton = new JButton("Restart");
        restartButton.addActionListener(this);
        restartButton.setActionCommand("restart");

        // (UNIMPLEMENTED)
        undoButton = new JButton("Undo");
        undoButton.addActionListener(this);
        undoButton.setActionCommand("undo");
        pauseButton = new JButton("Pause");
        pauseButton.addActionListener(this);
        pauseButton.setActionCommand("pause");

        // panel to buttons and textfields in:
        topPanel = new JPanel();
        topPanel.setBackground(Color.GRAY);
        topPanel.add(pauseButton);

        // UNIMPLEMENTED
        topPanel.add(restartButton);
        topPanel.add(undoButton);

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
     * Creates a Timer object and starts timer UNIMPLEMENTED
     */
    public void startTimer() {
        t = new Timer(10, this);
        t.setActionCommand("timerFired");
        t.start();
    }

    /**
     * Carries out actins based on each button
     * 
     * @param e ActionEvent records and starts event of that button press
     *          //UMIPLEMENTED BUTTONS
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getActionCommand().equals("restart")) // button has been pressed
        {
            shuffle();
            setCards();
            display.repaint();

        }
        // UNIMPLEMENTED, FUTURE WORK
        if (e.getActionCommand().equals("undo")) // button has been pressed
        {

        }
        if (e.getActionCommand().equals("pause")) // button has been pressed
        {

        }
        if (e.getActionCommand().equals("timerFired")) // timer has fired
        {
            // updateAll(); // does all motion and checking and logic (see below)
            // display.repaint(); // calls paintComponent to redraw everything
        }

    }

    /**
     * Creates a mouse pointer focus
     */
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }

    /**
     * Blank, but required for mouse listener
     */
    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    /**
     * Mouse clicked keeps track of where the player clicks and how to repsond to
     * that. Is used to determine decisions of graphical interface
     * 
     * @param e Mouse event tells us x and y of mouse as to track and interact with
     *          display
     */
    public void mouseClicked(MouseEvent e) {

        // Check all cards in deck to see which one was clicked
        for (int x = 0; x < deck.length; x++) {

            // Moving/interacting with singular cards
            if (deck[x].loc.baseX < e.getX() && deck[x].loc.baseY < e.getY() - 65 && deck[x].loc.baseX + 80 > e.getX()
                    && deck[x].loc.baseY + 133 > e.getY() - 65 && deck[x].covered == false) {

                // If a singular card is being shifted to another column
                if (cardClicked != 100 && x != cardClicked && deck[x].covered == false && deck[x].flip
                        && deck[cardClicked].covered == false && deck[x].loc.boardCol != deck[cardClicked].loc.boardCol
                        && blackRedRule(deck[x], deck[cardClicked])) {

                    moveCard(deck[cardClicked], deck[x]);
                    cardClicked = 100;
                    display.repaint();

                    break;

                    // If a stac of cards is being shifted to another column
                } else if (cardClicked != 100 && x != cardClicked && deck[x].flip && deck[x].covered == false
                        && deck[x].loc.boardCol != deck[cardClicked].loc.boardCol
                        && blackRedRule(deck[x], deck[cardClicked])) {

                    moveStack(deck[cardClicked], deck[x]);
                    cardClicked = 100;
                    display.repaint();

                    break;

                    // If no card is recorded, record a card to move next click
                } else {
                    cardClicked = x;

                    break;
                }

                // Interacting with Stacks, If stack is clicked
            } else if (deck[x].loc.baseX < e.getX() && deck[x].loc.baseY < e.getY() - 65
                    && deck[x].loc.baseX + 80 > e.getX() && deck[x].loc.baseY + 33 > e.getY() - 65 && deck[x].flip) {

                if (cardClicked == 100) {
                    cardClicked = x;
                }

                // If an empty slot is clicked while having a king recorded. Shifts king to
                // empty slot on board.
            } else if (cardClicked != 100 && deck[cardClicked].number.equals("K")) {
                int colNum = 0;
                if (checkEmptyForKing(e.getX(), e.getY())) {
                    for (int y = 0; y < 7; y++) {
                        if (posBoard[y][0].baseX < e.getX() && posBoard[y][0].baseY < e.getY() - 65
                                && posBoard[y][0].baseX + 80 > e.getX() && posBoard[y][0].baseY + 133 > e.getY() - 65) {
                            colNum = y;
                            break;
                        }
                    }
                    // Move a singular King to an empty slot
                    if (!deck[cardClicked].covered) {

                        moveKing(deck[cardClicked], posBoard[colNum][0]);
                        cardClicked = 100;
                        display.repaint();

                        break;

                        // Move a stack of kings to an empty slot
                    } else {

                        moveKingStack(deck[cardClicked], posBoard[colNum][0]);
                        cardClicked = 100;
                        display.repaint();

                        break;
                    }
                }
            }
        }
        // Code for Slots to win game, Future implementation
        /*
         * else { for (int slot = 0; slot < 4; slot++) { if (posSlots[slot].baseX <
         * e.getX() && posSlots[slot].baseY < e.getY() - 65 && posSlots[slot].baseX + 80
         * > e.getX() && posSlots[slot].baseY + 133 > e.getY() - 65) { for (int a = 0; a
         * < deck.length; a++) {
         * 
         * } } } }
         */
    }

    /**
     * This method is used to exemplify the solitaire game rule that a card can only
     * be stacked if it is of the opposite color and is one number lower
     * 
     * @param base The card that is going to get covered
     * @param top  The card that will cover the base
     * @return if or if not the top has the right suit and number to stack on top of
     *         the base
     */
    public boolean blackRedRule(Card base, Card top) {
        // checks suit as well as numerical value
        String[] numbers = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
        if ((base.suit.equals("C") || base.suit.equals("S")) && (top.suit.equals("H") || top.suit.equals("D"))) {
            for (int nums = 0; nums < numbers.length; nums++) {
                if (numbers[nums].equals(base.number)) {

                    if (top.number.equals(numbers[nums - 1]))
                        return true;
                }
            }
            // 2nd version for different suit color
        } else if ((base.suit.equals("D") || base.suit.equals("H")) && (top.suit.equals("C") || top.suit.equals("S"))) {
            for (int nums = 0; nums < numbers.length; nums++) {
                if (numbers[nums].equals(base.number)) {
                    if (top.number.equals(numbers[nums - 1]))
                        return true;
                }
            }
        }
        return false;
    }

    /**
     * This method looks to see if a king can occupy a slot. It makes sure the slot
     * is empty, and doesn't already have cards. Without this, the king would
     * overlap with unflipped cards.
     * 
     * @param a The x value of the mouse that clicked on an empty slot for the king
     *          to go to
     * @param b The y value of the mouse that clicked on an empty slot for the king
     *          to go to
     * @return It returns if or if not what themouse clicked was an empty slot and
     *         if or if not the king can be placed there
     */
    public boolean checkEmptyForKing(int a, int b) {
        for (int y = 0; y < 7; y++) {
            if (posBoard[y][0].baseX < a && posBoard[y][0].baseY < b - 65 && posBoard[y][0].baseX + 80 > a
                    && posBoard[y][0].baseY + 133 > b - 65) {
                for (int x = 0; x < deck.length; x++) {
                    if (deck[x].loc == posBoard[y][0]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /**
     * This method is used to change the positions of stacks of cards for the
     * display to show stacking
     * 
     * @param move the card that with stack on top of the base
     * @param base The card that will be covered by move
     */
    public void moveStack(Card move, Card base) {

        int moveOriCol = move.loc.boardCol;
        int moveOriRow = move.loc.boardRow;
        int changeColTo = base.loc.boardCol;
        int changeRowTo = base.loc.boardRow;
        base.covered = true;

        // shift cards
        for (int x = 0; x < deck.length; x++) {
            if (deck[x].loc.boardCol == moveOriCol && deck[x].loc.boardRow >= moveOriRow) {
                deck[x].loc = posBoard[changeColTo][changeRowTo + deck[x].loc.boardRow - moveOriRow + 1];

            }
        }

        // set exposed card to flip
        for (int x = 0; x < deck.length; x++) {
            if (deck[x].loc.boardCol == moveOriCol && deck[x].loc.boardRow >= moveOriRow - 1) {
                deck[x].covered = false;
                deck[x].flip = true;
                break;
            }
        }
    }

    /**
     * The method used to move a singlular king into an empty slot
     * 
     * @param move the card that is to be moved into the empty slot
     * @param base the position in which the first card of the stack will go.
     */
    public void moveKing(Card move, Position base) {

        int moveOriCol = move.loc.boardCol;
        int moveOriRow = move.loc.boardRow;
        int changeColTo = base.boardCol;
        int changeRowTo = base.boardRow;

        // shift king
        move.loc = posBoard[changeColTo][changeRowTo];

        // flip card previously underneath king
        for (int x = 0; x < deck.length; x++) {
            if (deck[x].loc.boardCol == moveOriCol && deck[x].loc.boardRow == moveOriRow - 1) {
                deck[x].covered = false;
                deck[x].flip = true;
                break;
            }
        }
    }

    /**
     * The method to move a king and the stack on top of it to an empty slot
     * 
     * @param move The card that is to be at the bottom of the empty slot, the king
     * @param base the position where the king should go to when moved
     */
    public void moveKingStack(Card move, Position base) {

        int moveOriCol = move.loc.boardCol;
        int moveOriRow = move.loc.boardRow;
        int changeColTo = base.boardCol;
        int changeRowTo = base.boardRow;

        // Shift King + stack on top of it
        for (int x = 0; x < deck.length; x++) {
            if (deck[x].loc.boardCol == moveOriCol && deck[x].loc.boardRow >= moveOriRow) {
                deck[x].loc = posBoard[changeColTo][changeRowTo + deck[x].loc.boardRow - moveOriRow];

            }
        }

        // flip the card previously underneath the king
        for (int x = 0; x < deck.length; x++) {
            if (deck[x].loc.boardCol == moveOriCol && deck[x].loc.boardRow == moveOriRow - 1) {
                deck[x].covered = false;
                deck[x].flip = true;
                break;
            }
        }
    }

    /**
     * The method used to change the positions of singular cards from one stack to
     * another
     * 
     * @param move The card that is going to stack on top of the base
     * @param base The card that will be covered by move
     */
    public void moveCard(Card move, Card base) {

        int moveOriCol = move.loc.boardCol;
        int moveOriRow = move.loc.boardRow;
        int changeColTo = base.loc.boardCol;
        int changeRowTo = base.loc.boardRow;
        base.covered = true;

        // Shift the card
        move.loc = posBoard[changeColTo][changeRowTo + 1];

        // Flip card previously underneath
        for (int x = 0; x < deck.length; x++) {
            if (deck[x].loc.boardCol == moveOriCol && deck[x].loc.boardRow == moveOriRow - 1) {
                deck[x].covered = false;
                deck[x].flip = true;
                break;
            }
        }
    }

    /**
     * UNIMPLEMENTED Method for the timer
     */
    public void updateAll() {

    }

    /**
     * Method used to start up the game by setting up the intial positions of the
     * cards
     */
    public void startUp() {
        shuffle();
        setCards();
    }

    /**
     * shuffles the original in order deck to provide a unique experience everytime
     * the game is reset.
     */
    public void shuffle() {

        for (int i = 0; i < 200; i++) {
            // Random for remaining positions.
            int r = (int) (Math.random() * (deck.length));
            int tempNum = 1 % deck.length;
            // swapping the elements
            Card temp = deck[r];
            deck[r] = deck[tempNum];
            deck[tempNum] = temp;

        }
        for (int x = 0; x < deck.length; x++) {
        }
    }

    /**
     * The method that sets up the initial game in its trade mark stair case of
     * cards Sets positions of shuffled cards.
     */
    public void setCards() {

        // Set up the main board's seven columns
        int count = 0;
        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < x + 1; y++) {
                if (y == x) {
                    deck[count].flip = true;
                    deck[count].covered = false;
                } else {
                    deck[count].flip = false;
                    deck[count].covered = true;
                }
                deck[count].loc = posBoard[x][y];
                count++;
            }
        }

        // Sets up the remaning cards in the deck on the side UMIMPLEMENTED
        while (count < deck.length) {
            deck[count].loc = posDeck;
            deck[count].covered = true;
            deck[count].flip = false;
            count++;
        }
    }

}