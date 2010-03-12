/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.edu.um.egresados.dao.impl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.edu.um.egresados.dao.EgresadoDao;
import mx.edu.um.egresados.modelo.Egresado;

/**
 *
 * @author jdmr
 */
@Stateless(name="EgresadoDao")
public class EgresadoDaoBean implements EgresadoDao {
    @PersistenceContext
    private EntityManager em;

    public List<Egresado> lista() {
        return em.createQuery("select e from Egresado e order by e.matricula").getResultList();
    }

    public Egresado obtiene(Long id) {
        return em.find(Egresado.class, id);
    }

    public Egresado guarda(Egresado egresado) {
        if (egresado.getId() != null) {
            egresado = em.merge(egresado);
        } else {
            em.persist(egresado);
        }
        return egresado;
    }

    public void elimina(Long id) {
        Egresado egresado = em.find(Egresado.class, id);
        em.remove(egresado);
    }

}
