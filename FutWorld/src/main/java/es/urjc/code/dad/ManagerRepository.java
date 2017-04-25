package es.urjc.code.dad;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

@CacheConfig(cacheNames="futworld")
public interface ManagerRepository extends JpaRepository <Manager, Long>{	
	@SuppressWarnings("unchecked")
	
	@CacheEvict(allEntries=true)	
	Manager save(Manager manager);
	@Cacheable
	Manager findByUserAndPassword(String user, String password);
	@Cacheable
	Manager findByUser(String user);
}
