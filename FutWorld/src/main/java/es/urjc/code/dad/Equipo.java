package es.urjc.code.dad;

import java.util.ArrayList;

public class Equipo {
	
	private long id;
	private String nombre;
	private ArrayList<Jugador> jugadores;
	private Palmares palmares;
	private String nacionalidad;
	private long valorMercado;
	
	public Equipo(){
		id = 0;
	}
	
	public Equipo (String nombre,ArrayList<Jugador> jugadores, Palmares palmares, String nacionalidad, long valorMercado){
		this.nombre = nombre;
		this.jugadores = jugadores;
		this.palmares = palmares;
		this.nacionalidad = nacionalidad;
		this.valorMercado = valorMercado;		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public Palmares getPalmares() {
		return palmares;
	}

	public void setPalmares(Palmares palmares) {
		this.palmares = palmares;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public long getValorMercado() {
		return valorMercado;
	}

	public void setValorMercado(long valorMercado) {
		this.valorMercado = valorMercado;
	}	
	
}
