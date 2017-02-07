package es.urjc.code.dad;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long>  {

		Manager findById(long id);	
		
	}