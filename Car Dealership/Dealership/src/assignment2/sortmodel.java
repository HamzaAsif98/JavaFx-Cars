package assignment2;
import java.util.Comparator;

import CarModel.vehicle;

public class sortmodel implements Comparator<Car> {

	@Override
	public int compare(Car v1, Car v2) {
		return v1.getmodel().compareTo(v2.getmodel());
	}

}
