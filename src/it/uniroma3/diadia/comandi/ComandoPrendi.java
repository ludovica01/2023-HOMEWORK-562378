package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoPrendi implements Comando {
	
	IOConsole ioConsole;
	private String attrezzo;
	/*
	 * Comando prendi: gli attrezzi presi vengono rimossi dalla stanza e aggiunti alla borsa
	 */
	@Override
	public void esegui(Partita partita) {
		if(attrezzo == null) 
			partita.getIo().mostraMessaggio("Quale attrezzo vuoi prendere?");
		else if(!partita.getLabirinto().getStanzaCorrente().hasAttrezzo(attrezzo))
			partita.getIo().mostraMessaggio("L'attrezzo che stai cercando non è presente nella stanza corrente");
		else if(!partita.getGiocatore().getBorsa().addAttrezzo(partita.getLabirinto().getStanzaCorrente().getAttrezzo(attrezzo)))
			partita.getIo().mostraMessaggio("Non puoi prendere l'attrezzo, hai raggiunto il peso massimo"); 
		else {
			partita.getLabirinto().getStanzaCorrente().removeAttrezzo(partita.getLabirinto().getStanzaCorrente().getAttrezzo(attrezzo));
			partita.getIo().mostraMessaggio("Attrezzo preso");
		}
	}

	@Override
	public void setParametro(String nomeAttrezzo) {
		this.attrezzo = nomeAttrezzo;
		
	}

	@Override
	public String getNome() {
		return "ComandoPrendi";
	}

	@Override
	public String getParametro() {
		return attrezzo;
	}

	

}
