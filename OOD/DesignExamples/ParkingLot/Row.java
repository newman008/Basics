package ParkingLot;

public class Row {
	private int floor;
	private int rowId;
	private ParkingSpot[] spots;
	private int availableSpot;
	public static int SPOT_PER_ROW = 10;
	
	public Row(int f, int rowId) {
		this.floor = f;
		this.rowId = rowId;
		spots = new ParkingSpot[SPOT_PER_ROW];
		availableSpot = SPOT_PER_ROW;
	}
	
	public int availableSpot() {
		return availableSpot;
	}
	
	public boolean parkVehicle(Vehicle vehicle) {
		return false;
	}
	
	private boolean parkVehicle(int num, Vehicle vehicle) {
		return true;
	}
	
	private int findSpotForVehicle(Vehicle vehicle) {
		return 0;
	}
	
}
