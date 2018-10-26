package ar.tomas.testtecso.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the alumno database table.
 * 
 */
@Entity
@NamedQuery(name="Alumno.findAll", query="SELECT a FROM Alumno a")
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer identificador;

	private Integer legajo;

	//uni-directional one-to-one association to Persona
	@OneToOne
	@JoinColumn(name="idpersona")
	private Persona persona;

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

}