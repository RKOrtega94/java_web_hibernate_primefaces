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
import model.Empleado;
import model.Empleado_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Cargo;
import model.Empresa;
import model.Usuario;

/**
 *
 * @author RKOrtega
 */
@Stateless
public class EmpleadoFacade extends AbstractFacade<Empleado> {

    @PersistenceContext(unitName = "primefaces_hibernatePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadoFacade() {
        super(Empleado.class);
    }

    public boolean isCargoIdEmpty(Empleado entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Empleado> empleado = cq.from(Empleado.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(empleado, entity), cb.isNotNull(empleado.get(Empleado_.cargoId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Cargo findCargoId(Empleado entity) {
        return this.getMergedEntity(entity).getCargoId();
    }

    public boolean isEmpresaIdEmpty(Empleado entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Empleado> empleado = cq.from(Empleado.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(empleado, entity), cb.isNotNull(empleado.get(Empleado_.empresaId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Empresa findEmpresaId(Empleado entity) {
        return this.getMergedEntity(entity).getEmpresaId();
    }

    public boolean isUsuarioCollectionEmpty(Empleado entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Empleado> empleado = cq.from(Empleado.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(empleado, entity), cb.isNotEmpty(empleado.get(Empleado_.usuarioCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Usuario> findUsuarioCollection(Empleado entity) {
        Empleado mergedEntity = this.getMergedEntity(entity);
        Collection<Usuario> usuarioCollection = mergedEntity.getUsuarioCollection();
        usuarioCollection.size();
        return usuarioCollection;
    }
    
}
