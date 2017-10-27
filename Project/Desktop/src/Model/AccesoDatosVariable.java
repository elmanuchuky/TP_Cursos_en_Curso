
package Model;

/**
 *
 * @author Yasmin
 */
public class AccesoDatosVariable {
    String  conexion = "jdbc:sqlserver://localhost:1412;databaseName=Colegio_Informatica_Metodologia";
    String ClasForName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String user = "";
    String pass = "";

    public AccesoDatosVariable() {
    }

    public AccesoDatosVariable(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public  String getConexion() {
        return conexion;
    }

    public String getPass() {
        return pass;
    }

    public String getUser() {
        return user;
    }

    public String getClasForName() {
        return ClasForName;
    }
    
    
}