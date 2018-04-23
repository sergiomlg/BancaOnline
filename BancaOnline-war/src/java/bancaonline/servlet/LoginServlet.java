/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancaonline.servlet;

import bancaonline.ejb.EmpleadoFacade;
import bancaonline.ejb.UsuarioFacade;
import bancaonline.entity.Empleado;
import bancaonline.entity.Usuario;
import java.io.IOException;

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
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @EJB
    private EmpleadoFacade empleadoFacade;

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
            throws ServletException, IOException {
       
        
        Usuario res= usuarioFacade.find(request.getParameter("usuario"));
        
        Empleado e=empleadoFacade.find(request.getParameter("usuario"));
        
        if (res != null && res.getPassword().equals(request.getParameter("contra"))){
            
            request.setAttribute("user", res);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/inicioUsuario.jsp");

            dispatcher.forward(request, response);
  
        }else if(e != null && e.getPassword().equals(request.getParameter("contra"))){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/inicioTrabajador.jsp");

            dispatcher.forward(request, response);
        }else{
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.html");

            dispatcher.forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
