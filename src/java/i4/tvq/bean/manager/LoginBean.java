/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i4.tvq.bean.manager;

import i4.tvq.bean.UserConnection;
import i4.tvq.bean.Util;
import i4.tvq.database.entity.Client;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Edgar
 */
@ManagedBean
@RequestScoped
public class LoginBean {

    private static final long serialVersionUID = 1L;
    private String message, nom, prenom, mail, password;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String login() {
        UserConnection uc = new UserConnection();
        Client result = uc.login(mail, password);
        if (result != null) {
            HttpSession session = Util.getSession();
            session.setAttribute("client", result);
            session.setAttribute("id", result.getIdclient());
            session.setAttribute("nom", result.getNomclient());
            session.setAttribute("prenom", result.getPrenomclient());
            session.setAttribute("mail", result.getMailclient());
            session.setAttribute("password", result.getPasswordclient());
            session.setAttribute("listeRecherche", result.getRechercheList());
            session.setAttribute("isLogged", true);
            return "index?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Invalid Login!",
                            "Please Try Again!"));
            return "login?faces-redirect=true";
        }
    }

    public String goTo() {
        return "login";
    }

    public String logout() {
        HttpSession session = Util.getSession();
        session.invalidate();
        return "index?faces-redirect=true";
    }
}
