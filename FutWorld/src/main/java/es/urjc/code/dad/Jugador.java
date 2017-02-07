package es.urjc.code.dad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Jugador {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nombreJugador;
	private int edad;
	private String nacionalidadJugador;
	private long valorMercado;
	
	@ManyToOne
	private Equipo equipo;
	
	public Jugador(){
		
	}
	
	public Jugador (String nombreJugador,Equipo equipo, int edad, String nacionalidadJugador, long valorMercado){
		this.nombreJugador = nombreJugador;
		this.equipo = equipo;
		this.edad = edad;
		this.nacionalidadJugador = nacionalidadJugador;
		this.valorMercado = valorMercado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombreJugador;
	}

	public void setNombre(String nombre) {
		this.nombreJugador = nombre;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNacionalidad() {
		return nacionalidadJugador;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidadJugador = nacionalidad;
	}

	public long getValorMercado() {
		return valorMercado;
	}

	public void setValorMercado(long valorMercado) {
		this.valorMercado = valorMercado;
	}
	
	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nombre=" + nombreJugador + ", equipo=" + equipo + ", edad=" + edad + ", nacionalidad="
				+ nacionalidadJugador + ", valorMercado=" + valorMercado + "]";
	}
}
