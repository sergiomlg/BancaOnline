/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancaonline.bean;

import bancaonline.ejb.CuentaFacade;
import bancaonline.ejb.MovimientoFacade;
import bancaonline.entity.Cuenta;
import bancaonline.entity.Movimiento;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author W10
 */
@Named(value = "realizarApunteBean")
@RequestScoped
public class RealizarApunteBean {

    @EJB
    private MovimientoFacade movimientoFacade;

    @EJB
    private CuentaFacade cuentaFacade;
    
    

    /**
     * Creates a new instance of RealizarApunteBean
     */
    
    
     private Integer idCuenta;
     private int cantidad;
     private String concepto;
     private String error;
    public RealizarApunteBean() {
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    
    
    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

   

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
    
    public String doApunte(){
        Cuenta cuenta=cuentaFacade.find(idCuenta);
        
        if(cuenta == null){
            error="Cuenta no válida";
            return "realizarApunte";
        }
        if(concepto.equals("")){
            error="Concepto obligatorio";
            return "realizarApunte";
        }
        cuenta.setSaldo(cuenta.getSaldo()+cantidad);
        Movimiento m= new Movimiento();
        m.setCantidad(cantidad);
        m.setConcepto(concepto);
         m.setFecha(new Date());
        m.setCuentaDestino(0);
       
        m.setCuentaOrigen(cuenta);
        
        
        movimientoFacade.create(m);
        cuenta.getMovimientoList().add(m);

        return "inicioTrabajador";
 
    }
    
    
    
    
}
