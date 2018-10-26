package ar.tomas.testtecso.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.tomas.testtecso.modelo.InscripcionesCurso;

@Repository
public interface InsCurRep extends JpaRepository<InscripcionesCurso, Integer> {
	InscripcionesCurso findByidentificador(Integer identificador);
}