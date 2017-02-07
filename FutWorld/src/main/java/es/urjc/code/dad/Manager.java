package es.urjc.code.dad;

public class Manager {

	private long id;
	private String nombre;
	private Equipo equipo;
	private String user;
	private String password;
	
	public Manager(){
		id = 0;
	}

	public Manager(String nombre, Equipo equipo, String user, String password) {
		this.nombre = nombre;
		this.equipo = equipo;
		this.user = user;
		this.password = password;
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
