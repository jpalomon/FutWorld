package es.urjc.code.dad;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {

	List<Equipo> findDistinctEquiposByLigaOrderByNombreEquipoAsc(String liga);
	List<Equipo> findDistinctEquiposByLigaOrderByNumTorneoGanadosDesc(String liga);
	
	Equipo findByNombreEquipo(String nombreEquipo);	
	
}
