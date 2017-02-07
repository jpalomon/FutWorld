package es.urjc.code.dad;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Equipo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nombreEquipo;
	private String nacionalidadEquipo;
	private int numTorneoGanados;
	
	@OneToMany(mappedBy="equipo")
	private List<Jugador> jugadores;
	
	@ManyToOne
	private Palmares palmares;	
	
	@OneToOne(mappedBy="equipo")
	private Manager manager;
	
	@ManyToOne
	private Torneo torneo;
	
	public Equipo(){
	}
	
	public Equipo (String nombreEquipo,List<Jugador> jugadores,Torneo torneo ,Palmares palmares, String nacionalidadEquipo, int numTorneoGanados){
		this.nombreEquipo = nombreEquipo;
		this.jugadores = jugadores;
		this.torneo = torneo;
		this.palmares = palmares;
		this.nacionalidadEquipo = nacionalidadEquipo;
		this.numTorneoGanados = numTorneoGanados;		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombreEquipo;
	}

	public void setNombre(String nombre) {
		this.nombreEquipo = nombre;
	}

	public String getNacionalidad() {
		return nacionalidadEquipo;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidadEquipo = nacionalidad;
	}

	public int getNumTorneoGanados() {
		return numTorneoGanados;
	}

	public void setNumTorneoGanados(int numTorneoGanados) {
		this.numTorneoGanados = numTorneoGanados;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public Palmares getPalmares() {
		return palmares;
	}

	public void setPalmares(Palmares palmares) {
		this.palmares = palmares;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Torneo getTorneo() {
		return torneo;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}

	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombreEquipo + ", nacionalidad=" + nacionalidadEquipo + ", numTorneoGanados="
				+ numTorneoGanados + ", jugadores=" + jugadores + ", palmares=" + palmares + ", manager=" + manager
				+ ", torneo=" + torneo + "]";
	}

}
