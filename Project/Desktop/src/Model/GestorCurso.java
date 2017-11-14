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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class GestorCurso {

    AccesoDatosVariable adv = new AccesoDatosVariable();

    String conexion = adv.getConexion();
    String user = adv.getUser();
    String pass = adv.getPass();
    String ClasForName = adv.getClasForName();

    String[] dias = new String[7];

    public GestorCurso() {
        dias[0] = "Domingo";
        dias[1] = "Lunes";
        dias[2] = "Martes";
        dias[3] = "Miercoles";
        dias[4] = "Jueves";
        dias[5] = "Viernes";
        dias[6] = "Sabado";
    }

    public void agregar(Curso c) throws SQLException, ClassNotFoundException {
        forName(ClasForName);
        Connection con = DriverManager.getConnection(conexion, user, pass);
        PreparedStatement comando = con.prepareStatement("exec sp_insert_curso ?,?,?,?,?,?,?,?,?,?");
        comando.setString(1, c.getNombreCurso());
        comando.setString(2, c.getDescripcion());
        comando.setString(3, c.getFechaInicio());
        comando.setString(4, c.getTemas());
        comando.setInt(5, c.getDuracionTotalSemanas());
        comando.setDouble(6, c.getCosto());
        comando.setInt(7, c.getCupo());
        comando.setString(8, c.getAula());
        comando.setString(9, c.getDiaHorario());
        comando.setInt(10, c.getCargaHoraria());

        comando.executeUpdate();
        comando.close();
        con.close();
    }

    public void modificar(Curso c) throws SQLException, ClassNotFoundException {
        forName(ClasForName);
        Connection con = DriverManager.getConnection(conexion, user, pass);
        PreparedStatement comando = con.prepareStatement("exec sp_update_curso_largo ?,?,?,?,?,?,?,?,?,?,?");
        comando.setInt(1, c.getIdCurso());
        comando.setString(2, c.getNombreCurso());
        comando.setString(3, c.getDescripcion());
        comando.setString(4, c.getFechaInicio());
        comando.setString(5, c.getTemas());
        comando.setInt(6, c.getDuracionTotalSemanas());
        comando.setDouble(7, c.getCosto());
        comando.setInt(8, c.getCupo());
        comando.setString(9, c.getAula());
        comando.setString(10, c.getDiaHorario());
        comando.setInt(11, c.getCargaHoraria());
        comando.executeUpdate();
        comando.close();
        con.close();
    }

    public Curso obtenerCurso(int i) throws ClassNotFoundException, SQLException {
        Curso c = new Curso();
        forName(ClasForName);
        Connection con = DriverManager.getConnection(conexion, user, pass);
        Statement comando = con.createStatement();
        ResultSet query = comando.executeQuery("select * from Cursos where id_curso = " + i);
        if (query.next()) {
            c.setNombreCurso(query.getString("nombre"));
            c.setDescripcion(query.getString("descripcion"));
            c.setTemas(query.getString("temas"));
            c.setFechaInicio(query.getString("fecha_inicio"));
            c.setDuracionTotalSemanas(query.getInt("duracion_total_semanas"));
            c.setCupo(query.getInt("cupo"));
            c.setCosto(query.getInt("costo"));
            c.setAula(query.getString("aula"));
            c.setDiaHorario(query.getString("dia_horario"));
            c.setCargaHoraria(query.getInt("carga_horaria"));
        }
        query.close();
        comando.close();
        con.close();
        return c;
    }

    public ArrayList<Curso> proximosCursos() throws SQLException, ClassNotFoundException {
        forName(ClasForName);
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        Connection con = DriverManager.getConnection(conexion, user, pass);
        Statement comando = con.createStatement();
        ResultSet query = comando.executeQuery("SELECT * FROM vw_consultar_cursos_proximos");
        while (query.next()) {
            Curso c = new Curso();

            c.setIdCurso(query.getInt("Id"));
            c.setNombreCurso(query.getString("Curso"));
            c.setDescripcion(query.getString("Descripcion"));
            c.setFechaInicio(query.getString("Inicio"));
            c.setTemas(query.getString("Temas"));
            c.setDuracionTotalSemanas(query.getInt("Cantidad de semanas"));
            c.setCosto(query.getDouble("Costo"));
            c.setCupo(query.getInt("Cupo"));
            c.setAula(query.getString("Aula"));
            String dia = dias[query.getInt("Dia")];
            String horario = query.getString("Horario");
            c.setDiaHorario(dia + " " + horario);
            c.setCargaHoraria(query.getInt("Carga horaria por dia"));
            cursos.add(c);
        }
        query.close();
        comando.close();
        con.close();
        return cursos;
    }

    public ArrayList<Curso> obtenerCursoEnCurso() throws ClassNotFoundException {
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        try {
            forName(ClasForName);
            Connection con = DriverManager.getConnection(conexion, user, pass);
            Statement comando = con.createStatement();
            ResultSet query = comando.executeQuery("SELECT * FROM vw_consultar_cursos_en_curso");
            while (query.next()) {
                Curso c = new Curso();

                c.setIdCurso(query.getInt("Id"));
                c.setNombreCurso(query.getString("Curso"));
                c.setDescripcion(query.getString("Descripcion"));
                c.setFechaInicio(query.getString("Inicio"));
                c.setTemas(query.getString("Temas"));
                c.setDuracionTotalSemanas(query.getInt("Cantidad de semanas"));
                c.setCosto(query.getDouble("Costo"));
                c.setAula(query.getString("Aula"));
                String dia = dias[query.getInt("Dia")];
                String horario = query.getString("Horario");
                c.setDiaHorario(dia + " " + horario);
                c.setCargaHoraria(query.getInt("Carga horaria por dia"));
                cursos.add(c);
            }
            query.close();
            comando.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cursos;
    }

    public ArrayList<Curso> TodosCursos() throws SQLException, ClassNotFoundException {
        forName(ClasForName);
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        Connection con = DriverManager.getConnection(conexion, user, pass);
        Statement comando = con.createStatement();
        ResultSet query = comando.executeQuery("SELECT * FROM vw_consultar_cursos_todos");
        while (query.next()) {
            Curso c = new Curso();

            c.setIdCurso(query.getInt("Id"));
            c.setNombreCurso(query.getString("Curso"));
            c.setDescripcion(query.getString("Descripcion"));
            c.setFechaInicio(query.getString("Inicio"));
            c.setTemas(query.getString("Temas"));
            c.setDuracionTotalSemanas(query.getInt("Cantidad de semanas"));
            c.setCosto(query.getDouble("Costo"));
            c.setAula(query.getString("Aula"));
            String dia = dias[query.getInt("Dia")];
            String horario = query.getString("Horario");
            c.setDiaHorario(dia + " " + horario);
            c.setCargaHoraria(query.getInt("Carga horaria por dia"));
            cursos.add(c);
        }
        query.close();
        comando.close();
        con.close();
        return cursos;
    }

    public ArrayList<ComboCurso> ComboCursosActuales() throws SQLException, ClassNotFoundException {
        forName(ClasForName);
        ArrayList<ComboCurso> cursos = new ArrayList<ComboCurso>();
        Connection con = DriverManager.getConnection(conexion, user, pass);
        Statement comando = con.createStatement();
        ResultSet query = comando.executeQuery("SELECT * FROM vw_cursos_actuales_combo");
        while (query.next()) {
            ComboCurso c = new ComboCurso();
            c.setId(query.getInt("Id"));
            c.setNombre(query.getString("Curso"));
            cursos.add(c);
        }
        query.close();
        comando.close();
        con.close();
        return cursos;
    }

    public ArrayList<ComboCurso> ComboCursosNegro() throws SQLException, ClassNotFoundException {
        forName(ClasForName);
        ArrayList<ComboCurso> cursos = new ArrayList<ComboCurso>();
        Connection con = DriverManager.getConnection(conexion, user, pass);
        Statement comando = con.createStatement();
        ResultSet query = comando.executeQuery("SELECT c.id_curso Id, c.nombre Curso FROM cursos c");
        while (query.next()) {
            ComboCurso c = new ComboCurso();
            c.setId(query.getInt("Id"));
            c.setNombre(query.getString("Curso"));
            cursos.add(c);
        }
        query.close();
        comando.close();
        con.close();
        return cursos;
    }

    public ArrayList<ComboNuevoCursante> ComboCursosIncribir() throws SQLException, ClassNotFoundException {
        forName(ClasForName);
        ArrayList<ComboNuevoCursante> cursos = new ArrayList<ComboNuevoCursante>();
        Connection con = DriverManager.getConnection(conexion, user, pass);
        Statement comando = con.createStatement();
        ResultSet query = comando.executeQuery("SELECT * FROM vw_cursos_proximos_combo");
        while (query.next()) {
            ComboNuevoCursante c = new ComboNuevoCursante();
            c.setId(query.getInt("Id"));
            c.setNombre(query.getString("Curso"));
            c.setFecha(query.getString("fecha"));
            cursos.add(c);
        }
        query.close();
        comando.close();
        con.close();
        return cursos;
    }

    public ArrayList<ComboNuevoCursante> ComboCursoProximoyActuales() throws SQLException, ClassNotFoundException {
        forName(ClasForName);
        ArrayList<ComboNuevoCursante> cursos = new ArrayList<ComboNuevoCursante>();
        Connection con = DriverManager.getConnection(conexion, user, pass);
        Statement comando = con.createStatement();
        ResultSet query = comando.executeQuery("SELECT * FROM vw_consultar_cursos_en_curso_y_proximos");
        while (query.next()) {
            ComboNuevoCursante c = new ComboNuevoCursante();

            c.setId(query.getInt("Id"));
            c.setNombre(query.getString("Curso"));
            c.setFecha(query.getString("inicio"));
            cursos.add(c);
        }
        query.close();
        comando.close();
        con.close();
        return cursos;
    }

    public String obtenerStringCurso(int idCuersante) throws SQLException {
        Connection con = DriverManager.getConnection(conexion, user, pass);
        Statement stmtIdCu = con.createStatement();
        ResultSet queryCu = stmtIdCu.executeQuery("SELECT c.nombre +' '+ CONVERT(varchar, c.fecha_inicio) as 'curso' FROM Inscripciones i JOIN Cursos c on (c.id_curso = i.id_inscripcion) WHERE i.id_cursante = " + idCuersante);
        String curso = "";
        if (queryCu.next()) {
            curso = queryCu.getString("curso");
        }
        queryCu.close();
        stmtIdCu.close();
        con.close();
        return curso;
    }

    public String obtenerFechaFinalCurso(String fechaInicio, int duracionTotalSemanas) throws SQLException {
        Connection con = DriverManager.getConnection(conexion, user, pass);
        PreparedStatement stmtIdCu = con.prepareStatement("exec sp_obtener_fecha_fin ?,? ");
        ResultSet queryCu = stmtIdCu.executeQuery();
        String curso = "";
        if (queryCu.next()) {
            curso = queryCu.getString(1);
        }
        queryCu.close();
        stmtIdCu.close();
        con.close();
        return curso;
    }

    public ArrayList<ComboCurso> ComboCursosPagar(String text) {
        ArrayList<ComboCurso> lista = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(conexion, user, pass);
            Statement comando = con.createStatement();
            ResultSet query = comando.executeQuery("SELECT c.id_curso curso, c.nombre nombre FROM Cursos c join Inscripciones i on i.id_curso = c.id_curso join Cursantes cu on cu.id_cursante = i.id_cursante join Datos_Generales dg on dg.id_datos_generales = cu.id_datos_generales WHERE dg.mail like '" + text + "'");
            while (query.next()) {
                ComboCurso c = new ComboCurso();
                c.setId(query.getInt("curso"));
                c.setNombre(query.getString("nombre"));
                lista.add(c);
            }
            query.close();
            comando.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

}
