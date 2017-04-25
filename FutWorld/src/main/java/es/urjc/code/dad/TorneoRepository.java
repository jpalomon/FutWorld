package es.urjc.code.dad;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

@CacheConfig(cacheNames="futworld")
public interface TorneoRepository extends JpaRepository<Torneo, Long> {
	@SuppressWarnings("unchecked")
	
	@CacheEvict(allEntries=true)	
	Torneo save(Torneo torneo);
	@Cacheable
	Torneo findByNombreLiga(String nombreLiga);
	
}
