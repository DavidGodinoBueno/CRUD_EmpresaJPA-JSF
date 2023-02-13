package backing;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import ejb.DaoOficio;
import ejb.DaoPersona;
import entidades.Oficio;
import entidades.Persona;

@Named
@RequestScoped
public class BackingEditarPersona implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private DaoPersona daopeople;
	
	@EJB
	private DaoOficio daojob;
	
	private Oficio jobEditPeople = new Oficio();
	private Persona peopleedit = new Persona();
	
	private int elidoficio;
	
	public BackingEditarPersona() {
		// TODO Auto-generated constructor stub
	}


	public Persona getPeopleedit() {
		return peopleedit;
	}

	public void setPeopleedit(Persona peopleedit) {
		this.peopleedit = peopleedit;
	}
	
	public Oficio getJobEditPeople() {
		return jobEditPeople;
	}


	public void setJobEditPeople(Oficio jobEditPeople) {
		this.jobEditPeople = jobEditPeople;
	}


	public int getElidoficio() {
		return elidoficio;
	}


	public void setElidoficio(int elidoficio) {
		this.elidoficio = elidoficio;
	}


	public void modificarPersona() {
		jobEditPeople = daojob.findOficioById(elidoficio);
		peopleedit.setOficio(jobEditPeople);
		daopeople.modifyPeople(peopleedit);
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage("Persona modificada: "+peopleedit.getNombre(), "Persona modificada: "+peopleedit.getNombre()));
	}
	
	

}
