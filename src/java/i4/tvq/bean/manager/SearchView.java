/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i4.tvq.bean.manager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Edgar
 */
@ManagedBean
@RequestScoped
public class SearchView {

    String recherche;

    /**
     * Creates a new instance of SearchView
     */
    public SearchView() {
    }

    public String getRecherche() {
        return recherche;
    }

    public void setRecherche(String recherche) {
        this.recherche = recherche;
    }

    public String rechercher() {
        return "resultatRecherche?faces-redirect=true";
    }

}
