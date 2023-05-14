package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza  
 * @version base
 */

public class Partita {
 
	private Giocatore giocatore;
	public Labirinto labirinto;
	private boolean finita;
	public IOConsole io;
	
	public Partita() {
		this.labirinto = new Labirinto();
		this.finita = false;
		this.giocatore = new Giocatore();
		this.io = new IOConsole();
	}
	
	public Partita(Labirinto labirinto) {
		this.labirinto = labirinto;
		this.finita = false;
		this.giocatore = new Giocatore();
		this.io = new IOConsole();
	}
	
	
	
	public IOConsole getIo() {
		return io;
	}


	public void setIo(IOConsole io) {
		this.io = io;
	}


	/** 
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.labirinto.getStanzaCorrente() == this.labirinto.getStanzaVincente();
	} 

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || this.giocatore.getCfu()==0;
	}
  
	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}
	
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	
	public boolean giocatoreIsVivo() {
		if(this.getGiocatore().getCfu()==0) 
			return false;
		else
			return true;
	}
}
