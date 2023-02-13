package backing;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import ejb.DaoOficio;
import ejb.DaoPersona;
import entidades.Oficio;
import entidades.Persona;

@Named
@ViewScoped
public class BackingPeopleByOficioCombo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private DaoOficio daoJob;
	
	@EJB
	private DaoPersona daopeople;
	
	private List<Oficio> listaOficios;
	private List<Persona> personasByOficio;
	private Oficio eloficio = new Oficio();
	private int idJob;
	private String namepeople;

	public BackingPeopleByOficioCombo() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void listadoOficios() {
		if(listaOficios == null) {
			listaOficios = daoJob.listaOficios();
		}
	}
	
	public void searchPeopleByOficio() {
		personasByOficio = daopeople.findPeopleByOficio(idJob);
		eloficio = daoJob.findOficioById(idJob);
	}
	
	public String getNamepeople() {
		return namepeople;
	}

	public void setNamepeople(String namepeople) {
		this.namepeople = namepeople;
	}

	public Oficio getEloficio() {
		return eloficio;
	}

	public void setEloficio(Oficio eloficio) {
		this.eloficio = eloficio;
	}

	public List<Persona> getPersonasByOficio() {
		return personasByOficio;
	}

	public void setPersonasByOficio(List<Persona> personasByOficio) {
		this.personasByOficio = personasByOficio;
	}

	public int getIdJob() {
		return idJob;
	}

	public void setIdJob(int idJob) {
		this.idJob = idJob;
	}

	public List<Oficio> getListaOficios() {
		return listaOficios;
	}

	public void setListaOficios(List<Oficio> listaOficios) {
		this.listaOficios = listaOficios;
	}
	

}
