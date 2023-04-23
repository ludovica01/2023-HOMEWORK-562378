package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando{

	@Override
	public void esegui(Partita partita) {
		partita.getIo().mostraMessaggio("Grazie di aver giocato!");  	// si desidera smettere

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNome() {
		return "ComandoFine";
	}

	@Override
	public String getParametro() {
		return "-";		
	}

}
