package TrabQuizz.model.dao;


import TrabQuizz.model.bo.Historico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import trabQuizz.model.dao.ConnectionDB;


public class HistoricoDAO {
    
    public void setBD(String nick, int score, int tema, int nivel, int quant) {
        Connection con = ConnectionDB.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into historico (nick, score, tema, nivel, quantidade) values (?, ?, ?, ?, ?)");
            stmt.setString(1, nick);
            stmt.setInt(2, score);
            stmt.setInt(3, tema);
            stmt.setInt(4, nivel);
            stmt.setInt(5, quant);
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao enviar dados para BD");
        }
    }
    
    public ArrayList<Historico> getBD() {
        Connection con = ConnectionDB.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Historico> ht = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("select * from historico order by idhistorico desc limit 15");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Historico historico = new Historico();

                historico.setNick(rs.getString("nick"));
                //System.out.println(rs.getString("pergunta"));
                historico.setScores(rs.getInt("score"));
                //System.out.println(rs.getString("alternativa1"));
                historico.setTema(rs.getInt("tema"));
                historico.setNivel(rs.getInt("nivel"));
                historico.setQuant(rs.getInt("quantidade"));
                
                ht.add(historico);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar consulta!");
        } finally {
            ConnectionDB.closeConnection(con, stmt, rs);
        }

        return ht;
    }
}
