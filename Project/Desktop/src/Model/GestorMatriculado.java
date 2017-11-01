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
import javax.swing.JOptionPane;

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
            JOptionPane.showMessageDialog(null, "Se ha insertado un nuevo registro");
        con.close();
    }
    
    //agrega un nuevo matriculado
    public void modificarMatriculado(Matriculado m, DatosGenerales d) throws SQLException, ClassNotFoundException {
        Connection con = DriverManager.getConnection(conexion, user, pass);
        GestorDatosGenerales gd = new GestorDatosGenerales();
        gd.modificarDatosGenerales(d);
        m.setDatos(gd.obtenerDatosPorLegajo(m.getLegajoMatriculado()));
        PreparedStatement comando2 = con.prepareStatement("exec sp_update_matriculado ?, ?, ?");
        comando2.setInt(1, m.getIdMatriculado());
        comando2.setInt(2, m.getDatos());
        comando2.setString(3, m.getProfesion());
        comando2.executeUpdate();
        comando2.close();
            JOptionPane.showMessageDialog(null, "anda");
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
    
    public Matriculado obtenerMatriculadoxLegajo (int legajo) throws SQLException{
        Connection con = DriverManager.getConnection(conexion, user, pass);
        Statement stmtId = con.createStatement();
        ResultSet query = stmtId.executeQuery("SELECT dg.id_datos_generales, m.profesion FROM Datos_Generales dg join Matriculados m ON m.id_datos_generales = dg.id_datos_generales WHERE m.legajo_matriculado = " + legajo);
        Matriculado m = new Matriculado();
        if (query.next()) {
            m.setProfesion(query.getString("profesion"));
            m.setDatos(query.getInt("id_datos_generales"));
        }
        query.close();
        stmtId.close();
        con.close();
        return m;
    }
    
}