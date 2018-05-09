/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancaonline.servlet;

import bancaonline.ejb.CuentaFacade;
import bancaonline.ejb.MovimientoFacade;
import bancaonline.entity.Cuenta;
import bancaonline.entity.Movimiento;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
@WebServlet(name = "RealizarApunteServlet", urlPatterns = {"/RealizarApunteServlet"})
public class RealizarApunteServlet extends HttpServlet {

    @EJB private CuentaFacade cuentaf;
    @EJB private MovimientoFacade movf;
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
        String c = request.getParameter("saldo");
        String concepto= request.getParameter("concepto");
        String cuenta = request.getParameter("cuentad");
        Cuenta cuentabbdd = cuentaf.find(cuenta);
        String mensaje = null;
        if(cuentabbdd==null || cuenta.equalsIgnoreCase("")){
            mensaje= "No existe la cuenta introducida";
            request.setAttribute("mensaje", mensaje);
                    
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ErrorRealizarApunte.jsp");

            dispatcher.forward(request, response);
        }else if(c.equalsIgnoreCase("")){
            mensaje = "Cantidad no valida";
            request.setAttribute("mensaje", mensaje);
                    
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ErrorRealizarApunte.jsp");

            dispatcher.forward(request, response);
        }else if(concepto.equalsIgnoreCase("")){
            mensaje = "Debes introducir un concepto";
            request.setAttribute("mensaje", mensaje);
                    
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ErrorRealizarApunte.jsp");

            dispatcher.forward(request, response);
        }else{
             
        Movimiento m = new Movimiento();
        int contador = movf.count();
        m.setCantidad(Integer.parseInt(c));
        m.setConcepto(concepto);
        m.setCuenta(cuenta);
        m.setFecha(new Date());
        m.setIdCodigo(contador+1);
        movf.create(m);
        cuentabbdd.getMovimientoList().add(m);
        cuentaf.edit(cuentabbdd);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/inicioTrabajador.jsp");

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
