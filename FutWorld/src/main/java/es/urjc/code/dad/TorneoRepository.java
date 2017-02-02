package es.urjc.code.dad;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TorneoRepository extends JpaRepository<Torneo, Long>  {

		Torneo findById(long id);	
		
	}