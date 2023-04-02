package it.uniroma3.diadia.giocatore.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

/*
 * test che coontrolla addAttrezzo , getPeso ed removeAttrezzo
 */

public class BorsaTest {
 
	private Borsa borsa;
	private Borsa sacca;
	private Attrezzo attrezzo;
	private Attrezzo utensile;
	private Attrezzo arma;
	private Attrezzo accessorio;
	
	@BeforeEach 
	public void setUp() { 
		this.sacca = new Borsa();
		this.borsa = new Borsa();
		this.accessorio = new Attrezzo("accessorio", 3);
		this.attrezzo = new Attrezzo("attrezzo", 6);
		this.utensile = new Attrezzo("utensile", 25);
		this.arma = new Attrezzo("arma", 17);
		
		this.sacca.addAttrezzo(attrezzo);
		this.sacca.addAttrezzo(accessorio);
		
	}
	 
	@AfterEach
	public void tearDown() {
		this.accessorio = null;
		this.sacca = null;
		this.attrezzo = null;
		this.borsa = null;
		this.utensile = null;
		this.arma= null;
	}
	
	/*
	 * test per addAttrezzo
	 */
	@Test //test con l'attrezzo 
	public void testAddAttrezzo1() {
		assertEquals(true, this.borsa.addAttrezzo(attrezzo));
	}
	@Test //test per un attrezzo troppo pesante
	public void testAddAttrezzo2() {
		assertEquals(false, this.borsa.addAttrezzo(utensile));
	}
	
	@Test //test per un attrezzo che sommato agli altri è troppo pesante per entrare in borsa
	public void testAddAttrezzo3() {
		assertEquals(false, this.borsa.addAttrezzo(arma));
	}
	
	/*
	 * test per getPeso
	 */
	@Test // test per una borsa con 2 oggetti leggeri
	public void testGetPeso1() {
		assertEquals(9  , this.sacca.getPeso());
	}
	
	@Test //test per una borsa vuota
	public void testGetPeso2() {
		assertEquals(0 , this.borsa.getPeso());
	} 
	
	/*
	 * test per removeAttrezzo 
	 */
	@Test //rimozione attrezzo 
	public void testRemoveAttrezzo1() {
		assertEquals(true, this.sacca.removeAttrezzo("accessorio"));
	}
	
	@Test //rimozione attrezzo inesistente
	public void testRemoveAttrezzo2() {
		assertEquals(false, this.sacca.removeAttrezzo("pistola"));
	}
	
	@Test //rimozione attrezzo in una borsa con piu attrezzi
	public void testRemoveAttrezzo3() {
		assertEquals(true, this.sacca.removeAttrezzo("attrezzo"));
	}

	
	/*
	 * test per hasAttrezzo
	 */
	
	@Test //Verifica che l'attrezzo "attrezzo" sia nella borsa
	void testHasAttrezzo1() {
		assertEquals(true, this.sacca.hasAttrezzo("attrezzo"));
	}


	@Test //Verifica che l'attrezzo "utensile" non sia nella borsa
	void testHasAttrezzo2() {
		assertEquals(false, this.borsa.hasAttrezzo("accessorio"));
	}

}
