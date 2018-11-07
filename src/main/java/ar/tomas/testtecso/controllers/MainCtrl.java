package ar.tomas.testtecso.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.tomas.testtecso.dao.AlumnoDao;
import ar.tomas.testtecso.modelo.Alumno;
import ar.tomas.testtecso.modelo.Carrera;
import ar.tomas.testtecso.modelo.Curso;
import ar.tomas.testtecso.modelo.InscripcionesCarrera;
import ar.tomas.testtecso.modelo.InscripcionesCurso;

@RestController
@EnableTransactionManagement
public class MainCtrl {

	@Autowired
	private AlumnoDao alumnoDao;
	
//	AlumnoDao alumnoDao = new AlumnoDao(); 

	@GetMapping("/alumnos")
	public Iterable<Alumno> getDatosAlumnos() {
		return alumnoDao.findAll();
	};
	
	@GetMapping("/alumno/{legajo}")
	public Optional<Alumno> getDatosAlumno(@PathVariable Integer legajo) {
		return alumnoDao.buscarAlumnoPorLegajo(legajo);		
		
	};

	@PostMapping("/alumno")
	public Alumno nuevoAlumno(@RequestBody Alumno alumno) {
//		return alumnoRepositorio.save(alumno);
		return null;
	};

	@PutMapping("/alumno")
	public boolean crearAlumno(@RequestBody Alumno alumno) {
//		alumnoRepositorio.saveAndFlush(alumno);
		return true;
	};

	@DeleteMapping("/alumno/{legajo}")
	public boolean borrarAlumno(@PathVariable Integer legajo) {
//		alumnoRepositorio.deleteById(legajo);
		return false;
	};

	@GetMapping("/carrera/{identificador}")
	public Carrera getDatosCarrera(@PathVariable Integer identificador) {
		Carrera carrera = null;
//		carreraRepositorio.findByidentificador(identificador);
		return carrera;
	};

	@GetMapping("/curso/{identificador}")
	public Curso getDatosCurso(@PathVariable Integer identificador) {
		Curso curso = null;
//		cursoRepositorio.findByidentificador(identificador);
		return curso;
	};
	
	@GetMapping("/insCarreraIdAlumno/{idalumno}")
	public List<InscripcionesCarrera> getDatosCarrCursoporId(@PathVariable Integer idalumno) {
		
		List<InscripcionesCarrera> listaInsCarrera = null;
//		insCarrRepositorio.findByalumnoIdentificador(idalumno);
		return listaInsCarrera;
	};
	
	@GetMapping("/insCarrera/{identificador}")
	public InscripcionesCarrera getDatosCarrCurso(@PathVariable Integer identificador) {
		InscripcionesCarrera insCarrera = null; 
//				insCarrRepositorio.findByidentificador(identificador);
		return insCarrera;
	};
	@GetMapping("/insCurso/{identificador}")
	public InscripcionesCurso getDatosInsCurso(@PathVariable Integer identificador) {
		InscripcionesCurso curso = null;
//		= insCaurRepositorio.findByidentificador(identificador);
		return curso;
	};

}