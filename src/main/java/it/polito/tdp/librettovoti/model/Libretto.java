package it.polito.tdp.librettovoti.model;

import java.util.ArrayList;
import java.util.List;

public class Libretto {

	private List<Voto> voti;
	
	public Libretto() {
		this.voti = new ArrayList<>();
	}
	
	public void add(Voto v) {
		voti.add(v);
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
}
