package it.polito.tdp.model;

public class Gruppo {
	private int num_persone;
	private float tolleranza;
	private int time_arrivo;
	private int time_uscita_seAccomodato;
	private Tavolo tavolo;

	public Gruppo(int t_arrivo) {
		num_persone=(int)(Math.random()*9)+1;
		time_arrivo=t_arrivo;
		time_uscita_seAccomodato=time_arrivo+(int)Math.random()*(60)+60;
		tolleranza=(float)(Math.random());
		tavolo=null;
	}

	public int getNum_persone() {
		return num_persone;
	}

	public float getTolleranza() {
		return tolleranza;
	}

	public int getTime_arrivo() {
		return time_arrivo;
	}

	public int getTime_uscita_seAccomodato() {
		return time_uscita_seAccomodato;
	}

	public Tavolo getTavolo() {
		return tavolo;
	}

	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}
	
	
	

}
