package CardGame;

public class BlackJackCard extends Card {

    public BlackJackCard(int r, Suit s) {
        super(r, s);
        // TODO Auto-generated constructor stub
    }
    
    public int value() {
        int r = super.value();
        if(r == 1) return 11;
        if(r < 10) return r;
        return 10;
    }
    
    public int minValue() {
        if(isAce()) return 1;
        else return getRank();
    }
    
    public int maxValue() {
        if(isAce()) return 11;
        else return getRank();
    }
    
    public boolean isAce() {
        return getRank() == 1;
    }
    
    public boolean isFaceCard() {
        return getRank() <= 13 && getRank() >= 11;
    }
}
