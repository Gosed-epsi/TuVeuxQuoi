/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i4.tvq.bean.manager;

import i4.tvq.bean.Util;
import i4.tvq.database.entity.Client;
import i4.tvq.database.entity.Recherche;
import i4.tvq.databse.session.bean.RechercheFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
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
public class SearchView {

    @EJB
    private RechercheFacade rechercheFacade;
    private Client client;
    private Recherche recherche;

    private String _recherche;

    /**
     * Creates a new instance of SearchView
     */
    public SearchView() {
    }

    public String getRecherche() {
        return _recherche;
    }

    public void setRecherche(String recherche) {
        this._recherche = recherche;
    }

    public String rechercherLogin() {
        HttpSession session = Util.getSession();
        client = new Client((BigDecimal) session.getAttribute("id"),
                (String) session.getAttribute("nom"),
                (String) session.getAttribute("prenom"),
                (String) session.getAttribute("mail"),
                (String) session.getAttribute("password"));
        recherche = new Recherche(new BigDecimal(BigInteger.ZERO));
        recherche.setIdclient(client);
        recherche.setLibellerecherche(_recherche);
        recherche.setProfondeurrecherche(BigInteger.TEN);
        recherche.setDaterecherche("2000-01-01");
        rechercheFacade.create(recherche);
        return "resultatRecherche?faces-redirect=true";
    }

    public String rechercherLogout() {
        return "resultatRecherche?faces-redirect=true";
    }

}
