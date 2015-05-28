package teste;

import static org.junit.Assert.*;
import junit.framework.TestSuite;

import org.junit.Test;

public class Suita {

	@Test
	public static TestSuite suite(){
		TestSuite ts= new TestSuite();
		ts.addTest(new TestCriptare("testCriptareParolaNula"));
		ts.addTest(new TestDAO("testParolaNulla"));
		ts.addTest(new TestDAO("testGetCaractNumePCNull"));
		ts.addTest(new TestDAO("testAddCalcNull"));
		ts.addTest(new TestStatistica("testMedieVectorNull"));
		ts.addTest(new TestStatistica("testMedianaVectorNull"));
		ts.addTest(new TestStatistica("testMaximVectorNull"));
		return ts;
		
	}

}
