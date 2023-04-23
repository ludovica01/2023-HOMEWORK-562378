package it.uniroma3.diadia.giocatore.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita; 

/*
 * classe test che verifica il funzionamento di getCfu e setCfu
 */


public class GiocatoreTest {

	private Partita partita; 
	private Partita gioco;
	private Partita match;
	
	@BeforeEach
	public void setUp() {
		this.partita= new Partita();
		this.gioco = new Partita();
		this.match = new Partita();
		this.match.getGiocatore().setCfu(-2);
		this.partita.getGiocatore().setCfu(15);
	}
	
	@AfterEach
	public void tearDown() {
		
		this.partita=null;
		this.gioco =null;
		this.match = null;
		
	}
	 
	/*
	 * test per Set cfu
	 */
	@Test //test per set manuale dei cfu
	public void testSetCfu1() {
		assertEquals(15, this.partita.getGiocatore().getCfu());
	}
	@Test //test per set automatico dei cfu 
	public void testSetCfu2() {
		assertEquals( 20 ,this.gioco.getGiocatore().getCfu()  );
	}
	
	/*
	 * test per getCfu
	 */
	@Test //test standard
	public void testGetCfu1(){
		assertEquals( 15  , this.partita.getGiocatore().getCfu()); 
	}

	@Test //partita con cfu negativi
	public void testGetCfu2() {
		assertEquals(-2, this.match.getGiocatore().getCfu());
	}
	
	@Test //test per una partita con i cfu diversi da 0
	public void testGetCfu3() {
		assertNotEquals(0, partita.getGiocatore().getCfu());
	}
	
	
	
	
	
}
