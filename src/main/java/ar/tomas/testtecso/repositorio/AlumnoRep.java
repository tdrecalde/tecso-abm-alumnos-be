package ar.tomas.testtecso.repositorio;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.tomas.testtecso.modelo.Alumno;

@Repository
public interface AlumnoRep extends CrudRepository<Alumno, Integer>, QuerydslPredicateExecutor<Alumno> {
    Alumno findByidentificador(Integer identificador);
    Alumno findBylegajo(Integer legajo);
    
}