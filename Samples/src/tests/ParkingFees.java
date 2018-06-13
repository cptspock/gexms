package tests;

/**
 * Entrance fee = 2
 * First hour = 3
 * Second hour or partial hour = 4/hr
 * 
 */
public class ParkingFees {
	
	public int getParkingFee(String entry, String exit) {
		int parkingFee = 0;
		
		String[] temp = entry.split(":");
		String entryHourText = temp[0];
		String entryMinText = temp[1];
		
		temp = exit.split(":");
		String exitHourText = temp[0];
		String exitMinText = temp[1];
		
		int entryHour = Integer.parseInt(entryHourText);
		int exitHour = Integer.parseInt(exitHourText);
		int entryMin = Integer.parseInt(entryMinText);
		int exitMin = Integer.parseInt(exitMinText);
		
		int diff = exitHour - entryHour;
		
		if (entryMin < exitMin) {
			diff = diff + 1;
		}
		
		parkingFee = 2 + 3 + 4*(diff - 1);	
		return parkingFee;
	}

	public static void main(String[] args) {
		System.out.println(new ParkingFees().getParkingFee("10:21", "11:42")); //9
		System.out.println(new ParkingFees().getParkingFee("10:21", "11:21")); //5
		System.out.println(new ParkingFees().getParkingFee("10:21", "13:42")); //17
		System.out.println(new ParkingFees().getParkingFee("10:21", "13:10")); //13
		System.out.println(new ParkingFees().getParkingFee("10:21", "13:21")); //13
	}

}
