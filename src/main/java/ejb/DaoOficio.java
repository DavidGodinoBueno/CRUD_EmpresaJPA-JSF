package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entidades.Oficio;

/**
 * Session Bean implementation class DaoOficio
 */
@Stateless
public class DaoOficio {

    /**
     * Default constructor. 
     */
    public DaoOficio() {
        // TODO Auto-generated constructor stub
    }
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRUD_EmpresaJPA-JSF");
    private EntityManager em = emf.createEntityManager();
    
    public List<Oficio> listaOficios() {
    	String listar = "select o from Oficio o";
    	TypedQuery<Oficio> consulta = em.createQuery(listar, Oficio.class);
    	List<Oficio> oficios = consulta.getResultList();
    	for(Oficio o:oficios) {
    		em.refresh(o);
    	}
    	return oficios;
    }
    
    
    public Oficio findOficioById(int idOficio) {
    	Oficio theJob = em.find(Oficio.class, idOficio);
    	return theJob;
    }
    
    
    public List<Oficio> findOficiosByName(String patron) {
    	String buscar = "select o from Oficio o"
                      +" where o.descripcion like (:elpatron)";
    	TypedQuery<Oficio> consulta = em.createQuery(buscar, Oficio.class);
    	consulta.setParameter("elpatron", "%"+patron+"%");
    	List<Oficio> oficios = consulta.getResultList();
    	for(Oficio o:oficios) {
    		em.refresh(o);
    	}
    	return oficios;
    }

}
