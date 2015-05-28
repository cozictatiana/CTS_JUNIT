package teste;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import clase.SendEmail;

public class TestEmail {
  SendEmail sendEmail;
final String fisierValori = "date.txt";


@Before
public void setUp(){
	System.out.println("setUp Unit test");
	sendEmail = new SendEmail();
}
	@Test
	public void testEmailContactNull() throws Exception {
		assertFalse(sendEmail.sendEmail(null, "123", "adreia@gmail.com", "buna"));
	}

	@Test
	public void testEmailAddreseGresite() throws Exception {
		assertFalse(sendEmail.sendEmail("tatiana@gmail.com", "123", "adreia@gmail.com", "buna"));
	}
	
	@Test
	public void testEmailDateValide() throws Exception {
		assertFalse(sendEmail.sendEmail("tatiana@gmail.com", "T20n1992**", "craciunescu.andreia17@gmail.com", "buna"));
	}
	
	@Test
	public void testRezEmailDateFisier() throws IOException, Exception {
		File file = new File(fisierValori);
		if(!file.exists())
			throw new FileNotFoundException("Lipsa fisier ");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String linie = null;
		ArrayList<String> valori = new ArrayList<>();
		String valFrom=null;
		String valPass=null;
		String valTo=null;
		String valMess=null;
		boolean rez=false;
		while((linie = reader.readLine())!=null){
			
			//elimin comentariile
			if(linie.startsWith("~~"))
				continue;
			
			//elimin spatiile si liniile goale
			linie = linie.trim();
			valori.add(linie);
			
			if(valori.size()==4){
				 valFrom= valori.get(0);
				 valPass= valori.get(1);
				 valTo= valori.get(2);
				valMess= valori.get(3);
		 rez= sendEmail.sendEmail(valFrom, valPass, valTo, valMess);
				
		
			}
			assertEquals(rez, sendEmail.sendEmail(valFrom, valPass, valTo, valMess));
			
		}	
		reader.close();
	
	
	}
	
	
	@Ignore
	@Test
	public void testTrueEmailDateFisier() throws IOException, Exception {
		File file = new File(fisierValori);
		if(!file.exists())
			throw new FileNotFoundException("Lipsa fisier ");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String linie = null;
		ArrayList<String> valori = new ArrayList<>();
		String valFrom=null;
		String valPass=null;
		String valTo=null;
		String valMess=null;
		while((linie = reader.readLine())!=null){
			
			//elimin comentariile
			if(linie.startsWith("~~"))
				continue;
			
			//elimin spatiile si liniile goale
			linie = linie.trim();
			valori.add(linie);
			
			if(valori.size()==4){
				 valFrom= valori.get(0);
				 valPass= valori.get(1);
				 valTo= valori.get(2);
				valMess= valori.get(3);
		//false daca e proxy, altfel true
				assertTrue(sendEmail.sendEmail(valFrom, valPass, valTo, valMess));
		
			}
			
			
		}	
		reader.close();
	
	//5 teste
	}
}

