package es.urjc.code.dad;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nombreManager;
	private String user;
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Equipo equipo;
	
	public Manager(){
	}

	public Manager(String nombreManager, Equipo equipo, String user, String password) {
		this.nombreManager = nombreManager;
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

	public String getNombreManager() {
		return nombreManager;
	}

	public void setNombreManager(String nombreManager) {
		this.nombreManager = nombreManager;
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

	@Override
	public String toString() {
		return "Manager [id=" + id + ", nombreManager=" + nombreManager + ", user=" + user + ", password=" + password
				+ ", equipo=" + equipo + "]";
	}

}
