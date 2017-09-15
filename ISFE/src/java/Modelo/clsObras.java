/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.clsConexionISFE;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.accessibility.AccessibleRole;
import javax.swing.JOptionPane;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 *
 * @author Blad
 */
public class clsObras {
    private clsConexionISFE varClsConexion;
    private final String varNombreEsquema;
    private final String varNombreTabla;
    private final String varNombreTablaChild;
    
    public clsObras() {
        varClsConexion = new clsConexionISFE();
        varNombreEsquema = "dbo";
        varNombreTabla = "OBRA";
        varNombreTablaChild = "PARTIDA";
    }

    public JSONObject metGetLista() {
        JSONObject varJsonObjectP = new JSONObject();
        JSONArray varJsonArrayP = new JSONArray();
        JSONObject varJsonObjectResultado = new JSONObject();
        int recordCount = 666;
        String where = "";
        
        try {
            String varSql = "SELECT \n"
                    + "  OBR.id,\n"
                    + "  OBR.usuario_id,\n"
                    + "  OBR.usuariocreacion,\n"
                    + "  OBR.codigo,\n"
                    + "  OBR.nombre,\n"
                    + "  OBR.nombrecliente,\n"
                    + "  OBR.ubicacion,\n"
                    + "  OBR.fechainicio,\n"
                    + "  OBR.fechafin,\n"
                    + "  OBR.presupuesto,\n"
                    + "  OBR.numeropartidas,\n"
                    + "  OBR.fechacreacion\n"
                    + "FROM \n"
                    + "  "+varNombreEsquema+"."+varNombreTabla+" OBR\n"
                    + "ORDER BY id\n"
                    + ";";
            PreparedStatement varPst = varClsConexion.getConexion().prepareStatement(varSql);
            
            ResultSet varResultado = varPst.executeQuery();
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            while (varResultado.next()) {
                varJsonObjectP.put("id", varResultado.getString("id"));
                varJsonObjectP.put("usuario_id", varResultado.getString("usuario_id"));
                varJsonObjectP.put("usuariocreacion", varResultado.getString("usuariocreacion"));
                varJsonObjectP.put("codigo", varResultado.getString("codigo"));
                varJsonObjectP.put("nombre", varResultado.getString("nombre"));
                varJsonObjectP.put("nombrecliente", varResultado.getString("nombrecliente"));
                varJsonObjectP.put("ubicacion", varResultado.getString("ubicacion"));
                if (varResultado.getString("fechainicio") != null) {
                    java.util.Date ObrInicioObra = formatoDelTexto.parse(varResultado.getString("fechainicio"));
                    varJsonObjectP.put("fechainicio", formatoDelTexto.format(ObrInicioObra));
                } else {
                    varJsonObjectP.put("fechainicio", "");
                }
                if (varResultado.getString("fechafin") != null) {
                    java.util.Date ObrFinObra = formatoDelTexto.parse(varResultado.getString("fechafin"));
                    varJsonObjectP.put("fechafin", formatoDelTexto.format(ObrFinObra));
                } else {
                    varJsonObjectP.put("fechafin", "");
                }
                varJsonObjectP.put("presupuesto", varResultado.getString("presupuesto"));
                varJsonObjectP.put("numeropartidas", varResultado.getString("numeropartidas"));
                varJsonObjectP.put("fechacreacion", varResultado.getString("fechacreacion"));
               
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
        varJsonObjectResultado.put("TotalRecordCount", recordCount);
        varJsonObjectResultado.put("Records", varJsonArrayP);
        return varJsonObjectResultado;
        
    }

    public JSONObject metNuevoObra(String varObrusuId, String varObrUsuCre, String varObrCod, String varObrNom, String varObrNomCli, String varObrUbi, String varObrFecIni, String varObrFecFin, String varObrPre, String varObrNumPar, String UsuCodigo) {
        
         JSONObject varJsonObjectResultado = new JSONObject();
        JSONObject varJsonObjectRegistro = new JSONObject();
        try {
            metGuardarEnBd(
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
            
            String varSql = "SELECT \n"
                    + " OBR.id,\n"
                     + " OBR.usuario_id,\n"
                    + "  OBR.usuariocreacion,\n"
                    + "  OBR.codigo,\n"
                    + "  OBR.nombre,\n"
                    + "  OBR.nombrecliente,\n"
                    + "  OBR.ubicacion,\n"
                    + "  OBR.fechainicio,\n"
                    + "  OBR.fechafin,\n"
                    + "  OBR.presupuesto,\n"
                    + "  OBR.numeropartidas,\n"
                    + "  OBR.fechacreacion\n"
                    + "FROM \n"
                    + " "+varNombreEsquema+"."+varNombreTabla+" OBR\n"
                    + "ORDER BY OBR.fechacreacion;";
            
            PreparedStatement varPst = varClsConexion.getConexion().prepareStatement(varSql);
            
            ResultSet varResultado = varPst.executeQuery();
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            while (varResultado.next()) {
                varJsonObjectRegistro.put("id", varResultado.getString("id"));
                varJsonObjectRegistro.put("usuario_id", varResultado.getString("usuario_id"));
                varJsonObjectRegistro.put("usuariocreacion", varResultado.getString("usuariocreacion"));
                varJsonObjectRegistro.put("codigo", varResultado.getString("codigo"));
                varJsonObjectRegistro.put("nombre", varResultado.getString("nombre"));
                varJsonObjectRegistro.put("nombrecliente", varResultado.getString("nombrecliente"));
                varJsonObjectRegistro.put("ubicacion", varResultado.getString("ubicacion"));
                if (varResultado.getString("fechainicio") != null) {
                    java.util.Date EntFechaNacimientoR = formatoDelTexto.parse(varResultado.getString("fechainicio"));
                    varJsonObjectRegistro.put("fechainicio", formatoDelTexto.format(EntFechaNacimientoR));
                } else {
                    varJsonObjectRegistro.put("fechainicio", "");
                }
                if (varResultado.getString("fechafin") != null) {
                    java.util.Date EntFechaNacimientoR = formatoDelTexto.parse(varResultado.getString("fechafin"));
                    varJsonObjectRegistro.put("fechafin", formatoDelTexto.format(EntFechaNacimientoR));
                } else {
                    varJsonObjectRegistro.put("fechafin", "");
                }
                varJsonObjectRegistro.put("presupuesto", varResultado.getString("presupuesto"));
                varJsonObjectRegistro.put("numeropartidas", varResultado.getString("numeropartidas"));
                varJsonObjectRegistro.put("fechacreacion", varResultado.getString("fechacreacion"));
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

    private void metGuardarEnBd(String varObrusuId, String varObrUsuCre, String varObrCod, String varObrNom, String varObrNomCli, String varObrUbi, String varObrFecIni, String varObrFecFin, String varObrPre, String varObrNumPar, String UsuCodigo) {
        try {
            java.util.Date fecha = new java.util.Date();
             SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
             String fechaactual = formateador.format(fecha);
            String sql = "INSERT INTO \n"
                    + "  "+varNombreEsquema+"."+varNombreTabla+" \n"
                    + "(\n"
                    + "  codigo,\n"
                    + "  nombre,\n"
                    + "  nombrecliente,\n"
                    + "  ubicacion,\n"
                    + "  fechainicio,\n"
                    + "  fechafin,\n"
                    + "  presupuesto,\n"
                    + "  numeropartidas,\n"
                    + "  usuariocreacion,\n"
                    + "  fechacreacion\n"
                    + ") \n"
                    + "VALUES (\n"
                    + "  '" + varObrCod + "',\n"
                    + "  '" + varObrNom + "',\n"
                    + "  '" + varObrNomCli + "',\n"
                    + "  '" + varObrUbi + "',\n"
                    + "  '" + varObrFecIni + "',\n"
                    + "  '" + varObrFecFin + "',\n"
                    + "  '" + varObrPre + "',\n"
                    + "  '" + varObrNumPar + "',\n"
                    + "  '" + UsuCodigo + "',\n"
                    + "  '" + fechaactual + "'\n"
                    + ");";
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

    public JSONObject metEditarObra(String varObrId, String varObrCod, String varObrNom, String varObrNomCli, String varObrUbi, String varObrFecIni, String varObrFecFin, String varObrPre, String varObrNumPar, String UsuCodigo) {
          JSONObject varJsonObjectResultado = new JSONObject();
        
        
        try {
            java.util.Date fecha = new java.util.Date();
             SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
             String fechaactual = formateador.format(fecha);
            String sql = "UPDATE \n"
                    + "  "+varNombreEsquema+"."+varNombreTabla+"  \n"
                    + "SET \n"
                    + "  codigo = (?),\n"
                    + "  nombre = (?),\n"
                    + "  nombrecliente = (?),\n"
                    + "  ubicacion = (?),\n"
                    + "  fechainicio = (?),\n"
                    + "  fechafin = (?),\n"
                    + "  presupuesto = (?),\n"
                    + "  numeropartidas = (?),\n"
                    + "  usuariomodificacion = (?),\n"
                    + "  fechamodificacion = (?)\n"
                    + " \n"
                    + "WHERE \n"
                    + "  id = (?)\n"
                    + ";";
            
            PreparedStatement varPst = varClsConexion.getConexion().prepareStatement(sql);
            
            varPst.setString(1, varObrCod);
            varPst.setString(2, varObrNom);
            varPst.setString(3, varObrNomCli);
            varPst.setString(4, varObrUbi);
            varPst.setString(5, varObrFecIni);
            varPst.setString(6, varObrFecFin);
            varPst.setString(7, varObrPre);
            varPst.setString(8, varObrNumPar);
            varPst.setString(9, UsuCodigo);
            varPst.setString(10, fechaactual);
            varPst.setInt(11, Integer.parseInt(varObrId));
            
            System.out.println("sql" + varPst.toString());
            
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

    public JSONObject metListChild(String varmaster) {
        JSONObject varJsonObjectP = new JSONObject();
        JSONArray varJsonArrayP = new JSONArray();
        JSONObject varJsonObjectResultado = new JSONObject();
        try {
            String varSql = "SELECT "
                    + "PAR.id,"
                    + "PAR.codigo,"
                    + "PAR.fechainicio,"
                    + "PAR.fechafin,"
                    + "PAR.usuariocreacion "
                    + "FROM "+varNombreTabla+" OBR inner join "
                    + " "+varNombreTablaChild+" PAR "
                    + "on OBR.id=PAR.obra_id\n"
                    + "where PAR.obra_id=?;";
            PreparedStatement varPst = varClsConexion.getConexion().prepareStatement(varSql);
            varPst.setInt(1, Integer.parseInt(varmaster));
            ResultSet varResultado = varPst.executeQuery();

            while (varResultado.next()) {
                varJsonObjectP.put("id", varResultado.getString("id"));
                varJsonObjectP.put("codigo", varResultado.getString("codigo"));
                varJsonObjectP.put("fechainicio", varResultado.getString("fechainicio"));
                varJsonObjectP.put("fechafin", varResultado.getString("fechafin"));
                varJsonObjectP.put("usuariocreacion", varResultado.getString("usuariocreacion"));

                varJsonArrayP.add(varJsonObjectP);
            }
            varPst.close();
            varResultado.close();
            varClsConexion.closeConexion();
        } catch (Exception e) {
            if (varClsConexion.getConexion() != null) {
                varClsConexion.closeConexion();
            }
            e.printStackTrace();

        }
        varJsonObjectResultado.put("Result", "OK");
        varJsonObjectResultado.put("Records", varJsonArrayP);
        return varJsonObjectResultado;
    }

    public JSONObject metNuevaPartida(String varParObrId, String varParCod, String varParFecIni, String varParFecFin, String UsuCodigo) {
         JSONObject varJsonObjectResultado = new JSONObject();
        JSONObject varJsonObjectRegistro = new JSONObject();
        try {
            metGuardarEnBd2(
                    varParObrId,
                    varParCod,
                    varParFecIni,
                    varParFecFin,
                    UsuCodigo);
            
            String varSql = "SELECT \n"
                    + " PAR.id,\n"
                    + " PAR.codigo,\n"
                    + "  PAR.fechainicio,\n"
                    + "  PAR.fechafin,\n"
                    + "  PAR.obra_id,\n"
                    + "  PAR.fechacreacion\n"
                    + "FROM \n"
                    + " "+varNombreEsquema+"."+varNombreTablaChild+" PAR\n"
                    + "ORDER BY PAR.fechacreacion;";
            
            PreparedStatement varPst = varClsConexion.getConexion().prepareStatement(varSql);
            
            ResultSet varResultado = varPst.executeQuery();
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            while (varResultado.next()) {
                varJsonObjectRegistro.put("id", varResultado.getString("id"));
                varJsonObjectRegistro.put("codigo", varResultado.getString("codigo"));
                if (varResultado.getString("fechainicio") != null) {
                    java.util.Date EntFechaNacimientoR = formatoDelTexto.parse(varResultado.getString("fechainicio"));
                    varJsonObjectRegistro.put("fechainicio", formatoDelTexto.format(EntFechaNacimientoR));
                } else {
                    varJsonObjectRegistro.put("fechainicio", "");
                }
                if (varResultado.getString("fechafin") != null) {
                    java.util.Date EntFechaNacimientoR = formatoDelTexto.parse(varResultado.getString("fechafin"));
                    varJsonObjectRegistro.put("fechafin", formatoDelTexto.format(EntFechaNacimientoR));
                } else {
                    varJsonObjectRegistro.put("fechafin", "");
                }
                varJsonObjectRegistro.put("obra_id", varResultado.getString("obra_id"));
                varJsonObjectRegistro.put("fechacreacion", varResultado.getString("fechacreacion"));
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

    private void metGuardarEnBd2(String varParObrId, String varParCod, String varParFecIni, String varParFecFin, String UsuCodigo) {
        try {
            java.util.Date fecha = new java.util.Date();
             SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
             String fechaactual = formateador.format(fecha);
            String sql = "INSERT INTO \n"
                    + "  "+varNombreEsquema+"."+varNombreTablaChild+" \n"
                    + "(\n"
                    + "  codigo,\n"
                    + "  fechainicio,\n"
                    + "  fechafin,\n"
                    + "  usuariocreacion,\n"
                    + "  fechacreacion,\n"
                    + "  obra_id\n"
                    + ") \n"
                    + "VALUES (\n"
                    + "  '" + varParCod + "',\n"
                    + "  '" + varParFecIni + "',\n"
                    + "  '" + varParFecFin + "',\n"
                    + "  '" + UsuCodigo + "',\n"
                    + "  '" + fechaactual + "',\n"
                    + "  '" + varParObrId + "'\n"
                    + ");";
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

    public JSONObject metEditarchild(String varParId, String varParObrId, String varParCod, String varParFecIni, String varParFecFin, String varParUsuModificacion) {
        JSONObject varJsonObjectResultado = new JSONObject();
        try {
             java.util.Date fecha = new java.util.Date();
             SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
             String fechaactual = formateador.format(fecha);
            String sql = " UPDATE \n"
                    + ""+varNombreEsquema+"."+varNombreTablaChild+" \n"
                    + " SET \n"
                    + " codigo= (?), \n"
                    + " fechainicio= (?), \n"
                    + " fechafin= (?), \n"
                    + " iusuariomodificacion= (?), \n"
                    + " fechamodificacion= (?) \n"
                    + " WHERE id= (?) ;";
            PreparedStatement varPst = varClsConexion.getConexion().prepareStatement(sql);
            varPst.setString(1, varParCod);
            varPst.setString(2, varParFecIni); 
            varPst.setString(3, varParFecFin);
            varPst.setString(4, varParUsuModificacion);
            varPst.setString(5, fechaactual);
            varPst.setString(6, varParId);
            
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

    public JSONObject metDeleteChild(String parameter) {
        JSONObject varJsonObjectResultado = new JSONObject();
        try {

            String sql = "DELETE FROM  " + varNombreEsquema + "." + varNombreTablaChild + " "
                    + "WHERE id = ?;";

            PreparedStatement varPst = varClsConexion.getConexion().prepareStatement(sql);
            varPst.setInt(1, Integer.valueOf(parameter)); //@ID            
            varPst.executeUpdate();
            varJsonObjectResultado.put("Result", "OK");
            varPst.close();

            varClsConexion.closeConexion();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e);
        }
        return varJsonObjectResultado;
    }

    public JSONArray metListObras() {
        JSONObject JSONObject = new JSONObject();
        JSONArray JSONArray = new JSONArray();
        try {

            String varSql = "SELECT \n"
                    + "id,\n"
                    + "codigo,\n"
                    + "nombre\n"
                    + "FROM "+varNombreTabla+"; \n";
            PreparedStatement varPst = varClsConexion.getConexion().prepareStatement(varSql);

            ResultSet varResultado = varPst.executeQuery();

            while (varResultado.next()) {
                JSONObject.put("id", varResultado.getString("id"));
                JSONObject.put("codigo", varResultado.getString("codigo"));
                JSONObject.put("nombre", varResultado.getString("nombre"));
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
