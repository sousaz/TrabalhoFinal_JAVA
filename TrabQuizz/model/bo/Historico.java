package TrabQuizz.model.bo;


public class Historico extends Ranking {
    private String tema;
    private String nivel;
    private int quant;

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public void setNivel(int nivel) {
        if (nivel == 0) {
            this.nivel = "Fácil";
        } else if (nivel == 1) {
            this.nivel = "Intermediário";
        } else if (nivel == 2) {
            this.nivel = "Dificíl";
        }
    }

    public void setTema(int tema) {
        if (tema == 0) {
            this.tema = "Português";
        } else if (tema == 1) {
            this.tema = "Matemática";
        } else if (tema == 2) {
            this.tema = "Ciências";
        } else if (tema == 3) {
            this.tema = "Conhecimentos Gerais";
        }
    }

    public String getNivel() {
        return nivel;
    }

    public int getQuant() {
        return quant;
    }

    public String getTema() {
        return tema;
    }

    
    
    
    
    
}
