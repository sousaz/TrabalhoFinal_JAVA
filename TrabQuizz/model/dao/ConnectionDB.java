package trabQuizz.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDB {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost/bdquestoes";
    private static String usuario = "root";
    private static String senha = "coringa";

    public static Connection conectar() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usuario, senha);
            return con;
        } catch (SQLException e) {
            System.out.println("Erro na conexão com o servidor");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro no driver de conexão");
        }
        return con;
    }


    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException i) {
            System.out.println("Erro ao fechar conexão!");
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {
        closeConnection(con);
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException i) {
            System.out.println("Erro ao fechar stmt!");
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        
        closeConnection(con, stmt);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException i) {
            System.out.println("Erro ao fechar rs!");
        }
    }

    public static void main(String[] args) {
        ConnectionDB.conectar();
    }
}
