package OthelloGame;

public class Piece {
    private Color color;
    public Piece(Color c) {
        color = c;
    }
    public void flip() {
        if(color == Color.black) color = Color.white;
        else color = Color.black;
    }
    public Color getColor() {
        return color;
    }
}
