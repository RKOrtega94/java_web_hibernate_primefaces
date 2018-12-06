/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Usuario;
import model.Usuario_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Empleado;

/**
 *
 * @author RKOrtega
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "primefaces_hibernatePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public boolean isEmpleadoIdEmpty(Usuario entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Usuario> usuario = cq.from(Usuario.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(usuario, entity), cb.isNotNull(usuario.get(Usuario_.empleadoId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Empleado findEmpleadoId(Usuario entity) {
        return this.getMergedEntity(entity).getEmpleadoId();
    }
    
}
