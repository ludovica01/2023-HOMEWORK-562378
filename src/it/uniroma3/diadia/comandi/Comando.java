package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;

/**
 * Questa classe modella un comando.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * (Ad es. alla riga digitata dall'utente "vai nord"
 *  corrisponde un comando di nome "vai" e parametro "nord").
 *
 * @author  docente di POO
 * @version base
 */


public interface Comando {
	
	public String getNome();
	
	public String getParametro();
	
	/**
	 * esecuzione del comando
	 */
	public void esegui(Partita partita);
	
	/**
	 * set parametro del comando (non utile per tutte le classi)
	 */
	public void setParametro(String parametro);
	
	
}
