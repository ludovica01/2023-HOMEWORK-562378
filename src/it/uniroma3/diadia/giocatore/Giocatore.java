package it.uniroma3.diadia.giocatore;

public class Giocatore {

	private int cfu;
	static final private int CFU_INIZIALI = 20; 
	private Borsa borsa;

	public Giocatore(){
		this.borsa = new Borsa();
		this.cfu = CFU_INIZIALI;
	} 
		/*
		 * retituisce il numero di CFU
		 */
		public int getCfu() {
			return this.cfu;
		}
	
		/* 
		 * imposta il numero di CFU
		 */
		public void setCfu(int cfu) {
			this.cfu = cfu;		
		}	
		
		public Borsa getBorsa() {
			return this.borsa;
		}
		
		
}
