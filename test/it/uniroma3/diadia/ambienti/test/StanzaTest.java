package it.uniroma3.diadia.ambienti.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/*
 * test che controllano impostaStanzaAdiacente, addAttrezzo, 
 * getStanzaAdiacente e removeAttrezzo
 * 
 */
  
public class StanzaTest { 
	
	private Stanza test; 
	private Stanza prova;
	private Stanza tentativo;
	private Attrezzo lanterna;
	private Attrezzo spada;
	private Attrezzo osso; 
 
 
	@BeforeEach  
	public void setUp() {
		this.test = new Stanza("test");
		this.prova = new Stanza("prova");
		this.tentativo = new Stanza("tentativo");
		
		test.impostaStanzaAdiacente("nord",prova); 
		test.impostaStanzaAdiacente("est", tentativo);
		prova.impostaStanzaAdiacente("ovest", tentativo); 
		this.lanterna = new Attrezzo("lanterna",3);
		this.spada = new Attrezzo("spada",3);
		this.osso = new Attrezzo("osso",3);
		test.addAttrezzo(lanterna); 
		prova.addAttrezzo(osso);
		prova.addAttrezzo(spada); 
	
	}
	
	@AfterEach
	public void tearDown() {
		this.test = null;
		this.prova = null;
		this.tentativo = null;
		this.lanterna = null;
		this.osso = null;
		this.prova = null;
		
	}
	
	/*
	 * test per getStanzaAdiacente
	 */ 
	
	@Test  //prova con direzione nord
	public void testAddStanzaAdiacente1() {  
		assertEquals("prova", this.test.getStanzaAdiacente("nord").getNome());
	}
	 
	@Test //prova con stanza senza stanze adiacenti nella direzizione nord
	public void testAddStanzaAdiacente2() {
		assertEquals(null, this.tentativo.getStanzaAdiacente("nord"));
	}
	
	@Test  //prova con direzione est
	public void testAddStanzaAdiacente3() {
		assertEquals("tentativo", this.test.getStanzaAdiacente("est").getNome());
	}
	
	/*
	 * test per addAttrezzo
	 */
	
	@Test	//test con un oggetto all'interno
	public void testaddAttrezzo1() {
		assertEquals(true ,test.addAttrezzo(lanterna));
	}
	
	@Test	//test con nessun oggetto all'interno
	public void testaddAttrezzo2() {
		assertEquals(true,tentativo.addAttrezzo(lanterna));
	}
	
	@Test	//test con 2 oggetti all'interno
	public void testaddAttrezzo3() {
		assertEquals(true,prova.addAttrezzo(spada));

	}
	
	/*
	 * test per getStanzaAdiagente
	 */
	
	@Test	//test per nord con 1 stanza adiacente
	public void testGetStanzaAdiacente1() {
		assertEquals("prova", test.getStanzaAdiacente("nord").getNome());
	}
	
	@Test 	//test per stanza con nessuna stanza adiacente 
	public void testGetStanzaAdiacente2() {
		assertEquals(null, tentativo.getStanzaAdiacente("nord"));
	}
	
	@Test //test per una stanza adiacente ad una stanza adiacente
	public void testGetStanzaAdiacente3() {
		assertEquals( "tentativo"  ,test.getStanzaAdiacente("nord").getStanzaAdiacente("ovest").getNome());
	}
	
	/* 
	 * test per removeAttrezzo
	 */
	@Test  //test per attrezzo esistente bella stanza
	public void testRemoveAttrezzo1() {
		assertEquals(true , this.prova.removeAttrezzo(spada));
	}
	
	@Test //test per attrezzo non presente nella stanza
	public void testRemoveAttrezzo2() {
		assertEquals(false, this.prova.removeAttrezzo(lanterna));
	}
	
	@Test //test per attrezzo in una stanza che ne contine piu di uno
	public void testRemoveAttrezzo3() {
		assertEquals(true, this.prova.removeAttrezzo(osso));
	}
	
	
	/*
	 * test per hasAttrezzo
	 */

	@Test //Verifica che la stanza non contenga l'attrezzo che non è prensente nella stanza
	void testHasAttrezzo1() {
		assertEquals(false, this.prova.hasAttrezzo("lanterna"));		
	}
	

	@Test //Verifica che la stanza contenga l'attrezzo 
	void testHasAttrezzo2() {
		assertEquals(true, this.test.hasAttrezzo("lanterna"));		
	}


	/*
	 * test per getAttrezzo
	 */

	
	@Test // test che verifica se get attrezzo ritorna l'attrezzo presente nella stanza 
	void testGetAttrezzo1() {
		assertEquals(lanterna, this.test.getAttrezzo("lanterna"));		
	}
	
	
	@Test // test che verifica che get attrezzo ritorni null per un attrezzo che non è nella stanza 
	void testGetAttrezzo2() {
		assertEquals(spada, this.prova.getAttrezzo("spada"));		
	}
	
}






