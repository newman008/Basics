package CardGame;

public class CardDeck {
    private Card[] deck;
    private int numCards;
    
    public CardDeck() {
        deck = new Card[52];
        fill();
    }
    
    public int getSize() {
        return numCards;
    }
    
    public Card deal() {
        if(numCards == 0) return null;
        numCards--;
        return deck[numCards];
    }
    
    public void shuffle() {
        for(int next = 0; next < numCards-1; next++) {
            int r = myRandom(next, numCards-1);
            Card tmp = deck[next];
            deck[next] = deck[r];
            deck[r] = tmp;
        }
    }
    
    private static int myRandom(int low, int high) {
        return (int)((high - low + 1) * Math.random() + low);
    }
    
    private void fill() {
        int index = 0;
        for(int r = 1; r <= 13; r++) {
            for(int s = 1; s <= 4; s++) {
                deck[index] = new Card(r, Suit.getSuitFromValue(s));
                index++;
            }
        }
        numCards = 52;
    }
}
