package it.polito.tdp.librettovoti.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Libretto {

	private List<Voto> voti;
	private Map<String, Voto> votiMap; //Identity map
	
	public Libretto() {
		this.voti = new ArrayList<>();
		this.votiMap = new HashMap<>();
	}
	
	public void add(Voto v) {
		voti.add(v);
		this.votiMap.put(v.getNome(), v);
	}
	/*
	public void stampaVotiUguali(int punteggio) {
		
	}
	
	public String votiUguali(int punteggio) {
		//Calcola String voti
		//poi il chiamante se vuole stampa
	}
	*/
	
	public List<Voto> listaVotiUguali(int punteggio){
		List<Voto> risultato = new ArrayList<Voto>();
		for(Voto v : voti) {
			if(v.getVoto() == punteggio) {
				risultato.add(v);
			}
		}
		return risultato;
	}
	
	public String toString() {
		String s = "";
		for(Voto v : voti) {
			s += v.toString()+"\n";
		}
		return s;
	}
	
	
	public boolean esisteDuplicato(Voto v) {
//		boolean trovato = false;
//		for(Voto voto : this.voti) {
//			if(voto.getNome().equals(v.getNome()) && voto.getVoto() == v.getVoto()) {
//				trovato = true;
//				break;
//			}
//		}
//		return trovato;
		
		Voto trovato = this.votiMap.get(v.getNome());
		if(trovato == null) {
			return false;
		}
		if(trovato.getVoto() == v.getVoto()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean esisteConflitto(Voto v) {
		boolean trovato = false;
		for(Voto voto : this.voti) {
			if(voto.getNome().equals(v.getNome()) && voto.getVoto() != v.getVoto()) {
				trovato = true;
				break;
			}
		}
		return trovato;
	}
}
