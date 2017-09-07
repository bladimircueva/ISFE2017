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
public class clsRoles {
    
    private clsConexionISFE varClsConexion;
    private final String varNombreEsquema;
    private final String varNombreTabla;
    
    public clsRoles()
    {
        varClsConexion = new clsConexionISFE();
        varNombreEsquema = "dbo";
        varNombreTabla = "ROL";
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
                varJsonObjectP.put("codigo", varResultado.getString("codigo"));
                varJsonObjectP.put("descripcion", varResultado.getString("descripcion"));

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

    public JSONObject metNuevo(String varRolCodigo, String varRolDescripcion, String UsuCodigo) {
        JSONObject varJsonObjectResultado = new JSONObject();
        JSONObject varJsonObjectRegistro = new JSONObject();
        
        try {
            metGuardarDB(varRolCodigo,varRolDescripcion,UsuCodigo);
            
            String varSql = "SELECT \n"
                    +" * \n"
                    +" FROM \n"
                    +" " +varNombreTabla+";";
            
            PreparedStatement varPst = varClsConexion.getConexion().prepareStatement(varSql);
            ResultSet varResultado = varPst.executeQuery();
            
             while (varResultado.next()) {
                varJsonObjectRegistro.put("codigo", varResultado.getString("codigo"));
                varJsonObjectRegistro.put("descripcion", varResultado.getString("descripcion"));
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

    private void metGuardarDB(String varRolCodigo, String varRolDescripcion, String UsuCodigo) {
        try {
             Date fechaactual = new Date();
             SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
             String convertido = formateador.format(fechaactual);
            String sql = "INSERT INTO \n"
                    + " " +varNombreTabla + " \n"
                    + " (\n"
                    + " codigo, \n"
                    + " descripcion, \n"
                    + " usuariocreacion, \n"
                    + " fechacreacion \n"
                    + " ) \n"
                    + "VALUES (\n"
                    + " '" + varRolCodigo + "', \n"
                    + " '" + varRolDescripcion +"', \n"
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
    
    public JSONObject metQuitar(String RolId) {
        
         JSONObject varJsonObjectResultado = new JSONObject();
        try {
            String sql = " DELETE FROM  "+varNombreEsquema+"."+varNombreTabla+" \n"
                    + " WHERE codigo = ?;";
            
            PreparedStatement varPst = varClsConexion.getConexion().prepareStatement(sql);
            varPst.setString(1, RolId); 
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

    public JSONObject metEditar(String RolId,String varRolCodigo, String varRolDescripcion, String varUsuModificacion) {
        JSONObject varJsonObjectResultado = new JSONObject();
        
        try {
            String sql = " UPDATE \n"
                    + " "+varNombreTabla+" \n"
                    + " SET "
                    + " descripcion= (?) \n"
                    + " WHERE codigo= (?) ;";
            PreparedStatement varPst = varClsConexion.getConexion().prepareStatement(sql);
            varPst.setString(1, varRolDescripcion); 
            varPst.setString(2, varRolCodigo);
            
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
    }

    public JSONArray metListRoles() {
         JSONObject JSONObject = new JSONObject();
        JSONArray JSONArray = new JSONArray();
        try {

            String varSql = "SELECT \n"
                    + "id,\n"
                    + "codigo,\n"
                    + "descripcion\n"
                    + "FROM "+varNombreTabla+"; \n";
            PreparedStatement varPst = varClsConexion.getConexion().prepareStatement(varSql);

            ResultSet varResultado = varPst.executeQuery();

            while (varResultado.next()) {
                JSONObject.put("id", varResultado.getString("id"));
                JSONObject.put("codigo", varResultado.getString("codigo"));
                JSONObject.put("descripcion", varResultado.getString("descripcion"));
                JSONArray.add(JSONObject);
            }
            varResultado.close();
            varResultado = null;
            varClsConexion.closeConexion();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e);
        }
        return JSONArray;
    }

    

    
    
}
