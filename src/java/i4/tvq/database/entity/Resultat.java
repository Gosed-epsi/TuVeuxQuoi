/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i4.tvq.database.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Edgar
 */
@Entity
@Table(name = "RESULTAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resultat.findAll", query = "SELECT r FROM Resultat r"),
    @NamedQuery(name = "Resultat.findByIdresultat", query = "SELECT r FROM Resultat r WHERE r.idresultat = :idresultat"),
    @NamedQuery(name = "Resultat.findByUrlresultat", query = "SELECT r FROM Resultat r WHERE r.urlresultat = :urlresultat"),
    @NamedQuery(name = "Resultat.findByMailresultat", query = "SELECT r FROM Resultat r WHERE r.mailresultat = :mailresultat")})
public class Resultat implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDRESULTAT")
    private BigDecimal idresultat;
    @Size(max = 1024)
    @Column(name = "URLRESULTAT")
    private String urlresultat;
    @Size(max = 1024)
    @Column(name = "MAILRESULTAT")
    private String mailresultat;
    @JoinColumn(name = "IDRECHERCHE", referencedColumnName = "IDRECHERCHE")
    @ManyToOne(optional = false)
    private Recherche idrecherche;

    public Resultat() {
    }

    public Resultat(String urlresultat, String mailresultat) {
        this.urlresultat = urlresultat;
        this.mailresultat = mailresultat;
    }

    public Resultat(BigDecimal idresultat) {
        this.idresultat = idresultat;
    }

    public BigDecimal getIdresultat() {
        return idresultat;
    }

    public void setIdresultat(BigDecimal idresultat) {
        this.idresultat = idresultat;
    }

    public String getUrlresultat() {
        return urlresultat;
    }

    public void setUrlresultat(String urlresultat) {
        this.urlresultat = urlresultat;
    }

    public String getMailresultat() {
        return mailresultat;
    }

    public void setMailresultat(String mailresultat) {
        this.mailresultat = mailresultat;
    }

    public Recherche getIdrecherche() {
        return idrecherche;
    }

    public void setIdrecherche(Recherche idrecherche) {
        this.idrecherche = idrecherche;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idresultat != null ? idresultat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resultat)) {
            return false;
        }
        Resultat other = (Resultat) object;
        if ((this.idresultat == null && other.idresultat != null) || (this.idresultat != null && !this.idresultat.equals(other.idresultat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.epsi.i4.tvq.database.entity.Resultat[ idresultat=" + idresultat + " ]";
    }

}
