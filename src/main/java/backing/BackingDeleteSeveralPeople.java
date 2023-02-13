package backing;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import ejb.DaoOficio;
import ejb.DaoPersona;
import entidades.Oficio;
import entidades.Persona;

@Named
@ViewScoped
public class BackingDeleteSeveralPeople implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private DaoOficio daoJob;
	
	@EJB
	private DaoPersona daopeople;
	
	private String patron;
	private List<Oficio> findOficios;
	private String elIdJob;
	private List<Persona> findPeoples;
	private Oficio eloficio = new Oficio();
	private String [] peopleremove;
	
	public BackingDeleteSeveralPeople() {
		// TODO Auto-generated constructor stub
	}
	
	public void jobsByNamePattern() {
		findOficios = daoJob.findOficiosByName(patron);
		elIdJob = null;
	}
	
	public void peoplesDeleteByJob() {
		eloficio = daoJob.findOficioById(Integer.parseInt(elIdJob));
		findPeoples = daopeople.findPeopleByOficio(Integer.parseInt(elIdJob));
	}
	
	public void removeManyPeople() {
		daopeople.removeSeveralPeoples(peopleremove);
		findPeoples = daopeople.findPeopleByOficio(Integer.parseInt(elIdJob));
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage("Personas eliminas", "Personas eliminadas"));
	}
	
	public String[] getPeopleremove() {
		return peopleremove;
	}

	public void setPeopleremove(String[] peopleremove) {
		this.peopleremove = peopleremove;
	}

	public Oficio getEloficio() {
		return eloficio;
	}

	public void setEloficio(Oficio eloficio) {
		this.eloficio = eloficio;
	}

	public String getElIdJob() {
		return elIdJob;
	}

	public void setElIdJob(String elIdJob) {
		this.elIdJob = elIdJob;
	}

	public List<Persona> getFindPeoples() {
		return findPeoples;
	}

	public void setFindPeoples(List<Persona> findPeoples) {
		this.findPeoples = findPeoples;
	}

	public String getPatron() {
		return patron;
	}

	public void setPatron(String patron) {
		this.patron = patron;
	}

	public List<Oficio> getFindOficios() {
		return findOficios;
	}

	public void setFindOficios(List<Oficio> findOficios) {
		this.findOficios = findOficios;
	}
	

}
