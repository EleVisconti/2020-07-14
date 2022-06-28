package it.polito.tdp.PremierLeague.model;


public class Event implements Comparable<Event>{

	public enum EventType {
		VINCITA,
		PERDITA,
		PAREGGIO
	}
	
	private Match partita;
    private double prob;
    private int n_reporter;
    private EventType type;
    
    
	public Event(Match partita, double prob, int n_reporter, EventType type) {
		super();
		this.partita = partita;
		this.prob = prob;
		this.n_reporter = n_reporter;
		this.type = type;
	}

	




	public Match getPartita() {
		return partita;
	}






	public void setPartita(Match partita) {
		this.partita = partita;
	}






	public double getProb() {
		return prob;
	}






	public void setProb(double prob) {
		this.prob = prob;
	}






	public int getN_reporter() {
		return n_reporter;
	}






	public void setN_reporter(int n_reporter) {
		this.n_reporter = n_reporter;
	}






	public EventType getType() {
		return type;
	}






	public void setType(EventType type) {
		this.type = type;
	}






	@Override
	public int compareTo(Event o) {
		// TODO Auto-generated method stub
		return this.partita.getDate().compareTo(o.partita.getDate());
	}

}
