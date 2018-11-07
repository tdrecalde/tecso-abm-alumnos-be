package ar.tomas.testtecso.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the profesor database table.
 * 
 */
@Entity
@Table(name="profesor")
@NamedQuery(name="Profesor.findAll", query="SELECT p FROM Profesor p")
public class Profesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer identificador;

	@Column(nullable=false, length=40)
	private String apellido;

	@Column(nullable=false, length=40)
	private String nombre;

	//bi-directional many-to-many association to Curso
	@ManyToMany
	@JoinTable(
		name="profesor_materia"
		, joinColumns={
			@JoinColumn(name="idprofesor", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="idmateria", nullable=false)
			}
		)
	private List<Curso> cursos;

	//bi-directional one-to-one association to ProfesorMateria
	@OneToOne(mappedBy="profesor", fetch=FetchType.LAZY)
	private ProfesorMateria profesorMateria;

	public Profesor() {
	}

	public Integer getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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

	public ProfesorMateria getProfesorMateria() {
		return this.profesorMateria;
	}

	public void setProfesorMateria(ProfesorMateria profesorMateria) {
		this.profesorMateria = profesorMateria;
	}

}