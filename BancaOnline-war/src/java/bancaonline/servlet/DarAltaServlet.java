/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancaonline.servlet;

import bancaonline.ejb.CuentaFacade;
import bancaonline.ejb.UsuarioFacade;
import bancaonline.entity.Cuenta;
import bancaonline.entity.Usuario;
import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author W10
 */
@WebServlet(name = "DarAltaServlet", urlPatterns = {"/DarAltaServlet"})
public class DarAltaServlet extends HttpServlet {
    
    @EJB
    private UsuarioFacade usuarioFacade;
    
    @EJB
    private CuentaFacade cuentaFacade;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        String user, contrasena, nombre, surname, fechaNac, email, domicilio1, telefono,ncuenta;
        
        Cuenta cuenta= new Cuenta();
       
        
        List<String> errores = new ArrayList();
        String error ="";
        Usuario usuario;
        user = request.getParameter("user");
        contrasena = request.getParameter("password");
        surname = request.getParameter("apellidos");
        ncuenta=request.getParameter("ncuenta");
        nombre = request.getParameter("name");
        email = request.getParameter("email");               
        domicilio1 = request.getParameter("domicilio1");  
        SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        fechaNac = request.getParameter("fechaNac");
        Date fecha1 = null;
        fecha1 = fecha.parse(fechaNac);
        telefono = request.getParameter("telefono");  
        
        if(user.equalsIgnoreCase("")){
            error = error + "Faltan datos por introducir.";
            request.setAttribute("error", error);
            
        }else if(contrasena.equalsIgnoreCase("")){
            error = error +"Faltan datos por introducir.";
            request.setAttribute("error", error);
            
        }else if(surname.equalsIgnoreCase("")){
            error =error + "Faltan datos por introducir.";
            request.setAttribute("error", error);
            
        }else if(ncuenta.equalsIgnoreCase("")){
            error =error + "Faltan datos por introducir.";
            request.setAttribute("error", error);
            
        }else if(nombre.equalsIgnoreCase("")){
            error = error +"Faltan datos por introducir.";
            request.setAttribute("error", error);
            
        }else if(email.equalsIgnoreCase("")){
            error = error + "Faltan datos por introducir.";
            request.setAttribute("error", error);
           
        }else if(domicilio1.equalsIgnoreCase("")){
            error =error + "Faltan datos por introducir.";
            request.setAttribute("error", error);
            
        }else if(fechaNac.equalsIgnoreCase("")){
            error = error + "Faltan datos por introducir.";
            request.setAttribute("error", error);
            
        }else if(telefono.equalsIgnoreCase("")){
            error =error + "Faltan datos por introducir.";
            request.setAttribute("error", error);
            
        }
        if(error.equalsIgnoreCase("")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/darAlta.jsp");
            dispatcher.forward(request, response);
        }else {
        usuario = new Usuario();
        usuario.setIdUsuario(user);//es el DNI
        usuario.setSurname(surname);
        usuario.setDireccion(domicilio1);
        usuario.setEmail(email);
        usuario.setFechaNac(fecha1);
        usuario.setName(nombre);
        usuario.setPassword(contrasena);
        usuario.setTlf(Integer.parseInt(telefono));
        usuario.setCuentaList(new ArrayList());
        
        request.setAttribute("us",usuario );
        
        cuenta.setIdIBAN(ncuenta);
        cuenta.setMovimientoList(new ArrayList());
        cuenta.setSaldo(100);
        cuenta.setUser(usuario);
        cuenta.setMovimientoList(new ArrayList());
        
       
        this.usuarioFacade.create(usuario);
        
        this.cuentaFacade.create(cuenta);
        
        usuario.getCuentaList().add(cuenta);
        
        this.usuarioFacade.edit(usuario);
        
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/darAltaConfirmacion.jsp");
        rd.forward(request, response);
        
        }
        
        
          
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(DarAltaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(DarAltaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
