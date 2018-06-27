/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancaonline.bean;

import bancaonline.ejb.UsuarioFacade;
import bancaonline.entity.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;


import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author EzequielRodriguez
 */
@Named(value = "bOnlineEditar")
@RequestScoped
public class bOnlineEditar implements Serializable{

    @Inject 
    private bOnlineBean bOnlineBean;
    
    @EJB private UsuarioFacade userFacade;
    
    private Usuario user;
   
    
    

    public bOnlineEditar() {
    }
    
    @PostConstruct
    public void init(){
        this.user = this.userFacade.find(this.bOnlineBean.getIdUsuarioSeleccionado());
        
    }

    public Usuario getUser() {
        return user;  
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    
   
    
    public String doGuardar(){
       
        
        this.userFacade.edit(user);
        this.bOnlineBean.actualizarLista();
        
        return "listadoClientes";
    }
    
    
}
