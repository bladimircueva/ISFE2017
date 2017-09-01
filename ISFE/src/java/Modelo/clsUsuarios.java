/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import Modelo.clsConexionISFE;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Blad
 */
public class clsUsuarios {
    
     private clsConexionISFE varClsConexion;
    private final String varNombreEsquema;
    private final String varNombreTabla;
    
    public clsUsuarios()
    {
        varClsConexion = new clsConexionISFE();
        varNombreEsquema = "dbo";
        varNombreTabla = "USUARIO";
    }
    public JSONObject metGetLista() {
        JSONObject varJsonObjectP = new JSONObject();
        JSONArray varJsonArrayP = new JSONArray();
        JSONObject varJsonObjectResultado = new JSONObject();
        
        try {
            String varSql = "SELECT \n"
                    +" * \n"
                    +" FROM \n"
                    +" "+varNombreTabla+";";
            PreparedStatement varPst = varClsConexion.getConexion().prepareStatement(varSql);
            ResultSet varResultado = varPst.executeQuery();
            System.out.println("RESULTADO DE LA COSNULTA" + varSql);
            while (varResultado.next()) {
                varJsonObjectP.put("nombres", varResultado.getString("nombres"));
                varJsonObjectP.put("apellidos", varResultado.getString("apellidos"));
                varJsonObjectP.put("email", varResultado.getString("email"));
                varJsonObjectP.put("direccion", varResultado.getString("direccion"));
                varJsonObjectP.put("telefono", varResultado.getString("telefono"));
                varJsonObjectP.put("dni", varResultado.getString("dni"));
                varJsonObjectP.put("nombreusuario", varResultado.getString("nombreusuario"));
                varJsonObjectP.put("password", varResultado.getString("password"));

                varJsonArrayP.add(varJsonObjectP);
            }
            varResultado.close();
            varResultado = null;
            varPst.close();
            varPst = null;
            varClsConexion.closeConexion();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e);
        }
        varJsonObjectResultado.put("Result", "OK");
        varJsonObjectResultado.put("Records", varJsonArrayP);
        return varJsonObjectResultado;
        
    }

    public JSONObject metNuevo(String varUsuNombre, String varUsuApellidos, String varUsuEmail, String varUsuDireccion, String varUsuTelefono, String varUsuDni, String varUsuNombreusuario, String varUsuPassword, String UsuCodigo) {
         JSONObject varJsonObjectResultado = new JSONObject();
        JSONObject varJsonObjectRegistro = new JSONObject();
        
        try {
            metGuardarDB(varUsuNombre,varUsuApellidos,varUsuEmail,varUsuDireccion,varUsuTelefono,varUsuDni,varUsuNombreusuario,varUsuPassword,UsuCodigo);
            
            String varSql = "SELECT \n"
                    +" * \n"
                    +" FROM \n"
                    +" " +varNombreTabla+";";
            
            PreparedStatement varPst = varClsConexion.getConexion().prepareStatement(varSql);
            ResultSet varResultado = varPst.executeQuery();
            
             while (varResultado.next()) {
                varJsonObjectRegistro.put("nombres", varResultado.getString("nombres"));
                varJsonObjectRegistro.put("apellidos", varResultado.getString("apellidos"));
                varJsonObjectRegistro.put("email", varResultado.getString("email"));
                varJsonObjectRegistro.put("direccion", varResultado.getString("direccion"));
                varJsonObjectRegistro.put("telefono", varResultado.getString("telefono"));
                varJsonObjectRegistro.put("dni", varResultado.getString("dni"));
                varJsonObjectRegistro.put("nombreusuario", varResultado.getString("nombreusuario"));
                varJsonObjectRegistro.put("password", varResultado.getString("password"));
                varJsonObjectRegistro.put("usuariocreacion", varResultado.getString("usuariocreacion"));
            
             }
            varJsonObjectResultado.put("Result", "OK");

            varJsonObjectResultado.put("Record", varJsonObjectRegistro);
            varResultado.close();
            varResultado = null;
            varClsConexion.closeConexion();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e);
        }
        return varJsonObjectResultado;
        
    }

    private void metGuardarDB(String varUsuNombre, String varUsuApellidos, String varUsuEmail, String varUsuDireccion, String varUsuTelefono, String varUsuDni, String varUsuNombreusuario, String varUsuPassword, String UsuCodigo) {

         try {
             Date fechaactual = new Date();
             SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
             String convertido = formateador.format(fechaactual);
            String sql = "INSERT INTO \n"
                    + " " +varNombreTabla + " \n"
                    + " (\n"
                    + " nombres, \n"
                    + " apellidos, \n"
                    + " email, \n"
                    + " direccion, \n"
                    + " telefono, \n"
                    + " dni, \n"
                    + " nombreusuario, \n"
                    + " password, \n"
                    + " usuariocreacion, \n"
                    + " fechacreacion \n"
                    + " ) \n"
                    + "VALUES (\n"
                    + " '" + varUsuNombre + "', \n"
                    + " '" + varUsuApellidos +"', \n"
                    + " '" + varUsuEmail +"', \n"
                    + " '" + varUsuDireccion +"', \n"
                    + " '" + varUsuTelefono +"', \n"
                    + " '" + varUsuDni +"', \n"
                    + " '" + varUsuNombreusuario +"', \n"
                    + " '" + varUsuPassword +"', \n"
                    + " '" + UsuCodigo + "', \n"
                    + " '"+ convertido + "' \n"
                    + " ); \n";
            PreparedStatement varPst = varClsConexion.getConexion().prepareStatement(sql);
            varPst.executeUpdate();
            varPst.close();
            varPst = null;
            varClsConexion.closeConexion();
        } catch (Exception e) {
             e.printStackTrace();
            System.out.print(e);
        }

    }
    
}
