package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi" , "posa", "guarda"};
	
	/**
	 * Stampa informazioni di aiuto.
	 */
	@Override
	public void esegui(Partita partita) {
		StringBuilder s = new StringBuilder();
		for(int i=0; i<elencoComandi.length; i++) {
			s.append(elencoComandi[i] + " ");
		}
		partita.getIo().mostraMessaggio(s.toString());
		
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNome() {
		return "ComandoAiuto";
	}

	@Override
	public String getParametro() {
		return "-";
		
	} 

}
