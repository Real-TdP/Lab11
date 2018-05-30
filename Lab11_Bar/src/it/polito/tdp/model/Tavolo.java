package it.polito.tdp.model;

public class Tavolo implements Comparable<Tavolo> {
	private int posti;
	private boolean free;
	private Gruppo g;
	public Tavolo(int posti, boolean free) {
		this.posti = posti;
		this.free = free;
	}
	public int getPosti() {
		return posti;
	}
	public void setPosti(int posti) {
		this.posti = posti;
	}
	public boolean isFree() {
		return free;
	}
	public void setFree(boolean free) {
		this.free = free;
	}
	public Gruppo getG() {
		return g;
	}
	public void setG(Gruppo g) {
		this.g = g;
	}
	@Override
	public int compareTo(Tavolo arg0) {
		// TODO Auto-generated method stub
		return this.getPosti()-arg0.getPosti();
	}
	
	
	

}
