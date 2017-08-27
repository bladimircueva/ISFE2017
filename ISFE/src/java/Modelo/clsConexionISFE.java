/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
/**
 *
 * @author Blad
 */
public class clsConexionISFE
{
    private static Connection varConexion;
    
    public Connection getConexion()
    {
        try
        {
            InitialContext initialContext = new InitialContext();
            Context context = (Context) initialContext.lookup("java:comp/env");
            DataSource ds = (DataSource) context.lookup("jdbc/isfe2017_db");
            varConexion = ds.getConnection();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return varConexion;
        }
    }
    
    public void closeConexion()
    {
        try
        {
            if(varConexion != null)
            {
                varConexion.close();
                varConexion = null;
            }
        }
        catch (Exception e)
        {
        }
    }
    
}
