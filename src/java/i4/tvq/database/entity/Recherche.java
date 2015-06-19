/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i4.tvq.database.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Edgar
 */
@Entity
@Table(name = "RECHERCHE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recherche.findAll", query = "SELECT r FROM Recherche r"),
    @NamedQuery(name = "Recherche.findByIdrecherche", query = "SELECT r FROM Recherche r WHERE r.idrecherche = :idrecherche"),
    @NamedQuery(name = "Recherche.findByLibellerecherche", query = "SELECT r FROM Recherche r WHERE r.libellerecherche = :libellerecherche"),
    @NamedQuery(name = "Recherche.findByProfondeurrecherche", query = "SELECT r FROM Recherche r WHERE r.profondeurrecherche = :profondeurrecherche"),
    @NamedQuery(name = "Recherche.findByDaterecherche", query = "SELECT r FROM Recherche r WHERE r.daterecherche = :daterecherche")})
public class Recherche implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDRECHERCHE")
    private BigDecimal idrecherche;
    @Size(max = 1024)
    @Column(name = "LIBELLERECHERCHE")
    private String libellerecherche;
    @Column(name = "PROFONDEURRECHERCHE")
    private BigInteger profondeurrecherche;
    @Size(max = 1024)
    @Column(name = "DATERECHERCHE")
    private String daterecherche;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idrecherche")
    private List<Resultat> resultatList;
    @JoinColumn(name = "IDCLIENT", referencedColumnName = "IDCLIENT")
    @ManyToOne(optional = false)
    private Client idclient;

    public Recherche() {
    }

    public Recherche(BigDecimal idrecherche) {
        this.idrecherche = idrecherche;
    }

    public BigDecimal getIdrecherche() {
        return idrecherche;
    }

    public void setIdrecherche(BigDecimal idrecherche) {
        this.idrecherche = idrecherche;
    }

    public String getLibellerecherche() {
        return libellerecherche;
    }

    public void setLibellerecherche(String libellerecherche) {
        this.libellerecherche = libellerecherche;
    }

    public BigInteger getProfondeurrecherche() {
        return profondeurrecherche;
    }

    public void setProfondeurrecherche(BigInteger profondeurrecherche) {
        this.profondeurrecherche = profondeurrecherche;
    }

    public String getDaterecherche() {
        return daterecherche;
    }

    public void setDaterecherche(String daterecherche) {
        this.daterecherche = daterecherche;
    }

    @XmlTransient
    public List<Resultat> getResultatList() {
        return resultatList;
    }

    public void setResultatList(List<Resultat> resultatList) {
        this.resultatList = resultatList;
    }

    public Client getIdclient() {
        return idclient;
    }

    public void setIdclient(Client idclient) {
        this.idclient = idclient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrecherche != null ? idrecherche.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recherche)) {
            return false;
        }
        Recherche other = (Recherche) object;
        if ((this.idrecherche == null && other.idrecherche != null) || (this.idrecherche != null && !this.idrecherche.equals(other.idrecherche))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.epsi.i4.tvq.database.entity.Recherche[ idrecherche=" + idrecherche + " ]";
    }

}
