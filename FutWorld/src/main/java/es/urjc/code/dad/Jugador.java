package es.urjc.code.dad;

public class Jugador {
	
	private int id;
	private String nombre;
	private Equipo equipo;
	private int edad;
	private String nacionalidad;
	private long valorMercado;
	
	public Jugador(){
	}
	
	public Jugador (String nombre,Equipo equipo, int edad, String nacionalidad, long valorMercado){
	this.nombre = nombre;
	this.equipo = equipo;
	this.edad = edad;
	this.nacionalidad = nacionalidad;
	this.valorMercado = valorMercado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
