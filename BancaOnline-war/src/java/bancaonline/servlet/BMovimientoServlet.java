/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancaonline.servlet;

import bancaonline.ejb.MovimientoFacade;
import bancaonline.entity.Cuenta;
import bancaonline.entity.Movimiento;
import bancaonline.entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author EzequielRodriguez
 */
@WebServlet(name = "BMovimientoServlet", urlPatterns = {"/BMovimientoServlet"})
public class BMovimientoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB
    private MovimientoFacade movimientoFacade;
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Movimiento> result= new ArrayList();
        HttpSession session= request.getSession();
        
        Usuario usuario = (Usuario) session.getAttribute("user");
        
        Cuenta cuentaUsuario= usuario.getCuentaList().get(0);
        String concepto= request.getParameter("concepto");
        
        List<Movimiento> resultado= movimientoFacade.findByConcepto(concepto,cuentaUsuario);
        
        if(resultado == null){
            request.setAttribute("movimientosEncontrados", resultado);
        }else{
            for(Movimiento mo : resultado){
                if(mo.getCuenta().equals(cuentaUsuario.getIdIBAN()) || mo.getIban().equals(cuentaUsuario)){
                    result.add(mo);
                }
            }
            
            request.setAttribute("movimientosEncontrados", result);
            
        }
        
        
        
        
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/busquedaFinalizada.jsp");
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
