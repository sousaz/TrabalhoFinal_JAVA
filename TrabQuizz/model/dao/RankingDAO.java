package TrabQuizz.model.dao;
import TrabQuizz.model.bo.Ranking;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import trabQuizz.model.dao.ConnectionDB;

public class RankingDAO {
    
    public void setBD(String nick, int score) {
        Connection con = ConnectionDB.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into ranking (nick, score) values (?, ?)");
            stmt.setString(1, nick);
            stmt.setInt(2, score);
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao enviar dados para BD");
        }
    }
    
    public void updateBD(String nick, int score) {
        Connection con = ConnectionDB.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("update ranking set score=? where nick=?");
            stmt.setInt(1, score);
            stmt.setString(2, nick);
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar dados para BD");
        }
    }
    
    public ArrayList<Ranking> getBD() {
        Connection con = ConnectionDB.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Ranking> rk = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("select * from ranking order by score desc limit 10");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Ranking ranking = new Ranking();

                ranking.setNick(rs.getString("nick"));
                //System.out.println(rs.getString("pergunta"));
                ranking.setScores(rs.getInt("score"));
                //System.out.println(rs.getString("alternativa1"));
                
                rk.add(ranking);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar consulta!");
        } finally {
            ConnectionDB.closeConnection(con, stmt, rs);
        }

        return rk;
    }
    
    public ArrayList<Ranking> getBDs() {
        Connection con = ConnectionDB.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Ranking> rk = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("select * from ranking");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Ranking ranking = new Ranking();

                ranking.setNick(rs.getString("nick"));
                //System.out.println(rs.getString("pergunta"));
                ranking.setScores(rs.getInt("score"));
                //System.out.println(rs.getString("alternativa1"));
                
                rk.add(ranking);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar consulta!");
        } finally {
            ConnectionDB.closeConnection(con, stmt, rs);
        }

        return rk;
    }
    
}
