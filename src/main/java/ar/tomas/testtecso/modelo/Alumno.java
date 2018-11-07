package ar.tomas.testtecso.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the alumno database table.
 * 
 */
@Entity
@Table(name="alumno")
@NamedQuery(name="Alumno.findAll", query="SELECT a FROM Alumno a")
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer identificador;

	@Column(nullable=false)
	private Integer legajo;

	//bi-directional one-to-one association to Persona
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idpersona")
	private Persona persona;

	//bi-directional many-to-one association to InscripcionesCarrera
	@OneToMany(mappedBy="alumno", fetch=FetchType.LAZY)
	private List<InscripcionesCarrera> inscripcionesCarreras;

	//bi-directional many-to-one association to InscripcionesCurso
	@OneToMany(mappedBy="alumno")
	private List<InscripcionesCurso> inscripcionesCursos;

	public Alumno() {
	}

	public Integer getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public Integer getLegajo() {
		return this.legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<InscripcionesCarrera> getInscripcionesCarreras() {
		return this.inscripcionesCarreras;
	}

	public void setInscripcionesCarreras(List<InscripcionesCarrera> inscripcionesCarreras) {
		this.inscripcionesCarreras = inscripcionesCarreras;
	}

	public InscripcionesCarrera addInscripcionesCarrera(InscripcionesCarrera inscripcionesCarrera) {
		getInscripcionesCarreras().add(inscripcionesCarrera);
		inscripcionesCarrera.setAlumno(this);

		return inscripcionesCarrera;
	}

	public InscripcionesCarrera removeInscripcionesCarrera(InscripcionesCarrera inscripcionesCarrera) {
		getInscripcionesCarreras().remove(inscripcionesCarrera);
		inscripcionesCarrera.setAlumno(null);

		return inscripcionesCarrera;
	}

	public List<InscripcionesCurso> getInscripcionesCursos() {
		return this.inscripcionesCursos;
	}

	public void setInscripcionesCursos(List<InscripcionesCurso> inscripcionesCursos) {
		this.inscripcionesCursos = inscripcionesCursos;
	}

	public InscripcionesCurso addInscripcionesCurso(InscripcionesCurso inscripcionesCurso) {
		getInscripcionesCursos().add(inscripcionesCurso);
		inscripcionesCurso.setAlumno(this);

		return inscripcionesCurso;
	}

	public InscripcionesCurso removeInscripcionesCurso(InscripcionesCurso inscripcionesCurso) {
		getInscripcionesCursos().remove(inscripcionesCurso);
		inscripcionesCurso.setAlumno(null);

		return inscripcionesCurso;
	}

}