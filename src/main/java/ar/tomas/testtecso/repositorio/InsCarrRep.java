package ar.tomas.testtecso.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.tomas.testtecso.modelo.InscripcionesCarrera;

@Repository
public interface InsCarrRep extends JpaRepository<InscripcionesCarrera, Integer> {
	InscripcionesCarrera findByidentificador(Integer identificador);
	
	List<InscripcionesCarrera> findByalumnoIdentificador(Integer idalumno);
}