package ar.tomas.testtecso.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the profesor_materia database table.
 * 
 */
@Entity
@Table(name="profesor_materia")
@NamedQuery(name="ProfesorMateria.findAll", query="SELECT p FROM ProfesorMateria p")
public class ProfesorMateria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer identificador;

	//bi-directional one-to-one association to Curso
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idmateria", nullable=false)
	private Curso curso;

	//bi-directional one-to-one association to Profesor
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idprofesor", nullable=false)
	private Profesor profesor;

	public ProfesorMateria() {
	}

	public Integer getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

}