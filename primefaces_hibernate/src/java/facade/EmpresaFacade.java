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
import model.Empresa;
import model.Empresa_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Empleado;

/**
 *
 * @author RKOrtega
 */
@Stateless
public class EmpresaFacade extends AbstractFacade<Empresa> {

    @PersistenceContext(unitName = "primefaces_hibernatePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpresaFacade() {
        super(Empresa.class);
    }

    public boolean isEmpleadoCollectionEmpty(Empresa entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Empresa> empresa = cq.from(Empresa.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(empresa, entity), cb.isNotEmpty(empresa.get(Empresa_.empleadoCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Empleado> findEmpleadoCollection(Empresa entity) {
        Empresa mergedEntity = this.getMergedEntity(entity);
        Collection<Empleado> empleadoCollection = mergedEntity.getEmpleadoCollection();
        empleadoCollection.size();
        return empleadoCollection;
    }
    
}
