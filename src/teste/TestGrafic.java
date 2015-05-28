package teste;

import static org.junit.Assert.*;

import org.jfree.data.category.DefaultCategoryDataset;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.snmp4j.CommunityTarget;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;

import clase.Manager;
import clase.SendEmail;
import exceptii.GraficException;
import exceptii.WrongAddressException;
import utils.BarGrafic;
import utils.Grafic;
import utils.LineGrafic;

public class TestGrafic {
	Grafic grafic;
	
	@Before
	public void setUp(){
		System.out.println("setUp Unit test");
		grafic= grafic.getInstance();
	}

	@Test
	public void testGraficBarDateNule() {
		DefaultCategoryDataset dcd=null;
		assertNull(new BarGrafic().creeaza(dcd));
	}
	
	@Test
	public void testGraficBarDateValide() {
		DefaultCategoryDataset dcd=new DefaultCategoryDataset();
		dcd.setValue(70,"procese", "nr"+1);
		dcd.setValue(70,"procese", "nr"+2);
		assertNotNull(new BarGrafic().creeaza(dcd));
	}
	
	@Test
	public void testGraficLineDateNulle() {
		DefaultCategoryDataset dcd=null;
		assertNull(new LineGrafic().creeaza(dcd));
	}
	

	@Test
	public void testGraficLineDateValide() {
		DefaultCategoryDataset dcd=new DefaultCategoryDataset();
		dcd.setValue(70,"procese", "nr"+1);
		dcd.setValue(70,"procese", "nr"+2);
		assertNotNull(new LineGrafic().creeaza(dcd));
	}
	
	@Test
	public void testGraficNull() throws Exception{
		try{
			grafic.creeazagrafic(null, null, null);
			 assertFalse("Metoda nu arunca exceptie pe campuri nule", true);
		}
			catch(GraficException ex){
				assertTrue(true);
			}
	}
	
	//5 teste
	
	
	
}
