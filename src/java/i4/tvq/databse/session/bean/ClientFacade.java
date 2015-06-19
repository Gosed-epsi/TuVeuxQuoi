/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i4.tvq.databse.session.bean;

import i4.tvq.database.entity.Client;
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
public class ClientFacade extends AbstractFacade<Client> {

    @PersistenceContext(unitName = "TuVeuxQuoiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }

    public boolean checkMail(String mail) {
        Query query = em.createNamedQuery("Client.findByMailclient");
        query.setParameter("mailclient", mail);
        List<Client> clientTrouve = query.getResultList();
        return !clientTrouve.isEmpty();
    }

    public Client connection(String mail, String passw) {
        Query query = em.createNamedQuery("Client.findByMailclient");
        query.setParameter("mailclient", mail);
        List<Client> clientTrouve = query.getResultList();
        if (clientTrouve.get(0).getPasswordclient().equals(passw)) {
            return clientTrouve.get(0);
        } else {
            return null;
        }
    }
}
