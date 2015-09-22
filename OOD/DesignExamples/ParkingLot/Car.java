package ParkingLot;

public class Car extends Vehicle{
	
	public Car() {
		this.spotsNeeded = 1;
		this.size = VehicleSize.Compact;
	}

	@Override
	public boolean canFitInSpot(ParkingSpot spot) {
		// TODO Auto-generated method stub
		return false;
	}

}
