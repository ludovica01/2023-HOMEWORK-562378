package it.uniroma3.diadia.ambienti;

import java.util.Map;
import java.util.HashMap;
import it.uniroma3.diadia.attrezzi.*;


public class LabirintoBuilder extends Labirinto {

	private Labirinto labirinto;
	private Map<String,Stanza> nome2stanza;
	private Stanza ultimaAggiunta;
	
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	 
	public Map<String,Stanza> getListaStanze(){
		return nome2stanza;
	} 
	
  
	public LabirintoBuilder() { 
		this.nome2stanza = new HashMap<>();
		 this.labirinto = new Labirinto();
	}  

	public LabirintoBuilder addStanzaIniziale(String nomeStanza) {
		Stanza stanzaCorrente = new Stanza(nomeStanza);
		this.labirinto.setStanzaCorrente(stanzaCorrente);
		ultimaAggiunta = stanzaCorrente;
		this.nome2stanza.put(nomeStanza, stanzaCorrente);
		return this;  
	}


	public LabirintoBuilder addStanzaVincente(String nomeStanza) {
		Stanza stanzaVincente = new Stanza(nomeStanza);
		this.labirinto.setStanzaVincente(stanzaVincente);
		this.nome2stanza.put(nomeStanza, stanzaVincente);
		return this;
	}
  
  
 
	public LabirintoBuilder addAdiacenza(String stanzaBase, String stanzaAdi, String direzione) {
		if(nome2stanza.containsKey(stanzaBase) && nome2stanza.containsKey(stanzaAdi))
			this.nome2stanza.get(stanzaBase).impostaStanzaAdiacente(direzione, nome2stanza.get(stanzaAdi));
		return this;  
	}        
 
	public LabirintoBuilder addStanza(String nomStanza) {
		Stanza stanzaN = new Stanza(nomStanza);
		this.nome2stanza.put(nomStanza, stanzaN);
		ultimaAggiunta = stanzaN;
		return this; 
	}
	   
	public LabirintoBuilder addStanzaBloccata(String nomStanza, Attrezzo attr, String direzioneOut) {
		Stanza stanzaN = new StanzaBloccata(nomStanza, attr , direzioneOut);
		this.nome2stanza.put(nomStanza, stanzaN);
		ultimaAggiunta = stanzaN;  
		return this;
	}
	
	public LabirintoBuilder addStanzaBuia(String nomStanza, Attrezzo attrezzo) {
		Stanza stanzaN = new StanzaBuia(nomStanza,attrezzo);
		this.nome2stanza.put(nomStanza, stanzaN);
		ultimaAggiunta = stanzaN;
		return this;
	}
	 
	public LabirintoBuilder addStanzaMagica(String nomStanza) {
		Stanza stanzaN = new StanzaMagica(nomStanza);
		this.nome2stanza.put(nomStanza, stanzaN);
		ultimaAggiunta = stanzaN; 
		return this; 
	} 
	 
	public LabirintoBuilder addStanzaMagica(String nomStanza,int soglia) {
		Stanza stanzaN = new StanzaMagica(nomStanza,soglia);
		this.nome2stanza.put(nomStanza, stanzaN);
		ultimaAggiunta = stanzaN;
		return this;
	}

	public LabirintoBuilder addAttrezzo(String nomeA, int peso) {
		Attrezzo a = new Attrezzo(nomeA,peso);
		this.nome2stanza.get(ultimaAggiunta.getNome()).addAttrezzo(a);
		return this;
	} 

	
	

	

}