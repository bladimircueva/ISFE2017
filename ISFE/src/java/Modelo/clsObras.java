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
    
    public clsObras() {
        varClsConexion = new clsConexionISFE();
        varNombreEsquema = "public";
        varNombreTabla = "tbl_obra_obr";
    }

    public JSONObject metGetLista() {
        JSONObject varJsonObjectP = new JSONObject();
        JSONArray varJsonArrayP = new JSONArray();
        JSONObject varJsonObjectResultado = new JSONObject();
        int recordCount = 666;
        String where = "";
        
        try {
            String varSql = "SELECT \n"
                    + "  OBR.obr_CodObra,\n"
                    + "  OBR.obr_NombreObra,\n"
                    + "  OBR.obr_NombreClienteObra,\n"
                    + "  OBR.obr_UbicacionObra,\n"
                    + "  OBR.obr_InicioObra,\n"
                    + "  OBR.obr_FinObra,\n"
                    + "  OBR.obr_presupuesto,\n"
                    + "  OBR.obr_NumPartidas,\n"
                    + "  OBR.obr_id\n"
                    + "FROM \n"
                    + "  dbo.tbl_obra_obr OBR\n"
                    + where
                    + "ORDER BY obr_id\n"
                    + ";";
            PreparedStatement varPst = varClsConexion.getConexion().prepareStatement(varSql);
            
            ResultSet varResultado = varPst.executeQuery();
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            while (varResultado.next()) {
                varJsonObjectP.put("obr_CodObra", varResultado.getString("obr_CodObra"));
                varJsonObjectP.put("obr_NombreObra", varResultado.getString("obr_NombreObra"));
                varJsonObjectP.put("obr_NombreClienteObra", varResultado.getString("obr_NombreClienteObra"));
                varJsonObjectP.put("obr_UbicacionObra", varResultado.getString("obr_UbicacionObra"));
                if (varResultado.getString("obr_InicioObra") != null) {
                    java.util.Date ObrInicioObra = formatoDelTexto.parse(varResultado.getString("obr_InicioObra"));
                    varJsonObjectP.put("obr_InicioObra", formatoDelTexto.format(ObrInicioObra));
                } else {
                    varJsonObjectP.put("obr_InicioObra", "");
                }
                if (varResultado.getString("obr_FinObra") != null) {
                    java.util.Date ObrFinObra = formatoDelTexto.parse(varResultado.getString("obr_FinObra"));
                    varJsonObjectP.put("obr_FinObra", formatoDelTexto.format(ObrFinObra));
                } else {
                    varJsonObjectP.put("obr_FinObra", "");
                }
                varJsonObjectP.put("ent_activo", varResultado.getBoolean("ent_activo"));
                varJsonObjectP.put("obr_presupuesto", varResultado.getString("obr_presupuesto"));
                varJsonObjectP.put("obr_NumPartidas", varResultado.getString("obr_NumPartidas"));
               
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
    
    
    
}
