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
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class GestorPago {

    String conexion = "jdbc:sqlserver://localhost:1412;databaseName=Colegio_Informatica_Metodologia";
    String user = "Gabriel";
    String pass = "1234";

    public void agregarPago(Pago p) throws ClassNotFoundException, SQLException {
        forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection(conexion, user, pass);
        PreparedStatement comando = con.prepareStatement("exec sp_insert_pago ?,?");
        comando.setInt(1, p.getInscripcion());
        comando.setDouble(2, p.getMonto());

        comando.executeUpdate();
        comando.close();
        con.close();
    }

    public ArrayList<Pago> obtenerTodos() throws ClassNotFoundException, SQLException {
        forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        ArrayList<Pago> pagos = new ArrayList<Pago>();
        Connection con = DriverManager.getConnection(conexion, user, pass);
        Statement comando = con.createStatement();
        ResultSet query = comando.executeQuery("Select * from Pagos");
        while (query.next()) {
            Pago p = new Pago();
            p.setIdPago(query.getInt("id_pago"));
            p.setIdPago(query.getInt("id_incripcion"));
            p.setMonto(query.getDouble("monto"));
            p.setFechaPago(query.getString("fecha_pago"));

            pagos.add(p);
        }
        query.close();
        comando.close();
        con.close();
        return pagos;
    }

    public Pago obtenerPago(int i) throws ClassNotFoundException, SQLException {
        forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection(conexion, user, pass);
        Statement comando = con.createStatement();
        ResultSet query = comando.executeQuery("Select * from Pagos where id_pago = " + i);
        Pago p = new Pago();
        if (query.next()) {
            p.setIdPago(query.getInt("id_pago"));
            p.setIdPago(query.getInt("id_incripcion"));
            p.setMonto(query.getDouble("monto"));
            p.setFechaPago(query.getString("fecha_pago"));
        }
        query.close();
        comando.close();
        con.close();
        return p;
    }

    //poder ver los pagos realizados filtrando por el mail
    public ArrayList<VMPagosXMail> VerPagosPorMail(String mail) throws ClassNotFoundException, SQLException {
        ArrayList<VMPagosXMail> lista = new ArrayList<>();
        forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection(conexion, user, pass);
        Statement stmtIns = con.createStatement(); // idCurso, idCursante
        ResultSet query = stmtIns.executeQuery("exec sp_ver_pagos_x_mail " + mail);

        while (query.next()) {
            VMPagosXMail datos = new VMPagosXMail();

            datos.setNombre(query.getString("Curso"));
            datos.setMonto(query.getFloat("Pago"));
            datos.setFecha(query.getString("Fecha"));

            lista.add(datos);
        }
        query.close();
        stmtIns.close();
        con.close();
        return lista;
    }

    //muestra lo adeudado filtrando por mail
    public VMPagosXMail mostrarDeuda(String mail) throws ClassNotFoundException, SQLException {
        forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection(conexion, user, pass);
        Statement stmtIns = con.createStatement(); // idCurso, idCursante
        ResultSet query = stmtIns.executeQuery("sp_ver_adeudado_x_mail " + mail);

        VMPagosXMail datos = new VMPagosXMail();
        if (query.next()) {

            datos.setNombre(query.getString("Curso"));
            datos.setMonto(query.getFloat("Pago"));
        }
        query.close();
        stmtIns.close();
        con.close();
        return datos;
    }
// mostrar pagos de una persona con fecha y el monto
    public ArrayList<VMPagosXMail> PagosPorFecha(int i) throws ClassNotFoundException, SQLException {
        ArrayList<VMPagosXMail> lista = new ArrayList<>();
        forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection(conexion, user, pass);
        Statement stmtIns = con.createStatement(); // idCurso, idCursante
        ResultSet query = stmtIns.executeQuery("sp_consultar_pagos_totales_x_inscripto " + i);

        if (query.next()) {
            VMPagosXMail datos = new VMPagosXMail();
            
            datos.setFecha(query.getString("Fecha"));
            datos.setMonto(query.getFloat("Pago"));
        }
        query.close();
        stmtIns.close();
        con.close();
        return lista;
    }
}
