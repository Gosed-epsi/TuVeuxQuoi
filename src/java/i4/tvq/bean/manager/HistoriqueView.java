/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i4.tvq.bean.manager;

import i4.tvq.bean.Util;
import i4.tvq.database.entity.Client;
import i4.tvq.database.entity.Recherche;
import i4.tvq.database.entity.Resultat;
import i4.tvq.database.session.bean.RechercheFacade;
import i4.tvq.database.session.bean.ResultatFacade;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
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
public class HistoriqueView {

    @EJB
    private ResultatFacade resultatFacade;
    @EJB
    private RechercheFacade rechercheFacade;

    List<Resultat> resultatList = new ArrayList();

    /**
     * Creates a new instance of HistoriqueView
     */
    public HistoriqueView() {
    }

    @PostConstruct
    public void init() {
        HttpSession session = Util.getSession();
        List<Recherche> rechercheList = new ArrayList();
        rechercheList = rechercheFacade.getRecherchesByClient((Client) session.getAttribute("client"));
        for (Recherche recherche : rechercheList) {
            System.err.println("------------" + recherche.getLibellerecherche() + "-----------------");
            for (Resultat resultat : recherche.getResultatList()) {
                System.out.println(resultat.getUrlresultat());
            }
        }
    }

    public String goTo() {
        return "historiqueRecherche?faces-redirect=true";
    }

}
