package it.uniroma3.diadia.ambienti;

import java.util.Iterator;
import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaProtected {

	static final protected int NUMERO_MASSIMO_DIREZIONI = 4;
	
	protected String nome;
	protected List<Attrezzo> attrezzi;
	protected int numeroAttrezzi;
	protected Stanza[] stanzeAdiacenti;
	protected int numeroStanzeAdiacenti;
	protected String[] direzioni; 
    protected Partita partita;
	
	/**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public StanzaProtected(String nome) {
        this.nome = nome;
        this.numeroStanzeAdiacenti = 0;
        this.numeroAttrezzi = 0;
        this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
        this.stanzeAdiacenti = new Stanza[NUMERO_MASSIMO_DIREZIONI];
        this.attrezzi = null;
    }
    
    
    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
        boolean agg = false;
    	for(int i=0; i<this.direzioni.length; i++) 
        	if (direzione.equals(this.direzioni[i])) {
        		this.stanzeAdiacenti[i] = stanza; 
        		agg = true;
        	}
    	if (!agg)
    		if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
    			this.direzioni[numeroStanzeAdiacenti] = direzione;
    			this.stanzeAdiacenti[numeroStanzeAdiacenti] = stanza;
    		    this.numeroStanzeAdiacenti++;
    		}
    }
    
    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public List<Attrezzo> getAttrezzi() {
    	return this.attrezzi;
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(String direzione) {
        Stanza stanza = null;
		for(int i=0; i<this.numeroStanzeAdiacenti; i++) {
        	if (this.direzioni[i].equals(direzione)) {
        		stanza = this.stanzeAdiacenti[i];
        	}
		}
        return stanza;
	}

    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    
    public void stampaAttrezzi() {
    	if(numeroAttrezzi == 0)
    		partita.getIo().mostraMessaggio(" - ");		// stanza senza attrezzi
    	else {
	        Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
	        while(iteratore.hasNext()) {
	        	partita.getIo().mostraMessaggio(iteratore.toString());
	        	iteratore.next();
	        }
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
		Iterator<Attrezzo>iteratore = this.attrezzi.iterator();
		while(iteratore.hasNext()) {
			Attrezzo a = iteratore.next();
			if(attrezzi.contains(a) && a.getNome().equals(nomeAttrezzo))
				return true;
			iteratore.next();
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
		Attrezzo a;
		a = null;
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while(iteratore.hasNext()) 
			if(iteratore.equals(nomeAttrezzo))
				return a;
		return a;	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		return attrezzi.remove(attrezzo);
	} 

  
	public String[] getDirezioni() {
		String[] direzioni = new String[this.numeroStanzeAdiacenti];
	    for(int i=0; i<this.numeroStanzeAdiacenti; i++) {
	    	direzioni[i] = this.direzioni[i];
	    }
	    return direzioni;
    } 

	
	
	/**
	 * funzione che mostra i dati di una stanza 
	 */
	public String getDescrizione() {
		StringBuilder descrizione = new StringBuilder();
		
		descrizione.append(this.getNome());
		descrizione.append("\nUscite: ");
		for(String direzione : this.getDirezioni())
			if(direzione != null)
				descrizione.append(" " + direzione);
			else
				descrizione.append(", " + direzione);
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
