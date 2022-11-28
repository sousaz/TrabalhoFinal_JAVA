package trabQuizz.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import TrabQuizz.model.bo.Questoes;

public class QuestoesDAO {
    

    public ArrayList<Questoes> read(int tema, int nivel, int quant) {
        Connection con = ConnectionDB.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Questoes> qu = new ArrayList<>();
        //System.out.println(tema + "" + nivel + "" + quant);
        
        try {
            stmt = con.prepareStatement("Select * from questao where tema = ? and nivel = ? order by rand() limit ?");
            stmt.setInt(1, tema);
            stmt.setInt(2, nivel);
            stmt.setInt(3, quant);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Questoes questoes = new Questoes();

                questoes.setPergunta(rs.getString("pergunta"));
                //System.out.println(rs.getString("pergunta"));
                questoes.setAlternativaCerta(rs.getString("alternativa1"));
                //System.out.println(rs.getString("alternativa1"));
                questoes.setAlternativa(rs.getString("alternativa1"));
                //System.out.println(rs.getString("alternativa1"));
                questoes.setAlternativa(rs.getString("alternativa2"));
                questoes.setAlternativa(rs.getString("alternativa3"));
                questoes.setAlternativa(rs.getString("alternativa4"));
                questoes.setNivel(rs.getInt("nivel"));
                questoes.setTema(rs.getInt("tema"));
                
                qu.add(questoes);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar consulta!");
        } finally {
            ConnectionDB.closeConnection(con, stmt, rs);
        }

        return qu;
    }
    
}
