package teste;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import utils.CryptUtil;

public class TestCriptare extends TestCase{
	
	public TestCriptare(String nume){
		super(nume);
	}

	@Test
	public void testCriptareParolaNula() {
	assertNull(CryptUtil.cryptPassword(null));
	}
	
	@Test
	public void testCriptareParola() {
	String rez= CryptUtil.cryptPassword("parola");
	
	assertEquals(rez, CryptUtil.cryptPassword("parola"));
	}
	
	//2 teste
}
