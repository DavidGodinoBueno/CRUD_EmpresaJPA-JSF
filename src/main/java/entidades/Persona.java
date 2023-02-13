package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the personas database table.
 * 
 */
@Entity
@Table(name="personas")
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERSONAS_IDPERSONA_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSONAS_IDPERSONA_GENERATOR")
	@Column(name="ID_PERSONA")
	private int idPersona;

	private int edad;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_NACIMIENTO")
	private Date fechaNacimiento;

	private String gmail;

	private String nombre;

	//bi-directional many-to-one association to Oficio
	@ManyToOne
	@JoinColumn(name="ID_OFICIO")
	private Oficio oficio;

	public Persona() {
	}

	public int getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGmail() {
		return this.gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Oficio getOficio() {
		return this.oficio;
	}

	public void setOficio(Oficio oficio) {
		this.oficio = oficio;
	}

}