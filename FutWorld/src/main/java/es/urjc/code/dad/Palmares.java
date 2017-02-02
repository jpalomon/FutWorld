package es.urjc.code.dad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Palmares {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private Torneo torneo;
	private int numTorneoGanados;
	
	public Palmares(){
		id = 0;
	}

	public Palmares(Torneo torneo, int numTorneoGanados) {
		this.torneo = torneo;
		this.numTorneoGanados = numTorneoGanados;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Torneo getTorneo() {
		return torneo;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}

	public int getNumTorneoGanados() {
		return numTorneoGanados;
	}

	public void setNumTorneoGanados(int numTorneoGanados) {
		this.numTorneoGanados = numTorneoGanados;
	}
	
	
}
