package OthelloGame;

enum Direction {
	left, right, up, down
}

enum Color {
	black, white
}

public class Game {
	private Player[] players;
	private static Game instance = null;
	private Board board;
	private final int ROWS = 10;
	private final int COLS = 10;
	
	private Game() {
		board = new Board(ROWS, COLS);
		players = new Player[2];
		players[0] = new Player(Color.black);
		players[1] = new Player(Color.white);
	}
	
	public static Game getInstance() {
		if(instance == null) {
			synchronized(Game.class) {
				instance = new Game();
			}
		}
		return instance;
	}
	
	public Board getBoard() {
		return board;
	}
}
