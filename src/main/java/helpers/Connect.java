/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ACER NITRO 5
 */
public class Connect {
    protected Connection con=null;
    public Connect(){
        try
        {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=QLTV3";
            con=DriverManager.getConnection(url,"sa","01219164372");
        }
           catch(Exception ex)
            {
                ex.printStackTrace();
            }   
    }
}
