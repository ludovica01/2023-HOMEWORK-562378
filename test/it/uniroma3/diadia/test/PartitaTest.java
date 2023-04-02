package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.diadia.Partita;


// Test che si riferisce alla classe partita e testa le funzioni :
 //setFinita, getStanzaCorrente e getCf



public class PartitaTest {
	
	private Partita partita;
	private Partita gioco;
	private Partita game;
	
	@BeforeEach  
	public void setUp() {
		
		this.game = new Partita();
		this.partita = new Partita();
		this.gioco = new Partita(); 
		partita.setFinita();
		this.gioco.getLabirinto().setStanzaCorrente(this.gioco.getLabirinto().getStanzaVincente());

	}

	@AfterEach
	public void tearDown() {
		this.game = null;
		this.partita=null;
		this.gioco= null;
	}

	
	//test da fare
	
	/*
	 * test per isFinita
	 */
	@Test // test con una partita finita 
	public void testsetFinita1() {
		assertEquals(true, this.partita.isFinita());
	}
	
	@Test // test con una partita non finita 
	public void testsetFinita2() {
		assertEquals(false, this.game.isFinita());
	}
	
	
	
	/*
	 * test per vinta
	 */
	
	@Test
	public void testVinta1() {
		assertEquals(false ,this.partita.vinta());
	}
	
	@Test
	void testVinta2() {
		assertEquals(true, this.gioco.vinta());
	}
		
	
}