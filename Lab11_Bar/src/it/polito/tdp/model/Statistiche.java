package it.polito.tdp.model;

public class Statistiche {
	private int clienti_soddisfatti;
	private int clienti_insoddisfatti;
	private int clienti_number;
	
	public Statistiche() {
		this.clienti_soddisfatti = 0;
		this.clienti_insoddisfatti = 0;
		this.clienti_number =0;
	}

	public int getClienti_soddisfatti() {
		return clienti_soddisfatti;
	}

	public void upClienti_soddisfatti(int clienti_soddisfatti) {
		this.clienti_soddisfatti+=clienti_soddisfatti;;
	}

	public int getClienti_insoddisfatti() {
		return clienti_insoddisfatti;
	}

	public void upClienti_insoddisfatti(int clienti_insoddisfatti) {
		this.clienti_insoddisfatti+=clienti_insoddisfatti;
	}

	public int getClienti_number() {
		return clienti_number;
	}

	public void upClienti_number(int clienti_number) {
		this.clienti_number += clienti_number;
	}
	
	
	

}
