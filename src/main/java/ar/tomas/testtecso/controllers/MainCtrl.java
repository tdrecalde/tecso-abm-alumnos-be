package ar.tomas.testtecso.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.tomas.testtecso.modelo.Alumno;
import ar.tomas.testtecso.modelo.Carrera;
import ar.tomas.testtecso.modelo.Curso;
import ar.tomas.testtecso.modelo.InscripcionesCarrera;
import ar.tomas.testtecso.modelo.InscripcionesCurso;
import ar.tomas.testtecso.repositorio.AlumnoRep;
import ar.tomas.testtecso.repositorio.CarrerasRep;
import ar.tomas.testtecso.repositorio.CursosRep;
import ar.tomas.testtecso.repositorio.InsCarrRep;
import ar.tomas.testtecso.repositorio.InsCurRep;

@RestController
@EnableTransactionManagement
public class MainCtrl {

	@Autowired
	private AlumnoRep alumnoRepositorio;
	@Autowired
	private CarrerasRep carreraRepositorio;
	@Autowired
	private CursosRep cursoRepositorio;
	@Autowired
	private InsCarrRep insCarrRepositorio;
	@Autowired
	private InsCurRep insCaurRepositorio;

	@GetMapping("/alumnos")
	public List<Alumno> getDatosAlumnos() {
		List<Alumno> alumno = alumnoRepositorio.findAll();
		return alumno;
	};
	
	@GetMapping("/alumno/{legajo}")
	public Alumno getDatosAlumno(@PathVariable Integer legajo) {
		System.out.println("recibiendo el legajo: " + legajo);
		Alumno alumno = alumnoRepositorio.findBylegajo(legajo);
		System.out.println("Alumno encontrado: " + alumno.toString());
		return alumno;
	};

	@PostMapping("/alumno")
	public Alumno nuevoAlumno(@RequestBody Alumno alumno) {
		return alumnoRepositorio.save(alumno);
	};

	@PutMapping("/alumno")
	public boolean crearAlumno(@RequestBody Alumno alumno) {
		alumnoRepositorio.saveAndFlush(alumno);
		return true;
	};

	@DeleteMapping("/alumno/{legajo}")
	public boolean borrarAlumno(@PathVariable Integer legajo) {
		alumnoRepositorio.deleteById(legajo);
		return true;
	};

	@GetMapping("/carrera/{identificador}")
	public Carrera getDatosCarrera(@PathVariable Integer identificador) {
		Carrera carrera = carreraRepositorio.findByidentificador(identificador);
		return carrera;
	};

	@GetMapping("/curso/{identificador}")
	public Curso getDatosCurso(@PathVariable Integer identificador) {
		Curso curso = cursoRepositorio.findByidentificador(identificador);
		return curso;
	};
	
	@GetMapping("/insCarreraIdAlumno/{idalumno}")
	public List<InscripcionesCarrera> getDatosCarrCursoporId(@PathVariable Integer idalumno) {
		
		List<InscripcionesCarrera> listaInsCarrera = insCarrRepositorio.findByalumnoIdentificador(idalumno);
		return listaInsCarrera;
	};
	
	@GetMapping("/insCarrera/{identificador}")
	public InscripcionesCarrera getDatosCarrCurso(@PathVariable Integer identificador) {
		InscripcionesCarrera insCarrera = insCarrRepositorio.findByidentificador(identificador);
		return insCarrera;
	};
	@GetMapping("/insCurso/{identificador}")
	public InscripcionesCurso getDatosInsCurso(@PathVariable Integer identificador) {
		InscripcionesCurso curso = insCaurRepositorio.findByidentificador(identificador);
		return curso;
	};

}