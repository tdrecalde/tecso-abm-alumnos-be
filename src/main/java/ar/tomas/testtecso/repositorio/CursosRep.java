package ar.tomas.testtecso.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.tomas.testtecso.modelo.Curso;

@Repository
public interface CursosRep extends JpaRepository<Curso, Integer> {
	Curso findByidentificador(Integer identificador);
}