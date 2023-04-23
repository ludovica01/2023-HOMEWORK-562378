package it.uniroma3.diadia.comandi.test;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;


public class ComandoPrendiTest {
	
	private Partita partita;
	private ComandoPrendi comandoPrendi;
	private Attrezzo bottiglia;
	private Attrezzo bottiglia1;
	
	
	@Before
	public void setUp() {
		partita = new Partita();
		comandoPrendi = new ComandoPrendi();
		bottiglia = new Attrezzo("Bottiglia",5);
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(bottiglia);
	}
	
	@After
	public void tearDown() {
		partita = null;
		comandoPrendi = null;
	}
	
	
	@Test
	public void comandoPrendiEsegui() {
		comandoPrendi.setParametro(bottiglia.getNome());
		comandoPrendi.esegui(partita);
		assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("Bottiglia"));
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("Bottiglia"));
	}
	
	@Test
	public void comandoPrendiEseguiDoppio() {			// prendi due attrezzi contemporaneamente dalla borsa
		bottiglia1 = new Attrezzo("Bottiglia1",6);
		partita.getGiocatore().getBorsa().addAttrezzo(bottiglia1);
		comandoPrendi.setParametro(bottiglia.getNome());
		comandoPrendi.esegui(partita);
		comandoPrendi.setParametro(bottiglia1.getNome());
		comandoPrendi.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("Bottiglia"));
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("Bottiglia1"));
	}
	
//	@Test
//	public void comandoPrendiEseguiNullo() {
//		comandoPrendi.setParametro(null);
//		comandoPrendi.esegui(partita);
//		
//	}
//	
}
