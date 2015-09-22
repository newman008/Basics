package ParkingLot;

public class ParkingSpot {
	private Vehicle vehicle;
	private VehicleSize spotSize;
	private Row row;
	private int spotNumber;
	private Level level;
	
	public ParkingSpot(Level lvl, Row r, int n, VehicleSize s) {
		this.level = lvl;
		this.row = r;
		this.spotNumber = n;
		this.spotSize = s;
	}
	
	public boolean isAvailable() {
		return vehicle == null;
	}
	
	public boolean canFitVehicle(Vehicle vehicle) {
		return true;
	}
	
	public boolean park(Vehicle vehicle) {
		return false;
	}
	
	public Row getRow() {
		return this.row;
	}
	
	public int getSpotNumber() {
		return this.spotNumber;
	}
	
	public void removeVehicle() {
		
	}
}
