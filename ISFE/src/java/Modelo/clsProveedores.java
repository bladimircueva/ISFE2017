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
public class clsProveedores {
    
    private clsConexionISFE varClsConexion;
    private final String varNombreEsquema;
    private final String varNombreTabla;
    
    public clsProveedores()
    {
        varClsConexion = new clsConexionISFE();
        varNombreEsquema = "dbo";
        varNombreTabla = "PROVEEDOR";
    }

    public JSONObject metNuevo(String VarCodigo, String VarRazonSocial, String VarRuc, String VarDireccion, String VarTelefono, String UsuCodigo) {

        JSONObject varJsonObjectResultado = new JSONObject();
        JSONObject varJsonObjectRegistro = new JSONObject();
        
        try {
            metGuardarDB(VarCodigo,VarRazonSocial,VarRuc,VarDireccion,VarTelefono,UsuCodigo);
            
            String varSql = "SELECT \n"
                    +" * \n"
                    +" FROM \n"
                    +" "+varNombreTabla+";";
            
            PreparedStatement varPst = varClsConexion.getConexion().prepareStatement(varSql);
            ResultSet varResultado = varPst.executeQuery();
            
             while (varResultado.next()) {
                varJsonObjectRegistro.put("codigo", varResultado.getString("codigo"));
                varJsonObjectRegistro.put("razonsocial", varResultado.getString("razonsocial"));
                varJsonObjectRegistro.put("ruc", varResultado.getString("ruc"));
                varJsonObjectRegistro.put("direccion", varResultado.getString("direccion"));
                varJsonObjectRegistro.put("telefono", varResultado.getString("telefono"));
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

    public JSONObject metQuitar(String VarId) {

         JSONObject varJsonObjectResultado = new JSONObject();
        try {
            String sql = " DELETE FROM  "+varNombreTabla+" \n"
                    + " WHERE id= (?) ;";
            
            PreparedStatement varPst = varClsConexion.getConexion().prepareStatement(sql);
            varPst.setString(1, VarId); 
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
            while (varResultado.next()) {
                varJsonObjectP.put("codigo", varResultado.getString("codigo"));
                varJsonObjectP.put("razonsocial", varResultado.getString("razonsocial"));
                varJsonObjectP.put("ruc", varResultado.getString("ruc"));
                varJsonObjectP.put("direccion", varResultado.getString("direccion"));
                varJsonObjectP.put("telefono", varResultado.getString("telefono"));
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

    public JSONObject metEditar(String VarId, String VarCodigo, String VarRazonSocial, String VarRuc, String VarDireccion, String VarTelefono, String VarUsuarioModificacion) {

        JSONObject varJsonObjectResultado = new JSONObject();
        
        try {
            String sql = " UPDATE \n"
                    + " "+varNombreTabla+" \n"
                    + " SET "
                    + " razonsocial= (?) \n"
                    + " WHERE codigo= (?) ;";
            PreparedStatement varPst = varClsConexion.getConexion().prepareStatement(sql);
            varPst.setString(1, VarRazonSocial); 
            varPst.setString(2, VarRuc);
            varPst.setString(3, VarDireccion); 
            varPst.setString(4, VarTelefono);
            varPst.setString(5, VarCodigo);
            
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

    private void metGuardarDB(String VarCodigo, String VarRazonSocial, String VarRuc, String VarDireccion, String VarTelefono, String UsuCodigo) {

try {
             Date fechaactual = new Date();
             SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
             String convertido = formateador.format(fechaactual);
            String sql = "INSERT INTO \n"
                    + " "+varNombreTabla+" \n"
                    + " (\n"
                    + " codigo, \n"
                    + " razonsocial, \n"
                    + " ruc, \n"
                    + " direccion, \n"
                    + " telefono, \n"
                    + " usuariocreacion, \n"
                    + " fechacreacion \n"
                    + " ) \n"
                    + "VALUES (\n"
                    + " '" + VarCodigo + "', \n"
                    + " '" + VarRazonSocial +"', \n"
                    + " '" + VarRuc +"', \n"
                    + " '" + VarDireccion +"', \n"
                    + " '" + VarTelefono +"', \n"
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
