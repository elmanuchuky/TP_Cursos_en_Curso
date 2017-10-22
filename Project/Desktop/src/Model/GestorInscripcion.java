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
import java.util.ArrayList;

/**
 *
 * @author Fernando M. de Lima
 */
public class GestorInscripcion {

    String conexion = "jdbc:sqlserver://localhost:1412;databaseName=Colegio_Informatica_Metodologia";
    String user = "Gabriel";
    String pass = "1234";

    public ArrayList<Inscripcion> obtenerTodas() {
        ArrayList<Inscripcion> resultado = new ArrayList<Inscripcion>();
        try {
            Connection con = DriverManager.getConnection(conexion, user, pass);
            //Ahora a la conexión le decimos que nos cree un Statement para ejecutar la consulta
            Statement stmt = con.createStatement();
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
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
    }

    public void agregarInscripcionOtro(DatosGenerales dg, int idCurso) throws ClassNotFoundException {
        try {
            GestorDatosGenerales gdg = new GestorDatosGenerales();
            GestorCursante gc = new GestorCursante();
            gdg.agregarDatosGenerales(dg);
            int ultimodgd = gdg.obtenerUltimoId();
            gc.agregarCursanteOtro(ultimodgd);
            int ultimoCursante = gc.obtenerUltimoCursante();
            
            // Recuperar el id de ese dato general (puede ser con mail)
            Connection con = DriverManager.getConnection(conexion, user, pass);

            // Insertar nueva inscripcion
            PreparedStatement stmtIns = con.prepareStatement("exec sp_insert_inscripcion ?, ?"); // idCurso, idCursante
            stmtIns.setInt(1, idCurso);
            stmtIns.setInt(2, ultimoCursante);
            stmtIns.executeUpdate();
            stmtIns.close();
            con.close();
        } catch (SQLException ex) {
        }
    }

    public void agregarInscripcionFamiliar(DatosGenerales dg, int legajo, int cursoId) throws ClassNotFoundException {
        try {
            GestorDatosGenerales gdg= new GestorDatosGenerales();
            GestorMatriculado gm = new GestorMatriculado();
            GestorCursante gc = new GestorCursante();
            
            gdg.agregarDatosGenerales(dg);
            int ultimogdg = gdg.obtenerUltimoId();
            int matriculado = gm.obtenerMatriculado(legajo);
            gc.agregarCursanteFamilia(matriculado, ultimogdg);
            int ultimoCursante = gc.obtenerUltimoCursante();
            
            // Insertar nueva inscripcion
            Connection con = DriverManager.getConnection(conexion,user,pass);
            PreparedStatement stmtIns = con.prepareStatement("exec sp_insert_inscripcion ?, ?"); // idCurso, idCursante
            stmtIns.setInt(1, cursoId);
            stmtIns.setInt(2, ultimoCursante);
            stmtIns.executeUpdate();
            stmtIns.close();
            con.close();
        } catch (SQLException ex) {
        }
    }

    public void agregarInscripcionMatriculado(int idCurso, int legajo) {
        try {
            GestorMatriculado gm = new GestorMatriculado();
            GestorDatosGenerales gdg = new GestorDatosGenerales();
            GestorCursante gc = new GestorCursante();
            int idDatosGeneral = gdg.obtenerDatosPorLegajo(legajo);
            int idMatriculado= gm.obtenerMatriculado(legajo);
            gc.agregarCursanteMatriculado(idMatriculado, idDatosGeneral);
            
            int ultimoCursante = gc.obtenerUltimoCursante();
            // Insertar nueva inscripcion
            Connection con = DriverManager.getConnection(conexion,user,pass);
            PreparedStatement stmtIns = con.prepareStatement("exec sp_insert_inscripcion ?, ?"); // idCurso, idCursante
            stmtIns.setInt(1, idCurso);
            stmtIns.setInt(2, ultimoCursante);
            stmtIns.executeUpdate();
            stmtIns.close();
            con.close();
        } catch (SQLException ex) {
        }
    }
}
