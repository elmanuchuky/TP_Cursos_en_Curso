/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Fernando M. de Lima
 */
public class GestorCursante {
    String conexion = "jdbc:sqlserver://localhost:1412;databaseName=Colegio_Informatica_Metodologia";
    String user = "Gabriel";
    String pass = "1234";

    public void agregarCursante(Cursante c) throws SQLException {
        Connection con = DriverManager.getConnection(conexion, user, pass);
        PreparedStatement comando = con.prepareStatement("exec sp_insert_cursante ?,?,?");
        comando.setInt(1, c.getId());
        comando.setInt(2, c.getId_Matriculado());
        comando.setBoolean(3, c.isEsFamilia());
        comando.setInt(4, c.getId_Datos_Generales());

        comando.executeUpdate();
        comando.close();
        con.close();
    }

    //obtener ultimo id de los cursantes
    public int obtenerUltimoCursante() throws SQLException {
        Connection con = DriverManager.getConnection(conexion, user, pass);
        Statement stmtIdCu = con.createStatement();
        ResultSet queryCu = stmtIdCu.executeQuery("SELECT MAX(id_cursante) id FROM Cursantes");
        int cuId = 0;
        if (queryCu.next()) {
            cuId = queryCu.getInt("id");
        }
        queryCu.close();
        stmtIdCu.close();
        con.close();
        return cuId;
    }

    // Insertar nuevo cursante
    public void agregarCursanteOtro(int i) throws SQLException {
        Connection con = DriverManager.getConnection(conexion, user, pass);
        PreparedStatement stmtCu = con.prepareStatement("exec sp_insert_cursante NULL, 0, ?"); // idMatri, esFamilia, IdDG
        stmtCu.setInt(1, i);
        stmtCu.executeUpdate();
        stmtCu.close();
        con.close();
    }

    // Insertar nuevo cursante
    public void agregarCursanteFamilia(int matricula, int idGenerales) throws SQLException {
        Connection con = DriverManager.getConnection(conexion, user, pass);
        PreparedStatement stmtCu = con.prepareStatement("exec sp_insert_cursante ?, 1, ?"); // idMatri, esFamilia, IdDG
        stmtCu.setInt(1, matricula);
        stmtCu.setInt(2, idGenerales);
        stmtCu.executeUpdate();
        stmtCu.close();
        con.close();
    }
    
    public void agregarCursanteMatriculado(int idMatriculado,int idDatosGeneral) throws SQLException{
        Connection con = DriverManager.getConnection(conexion,user,pass);
            PreparedStatement stmtCu = con.prepareStatement("exec sp_insert_cursante ?, 0, ?"); // idMatri, esFamilia, IdDG
            stmtCu.setInt(1, idMatriculado);
            stmtCu.setInt(2, idDatosGeneral);
            stmtCu.executeUpdate();
            stmtCu.close();
    }
}
