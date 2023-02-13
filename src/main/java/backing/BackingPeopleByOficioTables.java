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
public class BackingPeopleByOficioTables implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private DaoPersona daopeople;
	
	@EJB
	private DaoOficio daoJob;
	
	private List<Oficio> listadoOficios;
	private int idJob;
	private List<Persona> peopleThisJob;
	private Oficio theJob = new Oficio();

	public BackingPeopleByOficioTables() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void listarLosOficios() {
		if(listadoOficios == null) {
			listadoOficios = daoJob.listaOficios();
		}
	}
	
	public void listPeopleTheJob() {
		theJob = daoJob.findOficioById(idJob);
		peopleThisJob = daopeople.findPeopleByOficio(idJob);
	}

	public Oficio getTheJob() {
		return theJob;
	}

	public void setTheJob(Oficio theJob) {
		this.theJob = theJob;
	}

	public List<Persona> getPeopleThisJob() {
		return peopleThisJob;
	}

	public void setPeopleThisJob(List<Persona> peopleThisJob) {
		this.peopleThisJob = peopleThisJob;
	}

	public int getIdJob() {
		return idJob;
	}

	public void setIdJob(int idJob) {
		this.idJob = idJob;
	}

	public List<Oficio> getListadoOficios() {
		return listadoOficios;
	}

	public void setListadoOficios(List<Oficio> listadoOficios) {
		this.listadoOficios = listadoOficios;
	}
	

}
