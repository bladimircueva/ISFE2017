/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import net.sf.json.JSONObject;
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
public class clsCatMateriales {
    
   private clsConexionISFE varClsConexion;
    private final String varNombreEsquema;
    private final String varNombreTabla;
    
    public clsCatMateriales()
    {
        varClsConexion = new clsConexionISFE();
        varNombreEsquema = "dbo";
        varNombreTabla = "MATERIALCATEGORIA";
    }

    public JSONObject metGetLista() {
        JSONObject varJsonObjectP = new JSONObject();
        JSONArray varJsonArrayP = new JSONArray();
        JSONObject varJsonObjectResultado = new JSONObject();
        
        try {
            String varSql = "SELECT \n"
                    +" * \n"
                    +" FROM \n"
                    +" "+ varNombreTabla +";";
            PreparedStatement varPst = varClsConexion.getConexion().prepareStatement(varSql);
            ResultSet varResultado = varPst.executeQuery();
            System.out.println("RESULTADO DE LA COSNULTA" + varSql);
            while (varResultado.next()) {
                varJsonObjectP.put("codigo", varResultado.getString("codigo"));
                varJsonObjectP.put("descripcion", varResultado.getString("cdescripcion"));

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

    public JSONObject metNuevo(String varCamCodigo, String varCamDescripcion, String UsuCodigo) {
JSONObject varJsonObjectResultado = new JSONObject();
        JSONObject varJsonObjectRegistro = new JSONObject();
        
        try {
            metGuardarDB(varCamCodigo,varCamDescripcion,UsuCodigo);
            
            String varSql = "SELECT \n"
                    +" * \n"
                    +" FROM \n"
                    +" "+varNombreTabla+";";
            
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

    public JSONObject metQuitar(String CamId) {

        JSONObject varJsonObjectResultado = new JSONObject();
        try {
            String sql = " DELETE FROM  "+varNombreTabla+" \n"
                    + " WHERE id= (?) ;";
            
            PreparedStatement varPst = varClsConexion.getConexion().prepareStatement(sql);
            varPst.setString(1, CamId); 
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

    public JSONObject metEditar(String CamId, String varCamCodigo, String varCamDescripcion, String varUsuModificacion) {

        JSONObject varJsonObjectResultado = new JSONObject();
        
        try {
            String sql = " UPDATE \n"
                    + " "+varNombreTabla+" \n"
                    + " SET "
                    + " descripcion= (?) \n"
                    + " WHERE codigo= (?) ;";
            PreparedStatement varPst = varClsConexion.getConexion().prepareStatement(sql);
            varPst.setString(1, varCamDescripcion); 
            varPst.setString(2, varCamCodigo);
            
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

    private void metGuardarDB(String VarCodigo, String VarDescripcion, String UsuCodigo) {
        try {
             Date fechaactual = new Date();
             SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
             String convertido = formateador.format(fechaactual);
            String sql = "INSERT INTO \n"
                    + " "+varNombreTabla+" \n"
                    + " (\n"
                    + " codigo, \n"
                    + " descripcion, \n"
                    + " usuariocreacion, \n"
                    + " fechacreacion \n"
                    + " ) \n"
                    + "VALUES (\n"
                    + " '" + VarCodigo + "', \n"
                    + " '" + VarDescripcion +"', \n"
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
