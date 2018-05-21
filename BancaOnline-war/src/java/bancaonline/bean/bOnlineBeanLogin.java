/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancaonline.bean;

import bancaonline.ejb.EmpleadoFacade;
import bancaonline.ejb.UsuarioFacade;
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
    
        private String user="";
        private String password="";
        private Usuario usuario = new Usuario();
        private Empleado empleado = new Empleado();

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
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
}
