package it.uniroma3.diadia.ambienti.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.StanzaMagica;

public class StanzaMagicaTest {
	
	private StanzaMagica stanzaMagica;
	private Attrezzo attrezzo;
	private Attrezzo attrezzo1;
	
	@BeforeEach
	public void setUp() {
		stanzaMagica = new StanzaMagica("magica",2);
		attrezzo = new Attrezzo("pane",5);
		attrezzo1 = new Attrezzo("cuffie",1);
	}
	
	@AfterEach
	public void tearDown() {
		stanzaMagica = null;
		attrezzo = null;
		attrezzo1 = null;
	}
	
	
	@Test
	public void stanzaMagicaAddAttrezzo() {		// lo aggiungo meno volte di quelel necessarie a trasformarla magica
		stanzaMagica.addAttrezzo(attrezzo);
		stanzaMagica.addAttrezzo(attrezzo);
		stanzaMagica.addAttrezzo(attrezzo);
		stanzaMagica.addAttrezzo(attrezzo);
		assertEquals("enap",stanzaMagica.modificaAttrezzo(attrezzo).getNome());
		assertEquals(10,stanzaMagica.modificaAttrezzo(attrezzo).getPeso());
	}
	
	@Test
	public void stanzaMagicaAddAttrezzo1() {		// lo aggiungo meno volte di quelel necessarie a trasformarla magica ma con un altro attrezzo
		stanzaMagica.addAttrezzo(attrezzo1);
		stanzaMagica.addAttrezzo(attrezzo1);
		stanzaMagica.addAttrezzo(attrezzo1);
		stanzaMagica.addAttrezzo(attrezzo1);
		assertEquals("eiffuc",stanzaMagica.modificaAttrezzo(attrezzo1).getNome());
		assertEquals(2,stanzaMagica.modificaAttrezzo(attrezzo1).getPeso());
	}
	
	@Test
	public void stanzaMagicaAddAttrezzoNonMagica() {	// testo la stanza senza farla diventare magica
		stanzaMagica.addAttrezzo(attrezzo);
		stanzaMagica.addAttrezzo(attrezzo);
		assertEquals("pane",stanzaMagica.modificaAttrezzo(attrezzo).getNome());
		assertEquals(5,stanzaMagica.modificaAttrezzo(attrezzo).getPeso());
	}
	
	@Test
	public void stanzaMagicaAddAttrezzoNonMagica1() {	// testo la stanza senza farla diventare magica ma con un altro attrezzo
		stanzaMagica.addAttrezzo(attrezzo1);
		stanzaMagica.addAttrezzo(attrezzo1);
		assertEquals("cuffie",stanzaMagica.modificaAttrezzo(attrezzo1).getNome());
		assertEquals(1,stanzaMagica.modificaAttrezzo(attrezzo1).getPeso());
	}
	
	
	
	
}
