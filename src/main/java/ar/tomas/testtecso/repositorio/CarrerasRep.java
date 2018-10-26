package ar.tomas.testtecso.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.tomas.testtecso.modelo.Alumno;
import ar.tomas.testtecso.modelo.Carrera;

@Repository
public interface CarrerasRep extends JpaRepository<Carrera, Integer> {
	Carrera findByidentificador(Integer identificador);
}