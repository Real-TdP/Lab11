package it.polito.tdp.model;

public class Model {

	public Model() {
	}
	
	
	public Statistiche Simula(int num_gruppi) {
		Simulazione sim = new Simulazione(num_gruppi);
		Statistiche sta=sim.run();
		return sta;
	}

}
