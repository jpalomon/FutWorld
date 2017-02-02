package es.urjc.code.dad;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipoRepository extends JpaRepository<Equipo, Long>  {

		Equipo findById(long id);	
		
	}