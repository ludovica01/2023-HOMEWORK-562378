package it.uniroma3.diadia.comandi.test;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;

import it.uniroma3.diadia.Partita;
// import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoVai;
import org.junit.Test;

public class ComandoVaiTest {
	
	private String istruzione;
	private ComandoVai comandoVai;
	private Partita partita;
//	private StanzaBloccata stanzaBloccata;
//	private Attrezzo attrNecessario;
	
	@Before
	public void setUp() {
		partita = new Partita();
		comandoVai = new ComandoVai();
		comandoVai.setParametro(istruzione);
//		stanzaBloccata = new StanzaBloccata("stanzaBloccata");
//		attrNecessario = new Attrezzo("attrezzo",6);
	}
	
	@After
	public void tearDown() {
		istruzione = null;
		partita = null;
		comandoVai = null;
//		stanzaBloccata = null;
//		attrNecessario = null;
	}
	
	
	/*** METODI: esegui e parametro ***/
	
	/**
	 * test per il metodo esegui
	 */
	
	@Test
	public void eseguiVaiNordTest() {		// vai a nord
		comandoVai.setParametro("nord");
		comandoVai.esegui(partita);
		assertEquals("Biblioteca", partita.labirinto.getStanzaCorrente().getNome());
	}
	
	@Test
	public void eseguiVaiEstTest() {		// vai a est
		comandoVai.setParametro("est");
		comandoVai.esegui(partita);
		assertEquals("Aula N11", partita.labirinto.getStanzaCorrente().getNome());
	}
	
	@Test
	public void eseguiVaiNordTorna() {		// vai a nord e torna indietro
		comandoVai.setParametro("nord");
		comandoVai.esegui(partita);
		comandoVai.setParametro("sud");			// torna indietro
		comandoVai.esegui(partita);
		assertEquals("Atrio",partita.labirinto.getStanzaCorrente().getNome());
	}
	
	@Test
	public void eseguiVaiSudTest() {
		comandoVai.setParametro("sud");
		comandoVai.esegui(partita);
		assertEquals("Aula N10",partita.labirinto.getStanzaCorrente().getNome());
	}
	
	@Test
	public void eseguiVaiNulloTest() {
		comandoVai.setParametro("nord");
		comandoVai.esegui(partita);
		comandoVai.setParametro("est");
		comandoVai.esegui(partita);
		assertEquals("Biblioteca",partita.labirinto.getStanzaCorrente().getNome());
	}
	

	
}
