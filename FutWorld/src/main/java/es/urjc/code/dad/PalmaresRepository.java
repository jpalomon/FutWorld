package es.urjc.code.dad;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PalmaresRepository extends JpaRepository<Palmares, Long>  {

		Palmares findById(long id);	
		
	}