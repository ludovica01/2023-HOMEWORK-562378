package it.uniroma3.diadia.giocatore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.OrdinatorePerPeso;

public class Borsa implements Ordinabile {
	
	public final static int DEFAULT_PESO_MAX_BORSA = 10; 
	private List<Attrezzo> attrezzi;
	private int pesoMax; 

	
	
	public Borsa() {
		this.attrezzi = new ArrayList<Attrezzo>();
	}
	  
	public Borsa(int pesoMax, List<Attrezzo> attrezzi) {
		this.pesoMax = pesoMax;
		this.attrezzi = attrezzi;
	}
	 
	/* 
	 * Aggiunge un attrezzo alla borsa
	 * @return true se lo inserisce
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		// posso aggiungeere un nuovo attrezzo solo se con il suo peso non supero il peso massimo
		if(pesoMax + attrezzo.getPeso() > DEFAULT_PESO_MAX_BORSA)
			return false;
		return this.attrezzi.add(attrezzo);
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
		Attrezzo trovato = null;
		for(Attrezzo a : attrezzi) 
			if(a.getNome().equals(nomeAttrezzo)) 
				trovato = a;
			
	return trovato;
}
	
	/*
	 * @return il peso contenuto nella borsa 
	 */
	public int getPeso() { 
		int peso = 0;
		for(Attrezzo a : attrezzi)
			peso += a.getPeso();
			
		return peso;
	} 
	
	/*
	 * @return true se la borsa è vuota
	 */
	public boolean isEmpty() { 
		return attrezzi.isEmpty(); 
		}
	
	/*
	 * @return true se la borsa contiene quell'attrezzo
	 */
	public boolean hasAttrezzo(String attrezzo) { 
		return this.getAttrezzo(attrezzo) != null;
	}
	
	
	public Attrezzo removeAttrezzo(String attrezzo) {
		for(Attrezzo a : attrezzi) {
			if(a.getNome().equals(attrezzo)) {
				attrezzi.remove(a);
				return a;
			}
		}
		return null;
	}
	
	
	public String toString() {
		
		StringBuilder s = new StringBuilder(); 
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			s.append(this.getContenutoOrdinatoPerPeso());
		} 
		else 
			s.append("Borsa vuota"); 
		
		return s.toString();
		
	}


	
	/** metodo che restituisce la lista degli attrezzi nella borsa
	 * ordinati per peso e quindi, a parità di pero, per nome */
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		
		Attrezzo comparator = new Attrezzo();
		Collections.sort(attrezzi, new OrdinatorePerPeso());
		
		return attrezzi;
		
	}
	
	
	/** metodo che restituisce l'insieme degli attrezzi nella borsa
	 * ordinati per nome */
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		
		SortedSet<Attrezzo> ordinata = new TreeSet<>(new OrdinatorePerPeso());
		ordinata.addAll(attrezzi);
		
		return ordinata;
		
	}
	
	
	@Override
	public SortedSet<Attrezzo> ordinaPerNome() {
		
		SortedSet<Attrezzo> ordinata = new TreeSet<>(Comparator.comparing(Attrezzo::getNome));
		ordinata.addAll(attrezzi);
		
		return ordinata;
	}

	
	@Override
	public List<Attrezzo> ordinaPerPeso() {
		
		List<Attrezzo> ordinata = new ArrayList<>(attrezzi);
		Collections.sort(ordinata, Comparator.comparing(Attrezzo::getPeso));
		
		return ordinata;
	}
	
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		
		Map<Integer,Set<Attrezzo>> mappa = new HashMap<>();
		
		for(Attrezzo a : attrezzi ) {
			if(mappa.containsKey(a.getPeso())) {			// se già esiste il peso, devo aggiungere l'attrezzo corrente alla lista giusta
				Set<Attrezzo> temp = mappa.get(a.getPeso());
				temp.add(a);
				mappa.replace(a.getPeso(), temp);
			}
			else {			// altrimenti devo creare una nuova coppia chiave,valore
				Set<Attrezzo> temp = new HashSet<Attrezzo>();
				mappa.put(a.getPeso(), temp);
			}
				
		}
		
		return mappa;
		
	}

	
	
	/**
	 * metodo che restituisce l'insieme degli attrezzi nella borsa ordinati
	 * per peso e quindi, a parità di peso, per nome
	 */
	
	public SortedSet<Attrezzo> getSortedOrdinatoPerPeso() {

		SortedSet<Attrezzo> ordinata = new TreeSet<>(new OrdinatorePerPeso());
		ordinata.addAll(attrezzi);
		
		return ordinata;
	}
	
	
	
	
	
}
	
	
