package ar.tomas.testtecso.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@Table(name="persona")
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer identificador;

	@Column(nullable=false, length=40)
	private String apellido;

	@Column(length=200)
	private String direccion;

	@Column(nullable=false)
	private Long documento;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date fechanac;

	@Column(nullable=false, length=40)
	private String nombre;

	@Column(nullable=false, length=5)
	private String tipodoc;

	//bi-directional one-to-one association to Alumno
	@OneToOne(mappedBy="persona", fetch=FetchType.LAZY)
	private Alumno alumno;

	public Persona() {
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

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Long getDocumento() {
		return this.documento;
	}

	public void setDocumento(Long documento) {
		this.documento = documento;
	}

	public Date getFechanac() {
		return this.fechanac;
	}

	public void setFechanac(Date fechanac) {
		this.fechanac = fechanac;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipodoc() {
		return this.tipodoc;
	}

	public void setTipodoc(String tipodoc) {
		this.tipodoc = tipodoc;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

}