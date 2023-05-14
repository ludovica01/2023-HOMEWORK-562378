package it.uniroma3.diadia.ambienti.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

/*
 * test che verificano le funzioni getStanzaCorrente , 
 * getStanzaVincente e setStanzaCorrente.
 */ 

public class LabirintoTest {

	private Labirinto labirinto;
	private Labirinto universita;
	private Labirinto scuola;
	private Stanza stanza;
	private Stanza camera;
	
	@BeforeEach 
	public void setUp() {
		this.universita = new Labirinto();
		this.scuola = new Labirinto();
		this.labirinto = new Labirinto();
		this.stanza = new Stanza("stanza");
		this.camera = new Stanza("camera");
		labirinto.setStanzaCorrente(stanza);
		universita.setStanzaCorrente(camera);
	}
	
	@AfterEach
	public void tearDown() {
		this.scuola =null;
		this.universita = null;	
		this.labirinto= null;	
		this.labirinto= null;
		this.camera=null;
	}
	
	/*
	 * test per getStanzaCorrente
	 */
	@Test //test con una stanza
	public void testGetStanzaCorrente1() {
		assertEquals("stanza", this.labirinto.getStanzaCorrente().getNome());
	}
	
	@Test //test con stanza di default
	public void testGetStanzaCorrente2() {
		scuola.setStanzaCorrente(camera);
		assertEquals("camera",this.scuola.getStanzaCorrente().getNome());
	}

	/*
	 * test per getStanzaVincente
	 */
	@Test  //test stanza vincente di default 
	public void testGetStanzaVincente1() {
		labirinto.setStanzaVincente(stanza);
		assertEquals("stanza",this.labirinto.getStanzaVincente().getNome() );
	} 
	
	/*
	 * Test per setStanzaCorrente
	 */
	@Test 
	public void testSetStanzaCorrente1() {
		assertEquals("camera", this.universita.getStanzaCorrente().getNome());
	}
	
}

