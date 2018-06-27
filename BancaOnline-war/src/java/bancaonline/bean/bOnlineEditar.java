/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancaonline.bean;

import bancaonline.ejb.UsuarioFacade;
import bancaonline.entity.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class bOnlineEditar {

    @Inject private bOnlineBean bOnlineBean;
    
    @EJB private UsuarioFacade userFacade;
    
    private Usuario user;


    
    public bOnlineEditar() {
    }

    public Usuario getUser() {
        return user;  
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    
    public bOnlineBean getbOnlineBean() {
        return bOnlineBean;
    }

    public void setbOnlineBean(bOnlineBean bOnlineBean) {
        this.bOnlineBean = bOnlineBean;
    }
    
    @PostConstruct
    public void init(){
        this.user = this.userFacade.find(this.bOnlineBean.getIdUsuarioSeleccionado());
    }
    
    public String doGuardar(){
        
        this.userFacade.edit(user);
        this.bOnlineBean.init();
        return "listadoClientes.xhtml";
    }
    
    
}
