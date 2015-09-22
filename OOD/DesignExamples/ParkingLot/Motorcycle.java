package ParkingLot;

public class Motorcycle extends Vehicle{
	
	public Motorcycle() {
		this.spotsNeeded = 1;
		this.size = VehicleSize.Motorcycle;
	}

	@Override
	public boolean canFitInSpot(ParkingSpot spot) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
