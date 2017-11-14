/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static java.lang.Class.forName;
import java.sql.Array;
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
 * @author Fernando M. de Lima
 */
public class GestorInscripcion {

    AccesoDatosVariable adv = new AccesoDatosVariable();

    String conexion = adv.getConexion();
    String user = adv.getUser();
    String pass = adv.getPass();
    String ClasForName = adv.getClasForName();

    public void agregarInscripcionOtro(DatosGenerales dg, int idCurso) throws ClassNotFoundException {
        forName(ClasForName);
        try {
            GestorDatosGenerales gdg = new GestorDatosGenerales();
            gdg.agregarDatosGenerales(dg);
            int ultimodgd = gdg.obtenerUltimoId();
            GestorCursante gc = new GestorCursante();
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

    public boolean agregarInscripcionFamiliar(DatosGenerales dg, int legajo, int cursoId) throws ClassNotFoundException, SQLException {
        forName(ClasForName);
        try {
            GestorDatosGenerales gdg = new GestorDatosGenerales();
            gdg.agregarDatosGenerales(dg);
            int ultimogdg = gdg.obtenerUltimoId();
            GestorMatriculado gm = new GestorMatriculado();
            int matriculado = gm.obtenerMatriculado(legajo);
            GestorCursante gc = new GestorCursante();
            gc.agregarCursanteFamilia(matriculado, ultimogdg);
            int ultimoCursante = gc.obtenerUltimoCursante();

            // Insertar nueva inscripcion
            Connection con = DriverManager.getConnection(conexion, user, pass);
            PreparedStatement stmtIns = con.prepareStatement("exec sp_insert_inscripcion ?, ?"); // idCurso, idCursante
            stmtIns.setInt(1, cursoId);
            stmtIns.setInt(2, ultimoCursante);
            stmtIns.executeUpdate();
            stmtIns.close();
            con.close();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public void agregarInscripcionMatriculado(int legajo, int idCurso) throws ClassNotFoundException {
        forName(ClasForName);
        try {
            GestorDatosGenerales gdg = new GestorDatosGenerales();
            int idDatosGeneral = gdg.obtenerDatosPorLegajo(legajo);
            GestorMatriculado gm = new GestorMatriculado();
            int idMatriculado = gm.obtenerMatriculado(legajo);
            GestorCursante gc = new GestorCursante();
            gc.agregarCursanteMatriculado(idMatriculado, idDatosGeneral);

            int ultimoCursante = gc.obtenerUltimoCursante();
            // Insertar nueva inscripcion
            Connection con = DriverManager.getConnection(conexion, user, pass);
            PreparedStatement stmtIns = con.prepareStatement("exec sp_insert_inscripcion ?, ?"); // idCurso, idCursante
            stmtIns.setInt(1, idCurso);
            stmtIns.setInt(2, ultimoCursante);
            stmtIns.executeUpdate();
            stmtIns.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }

    public boolean existeMailEnCurso(String mail, int idCurso) throws ClassNotFoundException {
        forName(ClasForName);
        try {
            // Insertar nueva inscripcion
            Connection con = DriverManager.getConnection(conexion, user, pass);
            PreparedStatement stmtIns = con.prepareStatement("SELECT * FROM Datos_Generales dg join Cursantes cu on cu.id_datos_generales = dg.id_datos_generales join Inscripciones i on i.id_cursante = cu.id_cursante WHERE id_curso = ? AND dg.mail like ?"); // idCurso, idCursante
            stmtIns.setInt(1, idCurso);
            stmtIns.setString(2, mail);
            ResultSet query = stmtIns.executeQuery();
            if (query.next()) {
                query.close();
                stmtIns.close();
                con.close();
                return true;
            }
            query.close();
            stmtIns.close();
            con.close();
        } catch (SQLException ex) {
            return true;
        }
        return false;
    }

    public int obtenerInscripcionConMailYCurso(String mail, int idCurso) throws ClassNotFoundException {
        forName(ClasForName);
        try {
            // Insertar nueva inscripcion
            Connection con = DriverManager.getConnection(conexion, user, pass);
            PreparedStatement stmtIns = con.prepareStatement("SELECT i.id_inscripcion id FROM Datos_Generales dg join Cursantes cu on cu.id_datos_generales = dg.id_datos_generales join Inscripciones i on i.id_cursante = cu.id_cursante WHERE id_curso = ? AND dg.mail like ?"); // idCurso, idCursante
            stmtIns.setInt(1, idCurso);
            stmtIns.setString(2, mail);
            ResultSet query = stmtIns.executeQuery();
            if (query.next()) {
                int a = query.getInt("id");
                query.close();
                stmtIns.close();
                con.close();
                return a;
            }
            query.close();
            stmtIns.close();
            con.close();
        } catch (SQLException ex) {
            return -1;
        }
        return -1;
    }

    // reporte donde se mostrara un listado del nombre completo con su correspondiente documento
    public ArrayList<VMNombreDocumento> listado(int i) throws ClassNotFoundException, SQLException {
        ArrayList<VMNombreDocumento> lista = new ArrayList<>();
        forName(ClasForName);
        Connection con = DriverManager.getConnection(conexion, user, pass);
        PreparedStatement stmtIns = con.prepareStatement("exec sp_inscriptos_por_curso ?"); // idCurso, idCursante
        stmtIns.setInt(1, i);
        ResultSet query = stmtIns.executeQuery();

        while (query.next()) {
            VMNombreDocumento datos = new VMNombreDocumento();

            datos.setNombreCompleto(query.getString("Inscriptio"));
            datos.setDocumento(query.getString("Documento"));

            lista.add(datos);
        }
        query.close();
        stmtIns.close();
        con.close();
        return lista;
    }

    public ArrayList<VMPresinscripto> listadoPreinscriptos() throws ClassNotFoundException, SQLException {
        ArrayList<VMPresinscripto> lista = new ArrayList<>();
        forName(ClasForName);
        Connection con = DriverManager.getConnection(conexion, user, pass);
        PreparedStatement stmtIns = con.prepareStatement("SELECT * FROM vw_preinscriptos_cursos_x_comenzar_o_en_curso ORDER BY 4, 1, 2"); // idCurso, idCursante
        ResultSet query = stmtIns.executeQuery();

        while (query.next()) {
            VMPresinscripto datos = new VMPresinscripto();

            datos.setNombreCompleto(query.getString("Cursante"));
            datos.setDocumento(query.getString("Documento"));
            datos.setCurso(query.getString("Curso"));
            datos.setPagado(query.getDouble("Monto Pagado"));
            lista.add(datos);
        }
        query.close();
        stmtIns.close();
        con.close();
        return lista;
    }

    public ArrayList<Integer> obtenerIdDeTodosInscriptosPorCurso(int idCurso) throws ClassNotFoundException, SQLException {
        ArrayList<Integer> lista = new ArrayList<>();
        forName(ClasForName);
        Connection con = DriverManager.getConnection(conexion, user, pass);
        PreparedStatement stmtIns = con.prepareStatement("SELECT I.id_inscripcion from Inscripciones I join Cursos C on I.id_curso = C.id_curso join Cursantes cu on cu.id_cursante = i.id_cursante join Datos_Generales dg on dg.id_datos_generales = cu.id_datos_generales where C.id_curso = ? order by dg.apellido, dg.nombre");
        stmtIns.setInt(1, idCurso);
        ResultSet consulta = stmtIns.executeQuery();
        while (consulta.next()) {
            lista.add(consulta.getInt(1));

        }
        consulta.close();
        stmtIns.close();
        con.close();
        return lista;
    }

    public boolean existeMail(String text) throws SQLException {
        Connection con = DriverManager.getConnection(conexion, user, pass);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select distinct 1 from Datos_Generales dg join Cursantes cu on cu.id_datos_generales = dg.id_datos_generales join Inscripciones i on i.id_cursante = cu.id_cursante where mail like '" + text + "'");
        if (rs.next()){
            return true;
        }
        return false;
    }

}
