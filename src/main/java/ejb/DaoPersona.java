package ejb;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entidades.Persona;
import excepciones.PersonaException;

/**
 * Session Bean implementation class DaoPersona
 */
@Stateless
public class DaoPersona {

    /**
     * Default constructor. 
     */
    public DaoPersona() {
        // TODO Auto-generated constructor stub
    }
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRUD_EmpresaJPA-JSF");
    private EntityManager em = emf.createEntityManager();
    
    public List<Persona> listarPersonas(long firstRow, int rowsByPage) {
    	String listar = "select p from Persona p";
    	TypedQuery<Persona> consulta = em.createQuery(listar, Persona.class);
    	consulta.setFirstResult((int) firstRow);
    	consulta.setMaxResults(rowsByPage);
    	List<Persona> personas = consulta.getResultList();
    	for(Persona p:personas) {
    		 em.refresh(p);
    	}
    	return personas;
    }
    
    public long countPeople() {
    	String contar = "select count(p) from Persona p";
    	Query consulta = em.createQuery(contar);
    	long contador = (long) consulta.getSingleResult();
    	return contador;
    }
    
    
    public void newPeople(Persona p) throws PersonaException, EJBException {
    	String nombreTresX = p.getNombre();
    	if(nombreTresX.contains("XXX")) {
    		throw new PersonaException("El nombre "+p.getNombre()+", no puede contener 3 exis.");
    	}
    	try {
    		EntityTransaction et = em.getTransaction();
    		et.begin();
    		em.persist(p);
    		et.commit();
    	} catch(EJBException e) {
    		throw e;
    	}
    }
    
    public Persona findPeopleById(int idpeople) {
    	Persona estapersona = em.find(Persona.class, idpeople);
    	return estapersona;
    }
    
    public void modifyPeople(Persona p) {
    	EntityTransaction et = em.getTransaction();
		et.begin();
    	em.merge(p);
    	et.commit();
    }
    
    public void deletePeople(int idpeople) {
    	Persona personRemove = em.find(Persona.class, idpeople);
    	EntityTransaction et = em.getTransaction();
		et.begin();
    	if(personRemove != null) {
    		em.remove(personRemove);
    	}
    	et.commit();
    }
    
    
    public List<Persona> searchPeople(String patron) {
    	String buscar = "select p from Persona p"
                      +" where p.nombre like (:elpatron)";
    	TypedQuery<Persona> consulta = em.createQuery(buscar, Persona.class);
    	consulta.setParameter("elpatron", "%"+patron+"%");
    	List<Persona> personas = consulta.getResultList();
    	for(Persona p:personas) {
    		em.refresh(p);
    	}
    	return personas;
    }
    
    
    public List<Persona> findPeopleByOficio(int idoficio) {
    	String buscar = "select p from Persona p"
                     +" where p.oficio.idOficio = :elidoficio";
    	TypedQuery<Persona> consulta = em.createQuery(buscar, Persona.class);
    	consulta.setParameter("elidoficio", idoficio);
    	List<Persona> personas = consulta.getResultList();
    	return personas;
    }
    
    
    public void removeSeveralPeoples(String [] personas) {
    	for(String p:personas) {
    		Persona personaseliminar = em.find(Persona.class, Integer.parseInt(p));
    		EntityTransaction et = em.getTransaction();
    		et.begin();
    		if(personaseliminar != null) {
    			em.remove(personaseliminar);
    		}
    		et.commit();
    	}
    }

}
