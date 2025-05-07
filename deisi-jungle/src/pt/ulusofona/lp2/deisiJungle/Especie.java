package pt.ulusofona.lp2.deisiJungle;

public class Especie {
    char identificador;
    String nome;
    char dieta;
    public Especie(){
    }

    public Especie(Character identificador, String nome, char dieta) {
        this.identificador = identificador;
        this.nome = nome;
    }
    char getDieta(){
        return dieta;
    }
}

