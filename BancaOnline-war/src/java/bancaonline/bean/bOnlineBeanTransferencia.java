/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancaonline.bean;

import bancaonline.ejb.CuentaFacade;
import bancaonline.ejb.MovimientoFacade;
import bancaonline.ejb.UsuarioFacade;
import bancaonline.entity.Cuenta;
import bancaonline.entity.Movimiento;
import java.time.Instant;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author juan
 */
@Named(value = "bOnlineBeanTransferencia")
@RequestScoped
public class bOnlineBeanTransferencia {

    @Inject 
    private bOnlineBeanLogin beanLogin;
    
    @EJB 
    private CuentaFacade cuentaFacade;
    
    @EJB
    private MovimientoFacade movimientoFacade;
    
    @EJB
    private UsuarioFacade usuarioFacade;
    /**
     * Creates a new instance of bOnlineBeanTransferencia
     */
    
    protected Cuenta cuentaDestino, cuenta;
    protected Integer idIBAN;
    protected int cantidad;
    protected String concepto;
    
    public bOnlineBeanTransferencia() {
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Integer getIdIBAN() {
        return idIBAN;
    }

    public void setIdIBAN(Integer idIBAN) {
        this.idIBAN = idIBAN;
    }


    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }

    

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public String doRealizar(){
        this.cuentaDestino = cuentaFacade.find(idIBAN);
        this.cuenta = beanLogin.getCuentaTrans();
        cuenta.setSaldo(cuenta.getSaldo()-cantidad);
        cuentaDestino.setSaldo(cuentaDestino.getSaldo()+cantidad);
        int contador= movimientoFacade.count();
        
        Movimiento mov = new Movimiento();
        mov.setCantidad(cantidad);
        mov.setConcepto(concepto);
        mov.setFecha(new Date());
        mov.setCuentaOrigen(cuenta); 
        
        
        movimientoFacade.create(mov);
        
        cuenta.getMovimientoList().add(mov);
        cuentaDestino.getMovimientoList().add(mov);
        cuentaFacade.edit(cuenta);
        cuentaFacade.edit(cuentaDestino);
        
        
        
        return "paginaCuenta";
    }
    
    @PostConstruct
    public void init () {
        cuenta = beanLogin.getCuentaTrans();
        
    }
    
    
}
