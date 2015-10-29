package CardGame;

enum Suit {
    Club (0), Diamand (1), Heart(2), Spade(3);
    private int value;
    private Suit(int v) {
        value = v;
    }
    public int getValue() {
        return value;
    }
    public static Suit getSuitFromValue(int i) { return Club;}
}

public class Card implements Comparable{
    private boolean available;
    private int rank;
    private Suit suit;
    
    public Card(int r, Suit s) {
        rank = r;
        suit = s;
    }
    
    public int value() {
        return rank;
    }
    
    public int getRank() {
        return rank;
    }
    
    public Suit getSuit() {
        return suit;
    }
    
    public boolean isAvailable() {
        return available;
    }
    
    public void makeUnavailable() {
        available = false;
    }
    
    public void makeAvailable() {
        available = true;
    }
    
    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        Card other = (Card)o;
        int thisRank = this.getRank();
        int otherRank = other.getRank();
        
        return thisRank - otherRank;
    }
    
}
