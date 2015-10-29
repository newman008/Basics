package ParkingLot;

public class Bus extends Vehicle{
    
    public Bus() {
        this.spotsNeeded = 5;
        this.size = VehicleSize.Large;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
