package ar.tomas.testtecso.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.tomas.testtecso.modelo.Alumno;

@Repository
public interface AlumnoRep extends JpaRepository<Alumno, Integer> {
    Alumno findByidentificador(Integer identificador);
    Alumno findBylegajo(Integer legajo);
}