package es.urjc.code.dad;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames="futworld")
public interface EquipoRepository extends JpaRepository<Equipo, Long> {
	@SuppressWarnings("unchecked")
	
	@CacheEvict(allEntries=true)	
	Equipo save(Equipo equipo);	
	@Cacheable
	List<Equipo> findDistinctEquiposByLigaOrderByNombreEquipoAsc(String liga);
	@Cacheable
	List<Equipo> findDistinctEquiposByLigaOrderByNumTorneoGanadosDesc(String liga);
	@Cacheable
	Equipo findByNombreEquipo(String nombreEquipo);	
	
}
