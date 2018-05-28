/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancaonline.bean;

import bancaonline.ejb.CuentaFacade;
import bancaonline.ejb.EmpleadoFacade;
import bancaonline.ejb.UsuarioFacade;
import bancaonline.entity.Cuenta;
import bancaonline.entity.Empleado;
import bancaonline.entity.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author EzequielRodriguez
 */
@Named(value = "bOnlineBeanLogin")
@SessionScoped
public class bOnlineBeanLogin implements Serializable {

    /**
     * Creates a new instance of bOnlineBeanLogin
     */
    @EJB UsuarioFacade usuarioFacade;
    @EJB EmpleadoFacade empleadoFacade;
    @EJB CuentaFacade cuentaFacade;
    
        private String user="";
        private String password="";
        private Usuario usuario = new Usuario();
        private Empleado empleado = new Empleado();
        
        private Cuenta cuentaTrans=new Cuenta();

    public String getUser() {
        return user;
    }
    
    public Cuenta getCuentaTrans() {
        return cuentaTrans;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public bOnlineBeanLogin() {
    }
    
    public String doLogin(){
        String res = "";
        Usuario us = usuarioFacade.find(user);
        Empleado em = empleadoFacade.find(user);
        
        if(us!=null && us.getPassword().equals(password)){
            res="inicioUsuario";
            usuario = us;
        }else if(em!=null && em.getPassword().equals(password)){
            res="inicioTrabajador";
            empleado = em;
        }else{
            res="login";
            
        }
        
        return res;
    }
    
    public String doRealizarTransferencia(String idCuenta){
        cuentaTrans= cuentaFacade.find(idCuenta);
        return "transferencia";
    }
    
    public String doBuscarMovimientos(){
        return "buscarMovimientos";
        
    }
    
}
