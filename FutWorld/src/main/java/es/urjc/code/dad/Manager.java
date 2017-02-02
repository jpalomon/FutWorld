package es.urjc.code.dad;

public class Manager {

	private int id;
	private String nombre;
	private Equipo equipo;
	private String user;
	private String password;
	
	public Manager(){
	}

	public Manager(int id, String nombre, Equipo equipo, String user, String password) {
		this.id = id;
		this.nombre = nombre;
		this.equipo = equipo;
		this.user = user;
		this.password = password;
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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
