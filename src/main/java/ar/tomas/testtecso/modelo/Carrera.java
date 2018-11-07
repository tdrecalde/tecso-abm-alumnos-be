package ar.tomas.testtecso.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the carrera database table.
 * 
 */
@Entity
@Table(name="carrera")
@NamedQuery(name="Carrera.findAll", query="SELECT c FROM Carrera c")
public class Carrera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer identificador;

	@Column(length=250)
	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date fechadesde;

	@Temporal(TemporalType.DATE)
	private Date fechahasta;

	@Column(nullable=false, length=40)
	private String nombre;

	//bi-directional many-to-one association to Curso
	@OneToMany(mappedBy="carrera")
	private List<Curso> cursos;

	//bi-directional many-to-one association to InscripcionesCarrera
	@OneToMany(mappedBy="carrera")
	private List<InscripcionesCarrera> inscripcionesCarreras;

	public Carrera() {
	}

	public Integer getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechadesde() {
		return this.fechadesde;
	}

	public void setFechadesde(Date fechadesde) {
		this.fechadesde = fechadesde;
	}

	public Date getFechahasta() {
		return this.fechahasta;
	}

	public void setFechahasta(Date fechahasta) {
		this.fechahasta = fechahasta;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Curso addCurso(Curso curso) {
		getCursos().add(curso);
		curso.setCarrera(this);

		return curso;
	}

	public Curso removeCurso(Curso curso) {
		getCursos().remove(curso);
		curso.setCarrera(null);

		return curso;
	}

	public List<InscripcionesCarrera> getInscripcionesCarreras() {
		return this.inscripcionesCarreras;
	}

	public void setInscripcionesCarreras(List<InscripcionesCarrera> inscripcionesCarreras) {
		this.inscripcionesCarreras = inscripcionesCarreras;
	}

	public InscripcionesCarrera addInscripcionesCarrera(InscripcionesCarrera inscripcionesCarrera) {
		getInscripcionesCarreras().add(inscripcionesCarrera);
		inscripcionesCarrera.setCarrera(this);

		return inscripcionesCarrera;
	}

	public InscripcionesCarrera removeInscripcionesCarrera(InscripcionesCarrera inscripcionesCarrera) {
		getInscripcionesCarreras().remove(inscripcionesCarrera);
		inscripcionesCarrera.setCarrera(null);

		return inscripcionesCarrera;
	}

}