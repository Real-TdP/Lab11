package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Simulazione {
	
	private enum EventType {
		ARRIVO_GRUPPO_CLIENTI,OUT_SODDISFATTO;
	}
	
	//PARAMETRI
	private int time_last_group;   //ORARIO DI ARRIVO DELL'ULTIMO GRUPPO
	
	private List<Tavolo> tavoli = new ArrayList<Tavolo>();

	private PriorityQueue<Event> pq;
	
	public Simulazione(int num_gruppi) {
		//INIZIALIZZO I CONTATORI RELATIVI AI TAVOLI LIBERI IN UN DATO MOMENTO
		for(int i=0;i<5;i++)
			tavoli.add(new Tavolo(4,true));
		for(int i=0;i<4;i++)
			tavoli.add(new Tavolo(6,true));
		for(int i=0;i<4;i++)
			tavoli.add(new Tavolo(8,true));
		for(int i=0;i<2;i++)
			tavoli.add(new Tavolo(10,true));

		Collections.sort(tavoli);
		
		this.time_last_group=0;
		this.pq = new PriorityQueue<Event>();
		for(int i=0;i<num_gruppi;i++) {
			time_last_group+=(int)Math.random()*9+1;
			Gruppo g= new Gruppo(time_last_group);
			pq.add(new Event(EventType.ARRIVO_GRUPPO_CLIENTI,time_last_group,g));	
		}
		
	}
	
	public Statistiche run() {

		Statistiche sta = new Statistiche();
		Event e;
		while((e=pq.poll())!=null) {
			this.processEvent(e,sta);
		}
		return sta;
	}
	public void processEvent(Event e,Statistiche sta) {
		switch(e.getType()) {
		
		case ARRIVO_GRUPPO_CLIENTI:
			Gruppo g=e.getG();
			sta.upClienti_number(g.getNum_persone());
			for(Tavolo t:tavoli) {
				if(t.isFree()&& g.getNum_persone()<=t.getPosti() && g.getNum_persone() >= t.getPosti()*0.5) {
					g.setTavolo(t);
					t.setFree(false);
					t.setG(g);
					pq.add(new Event(EventType.OUT_SODDISFATTO,g.getTime_uscita_seAccomodato(),g));
					break;
				}
			}
			
			if(g.getTolleranza()>=0.5&&g.getTavolo()==null)
				sta.upClienti_soddisfatti(g.getNum_persone());
			else if(g.getTolleranza()<0.5&&g.getTavolo()==null)
				sta.upClienti_insoddisfatti(g.getNum_persone());
				
			break;
		case OUT_SODDISFATTO:
			Gruppo h = e.getG();
			sta.upClienti_soddisfatti(h.getNum_persone());
			h.getTavolo().setFree(true);
			h.getTavolo().setG(null);

			break;
		}
		
	}
	
	//EVENTO
	private class Event implements Comparable<Event> {	
		private EventType type;
		private int time;
		private Gruppo g;
	
		public Event(EventType type,int time,Gruppo g) {
			this.type = type;
			this.time=time;
			this.g=g;
		}

		public EventType getType() {
			return type;
		}
		public int getTime() {
			return time;
		}
		public Gruppo getG() {
			return g;
		}

		@Override
		public int compareTo(Event e2) {
			return this.time-e2.time;
		}
		
		
		
	}

}
