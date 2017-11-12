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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando M. de Lima
 */
public class GestorDatosGenerales {

    AccesoDatosVariable adv = new AccesoDatosVariable();

    String conexion = adv.getConexion();
    String user = adv.getUser();
    String pass = adv.getPass();
    String ClasForName = adv.getClasForName();

    public GestorDatosGenerales() {
    }

    public void agregarDatosGenerales(DatosGenerales d) throws ClassNotFoundException, SQLException {
        Class.forName(ClasForName);
        Connection con = DriverManager.getConnection(conexion, user, pass);
        PreparedStatement comando = con.prepareStatement("exec sp_insert_datos_generales ?,?,?,?,?,?,?");
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
        Class.forName(ClasForName);
        Connection con = DriverManager.getConnection(conexion, user, pass);
        PreparedStatement comando = con.prepareStatement("exec sp_update_datos_generales ?,?,?,?,?,?,?,?");
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
        Class.forName(ClasForName);
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

    public int obtenerDatosPorLegajo(int legajo) {
        int idDG = 0;
        try {
            Class.forName(ClasForName);
            Connection con = DriverManager.getConnection(conexion, user, pass);
            Statement stmtId = con.createStatement();
            ResultSet query = stmtId.executeQuery("SELECT m.id_datos_generales id FROM Matriculados m join Datos_Generales dg on m.id_datos_generales = dg.id_datos_generales WHERE m.legajo_matriculado = " + legajo);
            if (query.next()) {
                idDG = query.getInt("id");
            }
            query.close();
            stmtId.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorDatosGenerales.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorDatosGenerales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idDG;
    }

    public DatosGenerales obtenerDatosGenerales(int id) throws SQLException {
        Connection con = DriverManager.getConnection(conexion, user, pass);
        Statement stmtId = con.createStatement();
        ResultSet query = stmtId.executeQuery("SELECT * FROM Datos_Generales dg join Matriculados m on m.id_datos_generales = dg.id_datos_generales WHERE m.id_matriculado = " + id);
        DatosGenerales dg = new DatosGenerales();
        if (query.next()) {
            dg.setApellido(query.getString("apellido"));
            dg.setDni(query.getInt("dni"));
            dg.setNombre(query.getString("nombre"));
            dg.setIdDatosGenerales(query.getInt("id_datos_generales"));
            dg.setTipoDni(query.getInt("id_tipo_dni"));
            dg.setFechaNacimiento(query.getString("fecha_nacimiento"));
            dg.setTelefono(query.getString("telefono"));
            dg.setEmail(query.getString("mail"));
        }
        query.close();
        stmtId.close();
        con.close();
        return dg;
    }

    public DatosGenerales obtenerDatosGeneralesXMail(String mail) throws SQLException {
        Connection con = DriverManager.getConnection(conexion, user, pass);
        Statement stmtId = con.createStatement();
        ResultSet query = stmtId.executeQuery("SELECT * FROM Datos_Generales dg join Matriculados m on m.id_datos_generales = dg.id_datos_generales WHERE dg.mail= " + mail);
        DatosGenerales dg = new DatosGenerales();
        if (query.next()) {
            dg.setApellido(query.getString("apellido"));
            dg.setDni(query.getInt("dni"));
            dg.setNombre(query.getString("nombre"));
            dg.setIdDatosGenerales(query.getInt("id_datos_generales"));
            dg.setTipoDni(query.getInt("id_tipo_dni"));
            dg.setFechaNacimiento(query.getString("fecha_nacimiento"));
            dg.setTelefono(query.getString("telefono"));
            dg.setEmail(query.getString("mail"));
        }
        query.close();
        stmtId.close();
        con.close();
        return dg;
    }

}
