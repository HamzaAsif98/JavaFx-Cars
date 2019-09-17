package Sortor;

import java.util.Comparator;

import CarModel.vehicle;

public class naturalorder implements Comparator <vehicle> {

	@Override
	public int compare(vehicle o1, vehicle o2) {
		
		return o1.getmake().compareTo(o2.getmake());
	}

}
