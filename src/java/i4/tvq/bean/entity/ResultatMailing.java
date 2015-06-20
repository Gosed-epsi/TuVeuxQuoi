/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i4.tvq.bean.entity;

import i4.tvq.database.entity.Resultat;

/**
 *
 * @author Edgar
 */
public class ResultatMailing extends Resultat {

    boolean toSend;

    public ResultatMailing(String urlresultat, String mailresultat) {
        super(urlresultat, mailresultat);
        this.toSend = false;
    }

    public boolean isToSend() {
        return toSend;
    }

    public void setToSend(boolean toSend) {
        this.toSend = toSend;
    }

}
