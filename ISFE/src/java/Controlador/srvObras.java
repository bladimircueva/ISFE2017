/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.clsObras;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import net.sf.json.JSONObject;
import org.codehaus.groovy.ast.ClassHelper;
import java.sql.SQLException;
import net.sf.json.JSONArray;
import org.apache.commons.beanutils.Converter;
/**
 *
 * @author Blad
 */
public class srvObras extends HttpServlet {

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
    private clsObras varObras = null;
    
    public srvObras()
    {
        varObras = new clsObras();
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
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
            } else if (varRequest.getParameter("parAccion").equals("listchild")) {
                System.out.print("varmaster:" + varRequest.getParameter("varmaster"));
                metPartidadListar(varRequest.getParameter("varmaster"));
            } else if (varRequest.getParameter("parAccion").equals("updatechild")) {
                System.out.print("varmaster:" + varRequest.getParameter("varmaster"));
                metchildEditar(varRequest.getParameter("varmaster"));
            } else if (varRequest.getParameter("parAccion").equals("deletechild")) {
                metchildEliminar();
            } else if (varRequest.getParameter("parAccion").equals("createchild")) {
                metPartidaCrear(varRequest.getParameter("varmaster"));
            } else if (varRequest.getParameter("parAccion").equals("getListObra")) {
                metGetListObra();
            }
            
            
        } finally {
            out.close();
        }
        
    }
    
    private void metModificar() {
        String varObrId = varRequest.getParameter("id");
        String varObrCod = varRequest.getParameter("codigo");
        String varObrNom = varRequest.getParameter("nombre");
        String varObrNomCli = varRequest.getParameter("nombrecliente");
        String varObrUbi = varRequest.getParameter("ubicacion");
        String varObrFecIni = varRequest.getParameter("fechainicio");
        String varObrFecFin = varRequest.getParameter("fechafin");
        String varObrPre = varRequest.getParameter("presupuesto");
        String varObrNumPar = varRequest.getParameter("numeropartidas");
        String UsuCodigo = varSession.getAttribute("session_usu_nombreusuario").toString();
        JSONObject varJObjectNuevoRegistro = varObras.metEditarObra(
                varObrId,
                varObrCod,
                varObrNom,
                varObrNomCli,
                varObrUbi,
                varObrFecIni,
                varObrFecFin,
                varObrPre,
                varObrNumPar,
                UsuCodigo);
        varOut.print(varJObjectNuevoRegistro);
    }

    private void metEliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void metCrear() throws SQLException{
        String varObrusuId = varRequest.getParameter("usuario_id");
        String varObrUsuCre = varRequest.getParameter("usuariocreacion");
        String varObrCod = varRequest.getParameter("codigo");
        String varObrNom = varRequest.getParameter("nombre");
        String varObrNomCli = varRequest.getParameter("nombrecliente");
        String varObrUbi = varRequest.getParameter("ubicacion");
        String varObrFecIni = varRequest.getParameter("fechainicio");
        String varObrFecFin = varRequest.getParameter("fechafin");
        String varObrPre = varRequest.getParameter("presupuesto");
        String varObrNumPar = varRequest.getParameter("numeropartidas");
        String UsuCodigo = varSession.getAttribute("session_usu_nombreusuario").toString();
        JSONObject varJObjectNuevoRegistro = varObras.metNuevoObra(
                varObrusuId,
                varObrUsuCre,
                varObrCod,
                varObrNom,
                varObrNomCli,
                varObrUbi,
                varObrFecIni,
                varObrFecFin,
                varObrPre,
                varObrNumPar,
                UsuCodigo);
        varOut.print(varJObjectNuevoRegistro);
    }

    private void metLista() throws SQLException{

        JSONObject varJObjectLista = varObras.metGetLista();
        varOut.print(varJObjectLista);
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
            Logger.getLogger(srvObras.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(srvObras.class.getName()).log(Level.SEVERE, null, ex);
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

    private void metPartidadListar(String varmaster) throws SQLException{
        JSONObject varJObjectLista = varObras.metListChild(varmaster);
        varOut.print(varJObjectLista);
    }

    private void metchildEditar(String parameter) throws SQLException{
        String varParId = varRequest.getParameter("id");
        String varParObrId = parameter;
        String varParCod = varRequest.getParameter("codigo");
        String varParFecIni = varRequest.getParameter("fechainicio");
        String varParFecFin = varRequest.getParameter("fechafin");
        String varParUsuModificacion = varSession.getAttribute("session_usu_nombreusuario").toString();
        JSONObject varJObjectNuevoRegistro = varObras.metEditarchild(
                varParId,
                varParObrId,
                varParCod,
                varParFecIni,
                varParFecFin,
                varParUsuModificacion
        );
        varOut.print(varJObjectNuevoRegistro);
    }

    private void metchildEliminar() {
        JSONObject varJObjectLista = varObras.metDeleteChild(varRequest.getParameter("id"));
        varOut.print(varJObjectLista);
    }

    private void metPartidaCrear(String parameter) {
        String varParObrId = parameter;
        String varParCod = varRequest.getParameter("codigo");
        String varParFecIni = varRequest.getParameter("fechainicio");
        String varParFecFin = varRequest.getParameter("fechafin");
        String UsuCodigo = varSession.getAttribute("session_usu_nombreusuario").toString();
        JSONObject varJObjectNuevoRegistro = varObras.metNuevaPartida(
                varParObrId,
                varParCod,
                varParFecIni,
                varParFecFin,
                UsuCodigo);
        varOut.print(varJObjectNuevoRegistro);
    }

    private void metGetListObra() throws SQLException{
        JSONArray JSONArray = varObras.metListObras();
            varOut.print(JSONArray);
    }

    

}
