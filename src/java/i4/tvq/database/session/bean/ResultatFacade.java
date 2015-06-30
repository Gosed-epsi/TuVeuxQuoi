/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i4.tvq.database.session.bean;

import i4.tvq.database.entity.Resultat;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Edgar
 */
@Stateless
public class ResultatFacade extends AbstractFacade<Resultat> {

    @PersistenceContext(unitName = "TuVeuxQuoiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResultatFacade() {
        super(Resultat.class);
    }
}
