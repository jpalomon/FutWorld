package es.urjc.code.dad;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Torneo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nombreLiga;
	
	@OneToMany(mappedBy= "torneo")
	private List<Equipo> equipos;
	
	public Torneo(){
	}
	
	public Torneo (String nombreLiga, List<Equipo> equipos){
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

	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	@Override
	public String toString() {
		return "Torneo [id=" + id + ", nombreLiga=" + nombreLiga + ", equipos=" + equipos + "]";
	}	
	
	
}
