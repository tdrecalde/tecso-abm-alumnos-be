package ar.tomas.testtecso.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the inscripciones_curso database table.
 * 
 */
@Entity
@Table(name="inscripciones_curso")
@NamedQuery(name="InscripcionesCurso.findAll", query="SELECT i FROM InscripcionesCurso i")
public class InscripcionesCurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer identificador;

	private Boolean aprobado;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date fechainscripcion;

	//bi-directional many-to-one association to Alumno
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idalumno", nullable=false)
	private Alumno alumno;

	//bi-directional many-to-one association to Curso
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idcurso", nullable=false)
	private Curso curso;

	public InscripcionesCurso() {
	}

	public Integer getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public Boolean getAprobado() {
		return this.aprobado;
	}

	public void setAprobado(Boolean aprobado) {
		this.aprobado = aprobado;
	}

	public Date getFechainscripcion() {
		return this.fechainscripcion;
	}

	public void setFechainscripcion(Date fechainscripcion) {
		this.fechainscripcion = fechainscripcion;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}