package it.polito.tdp.PremierLeague.model;

public class Statistiche {
	 private int mediaReporter;
	 private int nPartiteCritiche;
	 
	public int getMediaReporter() {
		return mediaReporter;
	}
	public void setMediaReporter(int mediaReporter) {
		this.mediaReporter = mediaReporter;
	}
	public int getnPartiteCritiche() {
		return nPartiteCritiche;
	}
	public void setnPartiteCritiche(int nPartiteCritiche) {
		this.nPartiteCritiche = nPartiteCritiche;
	}
	public Statistiche(int mediaReporter, int nPartiteCritiche) {
		super();
		this.mediaReporter = mediaReporter;
		this.nPartiteCritiche = nPartiteCritiche;
	}
	 
	
	 
}
