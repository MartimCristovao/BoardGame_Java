package pt.ulusofona.lp2.deisiJungle;
import java.util.ArrayList;
public class Jogador {
    int id;
    String nome;
    char idEspecie;
    Especie especie = new Especie();
    int energia;
    int casaAtual = 1;
    int bananasComidas = 0;
    int posicoesAndadas = 0;
    int alimentosIngeridos = 0;
    char dieta;
    int aguaIngerida = 0, carneIngerida = 0, ervaIngerida = 0,cogumeloIngerido = 0,bananaIngerida = 0;
    String nomeEspecie;

    public Jogador(int id, String nome, char idEspecie, int energia) {
        this.id = id;
        this.nome = nome;
        this.idEspecie = idEspecie;
        this.energia = energia;
    }

    int getBananasComidas(){
        return bananasComidas;
    }
    int addBananasComidas(int soma){
        return bananasComidas += soma;
    }
    int addEnergia(double soma){
        return energia+=soma;
    }
    int getEnergia(){
        return energia;
    }
}


