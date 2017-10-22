/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class GestorTipoDni {
    String conexion = "jdbc:sqlserver://localhost:1412;databaseName=Colegio_Informatica_Metodologia";
    String user = "Gabriel";
    String pass = "1234";
    public ArrayList<TipoDni> obtenerTodos() throws ClassNotFoundException, SQLException{
        forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        ArrayList<TipoDni> documentos = new ArrayList<TipoDni>();
        Connection con = DriverManager.getConnection(conexion, user,pass);
        Statement comando = con.createStatement();
        ResultSet query = comando.executeQuery("Select * from Tipos_Dni");
        while(query.next()){
            TipoDni tp = new TipoDni();
            tp.setId(query.getInt("id_tipo_dni"));
            tp.setTipo(query.getString("tipo"));
            
            documentos.add(tp);
        }
        query.close();
        comando.close();
        con.close();
        return documentos;
    }
}
