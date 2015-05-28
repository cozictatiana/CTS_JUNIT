package teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import clase.Calculator;
import clase.Caracteristica;
import clase.User;
import exceptii.WrongAddressException;
import utils.HibernateUtil;

public class TestDAO extends TestCase{
	
	public TestDAO(String nume){
		super(nume);
	}
	
	HibernateUtil hu;
	User user;
	Caracteristica caract;
	Calculator calculator;
	
	
	
	@Before
	public void setUp() throws Exception{
		 hu= new HibernateUtil();
		user= Mockito.mock(User.class);
		caract=Mockito.mock(Caracteristica.class);
		calculator=Mockito.mock(Calculator.class);
		
	}
	@Test
	public void testLogareUsernameNull()throws Exception {
		Mockito.when(user.getNume()).thenReturn(null);
		Mockito.when(user.getParola()).thenReturn("admin");
		assertFalse(hu.logare(user));
		
	}

	@Test
	public void testLogareReusita()throws Exception {
		Mockito.when(user.getNume()).thenReturn("admin");
		Mockito.when(user.getParola()).thenReturn("admin");
		assertTrue(hu.logare(user));	
	}
	
	@Test
	public void testParolaNulla()throws Exception {
		Mockito.when(user.getNume()).thenReturn("admin");
		Mockito.when(user.getParola()).thenReturn(null);
		assertFalse(hu.logare(user));	 	
	}
	
	@Test
	public void testParolaGresita()throws Exception {
		Mockito.when(user.getNume()).thenReturn("admin");
		Mockito.when(user.getParola()).thenReturn("parolaGresita");
		assertFalse(hu.logare(user));
		 		
	}
	
	@Test
	public void testCreareCaractPcNull()throws Exception {
		Caracteristica caract= hu.creeazaCaracteristica(null, "loc1", "03:12", 4.0, 2.0, 40.0, 3, "descriere", new Date());
		assertNull(caract);
	}
	
	@Test
	public void testGetCaractNumePCNull()throws Exception {
		ArrayList<Caracteristica> lista= hu.getCaracteristicaPC(null);
		assertNull(lista);
	}
	
	@Test
	public void testGetCaractCorecta()throws Exception {
		ArrayList<Caracteristica> lista= hu.getCaracteristicaPC("tatiana");
		assertNotNull(lista);
	}
	
	@Test
	public void testGetCaractNumePcGresit()throws Exception {
		ArrayList<Caracteristica> lista= hu.getCaracteristicaPC("28uehdnxp");
		assertEquals(new ArrayList<>(), lista);
	}
	
	@Test
	public void testAddCaractPcNull()throws Exception {
		try{
		Mockito.when(caract.getPc()).thenReturn(null);
		hu.addCaracteristica(caract);
		assertFalse("Metoda nu arunca exceptie pe calculator inexistent", true);
		}
		catch(Exception ex){
			assertTrue(true);
		}
	}
	
	@Test
	public void testaddCaractNull()throws Exception {
		try{
		caract=null;
		hu.addCaracteristica(caract);
		assertFalse("Metoda nu arunca exceptie pe calculator/caract inexistenta", true);
		}
		catch(Exception ex){
			assertTrue(true);
		}
	}
	
	@Test
	public void testAddCalcNull()throws Exception {
		hu.addCalculator(null);
	}
	
	@Test
	public void testRemoveCalcNull()throws Exception {
		hu.deteleCalculator(null);
	}
	
	@Test
	public void testRemoveCalcInexistent()throws Exception {
		hu.deteleCalculator("290sm");
	}
	
	@Test
	public void testGetPcIdGresit()throws Exception {
		assertNull(hu.getPcById("123"));
	}
	
	@Test
	public void testGetPcIdNull()throws Exception {
		assertNull(hu.getPcById(null));
	}
	
	@Test
	public void testGetPcIdCorect()throws Exception {
		assertNotNull((hu.getPcById("tatiana")));
	}
	
	@Test
	public void testEditPcNull()throws Exception {
		hu.updatePc(null);
	}
	
	@Test
	public void testEditPcIdNull()throws Exception {
		Mockito.when(calculator.getId()).thenReturn(null);
		hu.updatePc(calculator);
	}
	
	
	
	//18 teste
	
}
