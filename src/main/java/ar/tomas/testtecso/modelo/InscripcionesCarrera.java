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
	private Integer identificador;

	@Temporal(TemporalType.DATE)
	private Date fechainscripcion;

	//uni-directional many-to-one association to Alumno
	@ManyToOne
	@JoinColumn(name="idalumno")
	private Alumno alumno;

	//uni-directional many-to-one association to Carrera
	@ManyToOne
	@JoinColumn(name="idcarrera")
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