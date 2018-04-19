/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancaonline.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author W10
 */
@Entity
@Table(name = "movimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimiento.findAll", query = "SELECT m FROM Movimiento m")
    , @NamedQuery(name = "Movimiento.findByIdCodigo", query = "SELECT m FROM Movimiento m WHERE m.idCodigo = :idCodigo")
    , @NamedQuery(name = "Movimiento.findByFecha", query = "SELECT m FROM Movimiento m WHERE m.fecha = :fecha")
    , @NamedQuery(name = "Movimiento.findByConcepto", query = "SELECT m FROM Movimiento m WHERE m.concepto = :concepto")
    , @NamedQuery(name = "Movimiento.findByCantidad", query = "SELECT m FROM Movimiento m WHERE m.cantidad = :cantidad")
    , @NamedQuery(name = "Movimiento.findByObservacion", query = "SELECT m FROM Movimiento m WHERE m.observacion = :observacion")
    , @NamedQuery(name = "Movimiento.findByCuenta", query = "SELECT m FROM Movimiento m WHERE m.cuenta = :cuenta")})
public class Movimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCodigo")
    private Integer idCodigo;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 45)
    @Column(name = "concepto")
    private String concepto;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Size(max = 45)
    @Column(name = "observacion")
    private String observacion;
    @Size(max = 20)
    @Column(name = "cuenta")
    private String cuenta;
    @JoinColumn(name = "empleado", referencedColumnName = "idEmpleado")
    @ManyToOne
    private Empleado empleado;
    @JoinColumn(name = "IBAN", referencedColumnName = "idIBAN")
    @ManyToOne
    private Cuenta iban;

    public Movimiento() {
    }

    public Movimiento(Integer idCodigo) {
        this.idCodigo = idCodigo;
    }

    public Integer getIdCodigo() {
        return idCodigo;
    }

    public void setIdCodigo(Integer idCodigo) {
        this.idCodigo = idCodigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Cuenta getIban() {
        return iban;
    }

    public void setIban(Cuenta iban) {
        this.iban = iban;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCodigo != null ? idCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimiento)) {
            return false;
        }
        Movimiento other = (Movimiento) object;
        if ((this.idCodigo == null && other.idCodigo != null) || (this.idCodigo != null && !this.idCodigo.equals(other.idCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bancaonline.ejb.Movimiento[ idCodigo=" + idCodigo + " ]";
    }
    
}
