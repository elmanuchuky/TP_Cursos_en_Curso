/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Asistencia;
import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Fernando M. de Lima
 */
public class GestorAsistencia {

    String conexion = "jdbc:sqlserver://localhost:1433;databaseName=Colegio_Informatica_Metodologia";
    String user = "sa";
    String pass = "Server1552";

    //vw_cursos_actuales_combo cargar combo de cursos
    //sp_listado_cursantes_x_curso
    public void agregarAsistencia(Asistencia a) throws ClassNotFoundException, SQLException {

        forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection(conexion, user, pass);
        PreparedStatement comando = con.prepareStatement("exec sp_insert_asistencia ?, ?, ?");
        comando.setInt(1, a.getInscripcion());
        comando.setString(2, a.getFechaAsistencia());
        comando.setBoolean(3, a.isEstaPresente());
        comando.executeUpdate();
        comando.close();
        con.close();

    }

    public void modificarAsistencia(Asistencia a) throws ClassNotFoundException, SQLException {

        forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection(conexion, user, pass);
        PreparedStatement comando = con.prepareStatement("exec sp_update_asistencia ?, ?, ?");
        comando.setInt(1, a.getInscripcion());
        comando.setString(2, a.getFechaAsistencia());
        comando.setBoolean(3, a.isEstaPresente());
        comando.executeUpdate();
        comando.close();
        con.close();
    }
//PASAR AL GESTOR DE INSCRIPCIONES SI LLEGAMOS CON EL TIEMPO

    /* public ArrayList<vwAsistenciaRegistrar> obtenerAsistenciaCursanteCurso(int idCurso) throws ClassNotFoundException, SQLException{
        
         forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         ArrayList<vwAsistenciaRegistrar> vmAsistencias = new ArrayList<>();
         Connection con = DriverManager.getConnection(conexion, user, pass);
         Statement comando = con.createStatement();
         ResultSet consulta = comando.executeQuery("exec sp_listado_cursantes_x_curso " + idCurso);
         while(consulta.next()){
             vwAsistenciaRegistrar vma = new vwAsistenciaRegistrar();
             vma.setIdInscripcion(consulta.getInt(0));
             vma.setNombreCompleto(consulta.getString(1));
             vma.setEstaPresente(consulta.getBoolean(2));
             vmAsistencias.add(vma);
         }
         consulta.close();
         comando.close();
         con.close();
         
         return vmAsistencias;
    }
     */
    //OBTENER ASISTENCIA POR CURSO
    public ArrayList<ArrayList<String>> obtenerAsistenciasPorCurso(int idCurso) throws ClassNotFoundException, SQLException {

        forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        ArrayList<ArrayList<String>> lista = new ArrayList<>();
        Connection con = DriverManager.getConnection(conexion, user, pass);
        PreparedStatement comando = con.prepareStatement("exec sp_fechas_x_curso ?");
        comando.setInt(1, idCurso);
        ResultSet consulta = comando.executeQuery();
        ArrayList<String> fechas = new ArrayList<>();
        fechas.add("Alumno");
        while (consulta.next()) {
            fechas.add(consulta.getString("Fecha"));
        }
        consulta.close();
        comando.close();
        boolean esPrimero = true;
        for (String fecha : fechas) {
            if (esPrimero) {
                esPrimero = false;
                ArrayList<String> alumnos = new ArrayList<>();
                alumnos.add(fecha);
                PreparedStatement comando2 = con.prepareStatement("exec sp_listado_cursantes_x_curso ?");
                comando.setInt(1, idCurso);
                ResultSet consulta2 = comando2.executeQuery();
                while (consulta2.next()) {
                    alumnos.add(consulta2.getString("Cursante"));
                }
                consulta2.close();
                comando2.close();
                lista.add(alumnos);
            } else {
                ArrayList<String> presentes = new ArrayList<>();
                presentes.add(fecha);
                PreparedStatement comando2 = con.prepareStatement("exec sp_asistencia_x_curso_x_fecha ?, ?");
                comando.setInt(1, idCurso);
                comando.setString(2, fecha);
                ResultSet consulta2 = comando2.executeQuery();
                while (consulta2.next()) {
                    boolean estaPresente = consulta2.getBoolean("Presente");
                    if (estaPresente) {
                        presentes.add("P");
                    } else {
                        presentes.add("A");
                    }
                }
                consulta2.close();
                comando2.close();
                lista.add(presentes);
            }
        }
        con.close();
        return lista;
    }

    //OBTENER ASISTENCIA POR CURSO POR FECHA
    
    public ArrayList<ArrayList<String>> obtenerAsistenciasPorCursoPorFecha(int idCurso, String fecha) throws ClassNotFoundException, SQLException {

        forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        ArrayList<ArrayList<String>> lista = new ArrayList<>();
        ArrayList<String> alumnos = new ArrayList<>();
        Connection con = DriverManager.getConnection(conexion, user, pass);
        PreparedStatement comando = con.prepareStatement("exec sp_listado_cursantes_x_curso ?");
        comando.setInt(1, idCurso);
        ResultSet consulta = comando.executeQuery();
        alumnos.add("Alumnno");
        while (consulta.next()) {
            alumnos.add(consulta.getString("Cursante"));
        }
        consulta.close();
        comando.close();
        ArrayList<String> presentes = new ArrayList<>();
        PreparedStatement comando2 = con.prepareStatement("exec sp_asistencia_x_curso_x_fecha ?, ?");
        comando.setInt(1, idCurso);
        comando.setString(2, fecha);
        ResultSet consulta2 = comando.executeQuery();
        presentes.add(fecha);
        while (consulta2.next()) {
            boolean estaPresente = consulta2.getBoolean("Presente");
            if (estaPresente) {
                presentes.add("P");
            } else {
                presentes.add("A");
            }
        }
        consulta2.close();
        comando2.close();
        con.close();
        lista.add(alumnos);
        lista.add(presentes);

        return lista;
    }

    //OBTENER ASISTENCIA POR CURSO POR MAIL
    
    public ArrayList<ArrayList<String>> obtenerAsistenciasPorCursoPorMail(int idCurso, String email) throws ClassNotFoundException, SQLException {

        forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        ArrayList<ArrayList<String>> lista = new ArrayList<>();
        Connection con = DriverManager.getConnection(conexion, user, pass);
        ArrayList<String> fechas = new ArrayList<>();
        PreparedStatement comando = con.prepareStatement("exec sp_fechas_x_curso ?");
        comando.setInt(1, idCurso);
        ResultSet consulta = comando.executeQuery();
        fechas.add("Alumno");
        while (consulta.next()) {
            fechas.add(consulta.getString("Fecha"));
        }
        consulta.close();
        comando.close();
        ArrayList<String> presentes = new ArrayList<>();
        PreparedStatement comando2 = con.prepareStatement("exec sp_asistencia_x_inscripto_x_curso ?, ?");
        comando2.setInt(1, idCurso);
        comando2.setString(2, email);
        ResultSet consulta2 = comando.executeQuery();
        presentes.add(email);
        while (consulta2.next()) {
            boolean estaPresente = consulta2.getBoolean("Presente");
            if (estaPresente) {
                presentes.add("P");
            } else {
                presentes.add("A");
            }
        }
        consulta2.close();
        comando2.close();
        con.close();
        lista.add(fechas);
        lista.add(presentes);

        return lista;
    }
}
