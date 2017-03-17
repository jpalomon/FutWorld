package es.urjc.code.dad;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nombreManager;
	private String equipoManager;
	private String user;
	private String password;

	@OneToOne
	private Equipo equipo;
	
	@OneToMany
	private List <Jugador> jugadores;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;
	
	public Manager(){
	}

	public Manager(String nombreManager, String equipoManager, String user, String password, String rol) {
		this.nombreManager = nombreManager;
		this.equipoManager = equipoManager;
		this.user = user;
		this.password = new BCryptPasswordEncoder().encode(password);
		this.roles = new ArrayList<String>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreManager() {
		return nombreManager;
	}

	public void setNombreManager(String nombreManager) {
		this.nombreManager = nombreManager;
	}

	public String getEquipoManager() {
		return equipoManager;
	}

	public void setEquipoManager(String equipoManager) {
		this.equipoManager = equipoManager;
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

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", nombreManager=" + nombreManager + ", equipoManager=" + equipoManager + ", user="
				+ user + ", password=" + password + ", equipo=" + equipo + ", jugadores=" + jugadores + ", roles="
				+ roles + "]";
	}
}
