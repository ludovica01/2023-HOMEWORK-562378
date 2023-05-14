package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	
	private String direzione;
	

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra  
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		Stanza prossimaStanza = null;
		
		if(direzione==null) {
			partita.getIo().mostraMessaggio("Dove vuoi andare? Specifica una direzione"); 
			return;
		}
		/** sei in una stanza bloccata? **/
		if(partita.getLabirinto().getStanzaCorrente().isBloccata())
			if(partita.labirinto.getStanzaCorrente().bloccaDirezione(partita,direzione))
				partita.getIo().mostraMessaggio("Non puoi andare verso " + direzione + " perchè è bloccata!");
			else
				prossimaStanza = stanzaCorrente.getStanzaAdiacente(direzione);
		else
			prossimaStanza = stanzaCorrente.getStanzaAdiacente(direzione);
		

		if (prossimaStanza == null) {
			partita.getIo().mostraMessaggio("Stanza inesistente!");
			return;
		}
		else { 
			partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = partita.getGiocatore().getCfu();
			partita.getGiocatore().setCfu(cfu--); 
		} 
		partita.getIo().mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getNome()); 
	} 
	
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}

	@Override
	public String getNome() {
		return "ComandoVai";
	}

	@Override
	public String getParametro() {
		return direzione;
	}
	
	

}
