package it.uniroma3.diadia.comandi.test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;

public class ComandoPosaTest {
	
	private Partita partita;
	private ComandoPosa comandoPosa;
	private Attrezzo bottiglia;
	private Attrezzo bottiglia1;
	
	
	@Before
	public void setUp() {
		partita = new Partita();
		comandoPosa = new ComandoPosa();
		bottiglia = new Attrezzo("Bottiglia",5);
		partita.getGiocatore().getBorsa().addAttrezzo(bottiglia);
	}
	
	@After
	public void tearDown() {
		partita = null;
		comandoPosa = null;
	}
	
	
	@Test
	public void comandoPosaEsegui() {
		comandoPosa.setParametro(bottiglia.getNome());
		comandoPosa.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("Bottiglia"));
		assertTrue(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("Bottiglia"));
	}
	
	@Test
	public void comandoPosaEseguiDoppio() {			// posa due attrezzi contemporaneamente dalla borsa
		bottiglia1 = new Attrezzo("Bottiglia1",6);
		partita.getGiocatore().getBorsa().addAttrezzo(bottiglia1);
		comandoPosa.setParametro(bottiglia.getNome());
		comandoPosa.esegui(partita);
		comandoPosa.setParametro(bottiglia1.getNome());
		comandoPosa.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("Bottiglia"));
		assertTrue(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("Bottiglia"));
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("Bottiglia1"));
		assertTrue(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("Bottiglia"));
	}
	
	

}
