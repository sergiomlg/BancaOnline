/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancaonline.bean;

import bancaonline.ejb.MovimientoFacade;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author W10
 */
@Named(value = "buscarMovimientosBean")
@RequestScoped
public class BuscarMovimientosBean {

    @EJB
    private MovimientoFacade movimientoFacade;
    /**
     * Creates a new instance of BuscarMovimientosBean
     */
    
    private String concepto;
    
    public BuscarMovimientosBean() {
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
    
    public String realizarBusqueda(){
        return "#";
    }
    
}
