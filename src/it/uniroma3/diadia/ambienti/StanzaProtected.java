package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaProtected {

	static final protected int NUMERO_MASSIMO_DIREZIONI = 4;
	static final protected int NUMERO_MASSIMO_ATTREZZI = 10;
	
	protected String nome;
	protected Attrezzo[] attrezzi;
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
        this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
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

    

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public void getAttrezzi() {
    	if(numeroAttrezzi == 0)
    		System.out.println(" - ");		// stanza senza attrezzi
    	else {
	        for(int i=0; i<numeroAttrezzi; i++) {
	        	System.out.println(attrezzi[i].toString());
	        }
    	}
    }
 
    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
    	boolean valore =false;
        if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
        	this.attrezzi[numeroAttrezzi] = attrezzo;
        	this.numeroAttrezzi++;
        	valore = true; 
        }
        return valore;
    }

   

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato;
		trovato = false;
		for (int i=0 ; i<numeroAttrezzi; i++) {
			if(attrezzi[i]!= null) {	
				if (attrezzi[i].getNome().equals(nomeAttrezzo)) {
					trovato = true;
				}
			}
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
		for (int i=0 ; i<numeroAttrezzi; i++) {
			if(attrezzi[i]!= null) {	
				if (attrezzi[i].getNome().equals(nomeAttrezzo)) {
					a = attrezzi[i];
				}
			}
		}
		return a;	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		boolean removed;
		removed = false; 

		for(int i=0; i<numeroAttrezzi; i++) {
			if(attrezzi[i]!= null) {	
				if(attrezzi[i].equals(attrezzo)) {
					attrezzi[i]= null;
					this.numeroAttrezzi --;
					removed = true;
				}
			}
		}
		return removed;
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
	public void getDescrizione() {
		partita.getIo().mostraMessaggio("Sei nella stanza: " + this.getNome() + "\nAttrezzi nella stanza: ");
		getAttrezzi();
	}
	
	public Boolean isBloccata() {
		return false;
	}
	
	public Boolean bloccaDirezione(Partita partita, String dir) {
		return false;
	}
}
