package es.urjc.code.dad;

import java.util.ArrayList;

public class Torneo {

	private long id;
	private String nombreLiga;
	private ArrayList<Equipo> equipos;
	
	public Torneo(){
		id = 0;
	}
	
	public Torneo (String nombreLiga, ArrayList<Equipo> equipos){
		this.nombreLiga = nombreLiga;
		this.equipos = equipos;
	}

	public long getId() {
		return id;
	} 

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreLiga() {
		return nombreLiga;
	}

	public void setNombreLiga(String nombreLiga) {
		this.nombreLiga = nombreLiga;
	}

	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
	}	
}
