package slots.parking.txstate.edu;

public class SlotMain {
	
	public static final String SHOW_CAR_SLOTS_AVAILABLE = "SHOW_CAR_SLOTS_AVAILABLE";
	public static final String SHOW_BIKE_SLOTS_AVAILABLE = "SHOW_BIKE_SLOTS_AVAILABLE";
	public static final String SHOW_BUS_SLOTS_AVAILABLE = "SHOW_BUS_SLOTS_AVAILABLE";
	public static final String SHOW_ALL_SLOTS_AVAILABLE = "SHOW_ALL_SLOTS_AVAILABLE";

	public static void main(String[] args) {
		
		Slots.main(null);
		
		//Slots.main(SHOW_ALL_SLOTS_AVAILABLE);
		
		//Slots.main(SHOW_BIKE_SLOTS_AVAILABLE);
		
		//Slots.main(SHOW_BUS_SLOTS_AVAILABLE);
		
		//Slots.main(SHOW_CAR_SLOTS_AVAILABLE);
		
		//String vehicle_number = "CAR 0030";
		//Slots.selectSlot(VehicleType.CAR, vehicle_number);
		//Slots.checkOut(vehicle_number);
		
		//SlotMain.selectSlot(VehicleType.MOTORCYCLE, vehicle_number);
		
		//SlotMain.selectSlot(VehicleType.BUS, vehicle_number);

	}
	
	public static void selectSlot(VehicleType vt, String vehicle_number) {
		Slots.selectSlot(vt, vehicle_number);
	}

	enum VehicleType{
		CAR,
		MOTORCYCLE,
		BUS
	}

}
