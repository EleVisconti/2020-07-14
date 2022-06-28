package it.polito.tdp.PremierLeague.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.PremierLeague.db.PremierLeagueDAO;


public class Model {
	PremierLeagueDAO dao;
	List<Team> squadre = new ArrayList<Team>();
	Map<Integer, Team> squadreMap;
	private Graph<Team, DefaultWeightedEdge> grafo;

	public Model() {
		this.dao = new PremierLeagueDAO();
		this.squadre = dao.listAllTeams();
		this.squadreMap = new HashMap<Integer, Team>();
		for(Team t : squadre) {
			this.squadreMap.put(t.getTeamID(), t);
		}
	} 
	
	public void creaGrafo() {
		grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		//aggiuta vertici 
		Graphs.addAllVertices(this.grafo, squadre);
		
		//aggiunta punti squadre
		for(Team s : squadre){
			this.dao.setPunteggioVinte(s.getTeamID(), squadreMap);
			this.dao.setPunteggioPari(s.getTeamID(), squadreMap);
		}
		
		for(Team t1 : squadre) {
			for(Team t2 : squadre) {
				if(!t1.equals(t2)) {
					int peso = t1.getPunteggio()-t2.getPunteggio();
					if(peso>0)
						Graphs.addEdge(this.grafo, t1, t2, peso);
					if(peso<0)
						Graphs.addEdge(this.grafo, t2, t1, (-peso));
				}
				 
			}
		}
	}
	
	public int nVertici() {
		return this.grafo.vertexSet().size();
	}
	
	public int nArchi() {
		return this.grafo.edgeSet().size();
	}

	public List<Team> getSquadre() {
		return squadre;
	}

	public void setSquadre(List<Team> squadre) {
		this.squadre = squadre;
	}
	
	public String squadreBattute(int squadraId){
		String st="";
		List<Team> squadreB = new ArrayList<Team>();
		for(Team s : this.squadre)
			if(!s.equals(squadreMap.get(squadraId))) {
			if(s.getPunteggio()<squadreMap.get(squadraId).getPunteggio())
				squadreB.add(s);}
		Collections.sort(squadreB);
		if(squadreB.size()!=0)
	    st = "\nSQUADRE PEGGIORI:";
		for(Team t : squadreB)
			st+="\n"+t.name+"("+(squadreMap.get(squadraId).getPunteggio()-t.getPunteggio())+")";
		return st;
	}
	
	public String squadreMigliori(int squadraId){
		String st = "\nSQUADRE MIGLIORI:";
		List<Team> squadreM = new ArrayList<Team>();
		for(Team s : this.squadre)
			if(!s.equals(squadreMap.get(squadraId))) {
			if(s.getPunteggio()>=squadreMap.get(squadraId).getPunteggio())
				squadreM.add(s);}
		Collections.sort(squadreM);
		for(Team t : squadreM)
			st+="\n"+t.name+"("+(t.getPunteggio()-squadreMap.get(squadraId).getPunteggio())+")";
		return st;
	}
	
	//simulazione

	
	
}
