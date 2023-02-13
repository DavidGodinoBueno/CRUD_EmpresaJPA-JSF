package backing;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import ejb.DaoPersona;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import entidades.Persona;

@Named
@ViewScoped
public class BackingListarPersonas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private DaoPersona daopeople;
	
	private long firstRow = 0;
	private int rowsByPage = 4;
	private List<Persona> listadoPersonas;
	private int idpeopledelete;
	private long cuentaPersonas;
	
	public BackingListarPersonas() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void listarPeople() {
		if(listadoPersonas == null) {
			listadoPersonas = daopeople.listarPersonas(firstRow, rowsByPage);
			cuentaPersonas = daopeople.countPeople();
		}
	}
	
	public void choiceRowsByPage() {
		listadoPersonas = daopeople.listarPersonas(firstRow, rowsByPage);
	}
	
	public void previousPage() {
		firstRow = firstRow - rowsByPage;
		if(firstRow < 0) {
			firstRow = 0;
		}
		listadoPersonas = daopeople.listarPersonas(firstRow, rowsByPage);
	}
	
	public void nextPage() {
		firstRow = firstRow + rowsByPage;
		if(firstRow >= cuentaPersonas) {
			firstRow = firstRow - rowsByPage;
		}
		listadoPersonas = daopeople.listarPersonas(firstRow, rowsByPage);
	}
	
	public void removePeople() {
		daopeople.deletePeople(idpeopledelete);
		listadoPersonas = daopeople.listarPersonas(firstRow, rowsByPage);
		cuentaPersonas = daopeople.countPeople();
	}

	public long getFirstRow() {
		return firstRow;
	}

	public void setFirstRow(long firstRow) {
		this.firstRow = firstRow;
	}

	public int getRowsByPage() {
		return rowsByPage;
	}

	public void setRowsByPage(int rowsByPage) {
		this.rowsByPage = rowsByPage;
	}

	public long getCuentaPersonas() {
		return cuentaPersonas;
	}

	public void setCuentaPersonas(long cuentaPersonas) {
		this.cuentaPersonas = cuentaPersonas;
	}

	public int getIdpeopledelete() {
		return idpeopledelete;
	}

	public void setIdpeopledelete(int idpeopledelete) {
		this.idpeopledelete = idpeopledelete;
	}

	public List<Persona> getListadoPersonas() {
		return listadoPersonas;
	}

	public void setListadoPersonas(List<Persona> listadoPersonas) {
		this.listadoPersonas = listadoPersonas;
	}
	
	

}
