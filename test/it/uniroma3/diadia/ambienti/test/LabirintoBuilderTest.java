package it.uniroma3.diadia.ambienti.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilderTest {
	
	private LabirintoBuilder labirintoBuilder;
	private Labirinto labirinto;
	private Attrezzo attrezzo;
	
	
	@Before
	public void setUp() {
		labirintoBuilder = new LabirintoBuilder();
		attrezzo = new Attrezzo("attrezzo",2);
	}
	
	@After
	public void tearDown() {
		labirintoBuilder = null;			// lo svuoto delle modifiche fatte
		
	}
	
	
	/**
	 * test per addAttrezzo
	 */
	
	@Test
	public void TestAddAttrezzo() {
		labirinto = this.labirintoBuilder.addStanzaIniziale("stanzaIniziale").addAttrezzo("attrezzo",7).getLabirinto();
		assertEquals("attrezzo", labirintoBuilder.getLabirinto().getStanzaCorrente().getAttrezzo("attrezzo").getNome());
	}
	
	/**
	 * test per stanza addSTanzaINiziale
	 */
	@Test
	public void TestAddStanzaIniziale() {
		labirinto = this.labirintoBuilder.addStanzaIniziale("stanzaIniziale").getLabirinto();
		assertEquals("stanzaIniziale", this.labirinto.getStanzaCorrente().getNome());
	}
	
	/**
	 * test per addStanzaVincente
	 */
	@Test
	public void TestAddStanzaVincente() {
		labirinto = this.labirintoBuilder.addStanzaVincente("stanzaVincente").getLabirinto();
		assertEquals("stanzaVincente", this.labirinto.getStanzaVincente().getNome());
	}
	
	@Test 
	public void testAddStanza(){
		labirinto = this.labirintoBuilder.addStanzaIniziale("stanza")
				.addStanza("aggiunta")
				.addAdiacenza("stanza", "aggiunta", "nord").getLabirinto();
		assertEquals("aggiunta",this.labirinto.getStanzaCorrente().getStanzaAdiacente("nord").getNome());
	} 
	 
  
	@Test   
	public void testAddAdiacenza(){
		labirinto = labirintoBuilder.addStanzaIniziale("stanza")
				.addStanza("stanzaAdicente") 
				.addAdiacenza("stanza", "stanzaAdicente", "nord").getLabirinto();	
		assertEquals("stanzaAdicente",this.labirinto.getStanzaCorrente().getStanzaAdiacente("nord").getNome());
		} 
		   
	@Test  
	public void testAddStanzaBloccata(){ 
		labirinto = labirintoBuilder.addStanzaIniziale("iniziale")
				.addStanzaBloccata("bloccata", attrezzo, "nord")
                .addAttrezzo("chiave", 1)
                .addAdiacenza("iniziale", "bloccata", "nord").getLabirinto();
        assertEquals("bloccata", labirinto.getStanzaCorrente().getStanzaAdiacente("nord").getNome());
	}
	@Test  
	public void testAddStanzaBuia(){ 
		labirinto = this.labirintoBuilder.addStanzaIniziale("stanza")
				.addStanzaBuia("buia",attrezzo)
				.addAttrezzo("attrezzo", 2).getLabirinto();	
		assertNotEquals("qui c'è buio pesto",this.labirinto.getStanzaCorrente().getDescrizione());
	}
	
	@Test  
	public void testAddStanzaMagica(){
		labirinto = this.labirintoBuilder.addStanzaIniziale("stanza")
		.addStanzaMagica("magica")
		.addAdiacenza("stanza", "magica", "nord")
		.addAttrezzo("attrezzo", 1).getLabirinto();		
		assertTrue(this.labirinto.getStanzaCorrente().getStanzaAdiacente("nord").getAttrezzi().contains("attrezzo"));
	} 
	 
	@Test 
	public void testAddStanzaMagica2(){
		labirinto = this.labirintoBuilder.addStanzaIniziale("stanza")
		.addStanzaMagica("magica",0)
		.addAdiacenza("stanza", "magica", "nord")
		.addAttrezzo("attrezzo", 2).getLabirinto();		
		assertTrue(this.labirinto.getStanzaCorrente().getStanzaAdiacente("nord").getAttrezzi().contains("ozzertta"));
	} 
	 
	
	
	
	
	
}
