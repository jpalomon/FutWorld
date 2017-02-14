package es.urjc.code.dad;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {

	Equipo findByNombreEquipo(String nombreEquipo);
	
	List<Equipo> findDistinctEquiposByLiga(String liga);
	List<Equipo> findDistinctEquiposByLigaOrderByNumTorneoGanadosDesc(String liga);
	
}
