package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the oficios database table.
 * 
 */
@Entity
@Table(name="oficios")
@NamedQuery(name="Oficio.findAll", query="SELECT o FROM Oficio o")
public class Oficio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OFICIOS_IDOFICIO_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OFICIOS_IDOFICIO_GENERATOR")
	@Column(name="ID_OFICIO")
	private int idOficio;

	private String descripcion;

	private double sueldo;

	//bi-directional many-to-one association to CategoriaOficio
	@ManyToOne
	@JoinColumn(name="ID_CATEGORIA")
	private CategoriaOficio categoriaOficio;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="oficio")
	private List<Persona> personas;

	public Oficio() {
	}

	public int getIdOficio() {
		return this.idOficio;
	}

	public void setIdOficio(int idOficio) {
		this.idOficio = idOficio;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getSueldo() {
		return this.sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public CategoriaOficio getCategoriaOficio() {
		return this.categoriaOficio;
	}

	public void setCategoriaOficio(CategoriaOficio categoriaOficio) {
		this.categoriaOficio = categoriaOficio;
	}

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public Persona addPersona(Persona persona) {
		getPersonas().add(persona);
		persona.setOficio(this);

		return persona;
	}

	public Persona removePersona(Persona persona) {
		getPersonas().remove(persona);
		persona.setOficio(null);

		return persona;
	}

}