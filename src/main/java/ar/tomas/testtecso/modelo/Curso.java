package ar.tomas.testtecso.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the curso database table.
 * 
 */
@Entity
@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer identificador;

	private Integer anio;

	private Integer cupomaximo;

	private String descripcion;

	private Integer idcarrera;

	private String nombre;

	//uni-directional one-to-one association to ProfesorMateria
	@OneToOne
	@JoinColumn(name="identificador", referencedColumnName="idmateria")
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

	public Integer getIdcarrera() {
		return this.idcarrera;
	}

	public void setIdcarrera(Integer idcarrera) {
		this.idcarrera = idcarrera;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ProfesorMateria getProfesorMateria() {
		return this.profesorMateria;
	}

	public void setProfesorMateria(ProfesorMateria profesorMateria) {
		this.profesorMateria = profesorMateria;
	}

}