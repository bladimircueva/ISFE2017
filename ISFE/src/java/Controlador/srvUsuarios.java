/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.clsUsuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONObject;

/**
 *
 * @author Blad
 */
public class srvUsuarios extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private HttpServletRequest varRequest = null;
    private HttpServletResponse varResponse = null;
    private PrintWriter varOut = null;
    private HttpSession varSession = null;
    private clsUsuarios varUsuarios = null;
    
    
    public srvUsuarios()
    {
        varUsuarios = new clsUsuarios();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            varRequest = request;
            varResponse = response;
            varSession = request.getSession();
            varOut = varResponse.getWriter();
            
             if (varRequest.getParameter("parAccion").equals("list")) {
                metLista();
            } else if (varRequest.getParameter("parAccion").equals("create")) {
                System.out.println("MIERDAAAA");
                metCrear();
            } else if (varRequest.getParameter("parAccion").equals("delete")) {
                metQuitar();
            } else if (varRequest.getParameter("parAccion").equals("update")) {
                metModificar();
            }
        } finally {
            out.close();
        }
    }
    private void metLista() throws SQLException{
        JSONObject varJObjectLista = varUsuarios.metGetLista(); //To change body of generated methods, choose Tools | Templates.
       varOut.print(varJObjectLista);
    }


    private void metQuitar()throws SQLException{
        JSONObject varJObjectLista = varUsuarios.metQuitar(varRequest.getParameter("codigo"));
        varOut.print(varJObjectLista); 
    }

    private void metModificar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void metCrear() throws SQLException{
        String varUsuNombre = varRequest.getParameter("nombres");
        String varUsuApellidos = varRequest.getParameter("apellidos");
        String varUsuEmail = varRequest.getParameter("email");
        String varUsuDireccion = varRequest.getParameter("direccion");
        String varUsuTelefono = varRequest.getParameter("telefono");
        String varUsuDni = varRequest.getParameter("dni");
        String varUsuNombreusuario = varRequest.getParameter("nombreusuario");
        String varUsuPassword = varRequest.getParameter("password");
        String varUsuRol = varRequest.getParameter("rol_id").toString();
        String UsuCodigo = varSession.getAttribute("session_usu_nombreusuario").toString();
        JSONObject varJObjectNuevoRegistro = varUsuarios.metNuevo(varUsuNombre,varUsuApellidos,varUsuEmail,varUsuDireccion,varUsuTelefono,varUsuDni,varUsuNombreusuario,varUsuPassword,varUsuRol,UsuCodigo);
        varOut.print(varJObjectNuevoRegistro);
        
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
        } catch (SQLException ex) {
            Logger.getLogger(srvUsuarios.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(srvUsuarios.class.getName()).log(Level.SEVERE, null, ex);
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
