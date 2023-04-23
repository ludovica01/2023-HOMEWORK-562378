package it.uniroma3.diadia.ambienti.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class StanzaBloccataTest {
	
	private StanzaBloccata stanzaBl;
	private Stanza stanza;
	private String direzioneBloccata;
	private Attrezzo chiave;
	
	
	@Before
	public void setUp() {
		direzioneBloccata = "nord";
		chiave = new Attrezzo("pane",3);
		stanzaBl = new StanzaBloccata("stanzaBl",chiave,direzioneBloccata);
		stanza = new Stanza("stanza");
	}
	 
	@After
	public void tearDown() {
		chiave = null;
		stanzaBl = null;
		stanza = null;
	}
	
	
	/**
	 * TEST isBloccata
	 */
	
	@Test
	public void isBloccataTrueTest() {			// testo una stanza che è di tipo StanzaBloccata
		assertTrue(stanzaBl.isBloccata());
	}
	
	@Test
	public void isBloccataFalseTest() {			// testo una stanza che non è di tipo StanzaBloccata
		assertFalse(stanza.isBloccata());
	}
	
	
	
	/**
	 * TEST getStanzaAdiacente
	 */
	
	@Test
	public void getStanzaAdiacenteBloccataTest() {		// prendi stanza adiacente a cui non è possibile accedere
		stanzaBl.impostaStanzaAdiacente(direzioneBloccata,stanza);
		assertEquals(stanzaBl,stanzaBl.getStanzaAdiacente(direzioneBloccata));
	}
	 
	@Test 
	public void getStanzaAdiacenteNonBloccataTest1() {
		stanzaBl.impostaStanzaAdiacente("est",stanza);
		assertEquals("stanza",stanzaBl.getStanzaAdiacente("est").getNome());
	}
	
	
	
	/**
	 * test getChiave
	 */
	@Test
	public void getChiavePresente() {
		stanzaBl.addAttrezzo(chiave);
		stanzaBl.setChiave(chiave);
		assertTrue(stanzaBl.hasAttrezzo(chiave.getNome()));
	}
	
	@Test
	public void getChiaveAssente() {
		assertFalse(stanzaBl.hasAttrezzo(chiave.getNome()));
	}
	
	
		
}
