package it.uniroma3.diadia.comandi.test;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.giocatore.*;
import it.uniroma3.diadia.attrezzi.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComandoPrendiTest {

	private Stanza stanza;
	private Borsa borsa;
	private Attrezzo attrezzo;

	
	@BeforeEach
	void setUp() throws Exception { 
		this.stanza = new Stanza("stanza");
		this.borsa = new Borsa();
		this.attrezzo = new Attrezzo("attrezzo",1);
		this.stanza.addAttrezzo(attrezzo);

	}

	@AfterEach
	void tearDown() throws Exception {
		this.attrezzo = null;
		this.borsa = null;
		this.stanza = null;

	}

	@Test
	void test() { 
		this.borsa.addAttrezzo(this.stanza.getAttrezzo("attrezzo"));
		this.stanza.removeAttrezzo(attrezzo);
		assertEquals(true, this.borsa.hasAttrezzo("attrezzo")); 

	}

}
