package TrabQuizz.model.bo;

import java.util.ArrayList;

public class Questoes{
    private String pergunta;
    private ArrayList<String> alternativa = new ArrayList<>();
    private String alternativaCerta;
    private int tema; //0- port 1- mat 2- ciencias 3- conheicmentos gerais
    private int nivel; // 0-facil 1- intermediario 2- dificil
    private int quantidade;

    public Questoes() {
        
    }

    public ArrayList<String> getAlternativa() {
        return alternativa;
    }

    public int getNivel() {
        return nivel;
    }

    public String getPergunta() {
        return pergunta;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getTema() {
        return tema;
    }

    public void setAlternativa(String alternativa) {
        this.alternativa.add(alternativa);
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setTema(int tema) {
        this.tema = tema;
    }

    public void setAlternativaCerta(String alternativaCerta) {
        this.alternativaCerta = alternativaCerta;
    }

    public String getAlternativaCerta() {
        return alternativaCerta;
    }
    
    
}
