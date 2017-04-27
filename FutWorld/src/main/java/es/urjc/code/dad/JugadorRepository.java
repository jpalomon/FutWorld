package es.urjc.code.dad;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

@CacheConfig(cacheNames="futworld")
public interface JugadorRepository extends JpaRepository <Jugador, Long>{
	@SuppressWarnings("unchecked")
	
	@CacheEvict(allEntries=true)	
	Jugador save(Jugador jugador);
	@Cacheable
	Jugador findByNombreJugador(String nombreJugador);
	@Cacheable
	List<Jugador> findByEdad(int edad);
	@Cacheable
	List<Jugador> findByNacionalidadJugador(String nacionalidadJugador);
	@Cacheable
	List<Jugador> findDistinctJugadoresByEquipoJugadorOrderByValorMercadoDesc(String equipoJugador);
	@Cacheable
	List<Jugador> findDistinctJugadoresByNacionalidadJugadorOrderByValorMercadoDesc(String nacionalidadJugador);
	@Cacheable
	List<Jugador> findDistinctJugadoresByEdadOrderByValorMercadoDesc(int edad);
}
