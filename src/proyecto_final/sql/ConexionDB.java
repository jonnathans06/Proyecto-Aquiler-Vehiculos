package proyecto_final.sql;

import java.sql.*;

public class ConexionDB {
    static String user = "JSAAVEDRA";
    static String pass = "hola1243";
    static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static Connection con = null;

    public static Connection conectar() {
        if (con == null) {
            try {
                con = DriverManager.getConnection(url, user, pass);
                System.out.println("Conexion creada");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return con;
    }
}