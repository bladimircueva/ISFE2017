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
import org.apache.commons.dbutils.DbUtils;

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
                    + " * \n"
                    + " FROM \n"
                    + " " + varNombreTabla + ";";
            PreparedStatement varPst = varClsConexion.getConexion().prepareStatement(varSql);
            ResultSet varResultado = varPst.executeQuery();
            while (varResultado.next()) {
                varJsonObjectP.put("id", varResultado.getString("id"));
                varJsonObjectP.put("nombres", varResultado.getString("nombres"));
                varJsonObjectP.put("apellidos", varResultado.getString("apellidos"));
                varJsonObjectP.put("email", varResultado.getString("email"));
                varJsonObjectP.put("direccion", varResultado.getString("direccion"));
                varJsonObjectP.put("telefono", varResultado.getString("telefono"));
                varJsonObjectP.put("dni", varResultado.getString("dni"));
                varJsonObjectP.put("nombreusuario", varResultado.getString("nombreusuario"));
                varJsonObjectP.put("password", varResultado.getString("password"));
                varJsonObjectP.put("rol_id", varResultado.getString("rol_id"));

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

    public JSONObject metNuevo(String varUsuNombre, String varUsuApellidos, String varUsuEmail, String varUsuDireccion, String varUsuTelefono, String varUsuDni, String varUsuNombreusuario, String varUsuPassword,String varUsuRol, String UsuCodigo) {
         JSONObject varJsonObjectResultado = new JSONObject();
        JSONObject varJsonObjectRegistro = new JSONObject();
        
        try {
            metGuardarDB(varUsuNombre,varUsuApellidos,varUsuEmail,varUsuDireccion,varUsuTelefono,varUsuDni,varUsuNombreusuario,varUsuPassword,varUsuRol,UsuCodigo);
            
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
                varJsonObjectRegistro.put("rol_id", varResultado.getString("rol_id"));
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

    private void metGuardarDB(String varUsuNombre, String varUsuApellidos, String varUsuEmail, String varUsuDireccion, String varUsuTelefono, String varUsuDni, String varUsuNombreusuario, String varUsuPassword,String varUsuRol, String UsuCodigo) {

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
                    + " rol_id, \n"
                    + " usuariocreacion, \n"
                    + " fechacreacion \n"
                    + " ) \n"
                    + "VALUES (\n"
                    + " '" + varUsuNombre + "', \n"
                    + " '" + varUsuApellidos + "', \n"
                    + " '" + varUsuEmail + "', \n"
                    + " '" + varUsuDireccion + "', \n"
                    + " '" + varUsuTelefono + "', \n"
                    + " '" + varUsuDni + "', \n"
                    + " '" + varUsuNombreusuario + "', \n"
                    + " '" + varUsuPassword + "', \n"
                    + " " + varUsuRol + ", \n"
                    + " '" + UsuCodigo + "', \n"
                    + " '" + convertido + "' \n"
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

    public JSONObject metEliminar(String varIdUusuario) {
        JSONObject varJsonObjectResultado = new JSONObject();
        try {
            System.out.println("melasuda");
            String sql = "DELETE FROM  " + varNombreEsquema + "." + varNombreTabla + " "
                    + "WHERE id = ?";

            PreparedStatement varPst = varClsConexion.getConexion().prepareStatement(sql);
            varPst.setString(1, varIdUusuario);

            varPst.executeUpdate();

            varJsonObjectResultado.put("Result", "OK");
            varPst.close();
            varPst = null;
            varClsConexion.closeConexion();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e);
        }
        return varJsonObjectResultado;
    }

    public JSONObject metEditar(String UsuarioId, String varUsuNombres, String varUsuApellidos, String varUsuEmail, String varUsuDireccion, String varUsuTelefono, String varUsuDni, String varUsuNombreusuario, String varUsuPassword, String varUsuRol, String varUsuModificacion) {
        JSONObject varJsonObjectResultado = new JSONObject();
        
        try {
            String sql = " UPDATE \n"
                    + " " + varNombreTabla + " \n"
                    + " SET "
                    + " nombres= (?), \n"
                    + " apellidos= (?), \n"
                    + " email= (?), \n"
                    + " direccion= (?), \n"
                    + " telefono= (?), \n"
                    + " dni= (?), \n"
                    + " nombreusuario= (?), \n"
                    + " password= (?), \n"
                    + " rol_id= (?), \n"
                    + " usuariomodificacion= (?) \n"
                    + " WHERE id= (?) ;";
            PreparedStatement varPst = varClsConexion.getConexion().prepareStatement(sql);
            varPst.setString(1, varUsuNombres);
            varPst.setString(2, varUsuApellidos); 
            varPst.setString(3, varUsuEmail); 
            varPst.setString(4, varUsuDireccion); 
            varPst.setString(5, varUsuTelefono); 
            varPst.setString(6, varUsuDni); 
            varPst.setString(7, varUsuNombreusuario); 
            varPst.setString(8, varUsuPassword); 
            varPst.setString(9, varUsuRol); 
            varPst.setString(10, varUsuModificacion); 
            varPst.setString(11, UsuarioId);            
            System.out.println("sql" + varPst.toString());
            varPst.executeUpdate();
            varJsonObjectResultado.put("Result", "OK");
            varPst.close();
            varPst = null;
            varClsConexion.closeConexion();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return varJsonObjectResultado;    
    }    }