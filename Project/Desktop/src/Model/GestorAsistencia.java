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
 * @author Usuario
 */
public class GestorAsistencia {
    
    String conexion = "jdbc:sqlserver://localhost:1433;databaseName=Colegio_Informatica_Metodologia";
    String user = "sa";
    String pass = "Server1552";
    
    //vw_cursos_actuales_combo cargar combo de cursos
    //sp_listado_cursantes_x_curso
    
    public void agregarAsistencia(Asistencia a) throws ClassNotFoundException, SQLException{
        
        forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection(conexion, user, pass);
        PreparedStatement comando = con.prepareStatement("exec sp_insert_asistencia ?, ?, ?");
        comando.setInt(1, a.getInscripcion());
        comando.setString(2,a.getFechaAsistencia());
        comando.setBoolean(3, a.isEstaPresente());
        comando.executeUpdate();
        comando.close();
        con.close();        
        
    }
    
    public void modificarAsistencia(Asistencia a) throws ClassNotFoundException, SQLException{
        
        forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection(conexion, user, pass);
        PreparedStatement comando = con.prepareStatement("exec sp_update_asistencia ?, ?, ?");
        comando.setInt(1, a.getInscripcion());
        comando.setString(2, a.getFechaAsistencia());
        comando.setBoolean(3, a.isEstaPresente());
        comando.close();
        con.close();
    }   
//
    
    public ArrayList<vwAsistenciaRegistrar> obtenerAsistenciaCursanteCurso(int idCurso) throws ClassNotFoundException, SQLException{
        
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
    
    public ArrayList<vwAsistenciaMostrar> obtenerAsistencias(int idCurso, String fecha, String email) throws ClassNotFoundException, SQLException{
        
         forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         ArrayList<vwAsistenciaMostrar> vmAsistencias = new ArrayList<>();
         Connection con = DriverManager.getConnection(conexion, user, pass);
         Statement comando = con.createStatement();
         ResultSet consulta = comando.executeQuery("exec sp_listado_asistencia_filtros " + idCurso +" "+ fecha +" "+ email);
         //puede filtrar por curso, o por curso y fecha, o curso y email, debe devolver nombre completo
         //(apellido + nombre Cursante), fecha_asistencia y si esta_presente o no
         while(consulta.next()){
             vwAsistenciaMostrar vma = new vwAsistenciaMostrar();
             vma.setNombreCompleto(consulta.getString(0));
             vma.setFechaAsistencia(consulta.getString(1));
             vma.setEstaPresente(consulta.getBoolean(2));
             vmAsistencias.add(vma);
         }
         consulta.close();
         comando.close();
         con.close();
         
         return vmAsistencias;
    }
    
}
