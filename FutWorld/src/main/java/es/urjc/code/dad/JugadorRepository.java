package es.urjc.code.dad;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JugadorRepository extends JpaRepository <Jugador, Long>{

	Jugador findByNombreJugador(String nombreJugador);
	
	List<Jugador> findDistinctJugadoresByEquipoJugador(String equipoJugador);

}
