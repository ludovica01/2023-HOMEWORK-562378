package it.uniroma3.diadia.ambienti;

public class Labirinto {
	
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	
	public Stanza getStanzaCorrente() {
		return stanzaCorrente;
	}   
	
	public Stanza getStanzaVincente() { 
		return stanzaVincente;
	}
	  
	public void setStanzaCorrente(Stanza stanzacorrente) {
		this.stanzaCorrente = stanzacorrente;
	}
	
	public void setStanzaVincente(Stanza stanzavincente) {
		this.stanzaVincente = stanzavincente;
	}
	
	
	
}
