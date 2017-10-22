/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Fernando M. de Lima
 */
public class GestorInscripcion {
     public static final String CONN_STR = "jdbc:sqlserver://LAPTOP-5AEIROHB\\SQLEXPRESS;databaseName=ABMPersonasDB";
    private String USER = "sa";
    private String PASS = "1234";
    private Connection conn;

    public ArrayList<Inscripcion> obtenerTodas() {
        ArrayList<Inscripcion> resultado = new ArrayList<Inscripcion>();
        try {
            abrirConexion();
            //Ahora a la conexión le decimos que nos cree un Statement para ejecutar la consulta
            Statement stmt = conn.createStatement();
            //Ejecutamos la consulta SQL. Esto nos devolverá un ResultSet con las filas correspondientes
            ResultSet query = stmt.executeQuery("SELECT * FROM Personas");

            while (query.next()) {
                String nombre = query.getString("nombre");
                String apellido = query.getString("apellido");
                int edad = query.getInt("edad");

                Inscripcion i = new Inscripcion();
                resultado.add(i);
            }
            query.close();
            stmt.close();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
    }

    private void cerrarConexion() throws SQLException {
        conn.close();
    }

    private void abrirConexion() throws SQLException {
        conn = DriverManager.getConnection(CONN_STR, USER, PASS);
    }

    public void agregarInscripcionOtro(DatosGenerales dg, Cursante cu, int idCurso) throws ClassNotFoundException {
        try {
            GestorDatosGenerales gdg = new GestorDatosGenerales();
            gdg.agregarDatosGenerales(dg);
            int ultimoGdg = gdg.obtenerUltimoId();
            abrirConexion();
            
            
            // Insertar nuevo cursante
            PreparedStatement stmtCu = conn.prepareStatement("exec sp_insert_cursante NULL, 0, ?"); // idMatri, esFamilia, IdDG
            stmtCu.setInt(1, dg.getIdDatosGenerales());
            stmtCu.executeUpdate();
            stmtCu.close();
            // Recuperar el id de ese cursante
            Statement stmtIdCu = conn.createStatement();
            ResultSet queryCu = stmtIdCu.executeQuery("SELECT MAX(id_cursante) id FROM Cursantes");
            int cuId = 0;
            if (queryCu.next())
                cuId = query.getInt("id");
            queryCu.close();
            stmtIdCu.close();
            // Insertar nueva inscripcion
            PreparedStatement stmtIns = conn.prepareStatement("exec sp_insert_inscripcion ?, ?"); // idCurso, idCursante
            stmt.setInt(1, idCurso);
            stmtIns.setInt(2, cuId);
            stmtIns.executeUpdate();
            stmtIns.close();
            cerrarConexion();
        } catch (SQLException ex) {
        }
    }

    public void agregarInscripcionFamiliar(DatosGenerales dg, Cursante cu, int idCurso, int legajo) {
        try {
            abrirConexion();
            // Pedir datos generales primero
            PreparedStatement stmt = conn.prepareStatement("exec sp_insert_datos_generales ?, ?, ?, ?, ?, ?, ?");
            stmt.setString(1, dg.getNombre());
            stmt.setString(2, dg.getApellido());
            stmt.setInt(3, dg.getTipoDni());
            stmt.setInt(4, dg.getDni());
            stmt.setString(5, dg.getFechaNacimiento());
            stmt.setString(6, dg.getTelefono());
            stmt.setString(7, dg.getEmail());
            stmt.executeUpdate();
            stmt.close();
            // Recuperar el id de ese dato general (puede ser con mail)
            Statement stmtId = conn.createStatement();
            ResultSet query = stmtId.executeQuery("SELECT MAX(id_datos_generales) id FROM Datos_Generales");
            if (query.next())
                dg.setIdDatosGenerales(query.getInt("id"));
            query.close();
            stmtId.close();
            // Recuperar el id del matriculado con el legajo
            Statement stmtLegajo = conn.createStatement();
            ResultSet queryLegajo = stmtLegajo.executeQuery("SELECT id_matriculado id FROM Matriculados WHERE legajo_matriculado = " + legajo);
            int idMatriculado = 0;
            if (queryLegajo.next())
                idMatriculado = queryLegajo.getInt("id");
            queryLegajo.close();
            stmtLegajo.close();
            // Insertar nuevo cursante
            PreparedStatement stmtCu = conn.prepareStatement("exec sp_insert_cursante ?, 1, ?"); // idMatri, esFamilia, IdDG
            stmtCu.setInt(1, idMatriculado);
            stmtCu.setInt(2, dg.getIdDatosGenerales());
            stmtCu.executeUpdate();
            stmtCu.close();
            // Recuperar el id de ese cursante
            Statement stmtIdCu = conn.createStatement();
            ResultSet queryCu = stmtIdCu.executeQuery("SELECT MAX(id_cursante) id FROM Cursantes");
            int cuId = 0;
            if (queryCu.next())
                cuId = query.getInt("id");
            queryCu.close();
            stmtIdCu.close();
            // Insertar nueva inscripcion
            PreparedStatement stmtIns = conn.prepareStatement("exec sp_insert_inscripcion ?, ?"); // idCurso, idCursante
            stmtIns.setInt(1, idCurso);
            stmtIns.setInt(2, cuId);
            stmtIns.executeUpdate();
            stmtIns.close();
            cerrarConexion();
        } catch (SQLException ex) {
        }
    }
    public void agregarInscripcionMatriculado(int idCurso, int legajo) {
        try {
            abrirConexion();
            // Recuperar el id del matriculado con el legajo
            Statement stmtLegajo = conn.createStatement();
            ResultSet queryLegajo = stmtLegajo.executeQuery("SELECT id_matriculado id FROM Matriculados WHERE legajo_matriculado = " + legajo);
            int idMatriculado = 0;
            if (queryLegajo.next())
                idMatriculado = queryLegajo.getInt("id");
            queryLegajo.close();
            stmtLegajo.close();
            // Recuperar el id de ese dato general (puede ser con mail)
            Statement stmtId = conn.createStatement();
            ResultSet query = stmtId.executeQuery("SELECT m.id_datos_generales id FROM Matriculados m join Datos_Generales dg on m.id_datos_generales = dg.id_datos_generales WHERE m.legajo_matriculado = " + legajo);
            int idDG = 0;
            if (query.next())
                idDG = query.getInt("id");
            query.close();
            stmtId.close();
            // Insertar nuevo cursante
            PreparedStatement stmtCu = conn.prepareStatement("exec sp_insert_cursante ?, 0, ?"); // idMatri, esFamilia, IdDG
            stmtCu.setInt(1, idMatriculado);
            stmtCu.setInt(2, idDG);
            stmtCu.executeUpdate();
            stmtCu.close();
            // Recuperar el id de ese cursante
            Statement stmtIdCu = conn.createStatement();
            ResultSet queryCu = stmtIdCu.executeQuery("SELECT MAX(id_cursante) id FROM Cursantes");
            int cuId = 0;
            if (queryCu.next())
                cuId = query.getInt("id");
            queryCu.close();
            stmtIdCu.close();
            // Insertar nueva inscripcion
            PreparedStatement stmtIns = conn.prepareStatement("exec sp_insert_inscripcion ?, ?"); // idCurso, idCursante
            stmtIns.setInt(1, idCurso);
            stmtIns.setInt(2, cuId);
            stmtIns.executeUpdate();
            stmtIns.close();
            cerrarConexion();
        } catch (SQLException ex) {
        }
    }
}
