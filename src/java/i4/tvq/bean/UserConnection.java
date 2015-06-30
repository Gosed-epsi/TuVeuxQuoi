/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i4.tvq.bean;

import i4.tvq.database.entity.Client;
import i4.tvq.database.session.bean.ClientFacade;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Edgar
 */
public class UserConnection {

    ClientFacade clientFacade = lookupClientFacadeBean();

    /**
     *
     * @param user
     * @param password
     * @return
     */
    public Client login(String user, String password) {
        try {
            return clientFacade.connection(user, password);
        } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            return null;
        }
    }

    private ClientFacade lookupClientFacadeBean() {
        try {
            Context c = new InitialContext();
            return (ClientFacade) c.lookup("java:global/TuVeuxQuoi/ClientFacade!i4.tvq.databse.session.bean.ClientFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
