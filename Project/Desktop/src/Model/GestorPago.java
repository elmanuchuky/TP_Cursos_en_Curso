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
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class GestorPago {

    AccesoDatosVariable adv = new AccesoDatosVariable();

    String conexion = adv.getConexion();
    String user = adv.getUser();
    String pass = adv.getPass();
    String ClasForName = adv.getClasForName();

    public void agregarPago(Pago p) throws ClassNotFoundException, SQLException {
        forName(ClasForName);
        Connection con = DriverManager.getConnection(conexion, user, pass);
        PreparedStatement comando = con.prepareStatement("exec sp_insert_pago ?,?");
        comando.setInt(1, p.getInscripcion());
        comando.setDouble(2, p.getMonto());

        comando.executeUpdate();
        comando.close();
        con.close();
    }

    public ArrayList<Pago> obtenerTodos() throws ClassNotFoundException, SQLException {
        forName(ClasForName);
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
        forName(ClasForName);
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
        forName(ClasForName);
        Connection con = DriverManager.getConnection(conexion, user, pass);
        PreparedStatement stmt = con.prepareStatement("exec sp_ver_pagos_x_mail ?"); // idCurso, idCursante
        stmt.setString(1, mail);
        ResultSet query = stmt.executeQuery();

        while (query.next()) {
            if (query.getInt("Pago") > 0) {

                VMPagosXMail datos = new VMPagosXMail();

                datos.setNombre(query.getString("Curso"));
                datos.setMonto(query.getFloat("Pago"));
                datos.setFecha(query.getString("Fecha"));

                lista.add(datos);
            }
        }
        query.close();
        stmt.close();
        con.close();
        return lista;
    }

    //muestra lo adeudado filtrando por mail
    public ArrayList<VMDeudasXMail> mostrarDeuda(String mail) throws ClassNotFoundException, SQLException {
        ArrayList<VMDeudasXMail> lista = new ArrayList<>();
        forName(ClasForName);
        Connection con = DriverManager.getConnection(conexion, user, pass);
        PreparedStatement stmt = con.prepareStatement("sp_ver_adeudado_x_mail ?"); // idCurso, idCursante
        stmt.setString(1, mail);
        ResultSet query = stmt.executeQuery();
        JOptionPane.showMessageDialog(null, "2");

        while (query.next()) {
            VMDeudasXMail datos = new VMDeudasXMail();

            datos.setNombre(query.getString("Curso"));
            datos.setMonto(query.getFloat("Pago"));
            lista.add(datos);
        }
        query.close();
        stmt.close();
        con.close();
        return lista;
    }
// mostrar pagos de una persona con fecha y el monto

    public ArrayList<VMPagosXMail> PagosPorFecha(int i) throws ClassNotFoundException, SQLException {
        ArrayList<VMPagosXMail> lista = new ArrayList<>();
        forName(ClasForName);
        Connection con = DriverManager.getConnection(conexion, user, pass);
        PreparedStatement stmt = con.prepareStatement("sp_consultar_pagos_totales_x_inscripto ?"); // idCurso, idCursante
        stmt.setInt(1, i);
        ResultSet query = stmt.executeQuery();

        if (query.next()) {
            VMPagosXMail datos = new VMPagosXMail();

            datos.setFecha(query.getString("Fecha"));
            datos.setMonto(query.getFloat("Pago"));
        }
        query.close();
        stmt.close();
        con.close();
        return lista;
    }

    public Pago obtenerUltimoPago() throws ClassNotFoundException, SQLException { //To change body of generated methods, choose Tools | Templates.
        forName(ClasForName);
        Connection con = DriverManager.getConnection(conexion, user, pass);
        Statement comando = con.createStatement();
        ResultSet query = comando.executeQuery("select top 1 p.monto, p.id_pago, p.fecha_pago from Pagos p order by p.id_pago desc");
        Pago p = new Pago();
        if (query.next()) {
            p.setIdPago(query.getInt("id_pago"));
            p.setMonto(query.getDouble("monto"));
            p.setFechaPago(query.getString("fecha_pago"));
        }
        query.close();
        comando.close();
        con.close();
        return p;

    }
}
