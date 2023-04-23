package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {

	@Override
	public void esegui(Partita partita) {
		partita.getIo().mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
	
	}
	

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNome() {
		return  "ComandoGuarda";
	}

	@Override
	public String getParametro() {
		return "-";
		
	}

}
