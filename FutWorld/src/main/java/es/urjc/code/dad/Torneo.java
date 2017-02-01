package es.urjc.code.dad;

import java.util.ArrayList;

public class Torneo {

	private int id;
	private String nombreLiga;
	private ArrayList<Equipo> equipos;
	
	public Torneo(){
		
	}
	
	public Torneo (String nombreLiga, ArrayList<Equipo> equipos){
		this.nombreLiga = nombreLiga;
		this.equipos = equipos;
	}
	
}
