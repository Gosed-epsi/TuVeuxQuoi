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
public class MenuView {

    /**
     * Creates a new instance of MenuView
     */
    public MenuView() {
    }

    public String inscription() {
        return "inscription?faces-redirect=true";
    }

}
