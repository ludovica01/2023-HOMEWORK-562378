package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {

	public void esegui(Partita partita) {
		partita.getIo().mostraMessaggio("comando non valido: inseriscine un altro");
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNome() {
		return "ComandoNonValido";
	}

	@Override
	public String getParametro() {
		return "-";
		
	}
	
}
