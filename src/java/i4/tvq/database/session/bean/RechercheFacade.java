/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i4.tvq.database.session.bean;

import i4.tvq.database.entity.Client;
import i4.tvq.database.entity.Recherche;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Edgar
 */
@Stateless
public class RechercheFacade extends AbstractFacade<Recherche> {

    @PersistenceContext(unitName = "TuVeuxQuoiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RechercheFacade() {
        super(Recherche.class);
    }

    public List<Recherche> getRecherchesByClient(Client client) {
        Query query = em.createNamedQuery("Recherche.findByClient");
        query.setParameter("idclient", client);
        return query.getResultList();
    }

}
