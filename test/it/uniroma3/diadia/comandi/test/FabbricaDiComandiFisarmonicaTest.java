package it.uniroma3.diadia.comandi.test;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

public class FabbricaDiComandiFisarmonicaTest {
	
	private FabbricaDiComandiFisarmonica fabbrica;
	private Partita partita;
	private String comando;
	
	@Before
	public void setUp() {
		fabbrica = new FabbricaDiComandiFisarmonica();
		partita = new Partita();
	}
	
	@After
	public void tearDown() {
		fabbrica = null;
		partita = null;
		comando = null;
	}
	
	
	@Test
	public void fabbricaDiComandiFisarmonicaVaiTest() {
		comando = "vai";
		assertEquals("ComandoVai",fabbrica.costruisciComando(comando).getNome());
	}
	
	@Test
	public void fabbricaDiComandiFisarmonicaPrendiTest() {
		comando = "prendi";
		assertEquals("ComandoPrendi",fabbrica.costruisciComando(comando).getNome());
	}
	
	@Test
	public void fabbricaDiComandiFisarmonicaPosaTest() {
		comando = "posa";
		assertEquals("ComandoPosa",fabbrica.costruisciComando(comando).getNome());
	}
	
	@Test
	public void fabbricaDiComandiFisarmonicaAiutoTest() {
		comando = "aiuto";
		assertEquals("ComandoAiuto",fabbrica.costruisciComando(comando).getNome());
	}
	
	@Test
	public void fabbricaDiComandiFisarmonicaFineTest() {
		comando = "fine";
		assertEquals("ComandoFine",fabbrica.costruisciComando(comando).getNome());
	}
	
	@Test
	public void fabbricaDiComandiFisarmonicaGuardaTest() {
		comando = "guarda";
		assertEquals("ComandoGuarda",fabbrica.costruisciComando(comando).getNome());
	}
	
}
