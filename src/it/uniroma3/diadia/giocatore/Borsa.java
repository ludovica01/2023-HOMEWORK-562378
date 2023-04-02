package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10; 
	private Attrezzo[] attrezzi; 
	private int numeroAttrezzi; 
	private int pesoMax; 
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	  
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax; 
		this.attrezzi = new Attrezzo[10];
		this.numeroAttrezzi = 0;
	}
	 
	/* 
	 * Aggiunge un attrezzo alla borsa
	 * @return true se lo inserisce
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax()) 
			return false;
		if (this.numeroAttrezzi==10) 
			return false;
		
		this.attrezzi[this.numeroAttrezzi] = attrezzo; 
		this.numeroAttrezzi++; 
		return true;
	}
	
	/*
	 * @return il peso massimo della borsa
	 */
	public int getPesoMax() { 
		return pesoMax;
	}
	
	/*
	 * @return l'attrezzo cercato
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) { 
		Attrezzo a = null; 
		for (int i= 0; i<this.numeroAttrezzi; i++) {
			if(attrezzi[i]!= null) {	
				if (this.attrezzi[i].getNome().equals(nomeAttrezzo)) 
					a = attrezzi[i];
			}
		}
	return a;
}
	
	/*
	 * @return il peso contenuto nella borsa 
	 */
	public int getPeso() { 
		int peso = 0;
		for (int i= 0; i < this.numeroAttrezzi; i++) 
			if(attrezzi[i]!= null) {	
				peso += this.attrezzi[i].getPeso();
				
			}
		return peso; 
		} 
	
	/*
	 * @return true se la borsa è vuota
	 */
	public boolean isEmpty() { 
		return this.numeroAttrezzi == 0; 
		}
	
	/*
	 * @return true se la borsa contiene quell'attrezzo
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) { 
		return this.getAttrezzo(nomeAttrezzo) != null;
	}
	
	
	public boolean removeAttrezzo(String nomeAttrezzo) { 
		boolean removed = false; 
		for(int i=0; i<this.numeroAttrezzi; i++) {
			if(attrezzi[i]!= null) {	
				if(attrezzi[i].getNome().equals(nomeAttrezzo)) {
					removed = true;
				    attrezzi[i] = null;
				}
			}
		}
		return removed;
	} 
	
	public String toString() {
	StringBuilder s = new StringBuilder(); 
	if (!this.isEmpty()) {
		s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): "); 
		for (int i= 0; i < this.numeroAttrezzi; i++)
			s.append(attrezzi[i].toString()+" ");
	} 
	else 
		s.append("Borsa vuota"); 
	
	return s.toString(); }
}
	
	
