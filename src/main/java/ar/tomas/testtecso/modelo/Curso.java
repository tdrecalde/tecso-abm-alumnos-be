package ar.tomas.testtecso.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the curso database table.
 * 
 */
@Entity
@Table(name="curso")
@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer identificador;

	@Column(nullable=false)
	private Integer anio;

	@Column(nullable=false)
	private Integer cupomaximo;

	@Column(length=250)
	private String descripcion;

	@Column(nullable=false, length=40)
	private String nombre;

	//bi-directional many-to-one association to Carrera
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idcarrera")
	private Carrera carrera;

	//bi-directional many-to-one association to InscripcionesCurso
	@OneToMany(mappedBy="curso")
	private List<InscripcionesCurso> inscripcionesCursos;

	//bi-directional many-to-many association to Profesor
	@ManyToMany(mappedBy="cursos")
	private List<Profesor> profesors;

	//bi-directional one-to-one association to ProfesorMateria
	@OneToOne(mappedBy="curso", fetch=FetchType.LAZY)
	private ProfesorMateria profesorMateria;

	public Curso() {
	}

	public Integer getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public Integer getAnio() {
		return this.anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getCupomaximo() {
		return this.cupomaximo;
	}

	public void setCupomaximo(Integer cupomaximo) {
		this.cupomaximo = cupomaximo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Carrera getCarrera() {
		return this.carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public List<InscripcionesCurso> getInscripcionesCursos() {
		return this.inscripcionesCursos;
	}

	public void setInscripcionesCursos(List<InscripcionesCurso> inscripcionesCursos) {
		this.inscripcionesCursos = inscripcionesCursos;
	}

	public InscripcionesCurso addInscripcionesCurso(InscripcionesCurso inscripcionesCurso) {
		getInscripcionesCursos().add(inscripcionesCurso);
		inscripcionesCurso.setCurso(this);

		return inscripcionesCurso;
	}

	public InscripcionesCurso removeInscripcionesCurso(InscripcionesCurso inscripcionesCurso) {
		getInscripcionesCursos().remove(inscripcionesCurso);
		inscripcionesCurso.setCurso(null);

		return inscripcionesCurso;
	}

	public List<Profesor> getProfesors() {
		return this.profesors;
	}

	public void setProfesors(List<Profesor> profesors) {
		this.profesors = profesors;
	}

	public ProfesorMateria getProfesorMateria() {
		return this.profesorMateria;
	}

	public void setProfesorMateria(ProfesorMateria profesorMateria) {
		this.profesorMateria = profesorMateria;
	}

}