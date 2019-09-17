package junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import assignment2.Car;

public class cartest {
	Car c ;
	@Before
	public void setUp() throws Exception {
		c = new Car ("Toyota","Yaris","06-C-41429",2007,150000);
	}

	@Test
	public void test() {
		assertTrue("It can't be null", (c.getmake() !=null));
        assertTrue("It can't be null", (c.getmodel() !=null));
        assertTrue("It can't be null", (c.getreg() !=null));
        assertTrue("It can't be negative number or 0", (c.getyear() !=0));
        assertTrue("It can't be negative number or 0", (c.getmile() !=0));
	}

}
