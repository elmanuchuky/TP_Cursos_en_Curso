/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Gabriel
 */
public class GestorCursante {
    String conexion = "jdbc:sqlserver://localhost:1412;databaseName=Colegio_Informatica_Metodologia";
    String user = "Gabriel";
    String pass = "1234";
    
    public void agregarCursante(Cursante c) throws SQLException{
        Connection con = DriverManager.getConnection(conexion,user,pass);
        PreparedStatement comando = con.prepareStatement("exec sp_insert_cursante ?,?,?");
        comando.setInt(1, c.getId());
        comando.setInt(2, c.getId_Matriculado());
        comando.setBoolean(3, c.isEsFamilia());
        comando.setInt(4, c.getId_Datos_Generales());
        
        comando.executeUpdate();
        comando.close();
        con.close();
    }
}
