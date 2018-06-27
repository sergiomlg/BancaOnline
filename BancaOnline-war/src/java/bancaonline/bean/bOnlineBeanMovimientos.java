/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancaonline.bean;

import bancaonline.ejb.MovimientoFacade;
import bancaonline.entity.Cuenta;
import bancaonline.entity.Movimiento;
import bancaonline.entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Angel
 */
@Named(value = "bOnlineBeanMovimientos")
@RequestScoped
public class bOnlineBeanMovimientos {

    @Inject
    private bOnlineBeanLogin sessionBean;
    
    private Usuario user;
    private Cuenta cuenta;
    private List<Movimiento> listaMovimientos, listaMovimientosFiltrado;
    private String concepto;
   
    /**
     * Creates a new instance of bOnlineBeanMovimientos
     */
    public bOnlineBeanMovimientos() {
    }
    
    
    @PostConstruct
    public void init(){
        user = sessionBean.getUsuario();
        cuenta = user.getCuentaList().get(0);
        listaMovimientos = cuenta.getMovimientoList();
        listaMovimientosFiltrado=listaMovimientos;
    }
    
    public void filtrar(){
        
        listaMovimientosFiltrado= new ArrayList<>();
        if(!concepto.equals("")){
        for(Movimiento m : listaMovimientos){
            if(m.getConcepto().equalsIgnoreCase(concepto)){
                listaMovimientosFiltrado.add(m);
            }
        }
        }else{
            listaMovimientosFiltrado = listaMovimientos;
        }
        
        int i=0;
        
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public List<Movimiento> getListaMovimientos() {
        return listaMovimientos;
    }

    public void setListaMovimientos(List<Movimiento> listaMovimientos) {
        this.listaMovimientos = listaMovimientos;
    }

    public List<Movimiento> getListaMovimientosFiltrado() {
        return listaMovimientosFiltrado;
    }

    public void setListaMovimientosFiltrado(List<Movimiento> listaMovimientosFiltrado) {
        this.listaMovimientosFiltrado = listaMovimientosFiltrado;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
    
    
}
