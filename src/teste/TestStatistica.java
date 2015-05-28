package teste;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import exceptii.LengthZeroException;
import exceptii.NullVectorException;
import utils.Statistica;

public class TestStatistica extends TestCase{
	
	 public TestStatistica(String nume) {
		super(nume);
	}

	@Test
	public void testMedieVectorNull() {
			try{
			double[] m=null;
			Statistica.medie(m);
			assertFalse("Metoda nu arunca exceptie pe vector null", true);
			}
			catch(Exception ex){
				assertTrue(true);
			}
	}
	@Test
	public void testMedieVectorLungimeZero() throws NullVectorException,LengthZeroException {
		
			try{
			double[] m=new double[0];
			
			assertEquals(0f, Statistica.medie(m));
			assertFalse("Metoda nu arunca exceptie pe vector de lungime zero", true);}
			catch(Exception ex){
				assertTrue(true);
			}
			
	}
	
	@Test
	public void testMedieValid() throws NullVectorException,LengthZeroException {
			double[] m=new double[2];
			assertEquals(0f, Statistica.medie(m),0.0);	
	}
	
	@Test
	public void testMedieValNegative() throws NullVectorException,LengthZeroException {
			double[] m=new double[5];
			m[0]=-10;
			m[1]=10;
			m[2]=-3;
			m[3]=3;
			m[4]=1;
			double rez= Statistica.medie(m);
			assertEquals(0.2, Statistica.medie(m),0.0);	
			;
	}

	@Test
	public void testMedianaVectorImpar() throws NullVectorException,LengthZeroException {
			double[] m=new double[5];
			m[0]=-10;
			m[1]=10;
			m[2]=-3;
			m[3]=3;
			m[4]=1;
			assertEquals(-3, Statistica.mediana(m),0.0);
	}
	
	@Test
	public void testMedianaVectorNull() {
			try{
			double[] m=null;
			Statistica.mediana(m);
			assertFalse("Metoda nu arunca exceptie pe vector null", true);
			}
			catch(Exception ex){
				assertTrue(true);
			}
	}
	
	@Test
	public void testMedianaVectorLungimeZero() throws NullVectorException,LengthZeroException {
		try{
			double[] m= new double[0];
			 Statistica.mediana(m);
			 assertFalse("Metoda nu arunca exceptie pe vector de lungime 0", true);
		}
		catch(Exception ex){
			assertTrue(true);
		}
			
			
	}
	
	@Test
	public void testMedianaVectorPar() throws NullVectorException,LengthZeroException {
			double[] m=new double[4];
			m[0]=0;
			m[1]=1;
			m[2]=1;
			m[3]=0;	
			assertEquals(1, Statistica.mediana(m),0.0);
	}
	
	@Test
	public void testMedie() throws NullVectorException,LengthZeroException {
		double[] m=new double[5];
		m[0]=-10;
		m[1]=10;
		m[2]=-3;
		m[3]=3;
		m[4]=1;
		double rez= Statistica.medie(m);
		assertEquals(rez, Statistica.medie(m),0.0);
	}
	
	@Test
	public void testMaximVectorLungimeZero() throws NullVectorException,LengthZeroException {
		try{
			int[] m= new int[0];
			 Statistica.maxim(m);
			 assertFalse("Metoda nu arunca exceptie pe vector de lungime 0", true);
		}
		catch(Exception ex){
			assertTrue(true);
		}
				
	}
	
	@Test
	public void testMaximNrDiferite() throws NullVectorException,LengthZeroException {
		
			int[] m= new int[3];
			m[0]=10;
			m[1]=-10;
			m[2]=0;
			assertEquals(10,  Statistica.maxim(m));				
	}
	
	@Test
	public void testMaximVectorNull() throws NullVectorException,LengthZeroException {
		
		try{
			int[] m=null;
			Statistica.maxim(m);
			assertFalse("Metoda nu arunca exceptie pe vector null", true);
			}
			catch(Exception ex){
				assertTrue(true);
			}		
	}
	
	@Test
	public void testMaximNrNegative() throws NullVectorException,LengthZeroException {
			int[] m=new int[4];
			m[0]=-100;
			m[1]=-150;
			m[2]=-200;
			m[3]=-250;
			assertEquals(-100, Statistica.maxim(m));	
	}
	
	@Test
	public void testMinimvectorLungimeZero() throws NullVectorException,LengthZeroException {
		try{
			int[] m= new int[0];
			 Statistica.minim(m);
			 assertFalse("Metoda nu arunca exceptie pe vector de lungime 0", true);
		}
		catch(Exception ex){
			assertTrue(true);
		}
				
	}
	
	@Test
	public void testMinimNr() throws NullVectorException,LengthZeroException {
		
			int[] m= new int[4];
			m[0]=10;
			m[1]=-10;
			m[2]=0;
			m[3]=100;
			assertEquals(-10,  Statistica.minim(m));				
	}
	
	@Test
	public void testMinimVectorNull() throws NullVectorException,LengthZeroException {
		
		try{
			int[] m=null;
			Statistica.minim(m);
			assertFalse("Metoda nu arunca exceptie pe vector null", true);
			}
			catch(Exception ex){
				assertTrue(true);
			}		
	}
	
	//16 teste
}
