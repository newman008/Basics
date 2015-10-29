package OthelloGame;

public class Board {
    private int blackCount = 0;
    private int whiteCount = 0;
    private Piece[][] board;
    
    public Board(int rows, int column) {
        board = new Piece[rows][column];
    }
    
    public void initialize() {}
    
    public boolean placeColor(int row, int col, Color color) {
        //...
        return true;
    }
    
    private int flipSection(int row, int col, Color color, Direction d) {
        return 1;
    }
    
    public int getScore(Color c) {
        if(c == Color.black) return blackCount;
        else return whiteCount;
    }
    
    public void updateScore(Color newColor, int newPiece) {
        
    }
}
