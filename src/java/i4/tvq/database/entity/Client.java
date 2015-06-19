/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i4.tvq.database.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "CLIENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByIdclient", query = "SELECT c FROM Client c WHERE c.idclient = :idclient"),
    @NamedQuery(name = "Client.findByNomclient", query = "SELECT c FROM Client c WHERE c.nomclient = :nomclient"),
    @NamedQuery(name = "Client.findByPrenomclient", query = "SELECT c FROM Client c WHERE c.prenomclient = :prenomclient"),
    @NamedQuery(name = "Client.findByMailclient", query = "SELECT c FROM Client c WHERE c.mailclient = :mailclient")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCLIENT")
    private BigDecimal idclient;
    @Size(max = 1024)
    @Column(name = "NOMCLIENT")
    private String nomclient;
    @Size(max = 1024)
    @Column(name = "PRENOMCLIENT")
    private String prenomclient;
    @Size(max = 1024)
    @Column(name = "MAILCLIENT")
    private String mailclient;
    @Lob
    @Column(name = "PASSWORDCLIENT")
    private String passwordclient;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idclient")
    private List<Recherche> rechercheList;

    public Client() {
    }

    public Client(BigDecimal idclient) {
        this.idclient = idclient;
    }

    public Client(BigDecimal idclient, String nomclient, String prenomclient, String mailclient, String passwordclient) {
        this.idclient = idclient;
        this.nomclient = nomclient;
        this.prenomclient = prenomclient;
        this.mailclient = mailclient;
        this.passwordclient = passwordclient;
    }

    public BigDecimal getIdclient() {
        return idclient;
    }

    public void setIdclient(BigDecimal idclient) {
        this.idclient = idclient;
    }

    public String getNomclient() {
        return nomclient;
    }

    public void setNomclient(String nomclient) {
        this.nomclient = nomclient;
    }

    public String getPrenomclient() {
        return prenomclient;
    }

    public void setPrenomclient(String prenomclient) {
        this.prenomclient = prenomclient;
    }

    public String getMailclient() {
        return mailclient;
    }

    public void setMailclient(String mailclient) {
        this.mailclient = mailclient;
    }

    public String getPasswordclient() {
        return passwordclient;
    }

    public void setPasswordclient(String passwordclient) {
        this.passwordclient = passwordclient;
    }

    @XmlTransient
    public List<Recherche> getRechercheList() {
        return rechercheList;
    }

    public void setRechercheList(List<Recherche> rechercheList) {
        this.rechercheList = rechercheList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclient != null ? idclient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.idclient == null && other.idclient != null) || (this.idclient != null && !this.idclient.equals(other.idclient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.epsi.i4.tvq.database.entity.Client[ idclient=" + idclient + " ]";
    }

}
