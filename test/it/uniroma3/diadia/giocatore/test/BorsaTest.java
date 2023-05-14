package it.uniroma3.diadia.giocatore.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

/*
 * test che coontrolla addAttrezzo , getPeso ed removeAttrezzo
 */

public class BorsaTest {
 
	private Borsa borsa;
	private Borsa sacca;
	private Attrezzo attrezzo;
	private Attrezzo utensile;
	private Attrezzo arma;
	private Attrezzo accessorio;
	
	@BeforeEach 
	public void setUp() { 
		this.sacca = new Borsa();
		this.borsa = new Borsa();
		this.accessorio = new Attrezzo("accessorio", 3);
		this.attrezzo = new Attrezzo("attrezzo", 6);
		this.utensile = new Attrezzo("utensile", 25);
		this.arma = new Attrezzo("arma", 17);
		
		this.sacca.addAttrezzo(attrezzo);
		this.sacca.addAttrezzo(accessorio);
		
	}
	 
	@AfterEach
	public void tearDown() {
		this.accessorio = null;
		this.sacca = null;
		this.attrezzo = null;
		this.borsa = null;
		this.utensile = null;
		this.arma= null;
	}
	
	/*
	 * test per addAttrezzo
	 */
	@Test //test con l'attrezzo 
	public void testAddAttrezzo1() {
		assertEquals(true, this.borsa.addAttrezzo(attrezzo));
	}
	@Test //test per un attrezzo troppo pesante
	public void testAddAttrezzo2() {
		assertEquals(false, this.borsa.addAttrezzo(utensile));
	}
	
	@Test //test per un attrezzo che sommato agli altri è troppo pesante per entrare in borsa
	public void testAddAttrezzo3() {
		assertEquals(false, this.borsa.addAttrezzo(arma));
	}
	
	/*
	 * test per getPeso
	 */
	@Test // test per una borsa con 2 oggetti leggeri
	public void testGetPeso1() {
		assertEquals(9  , this.sacca.getPeso());
	}
	
	@Test //test per una borsa vuota
	public void testGetPeso2() {
		assertEquals(0 , this.borsa.getPeso());
	} 
	
	/*
	 * test per removeAttrezzo 
	 */
	@Test //rimozione attrezzo 
	public void testRemoveAttrezzo1() {
		assertEquals(accessorio, this.sacca.removeAttrezzo(accessorio.getNome()));
	}
	
	@Test //rimozione attrezzo inesistente
	public void testRemoveAttrezzo2() {
		assertNull(this.sacca.removeAttrezzo(arma.getNome()));
	}
	
	@Test //rimozione attrezzo in una borsa con piu attrezzi
	public void testRemoveAttrezzo3() {
		assertEquals(attrezzo, this.sacca.removeAttrezzo(attrezzo.getNome()));
	}

	
	/*
	 * test per hasAttrezzo
	 */
	
	@Test //Verifica che l'attrezzo "attrezzo" sia nella borsa
	void testHasAttrezzo1() {
		assertEquals(true, this.sacca.hasAttrezzo(attrezzo.getNome()));
	}


	@Test //Verifica che l'attrezzo "utensile" non sia nella borsa
	void testHasAttrezzo2() {
		assertEquals(false, this.borsa.hasAttrezzo(accessorio.getNome()));
	}
	
	
	/**
	 * test per getContenutoOrdinatoPerPeso
	 */
	@Test
	void testGetContenutoOrdinatoPerPeso() {
		assertEquals("[accessorio, attrezzo]", sacca.getContenutoOrdinatoPerPeso().toString());
	}
	
	@Test
	void testGetContenutoOrdinatoPerPesoPiuAttrezzi() {			// aggiungo altri attrezzi in maniera non ordinata
		Attrezzo attr = new Attrezzo("attr",4);
		Attrezzo attr1 = new Attrezzo("attr1",9);
		sacca.addAttrezzo(attr1);
		sacca.addAttrezzo(attr);
		assertEquals("[accessorio, attr, attrezzo, attr1]", sacca.getContenutoOrdinatoPerPeso().toString());
	}
	
	/** test non minimali **/
	
	@Test
	void testGetContenutoOrdinatoPerPesoNomiUguali() {			// alcuni attrezzi hanno nome uguale ma pesi diversi
		Attrezzo accessorio1 = new Attrezzo("accessorio",5);
		sacca.addAttrezzo(accessorio1);
		assertEquals("[accessorio, accessorio, attrezzo]", sacca.getContenutoOrdinatoPerPeso().toString());
	}
	
	@Test
	void testGetContenutoOrdinatoPerPesoPesiUguali() {			// attrezzi con stessi nomi ma pesi diversi
		Attrezzo attrezzo1 = new Attrezzo("nomeDiverso",3);
		sacca.addAttrezzo(attrezzo1);
		assertEquals("[accessorio, nomeDiverso, attrezzo]",sacca.getContenutoOrdinatoPerPeso().toString());
	}
	
	
	
	/**
	 * test per getContenutoOrdinatoPerNome
	 */
	
	@Test
	void testGetContenutoOrdinatoPerNome() {
		assertEquals("[accessorio, attrezzo]", sacca.getContenutoOrdinatoPerNome().toString());

	}
	
	@Test
	void testGetContenutoOrdinatoPerNomePiuAttrezzi() {				// aggiungo altri attrezzi in maniera non ordinata
		Attrezzo attr = new Attrezzo("attr",4);
		Attrezzo attr1 = new Attrezzo("attr1",9);
		sacca.addAttrezzo(attr1);
		sacca.addAttrezzo(attr);
		assertEquals("[accessorio, attr, attrezzo, attr1]", sacca.getContenutoOrdinatoPerNome().toString());
	}
	
	
	/**
	 * test per ordinaPerNome
	 */
	@Test
	void testOrdinaPerNome() {						// ordino per nome gli attrezzi
		assertEquals("[accessorio, attrezzo]", sacca.ordinaPerNome().toString());
	}
	
	@Test
	void testOrdinaPerNomePiuAttrezzi() {			// aggiungo altri attrezzi in maniera non ordinata
		Attrezzo attr = new Attrezzo("attr",4);
		Attrezzo attr1 = new Attrezzo("attr1",9);
		sacca.addAttrezzo(attr1);
		sacca.addAttrezzo(attr);
		assertEquals("[accessorio, attr, attr1, attrezzo]", sacca.ordinaPerNome().toString());
	}
	
	
	/**
	 * test per ordinaPerPeso
	 */
	@Test
	void testOrdinaPerPeso() {						// ordino per nome gli attrezzi
		assertEquals("[accessorio, attrezzo]", sacca.ordinaPerPeso().toString());
	}
	
	@Test
	void testOrdinaPerPesoPiuAttrezzi() {			// aggiungo altri attrezzi in maniera non ordinata
		Attrezzo attr = new Attrezzo("attr",4);
		Attrezzo attr1 = new Attrezzo("attr1",9);
		sacca.addAttrezzo(attr);
		sacca.addAttrezzo(attr1);
		assertEquals("[accessorio, attr, attrezzo, attr1]", sacca.ordinaPerPeso().toString());
	}
	
	/** test non minimali **/
	
	@Test
	void testOrdinaPerPesoNomiUguali() {			// alcuni attrezzi hanno nome uguale ma pesi diversi
		Attrezzo accessorio1 = new Attrezzo("accessorio",5);
		sacca.addAttrezzo(accessorio1);
		assertEquals("[accessorio, accessorio, attrezzo]", sacca.getContenutoOrdinatoPerPeso().toString());
	}
	
	@Test
	void testOrdinaPerPesoPesiUguali() {			// attrezzi con stessi nomi ma pesi diversi
		Attrezzo attrezzo1 = new Attrezzo("nomeDiverso",3);
		sacca.addAttrezzo(attrezzo1);
		assertEquals("[accessorio, nomeDiverso, attrezzo]",sacca.getContenutoOrdinatoPerPeso().toString());
	}
	
	
	
	
	
	
	/*
	 * test per getSortedOrdinatoPerPeso
	 */
	@Test			// verifica se due attrezzi con stesso nome ma peso diverso rimangano distinti
	void testGetSortedOrdinatoPerPeso() {
		Attrezzo accessorio1 = new Attrezzo("accessorio1",5);
		this.sacca.addAttrezzo(accessorio1);
		assertEquals("[accessorio, accessorio1, attrezzo]", sacca.getSortedOrdinatoPerPeso().toString());
	}
	
	@Test
	void testGetSortedOrdinatoPerPeso1() {			// aggiungo due volte attrezzo con stesso nome e peso di un altro
		Attrezzo accessorio1 = new Attrezzo("accessorio1",3);
		this.sacca.addAttrezzo(accessorio1);
		assertEquals("[accessorio, accessorio1, attrezzo]", sacca.getSortedOrdinatoPerPeso().toString());
	}
	
	@Test
	void testGetSortedOrdinatoPerPesoAggiuntoDueVolte() {			// aggiungo due volte lo stesso attrezzo
		this.sacca.addAttrezzo(accessorio);
		assertEquals("[accessorio, attrezzo]", sacca.getSortedOrdinatoPerPeso().toString());
	}
	
/** test non minimali **/
	
	@Test
	void testGetSortedOrdinatoPerPesoNomiUguali() {			// alcuni attrezzi hanno nome uguale ma pesi diversi
		Attrezzo accessorio1 = new Attrezzo("accessorio",5);
		sacca.addAttrezzo(accessorio1);
		assertEquals("[accessorio, accessorio, attrezzo]", sacca.getSortedOrdinatoPerPeso().toString());
	}
	
	@Test
	void testGetSortedOrdinatoPerPesoPesiUguali() {			// attrezzi con stessi nomi ma pesi diversi
		Attrezzo attrezzo1 = new Attrezzo("nomeDiverso",3);
		sacca.addAttrezzo(attrezzo1);
		assertEquals("[accessorio, nomeDiverso, attrezzo]",sacca.getSortedOrdinatoPerPeso().toString());
	}

	
	
	
	
	
	
}
