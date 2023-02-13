package backing;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import ejb.DaoOficio;
import ejb.DaoPersona;
import entidades.Oficio;
import entidades.Persona;
import excepciones.PersonaException;

@Named
@RequestScoped
public class BackingAltaPersona implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private DaoPersona daopeople;
	
	@EJB
	private DaoOficio daojob;
	
	private List<Oficio> listadoOficios;
	private String idJobPeople;
	private Oficio jobPeople = new Oficio();
	private Persona newpersona = new Persona();
	
	public BackingAltaPersona() {
		// TODO Auto-generated constructor stub
	}

	public Oficio getJobPeople() {
		return jobPeople;
	}

	public void setJobPeople(Oficio jobPeople) {
		this.jobPeople = jobPeople;
	}

	public Persona getNewpersona() {
		return newpersona;
	}
	
	public List<Oficio> getListadoOficios() {
		return listadoOficios;
	}

	public void setListadoOficios(List<Oficio> listadoOficios) {
		this.listadoOficios = listadoOficios;
	}

	public void setNewpersona(Persona newpersona) {
		this.newpersona = newpersona;
	}
	
	public String getIdJobPeople() {
		return idJobPeople;
	}

	public void setIdJobPeople(String idJobPeople) {
		this.idJobPeople = idJobPeople;
	}


	@PostConstruct
	public void listJobs() {
		if(listadoOficios == null) {
			listadoOficios = daojob.listaOficios();
		}
	}

	public void addPersona() throws PersonaException, EJBException {
	  try {
		   jobPeople = daojob.findOficioById(Integer.parseInt(idJobPeople));
			newpersona.setOficio(jobPeople);
			daopeople.newPeople(newpersona);
			idJobPeople = null;
			newpersona = new Persona();
			jobPeople = new Oficio();
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, new FacesMessage("Persona insertada", "Persona insertada"));
	    } catch(PersonaException pe) {
		    FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, new FacesMessage(pe.getMessage(), pe.getMessage()));
	      }
	}
	

}
