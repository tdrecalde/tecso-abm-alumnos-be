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
	private Integer identificador;

	private Integer idmateria;

	//uni-directional one-to-one association to Profesor
	@OneToOne
	@JoinColumn(name="idprofesor")
	private Profesor profesor;

	public ProfesorMateria() {
	}

	public Integer getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public Integer getIdmateria() {
		return this.idmateria;
	}

	public void setIdmateria(Integer idmateria) {
		this.idmateria = idmateria;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

}