package ar.tomas.testtecso.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;

import ar.tomas.testtecso.modelo.Alumno;
import ar.tomas.testtecso.modelo.QAlumno;
import ar.tomas.testtecso.repositorio.AlumnoRep;

@Service
public class AlumnoDao {
	
	@Autowired
	private AlumnoRep alumnoRepositorio;

	public Optional<Alumno> buscarAlumnoPorLegajo(Integer legajo) {
		System.out.println("recibiendo el legajo: " + legajo);
		System.out.println("alumnoRepositorio " + alumnoRepositorio);

		BooleanExpression booleanExpression = QAlumno.alumno.legajo.eq(legajo);
		OrderSpecifier<Integer> orderSpecifier = QAlumno.alumno.identificador.asc();
		
		System.out.println("booleanExpression " + booleanExpression);
		System.out.println("orderSpecifier " + orderSpecifier);
		
		Optional<Alumno> alumno = alumnoRepositorio.findOne(booleanExpression);

		return alumno;
	}
	
	public Iterable<Alumno> findAll() {
		
		OrderSpecifier<Integer> orderSpecifier = QAlumno.alumno.identificador.asc();
		Iterable<Alumno> alumnos = alumnoRepositorio.findAll(orderSpecifier);
		alumnos.forEach(System.out::println);
		
		return alumnos;
	}

}
