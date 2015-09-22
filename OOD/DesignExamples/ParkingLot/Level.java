package ParkingLot;

public class Level {
	private int floor;
	private Row[] rows;
	private int availableSpot;
	private final int Row_PER_LEVEL = 5;
	
	public Level(int flr) {
		this.floor = flr;
		this.rows = new Row[Row_PER_LEVEL];
		availableSpot = Row.SPOT_PER_ROW * Row_PER_LEVEL;
	}
	
}
