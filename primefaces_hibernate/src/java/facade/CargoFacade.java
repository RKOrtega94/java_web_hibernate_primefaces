/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Cargo;
import model.Cargo_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Empleado;

/**
 *
 * @author RKOrtega
 */
@Stateless
public class CargoFacade extends AbstractFacade<Cargo> {

    @PersistenceContext(unitName = "primefaces_hibernatePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CargoFacade() {
        super(Cargo.class);
    }

    public boolean isEmpleadoCollectionEmpty(Cargo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cargo> cargo = cq.from(Cargo.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cargo, entity), cb.isNotEmpty(cargo.get(Cargo_.empleadoCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Empleado> findEmpleadoCollection(Cargo entity) {
        Cargo mergedEntity = this.getMergedEntity(entity);
        Collection<Empleado> empleadoCollection = mergedEntity.getEmpleadoCollection();
        empleadoCollection.size();
        return empleadoCollection;
    }
    
}
