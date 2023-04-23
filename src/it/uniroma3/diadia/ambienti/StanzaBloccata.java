package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;


public class StanzaBloccata extends Stanza {
	
	private Attrezzo chiave;	// attrezzo che sblocca la direzione sbloccata
	private String dirBloccata;				// direzione bloccata se l'attrezzo non è presente nella stanza

	
	public StanzaBloccata(String nome, Attrezzo attr, String dir) {
		super(nome);
		this.chiave = attr;
		this.dirBloccata = dir;
	}
	
	
	public Attrezzo getChiave() {
		return this.chiave;
	}

	public void setChiave(Attrezzo chiave) {
		this.chiave = chiave;
	}

	
	public Boolean isBloccata() {
		return true;
	}
	
	/**
	 * funzione che data una stanza prende una direzione bloccata e un attrezzo che la sblocchi
	 */
	@Override
	public Stanza getStanzaAdiacente(String dir) {
		Stanza st = null;
		if(!this.hasAttrezzo(chiave.getNome()) && dir.equals(dirBloccata))
			st = this;			// ritorno riferimento alla stanza corrente
		else
			st = super.getStanzaAdiacente(dir);
		return st;			// altrimenti richiamo la funzione della superclasse
	}
	
	@Override
	public String getDescrizione() {
		
		StringBuilder descrizione = new StringBuilder();
		descrizione.append(this.getNome());
		descrizione.append("\nUscite: ");
		for(String direzione : this.getDirezioni())
			if(direzione!=null) 
				descrizione.append(" " + direzione + "(bloccata usa " + this.chiave + ")");
			else
				descrizione.append(", " + direzione);
		descrizione.append("\nAttrezzi nella stanza: ");
		for(Attrezzo attrezzo : this.getAttrezzi())
			if(attrezzo != null)
				descrizione.append(attrezzo.toString() + " ");
		
		return descrizione.toString();
		
		
//		partita.getIo().mostraMessaggio("Sei nella stanza: " + this.getNome() + ", che del tipo StanzaBloccata\nAttrezzi nella stanza: "
//				+ "\nL'attrezzo che la sblocca è: " + this.attrezzoNecessario.toString());
//		getAttrezzi();
	}
	
	
	

}
