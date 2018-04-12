/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancaonline.ejb;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
 * @author W10
 */
@Entity
@Table(name = "cuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c")
    , @NamedQuery(name = "Cuenta.findByIdIBAN", query = "SELECT c FROM Cuenta c WHERE c.idIBAN = :idIBAN")
    , @NamedQuery(name = "Cuenta.findBySaldo", query = "SELECT c FROM Cuenta c WHERE c.saldo = :saldo")})
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "idIBAN")
    private String idIBAN;
    @Column(name = "saldo")
    private Integer saldo;
    @OneToMany(mappedBy = "iban")
    private List<Movimiento> movimientoList;
    @JoinColumn(name = "user", referencedColumnName = "idUsuario")
    @ManyToOne
    private Usuario user;

    public Cuenta() {
    }

    public Cuenta(String idIBAN) {
        this.idIBAN = idIBAN;
    }

    public String getIdIBAN() {
        return idIBAN;
    }

    public void setIdIBAN(String idIBAN) {
        this.idIBAN = idIBAN;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    @XmlTransient
    public List<Movimiento> getMovimientoList() {
        return movimientoList;
    }

    public void setMovimientoList(List<Movimiento> movimientoList) {
        this.movimientoList = movimientoList;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIBAN != null ? idIBAN.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.idIBAN == null && other.idIBAN != null) || (this.idIBAN != null && !this.idIBAN.equals(other.idIBAN))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bancaonline.ejb.Cuenta[ idIBAN=" + idIBAN + " ]";
    }
    
}
