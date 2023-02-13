package backing;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import entidades.Persona;

import ejb.DaoPersona;

@Named
@ViewScoped
public class BackingBuscarPeople implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private DaoPersona daopeople;
	
	private List<Persona> findPeoples;
	private String patronNombre;

	public BackingBuscarPeople() {
		// TODO Auto-generated constructor stub
	}

	public String getPatronNombre() {
		return patronNombre;
	}

	public void setPatronNombre(String patronNombre) {
		this.patronNombre = patronNombre;
	}
	
	public List<Persona> getFindPeoples() {
		return findPeoples;
	}

	public void setFindPeoples(List<Persona> findPeoples) {
		this.findPeoples = findPeoples;
	}

	public void buscarPersonas() {
		findPeoples = daopeople.searchPeople(patronNombre);
	}
	

}
