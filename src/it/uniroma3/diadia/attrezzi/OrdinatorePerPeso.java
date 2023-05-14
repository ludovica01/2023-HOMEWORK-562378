package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;


public class OrdinatorePerPeso implements Comparator<Attrezzo> {

	@Override
	public int compare(Attrezzo a1, Attrezzo a2) {
		
		int ris = a1.getPeso() - a2.getPeso();
		
		if(ris != 0)
			return ris;
		// se il peso è lo stesso, ordino sul nome
		return a1.getNome().compareTo(a2.getNome());
	}
	
}
