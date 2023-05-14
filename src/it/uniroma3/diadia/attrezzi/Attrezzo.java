package it.uniroma3.diadia.attrezzi;
import java.util.Comparator;

import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Una semplice classe che modella un attrezzo.
 * Gli attrezzi possono trovarsi all'interno delle stanze
 * del labirinto.
 * Ogni attrezzo ha un nome ed un peso.
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */ 
public class Attrezzo implements Comparator<Attrezzo> {

	private String nome;
	private int peso;
	
	public static OrdinatorePerNome ORDINAMENTO_PER_NOME;
	public OrdinatorePerPeso ORDINAMENTO_PER_PERSO;
 
	/**
	 * Crea un attrezzo
	 * @param nome il nome che identifica l'attrezzo
	 * @param peso il peso dell'attrezzo
	 */
	public Attrezzo(String nome, int peso) {
		this.peso = peso;
		this.nome = nome;
	}
	public Attrezzo() {
		
	}

	/**
	 * Restituisce il nome identificatore dell'attrezzo
	 * @return il nome identificatore dell'attrezzo
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Restituisce il peso dell'attrezzo
	 * @return il peso dell'attrezzo
	 */
	public int getPeso() {
		return this.peso;
	}

	/**
	 * Restituisce una rappresentazione stringa di questo attrezzo
	 * @return la rappresentazione stringa
	 */
	public String toStringPeso() {
		return this.getNome()+":"+this.getPeso();
	}
	
	public String toString() {
		return this.getNome();
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
		
	}
	

	@Override
	public int compare(Attrezzo a1, Attrezzo a2) {
		// ordinamento per peso
		int pesoComparison = Integer.compare(a1.getPeso(),a2.getPeso());
		
		if(pesoComparison != 0) 
			return pesoComparison;
		
		return 		// altrimenti per nome
			a1.getNome().compareTo(a2.getNome());
		
	}
	
	
	
	// per ordinare una collezione di attrezzi per nome
	public int compareTo(Attrezzo a) {
		
		return this.nome.compareTo(a.getNome());
		
		
	}
	
	

}