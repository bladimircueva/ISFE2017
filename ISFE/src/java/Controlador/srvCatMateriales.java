/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.clsCatMateriales;
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
public class srvCatMateriales extends HttpServlet {

    private HttpServletRequest varRequest = null;
    private HttpServletResponse varResponse = null;
    private PrintWriter varOut = null;
    private HttpSession varSession = null;
    private clsCatMateriales varCatMateriales = null;
    
    
    public srvCatMateriales()
    {
        varCatMateriales = new clsCatMateriales();
    }
    
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
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
                metCrear();
            } else if (varRequest.getParameter("parAccion").equals("delete")) {
                metEliminar();
            } else if (varRequest.getParameter("parAccion").equals("update")) {
                metModificar();
            }
        } finally {
            out.close();
        }
    }
    

    private void metLista() throws SQLException{
       JSONObject varJObjectLista = varCatMateriales.metGetLista(); //To change body of generated methods, choose Tools | Templates.
       varOut.print(varJObjectLista);
               }

    private void metCrear() throws SQLException {
        String VarCodigo = varRequest.getParameter("codigo");
        String VarDescripcion = varRequest.getParameter("descripcion");
        String UsuCodigo = varSession.getAttribute("session_usu_nombreusuario").toString();
        JSONObject varJObjectNuevoRegistro = varCatMateriales.metNuevo(VarCodigo,VarDescripcion,UsuCodigo);
        varOut.print(varJObjectNuevoRegistro);
    }

    private void metEliminar() throws SQLException {
        String VarId = varRequest.getParameter("id");
        JSONObject varJObjectLista = varCatMateriales.metQuitar(VarId);
        varOut.print(varJObjectLista);
    }

    private void metModificar() throws SQLException{
        String VarId = varRequest.getParameter("id");
         String VarCodigo = varRequest.getParameter("codigo");
        String VarDescripcion = varRequest.getParameter("descripcion");
        String VarUsuarioModificacion = varSession.getAttribute("session_usu_nombreusuario").toString();
        JSONObject varJObjectNuevoRegistro = varCatMateriales.metEditar(VarId,VarCodigo, VarDescripcion,VarUsuarioModificacion);
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
            Logger.getLogger(srvCatMateriales.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(srvCatMateriales.class.getName()).log(Level.SEVERE, null, ex);
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
