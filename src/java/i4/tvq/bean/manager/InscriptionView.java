/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i4.tvq.bean.manager;

import i4.tvq.database.entity.Client;
import i4.tvq.database.session.bean.ClientFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Edgar
 */
@ManagedBean
public class InscriptionView {

    @EJB
    private ClientFacade clientFacade;

    /**
     * @Pattern \S+ : pas d'espaces \w : [a-zA-Z_0-9] \D : [^0-9]
     */
    @Size(min = 3, max = 20)
    @Pattern(regexp = "\\S+\\w\\D", message = "Saisie du nom incorrect")
    private String name;

    @Size(min = 3, max = 20)
    @Pattern(regexp = "\\S+\\w\\D", message = "Saisie du prénom incorrecte")
    private String fname;

    @Size(min = 5)
    @Pattern(regexp = "\\S+\\w@\\S+\\w.\\S+\\w", message = "Saisie de l'adresse e-mail incorrecte")
    private String mail;

    @Size(min = 5)
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String register() {
        //System.out.println(clientFacade.getLastId());
        Client cl = new Client(new BigDecimal(BigInteger.ZERO), name, fname, mail, password);
        if (!clientFacade.checkMail(mail)) {
            clientFacade.create(cl);
            return "index?faces-redirect=true";
        } else {
            return "inscription?faces-redirect=true";
        }
    }

    public String goTo() {
        return "inscription?faces-redirect=true";
    }

}
