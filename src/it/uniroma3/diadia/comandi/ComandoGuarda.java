package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {
	
	private String oggetto;				// per definire se si voglia vedere contenuto della stanza o della borsa

	
	/**
	 * stampa le informazioni della situazione corrente della partita
	 * si può decidere se visualizzare lo stato della borsa del giocatore
	 * oppure perlustrare la stanza corrente
	 */
	@Override
	public void esegui(Partita partita) {
		
		if(oggetto == null) {
			partita.getIo().mostraMessaggio("Cosa vuoi vedere? Specifica se la borsa o la stanza");
			return;
		}
		// vuoi vedere la borsa?
		if(oggetto.equals("borsa")) {
			// stampi gli attrezzi della borsa ordinati per peso
			partita.getIo().mostraMessaggio(partita.getGiocatore().getBorsa().toString());

		}
		// vuoi vedere la stanza?
		else if(oggetto.equals("stanza")) {
			partita.getIo().mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
			
		}
		
	
	}
	

	@Override
	public void setParametro(String parametro) {
		this.oggetto = parametro;
	}

	@Override
	public String getNome() {
		return  "ComandoGuarda";
	}

	@Override
	public String getParametro() {
		return oggetto;
		
	}

}


