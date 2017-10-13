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
 * @author Gabriel
 */
public class GestorCurso {
    String conexion ;
    String user = "Gabriel";
    String pass = "1234";
    
    public void agregar(Curso c) throws SQLException{
        Connection con = DriverManager.getConnection(conexion,user,pass);
        PreparedStatement comando = con.prepareStatement("exec proc sp_insert_curso ?,?,?,?,?,?,?,?,?,?");
        comando.setString(1, c.getNombreCurso());
        comando.setString(2, c.getDescripcion()); 
        comando.setDate(3,((java.sql.Date)c.getFechaInicio()));
        comando.setString(4, c.getTemas());
        comando.setInt(4, c.getDuracionTotalSemanas());
        comando.setDouble(6,c.getCosto());
        comando.setInt(7, c.getCupo());
        comando.setString(8, c.getAula());
        comando.setTimestamp(9, c.getDiaHorario());
        comando.setInt(10, c.getCargaHoraria());
        
        comando.executeUpdate();
        comando.close();
        con.close();
    }
    
    public void modificar(Curso c) throws SQLException{
        Connection con = DriverManager.getConnection(conexion, user,pass);
        PreparedStatement comando = con.prepareStatement("exec proc SP_UPDATE_CURSOS ?,?,?,?,?,?,?,?,?,?");
        comando.setString(1, c.getNombreCurso());
        comando.setString(2, c.getDescripcion()); 
        comando.setDate(3,((java.sql.Date)c.getFechaInicio()));
        comando.setString(4, c.getTemas());
        comando.setInt(4, c.getDuracionTotalSemanas());
        comando.setDouble(6, c.getCosto());
        comando.setInt(7, c.getCupo());
        comando.setString(8, c.getAula());
        comando.setTimestamp(9, c.getDiaHorario());
        comando.setInt(10, c.getCargaHoraria());
        comando.executeUpdate();
        comando.close();
        con.close();
    }
    
    public ArrayList<Curso> proximosCursos() throws SQLException{
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        Connection con = DriverManager.getConnection(conexion, user,pass);
        Statement comando = con.createStatement();
        ResultSet query = comando.executeQuery("");
        while(query.next()){
            Curso c = new Curso();
            c.setIdCurso(query.getInt("id_curso"));
            c.setNombreCurso(query.getString("nombre"));
            c.setDescripcion("descripcion");
            c.setFechaInicio(query.getDate("fecha_inicio"));
            c.setTemas(query.getString("temas"));
            c.setDuracionTotalSemanas(query.getInt("duracion_total_semanas"));
            c.setCosto(query.getDouble("costo"));
            c.setCupo(query.getInt("cupo"));
            c.setAula(query.getString("aula"));
            c.setDiaHorario(query.getTimestamp("dia_horario"));
            c.setCargaHoraria(query.getInt("carga_horaria"));
            cursos.add(c);
        }
        return cursos;
    }
}
