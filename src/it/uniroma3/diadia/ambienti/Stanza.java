package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.uniroma3.diadia.Partita;


/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base 
*/

public class Stanza {
	
	String nome;
    private List<Attrezzo> attrezzi;
    protected Map<String,Stanza> stanzeAdiacenti;
	private Partita partita;
	
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.stanzeAdiacenti = new HashMap<>();
        this.attrezzi = new ArrayList<>();
        this.nome = nome;
    }
    
    public String getNome() {
    	return this.nome;
    }
    
    
    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
    	this.stanzeAdiacenti.put(direzione, stanza);
    }
    
    public List<Attrezzo> getAttrezzi() {
    	return this.attrezzi;
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(String direzione) {
        return this.stanzeAdiacenti.get(direzione);
	}

    
    

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public void stampaAttrezzi() {
    	if(attrezzi.isEmpty())
    		partita.getIo().mostraMessaggio(" - ");		// stanza senza attrezzi
    	else {
	        for(Attrezzo a : attrezzi)
	        	a.toString();
    	}
    }
 
    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
    	return attrezzi.add(attrezzo);
    }

   

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato;
		trovato = false;
		for(Attrezzo a : attrezzi) {
			if(attrezzi.contains(a) && a.getNome().equals(nomeAttrezzo))
				return true;
		}
		return trovato;
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		for(Attrezzo a : attrezzi) {
        	if(a.getNome().equals(nomeAttrezzo)) {
        		return a;
        	}
        }
		return null;	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		return attrezzi.remove(attrezzo);
	} 

	
	
	
	/**
	 * funzione che mostra i dati di una stanza 
	 */
	public String getDescrizione() {
		StringBuilder descrizione = new StringBuilder();
		
		descrizione.append(this.getNome());
		descrizione.append("\nUscite: ");
		descrizione.append(stanzeAdiacenti.keySet());
		descrizione.append("\nAttrezzi nella stanza: ");
		for(Attrezzo attrezzo : this.attrezzi)
			if(attrezzo != null)
				descrizione.append(attrezzo.toString());
		
		
		return descrizione.toString();
	}
	
	public Boolean isBloccata() {
		return false;
	}
	
	public Boolean bloccaDirezione(Partita partita, String dir) {
		return false;
	}
}