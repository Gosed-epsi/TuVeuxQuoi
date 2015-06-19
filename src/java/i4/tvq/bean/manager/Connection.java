/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i4.tvq.bean.manager;

import i4.tvq.databse.session.bean.ClientFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Edgar
 */
@ManagedBean
@RequestScoped
public class Connection {

    @EJB
    private ClientFacade clientFacade;

    private String login;
    private String password;

    /**
     * Creates a new instance of Connection
     */
    public Connection() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String connection() {
        System.out.println(clientFacade.connection(login, password));
        return "test?faces-redirect=true";
    }

}
