/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancaonline.bean;

import bancaonline.ejb.CuentaFacade;
import bancaonline.ejb.UsuarioFacade;
import bancaonline.entity.Cuenta;
import bancaonline.entity.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


/**
 *
 * @author W10
 */
@Named(value = "darDeAltaBean")
@RequestScoped
public class DarDeAltaBean {

    @EJB
    private CuentaFacade cuentaFacade;
    
    @EJB
    private UsuarioFacade usuarioFacade;

    private String usuario;
    private String password;
    private String nombre;
    private String apellidos;
    private String email;
    private String direccion;
    private String ncuenta;
    private String telefono;
    private String fechaNac;
    private  SimpleDateFormat fecha1 = new SimpleDateFormat("yyyy-MM-dd");
    private Date fecha=null;
    private String error;

    /**
     * Creates a new instance of DarDeAltaBean
     */
    public DarDeAltaBean() {
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    

    public String getNcuenta() {
        return ncuenta;
    }

    public void setNcuenta(String ncuenta) {
        this.ncuenta = ncuenta;
    }

    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        
            this.telefono = telefono;

    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        try{
            this.fechaNac = fechaNac;
             Date aux= fecha1.parse(fechaNac);
            this.setFecha(aux);
        }catch (ParseException e){
            error = "Formato fecha errónea";
        }
        
    }

    public Date getFecha() {
        return fecha;
    }

    private void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public String darDealta(){
        int telf=0;
        try{
            telf=Integer.parseInt(this.telefono);
        }catch (NumberFormatException e){
            error= "Teléfono no válido";
            return "darDeAlta";
        }
        if(usuario.equalsIgnoreCase("") || password.equalsIgnoreCase("") || apellidos.equalsIgnoreCase("") 
                || ncuenta.equalsIgnoreCase("") || nombre.equalsIgnoreCase("") || email.equalsIgnoreCase("")
                || direccion.equalsIgnoreCase("") || fechaNac.equalsIgnoreCase("") || telf == 0){
            error = "Datos no válidos";
            return "darDeAlta";
        }else{
        Usuario user = new Usuario();
        user.setIdUsuario(this.usuario);//es el DNI
        user.setSurname(apellidos);
        user.setDireccion(direccion);
        user.setEmail(email);
        user.setFechaNac(fecha);
        user.setName(nombre);
        user.setPassword(password);
        user.setTlf(telf);
        user.setCuentaList(new ArrayList());
        
       
        Cuenta cuenta= new Cuenta();
        cuenta.setIdIBAN(ncuenta);
        cuenta.setMovimientoList(new ArrayList());
        cuenta.setSaldo(100);//Por defecto
        cuenta.setUser(user);
        
        
       
        this.usuarioFacade.create(user);
        
        this.cuentaFacade.create(cuenta);
        
        user.getCuentaList().add(cuenta);
        
        this.usuarioFacade.edit(user);
        
        return "darDeAlta";
        }
        
        
    }
    
    
}
