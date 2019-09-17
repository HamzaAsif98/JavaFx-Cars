package junit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import assignment2.Car;
import assignment2.Carlist;

public class carlisttest {
	ArrayList c =new ArrayList() ;
	Car c1,c2,c3;
	@Before
	public void setUp() throws Exception {
	c1=new Car("Honda","Accord","15-P-2654",2014,15000);
	c2=new Car("Toyota","Yaris","181-C-2489",2017,22000);
	c3=new Car("Land Rover","Evoque","162-D-3648",2016,33000);
	c.add(c1);
	c.add(c2);
	c.add(c3);
	}

	@Test
	public void test() {
		int old = c.size();
		int g = c.size()+1;
		assertTrue(old<g);
	}



}
