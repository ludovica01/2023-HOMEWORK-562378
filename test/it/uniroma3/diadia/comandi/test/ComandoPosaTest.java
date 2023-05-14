package it.uniroma3.diadia.comandi.test;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.giocatore.*;
import it.uniroma3.diadia.attrezzi.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComandoPosaTest {

	private Stanza stanza;
	private Borsa borsa;
	private Attrezzo attrezzo;
	
	@BeforeEach
	void setUp()  {
		this.stanza = new Stanza("stanza");
		this.borsa = new Borsa();
		this.attrezzo = new Attrezzo("attrezzo",1);
		this.borsa.addAttrezzo(attrezzo);
	}

	@AfterEach
	void tearDown() {
		this.attrezzo = null;
		this.borsa = null;
		this.stanza = null;
	}

	@Test
	void test() {
		this.stanza.addAttrezzo(this.borsa.getAttrezzo("attrezzo"));
		this.borsa.removeAttrezzo("attrezzo");
		assertEquals(true, this.stanza.hasAttrezzo("attrezzo")); 
	}

}
