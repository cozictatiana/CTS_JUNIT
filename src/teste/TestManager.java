package teste;

import static org.junit.Assert.*;

import org.junit.Test;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;

import clase.Manager;
import exceptii.NullIdentificatorException;
import exceptii.WrongAddressException;


public class TestManager {

	@Test
	public void testTimpAdresaGresita() throws Exception{
		try{
			Manager m= Manager.getInstance();
			String t=null;
			Address address= (Address) GenericAddress.parse("aaa13287");
			 t=(String)	m.getSysTime( address);
			 assertFalse("Metoda nu arunca exceptie pe adresa gresita", true);
		}
			catch(WrongAddressException ex){
				assertTrue(true);
			}
	}
	
	@Test
	public void testTimpAdresaNula() throws Exception {
		try{
			Manager m= Manager.getInstance();
			String t=null;
			 t=(String)	m.getSysTime( null);
			 assertFalse("Metoda nu arunca exceptie pe adresa nula", true);
		}
			catch(WrongAddressException ex){
				assertTrue(true);
			}
	}
	
	@Test
	public void testTimpAdresaCorecta() throws Exception {
		
			Manager m= Manager.getInstance();
			String t=null;
			Address address= (Address) GenericAddress.parse("127.0.0.1"+"/161");
			 t=(String)	m.getSysTime(address);
			 assertNotNull(t);
		}
			
	
	@Test
	public void testNumeSistem() throws Exception {
		
			Manager m= Manager.getInstance();
			String t=null;
			Address address= (Address) GenericAddress.parse("127.0.0.1"+"/161");
			 t=(String)	m.getSysName(address);
			 assertEquals("tatiana",t);
		}
	
	@Test
	public void testPDUNull() throws NullIdentificatorException{
		try{
			Manager m= Manager.getInstance();
			PDU pdu= m.setPDU(null);
			assertFalse("Metoda nu arunca exceptie pe identificator null", true);
	}
		catch(NullIdentificatorException ex){
			assertTrue(true);
		}
		}
	
	
	@Test
	public void testTargetNull() throws Exception {
		try{
			Manager m= Manager.getInstance();
			Address adr= GenericAddress.parse("null");
			CommunityTarget ct= m.setTarget( adr);
			 assertFalse("Metoda nu arunca exceptie pe adresa nula", true);
		}
			catch(WrongAddressException ex){
				assertTrue(true);
			}
	}			

	@Test
	public void testDescriereAdrrGresita() throws Exception{
		try{
			Manager m= Manager.getInstance();
			String t=null;
			Address address= (Address) GenericAddress.parse("aaa13287");
			 t=(String)	m.getSysDescr(address);
			 assertFalse("Metoda nu arunca exceptie pe adresa gresita", true);
		}
			catch(WrongAddressException ex){
				assertTrue(true);
			}
	}
	
	@Test
	public void testramUsedAdrrGresita() throws Exception{
		try{
			Manager m= Manager.getInstance();
			double rez=0;
			Address address= (Address) GenericAddress.parse("aaa13287");
			 rez=	m.getRamUsed(address);
			 assertFalse("Metoda nu arunca exceptie pe adresa gresita", true);
		}
			catch(WrongAddressException ex){
				assertTrue(true);
			}
	}
	
	@Test
	public void testRamUsedAdrrCorecta() throws Exception{
			Manager m= Manager.getInstance();
			double rez=0;
			Address address= (Address) GenericAddress.parse("127.0.0.1"+"/161");
			 rez=	m.getRamUsed(address);
			 assertEquals(rez, m.getRamUsed(address),0.0);
	}
	
	
	@Test
	public void testDescrAddrCorecta() throws Exception{
			Manager m= Manager.getInstance();
			String rez=null;
			Address address= (Address) GenericAddress.parse("127.0.0.1"+"/161");
			 rez=	m.getSysDescr(address);
			assertNotNull(rez);
	}
	
	@Test
	public void testLocatieAdrrNula() throws Exception {
		try{
			Manager m= Manager.getInstance();
			String t=null;
			 t=(String)	m.getSysLocation(null);
			 assertFalse("Metoda nu arunca exceptie pe adresa nula", true);
		}
			catch(WrongAddressException ex){
				assertTrue(true);
			}
	}
	
}//11 teste

