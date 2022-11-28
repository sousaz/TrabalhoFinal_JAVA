package trabQuizz.model.vo;

import TrabQuizz.model.bo.Questoes;
import TrabQuizz.model.bo.Ranking;
import TrabQuizz.model.dao.RankingDAO;
import java.util.ArrayList;
import java.util.Collections;
import trabQuizz.model.dao.QuestoesDAO;

public class Quiz {
    
    
    public ArrayList<Questoes> questoes = new ArrayList<>();
    public ArrayList<String> alternatives = new ArrayList<>();
    public ArrayList<Ranking> ranking = new ArrayList<>();
    public static int score;
    public static int corrects;
    private String correct;

    QuestoesDAO que = new QuestoesDAO();
    RankingDAO rkg = new RankingDAO();
    //Questoes qt = new Questoes();

    
    
    public void getQuestion(int tema, int nivel, int quant) {
        questoes =  que.read(tema, nivel, quant);
        score = 1;
        corrects = 0;
    }
    
    public ArrayList<Questoes> showQuestion() {
        correct = questoes.get(0).getAlternativaCerta();
        alternatives = new ArrayList<>();
        for(int j = 0; j < 4; j++) {
            alternatives.add(questoes.get(0).getAlternativa().get(j));
        }        
        
        return questoes;
    }
    
    public ArrayList<String> shuffleAlternatives() {
        Collections.shuffle(alternatives);
        questoes.remove(0);
        return alternatives;
        
    }
    
    
    public void score(String answer, int nivel) {
        if(answer.equals(correct)) {
           if(nivel == 0) {
               score++;
           } if (nivel == 1) {
               score *= 1.25;
           } if (nivel == 2) {
               score *= 1.5;
           }
           corrects++;
        }
        System.out.println(score);
    }
    
    public ArrayList<Ranking> showRanking() {
        ranking = rkg.getBD();
        return ranking;
    }
}