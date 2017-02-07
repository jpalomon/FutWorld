package es.urjc.code.dad;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JugadorRepository extends JpaRepository<Jugador, Long>  {

		Jugador findById(long id);	
		
	}
