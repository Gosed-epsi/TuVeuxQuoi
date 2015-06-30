/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i4.tvq.bean.manager;

import i4.tvq.bean.Util;
import i4.tvq.database.entity.Client;
import i4.tvq.database.session.bean.ClientFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Edgar
 */
@ManagedBean
@RequestScoped
public class ProfilView {

    @EJB
    private ClientFacade clientFacade;
    private Client client;

    /**
     * Creates a new instance of ProfilBean
     */
    public ProfilView() {
        client = new Client();
    }

    public Client getClient() {
        return client;
    }

    public String goTo() {
        return "profil?faces-redirect=true";
    }

    public String editProfil() {
        clientFacade.edit(client);
        HttpSession session = Util.getSession();
        session.setAttribute("nom", getClient().getNomclient());
        session.setAttribute("prenom", getClient().getPrenomclient());
        session.setAttribute("mail", getClient().getMailclient());
        session.setAttribute("password", getClient().getPasswordclient());
        return "index?faces-redirect=true";

    }

}
