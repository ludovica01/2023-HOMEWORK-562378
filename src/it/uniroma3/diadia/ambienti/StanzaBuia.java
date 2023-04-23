package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;


public class StanzaBuia extends Stanza {
	
	private Attrezzo attrezzoBuio;

	public StanzaBuia(String nome, Attrezzo attrezzoBuio) {
		super(nome);
		this.attrezzoBuio = attrezzoBuio;
    }

	
	@Override
	public String getDescrizione() {
		StringBuilder descrizione = new StringBuilder();
		if(!this.hasAttrezzo(attrezzoBuio.getNome())) {				// se non ha quell'attrezzo
			descrizione.append("qui c'è buio pesto");
			
		}
		else {
			descrizione.append(this.getNome());
			descrizione.append("\nUscite: ");
			for(String direzione : this.getDirezioni())
				if(direzione != null)
					descrizione.append(" " + direzione);
				else
					descrizione.append(", " + direzione);
			descrizione.append("\nAttrezzi nella stanza: ");
			for(Attrezzo attrezzo : this.getAttrezzi())
				if(attrezzo != null)
					descrizione.append(attrezzo.toString());
		
		}
		return descrizione.toString();
	}

}
