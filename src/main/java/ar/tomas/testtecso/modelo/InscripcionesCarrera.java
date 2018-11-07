package ar.tomas.testtecso.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the inscripciones_carrera database table.
 * 
 */
@Entity
@Table(name="inscripciones_carrera")
@NamedQuery(name="InscripcionesCarrera.findAll", query="SELECT i FROM InscripcionesCarrera i")
public class InscripcionesCarrera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer identificador;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date fechainscripcion;

	//bi-directional many-to-one association to Alumno
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idalumno", nullable=false)
	private Alumno alumno;

	//bi-directional many-to-one association to Carrera
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idcarrera", nullable=false)
	private Carrera carrera;

	public InscripcionesCarrera() {
	}

	public Integer getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
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

	public Carrera getCarrera() {
		return this.carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

}