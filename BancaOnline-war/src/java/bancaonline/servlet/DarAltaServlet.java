/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancaonline.servlet;

import bancaonline.ejb.UsuarioFacade;
import bancaonline.entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        String user, contraseña, nombre, surname, fechaNac, email, domicilio1, telefono;
       
        Usuario usuario;
        user = request.getParameter("user");
        contraseña = request.getParameter("password");
        surname = request.getParameter("apellidos");
        
        nombre = request.getParameter("name");
        email = request.getParameter("email");               
        domicilio1 = request.getParameter("domicilio1");  
        SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        fechaNac = request.getParameter("fechaNac");
        Date fecha1 = null;
        fecha1 = fecha.parse(fechaNac);
        
        telefono = request.getParameter("telefono");                
        
        usuario = new Usuario();
        usuario.setIdUsuario(user);//es el DNI
        usuario.setSurname(surname);
        usuario.setDireccion(domicilio1);
        usuario.setEmail(email);
        usuario.setFechaNac(fecha1);
        usuario.setName(nombre);
        usuario.setPassword(contraseña);
        usuario.setTlf(Integer.parseInt(telefono));
       
        this.usuarioFacade.create(usuario);
        
         RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/inicioTrabajador.jsp");
        rd.forward(request, response); 
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
