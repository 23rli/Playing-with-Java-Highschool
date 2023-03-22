/**
 * The class used to track positions on the game board.
 * 
 * @author Richard Li
 * @version 1.0.0
 */
public class Position {
    int baseX;
    int baseY;
    int centX;
    int centY;
    int boardCol;
    int boardRow;

    public Position(int x, int y, int col, int row) {
        baseX = x;
        baseY = y;
        centX = x + 40;
        centY = y + 67;
        boardCol = col;
        boardRow = row;

    }

}