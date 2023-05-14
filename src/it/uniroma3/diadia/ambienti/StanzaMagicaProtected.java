package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected {

	protected int contatoreAttrezziPosati;
	protected int sogliaMagica;
	protected static final int SOGLIA_MAGICA_DEFAULT = 3;
	
	
	public StanzaMagicaProtected(String nome, int soglia) {
		super(nome);
		this.sogliaMagica = soglia;
		this.contatoreAttrezziPosati = 0;

	}
	
	public StanzaMagicaProtected(String nome) {
		this(nome,SOGLIA_MAGICA_DEFAULT);

	}


	
	/**
	 * nuovo metodo per cambiare ordine lettere nel nome e raddoppiare il peso
	 * 	RESTITUISCE UN NUOVO ATTREZZO
	 */
	public Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		if(contatoreAttrezziPosati>sogliaMagica) {			// controlla se la stanza deve comportarsi da stanza magica
			StringBuilder nomeInvertito;
			int pesoDoppio = attrezzo.getPeso()*2;
			nomeInvertito = new StringBuilder(attrezzo.getNome());
			nomeInvertito = nomeInvertito.reverse();
			Attrezzo nuovo = new Attrezzo(nomeInvertito.toString(), pesoDoppio);
			return nuovo;
		}
		return attrezzo;
	}
	
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.contatoreAttrezziPosati++;
		if(this.contatoreAttrezziPosati > this.sogliaMagica)
			attrezzo = this.modificaAttrezzo(attrezzo);
		return super.addAttrezzo(attrezzo);
	}
	
	

	
	
}
