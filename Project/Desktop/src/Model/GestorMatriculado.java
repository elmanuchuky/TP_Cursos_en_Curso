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
public class GestorMatriculado {
    String conexion = "jdbc:sqlserver://localhost:1412;databaseName=Colegio_Informatica_Metodologia";
    String user = "Gabriel";
    String pass = "1234";
    
    public void agregarMatriculado(Matriculado m) throws SQLException{
        Connection con = DriverManager.getConnection(conexion,user,pass);
        PreparedStatement comando = con.prepareStatement("exec sp_insert_matriculado ?,?,?");
        comando.setInt(1, m.getLegajoMatriculado());
        comando.setInt(2, m.getDatos());
        comando.setString(3, m.getProfesion());
        
        comando.executeUpdate();
        comando.close();
        con.close();
    }
}
