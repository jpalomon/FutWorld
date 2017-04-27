package es.urjc.code.dad;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;

@CacheConfig(cacheNames="futworld")
public interface PalmaresRepository extends JpaRepository <Palmares, Long> {
	@SuppressWarnings("unchecked")
	
	@CacheEvict(allEntries=true)	
	Palmares save(Palmares palmares);
}
