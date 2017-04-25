package es.urjc.code.dad;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

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
