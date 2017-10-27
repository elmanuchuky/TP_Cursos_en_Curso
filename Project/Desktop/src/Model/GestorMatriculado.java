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
public class GestorMatriculado {

    AccesoDatosVariable adv = new AccesoDatosVariable();
    
    String conexion = adv.getConexion();
    String user = adv.getUser();
    String pass = adv.getPass();
    String ClasForName = adv.getClasForName();

//agrega un nuevo matriculado
    public void agregarMatriculado(Matriculado m, DatosGenerales d) throws SQLException, ClassNotFoundException {
        Connection con = DriverManager.getConnection(conexion, user, pass);
        GestorDatosGenerales gd = new GestorDatosGenerales();
        gd.agregarDatosGenerales(d);
        m.setDatos(gd.obtenerUltimoId());
        PreparedStatement comando2 = con.prepareStatement("exec sp_insert_matriculado ?,?");
        comando2.setInt(1, m.getDatos());
        comando2.setString(2, m.getProfesion());
        comando2.executeUpdate();
        comando2.close();
        con.close();
    }

    // Recuperar el id del matriculado con el legajo
    public int obtenerMatriculado(int legajo) throws SQLException {
        Connection con = DriverManager.getConnection(conexion, user, pass);
        Statement stmtLegajo = con.createStatement();
        ResultSet queryLegajo = stmtLegajo.executeQuery("SELECT id_matriculado id FROM Matriculados WHERE legajo_matriculado = " + legajo);
        int idMatriculado = 0;
        if (queryLegajo.next()) {
            idMatriculado = queryLegajo.getInt("id");
        }
        queryLegajo.close();
        stmtLegajo.close();
        con.close();
        return idMatriculado;
    }
}
