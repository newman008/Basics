package Restaurant;

public class Party {
    private Guest[] party;
    private Table[] tables;
    
    public Party(Guest[] guests) {
        party = guests;
    }
    
    public Party(Guest[] guests, Table[] tables) {
        party = guests;
        this.tables = tables;
    }
}
