package es.urjc.code.dad;

public class Palmares {

	private int id;
	private Torneo torneo;
	private int numTorneoGanados;
	
	public Palmares(){
		
	}

	public Palmares(int id, Torneo torneo, int numTorneoGanados) {
		this.id = id;
		this.torneo = torneo;
		this.numTorneoGanados = numTorneoGanados;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
