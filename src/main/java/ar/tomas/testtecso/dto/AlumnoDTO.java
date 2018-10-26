package ar.tomas.testtecso.dto;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
	    name="DatosAlumnoMapping",
	    classes={
	        @ConstructorResult(
	            targetClass=AlumnoDTO.class,
	            columns={
	                @ColumnResult(name="identificador"),
	                @ColumnResult(name="idpersona"),
	                @ColumnResult(name="legajo")
	            }
	        )
	    }
	)

	@NamedNativeQuery(name="getDatosAlumno", query="SELECT select * from alumno a WHERE a.legajo = :legajo", resultSetMapping="DatosAlumnoMapping")

public abstract class AlumnoDTO {
	

	private Integer legajo;
	private Integer identificador;
	private Integer idpersona;

	public AlumnoDTO() {
	}
	
	public AlumnoDTO(Integer legajo, Integer identificador, Integer idpersona) {
		super();
		this.legajo = legajo;
		this.identificador = identificador;
		this.idpersona = idpersona;
	}
	public Integer getLegajo() {
		return legajo;
	}
	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}
	public Integer getIdentificador() {
		return identificador;
	}
	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}
	public Integer getIdpersona() {
		return idpersona;
	}
	public void setIdpersona(Integer idpersona) {
		this.idpersona = idpersona;
	}
	
}
