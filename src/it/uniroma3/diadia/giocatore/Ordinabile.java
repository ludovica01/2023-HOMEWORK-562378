package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import java.util.List;
import java.util.SortedSet;


public interface Ordinabile {
	
	SortedSet<Attrezzo> ordinaPerNome();
	List<Attrezzo> ordinaPerPeso();

}
