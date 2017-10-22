/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Gabriel
 */
public class GestorDatosGenerales {

    String conexion = "jdbc:sqlserver://localhost:1412;databaseName=Colegio_Informatica_Metodologia";
    String user = "Gabriel";
    String pass = "1234";

    public void agregarDatosGenerales(DatosGenerales d) throws ClassNotFoundException, SQLException {
        forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection(conexion, user, pass);
        PreparedStatement comando = con.prepareStatement("exec sp_insert_datosGenerales ?,?,?,?,?,?,?");
        comando.setString(1, d.getNombre());
        comando.setString(2, d.getApellido());
        comando.setInt(3, d.getTipoDni());
        comando.setInt(4, d.getDni());
        comando.setString(5, d.getFechaNacimiento());
        comando.setString(6, d.getTelefono());
        comando.setString(7, d.getEmail());

        comando.executeUpdate();
        comando.close();
        con.close();

    }

    public void modificarDatosGenerales(DatosGenerales d) throws ClassNotFoundException, SQLException {
        forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection(conexion, user, pass);
        PreparedStatement comando = con.prepareStatement("exec sp_update_datosGenerales ?,?,?,?,?,?,?,?");
        comando.setInt(1, d.getIdDatosGenerales());
        comando.setString(2, d.getNombre());
        comando.setString(3, d.getApellido());
        comando.setInt(4, d.getTipoDni());
        comando.setInt(5, d.getDni());
        comando.setString(6, d.getFechaNacimiento());
        comando.setString(7, d.getTelefono());
        comando.setString(8, d.getEmail());

        comando.executeUpdate();
        comando.close();
        con.close();
    }

    public int obtenerUltimoId() throws ClassNotFoundException, SQLException {
        // Recuperar el id de ese dato general (puede ser con mail)
        forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection(conexion, user, pass);
        Statement stmtId = con.createStatement();
        ResultSet query = stmtId.executeQuery("SELECT MAX(id_datos_generales) id FROM Datos_Generales");
        int resultado = 0;
        if (query.next()) {
            resultado = (query.getInt("id"));
        }
        query.close();
        stmtId.close();
        return resultado;
    }

    public int obtenerDatosPorLegajo(int legajo) throws SQLException {
        Connection con = DriverManager.getConnection(conexion, user, pass);
        Statement stmtId = con.createStatement();
        ResultSet query = stmtId.executeQuery("SELECT m.id_datos_generales id FROM Matriculados m join Datos_Generales dg on m.id_datos_generales = dg.id_datos_generales WHERE m.legajo_matriculado = " + legajo);
        int idDG = 0;
        if (query.next()) {
            idDG = query.getInt("id");
        }
        query.close();
        stmtId.close();
        con.close();
        return idDG;
    }
}
