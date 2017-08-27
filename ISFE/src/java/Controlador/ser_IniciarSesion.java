/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.clsConexionISFE;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Blad
 */
public class ser_IniciarSesion extends HttpServlet {

    private clsConexionISFE varClsConexion;
    private PreparedStatement pstmt;
    private HttpSession varSesion;
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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        String varAccion = request.getParameter("parAccion");
        System.out.print("VALOR VARACCION: " + varAccion);
        if(varAccion.equals("cerrar_sesion"))
        {
            metCerrarSesion(request, response);
            return;
        }
        try {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            if (varAccion.equals("iniciar"))
            {
                session.setAttribute("session_usu_nombreusuario", request.getParameter("parNombreUsuario"));
                
            }
            else if(varAccion.equals("consulta"))
            {
                String consulta = "SELECT "
                        + "USU.nombreusuario,"
                        + "USU.password "
                        + "FROM USUARIO USU "
                        + "WHERE "
                        + "USU.nombreusuario=(?) "
                        + "AND "
                        + "USU.password=(?);";
                System.out.print("consulta: " + consulta);
                varClsConexion = new clsConexionISFE();
                
                pstmt = varClsConexion.getConexion().prepareStatement(consulta);
                pstmt.setString(1,request.getParameter("parNombreUsuario").toString());
                pstmt.setString(2, request.getParameter("parContrasenha").toString());
                
                ResultSet varResultado = pstmt.executeQuery();
                String varNombreUsuario = "", varCodigoUsuario = "";
                boolean usuario = false;
                while (varResultado.next())
                {
                    varNombreUsuario = varResultado.getString("nombreusuario");
                    varCodigoUsuario = varResultado.getString("password");
                    usuario = true;
                }
                varResultado.close();
                varResultado = null;
                pstmt.close();
                pstmt = null;
                varClsConexion.closeConexion();
                varOut = response.getWriter();
                varOut.println(usuario);
                session.setAttribute("session_usu_nombreusuario", varNombreUsuario);
                session.setAttribute("session_usu_password", varCodigoUsuario);
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ser_IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        finally
        {
            out.close();
        }
        
    }
    private PrintWriter varOut = null;
    private void metCerrarSesion(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        HttpSession session = request.getSession();
        session.invalidate();
        System.out.println("Sesion cerrada");
        response.sendRedirect("/ISFE/");
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
            Logger.getLogger(ser_IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ser_IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
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
