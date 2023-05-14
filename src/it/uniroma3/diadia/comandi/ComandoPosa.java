package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	
	private String attrezzo;
	
	/*
	 * Comando posa : gli attrezzi posati vengono rimossi dalla borsa e aggiunti alla stanza
	 */

	@Override
	public void esegui(Partita partita) {
		if(attrezzo == null) 
			partita.getIo().mostraMessaggio("Che attrezzo vuoi posare?");
		else if(!partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo))
			partita.getIo().mostraMessaggio("Attrezzo non presente in borsa");
		else if(!partita.getLabirinto().getStanzaCorrente().addAttrezzo(partita.getGiocatore().getBorsa().getAttrezzo(attrezzo)))
			partita.getIo().mostraMessaggio("Impossibile posare l'attrezzo: stanza piena"); 
		else {
			partita.getIo().mostraMessaggio(attrezzo.toString() + " posato"); 
			partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo);
		}
		
	}

	@Override
	public void setParametro(String nomeAttrezzo) {
		this.attrezzo = nomeAttrezzo;
	}

	@Override
	public String getNome() {
		return "ComandoPosa";
	}

	@Override
	public String getParametro() {
		return attrezzo;
	}

	
}
