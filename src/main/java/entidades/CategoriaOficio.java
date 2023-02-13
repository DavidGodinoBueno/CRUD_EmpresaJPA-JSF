package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categoria_oficio database table.
 * 
 */
@Entity
@Table(name="categoria_oficio")
@NamedQuery(name="CategoriaOficio.findAll", query="SELECT c FROM CategoriaOficio c")
public class CategoriaOficio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CATEGORIA_OFICIO_IDCATEGORIA_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CATEGORIA_OFICIO_IDCATEGORIA_GENERATOR")
	@Column(name="ID_CATEGORIA")
	private int idCategoria;

	private String descripcion;

	//bi-directional many-to-one association to Oficio
	@OneToMany(mappedBy="categoriaOficio")
	private List<Oficio> oficios;

	public CategoriaOficio() {
	}

	public int getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Oficio> getOficios() {
		return this.oficios;
	}

	public void setOficios(List<Oficio> oficios) {
		this.oficios = oficios;
	}

	public Oficio addOficio(Oficio oficio) {
		getOficios().add(oficio);
		oficio.setCategoriaOficio(this);

		return oficio;
	}

	public Oficio removeOficio(Oficio oficio) {
		getOficios().remove(oficio);
		oficio.setCategoriaOficio(null);

		return oficio;
	}

}