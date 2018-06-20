/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancaonline.bean;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Angel
 */
@Named(value = "bOnlineRealizarApunte")
@RequestScoped
public class bOnlineRealizarApunte {

    @Inject
    bOnlineBeanLogin sessionBean;
    
    private Integer idIban, cantidad;
    private String Concepto = "";
   
    /**
     * Creates a new instance of bOnlineRealizarApunte
     */
    public bOnlineRealizarApunte() {
    }
    
}
