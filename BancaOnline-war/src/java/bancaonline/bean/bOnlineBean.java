/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancaonline.bean;

import bancaonline.ejb.UsuarioFacade;
import bancaonline.entity.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author EzequielRodriguez
 */
@Named(value = "bOnlineBean") //Bean de listado Clientes
@SessionScoped
public class bOnlineBean implements Serializable {

   @EJB private UsuarioFacade userFacade;
   
   private List<Usuario> listaClientes;
   
   private String idUsuarioSeleccionado;
   
    
    public bOnlineBean() {
    }

    public List<Usuario> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Usuario> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public String getIdUsuarioSeleccionado() {
        return idUsuarioSeleccionado;
    }

    public void setIdUsuarioSeleccionado(String idUsuarioSeleccionado) {
        this.idUsuarioSeleccionado = idUsuarioSeleccionado;
    }
    
    
    
    @PostConstruct
    public void init(){
        listaClientes = this.userFacade.findAll();
    }
    
    public String doEditar(String idUsuario){
        this.idUsuarioSeleccionado = idUsuario;
        return "editarCliente.xhtml";
    }
    
    public String doEliminar(String idUsuario){
        return "listaClientes.xhtml";
    }
    
}
