package it.uniroma3.diadia.ambienti.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	
	
	private StanzaBuia stanzaBuia;
	private Attrezzo lanterna;
	private Attrezzo bottiglia;
	
	@Before
	public void setUp() {
		lanterna = new Attrezzo("lanterna",2);
		stanzaBuia = new StanzaBuia("stanzaBuia",lanterna);
		stanzaBuia.addAttrezzo(lanterna);
		bottiglia = new Attrezzo("bottiglia", 5);
		
	}
	
	@After
	public void tearDown() {
		stanzaBuia = null;
		lanterna = null;
	}
	
	
	@Test
	public void hasAttrezzoLanterna() {
		stanzaBuia.addAttrezzo(lanterna);
		assertTrue(stanzaBuia.hasAttrezzo("lanterna"));
	}
	
	@Test
	public void hasAttrezzoLanternaNot() {			// non c'è la lanterna
		stanzaBuia.addAttrezzo(bottiglia);
		assertTrue(stanzaBuia.hasAttrezzo("bottiglia"));
	}
	
	@Test
	public void getDescrizioneStanzaBuia() {			// non c'è l'attrezzo lanterna quindi non puoi vedere
		stanzaBuia.removeAttrezzo(lanterna);
		assertEquals("qui c'è buio pesto",stanzaBuia.getDescrizione());
	}
	
	@Test
	public void getDescrizioneStanzaNormale() {			// c'è l'attrezzo lanterna quindi stampi la descrizione normalmente
		assertEquals("stanzaBuia\nUscite: \nAttrezzi nella stanza: lanterna (2kg)",stanzaBuia.getDescrizione());
	}

}
