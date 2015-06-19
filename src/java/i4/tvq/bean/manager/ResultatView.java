/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i4.tvq.bean.manager;

import i4.tvq.database.entity.Resultat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Edgar
 */
@ManagedBean
@RequestScoped
public class ResultatView {

    private List<Resultat> listResultat;

    private Resultat resultat;

    @PostConstruct
    public void init() {
        listResultat = new ArrayList<>();
        listResultat.add(new Resultat("www.test1.fr", "test1@gmail.com"));
        listResultat.add(new Resultat("www.test2.fr", "test2@gmail.com"));
        listResultat.add(new Resultat("www.test3.fr", "test3@gmail.com"));
        listResultat.add(new Resultat("www.test4.fr", "test4@gmail.com"));
        listResultat.add(new Resultat("www.test5.fr", "test5@gmail.com"));
        listResultat.add(new Resultat("www.test6.fr", "test6@gmail.com"));
        listResultat.add(new Resultat("www.test7.fr", "test7@gmail.com"));
        listResultat.add(new Resultat("www.test8.fr", "test8@gmail.com"));
        listResultat.add(new Resultat("www.test9.fr", "test9@gmail.com"));
    }

    public List<Resultat> getResultats() {
        return listResultat;
    }

    public Resultat getResultat() {
        return resultat;
    }

    public void setSelectedCar(Resultat resultat) {
        this.resultat = resultat;
    }

}
