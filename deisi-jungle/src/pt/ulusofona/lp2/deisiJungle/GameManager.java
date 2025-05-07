package pt.ulusofona.lp2.deisiJungle;



import javax.swing.*;
import java.io.*;
import java.util.*;

public class GameManager {

    ArrayList<Jogador> jogadores;
    Mapa mapa;
    int turno = 0;
    int id = -1;
    int jungleSize = 0;
    int nrJogadores = 0;
    int nrFoods = 0;
    String[] dados;
    int helpVelo = 0;
    Jogador jogadorGanhou;

    public static String[] nomesEPosicoesDosUnicornios(GameManager gameManager){
        int count = 0;
        ArrayList<Jogador> unicorniosInfo = new ArrayList();
        for(int i = 0; i < gameManager.jogadores.size(); i++){
            if(gameManager.jogadores.get(i).idEspecie == 'U'){
                count++;
                unicorniosInfo.add(gameManager.jogadores.get(i));
            }
        }
        String[] unicornios = new String[count];
        for(int i = 0; i < unicorniosInfo.size(); i++){
            if(gameManager.jogadores.get(i).idEspecie == 'U'){
                unicornios[i] = unicorniosInfo.get(i).casaAtual + " : " + unicorniosInfo.get(i).id + " : " +
                        unicorniosInfo.get(i).nome;
            }
        }
        return unicornios;
    }
    public static GameManager jogoDaDefesa(){
        GameManager gameManager = new GameManager();
        gameManager.jogadores = new ArrayList<>();
        gameManager.mapa = new Mapa(15);

        gameManager.jogadores.add(new Jogador(1, "Ze", 'L', 80));
        gameManager.jogadores.add(new Jogador(2, "Jeremias", 'Z', 70));
        gameManager.jogadores.add(new Jogador(3, "Touche", 'T', 150));
        gameManager.jogadores.add(new Jogador(4, "NullPointerException", 'U', 200));

        for(int i = 1; i <= 15; i++){
            gameManager.mapa.casas.add(new Casa(i));
        }

        gameManager.mapa.casas.get(1).alimento = new Carne('c');
        gameManager.mapa.casas.get(2).alimento = new Carne('b');
        gameManager.mapa.casas.get(4).alimento = new Carne('m');
        gameManager.mapa.casas.get(7).alimento = new Carne('a');
        gameManager.mapa.casas.get(9).alimento = new Carne('e');


        return gameManager;
    }
    public String[] infoJogador(int idJogador) {

        String[] infoJogador = new String[5];

        for (int i = 0; i < jogadores.size(); i++) {

            if (idJogador == jogadores.get(i).id) {
                infoJogador[0] = String.valueOf(jogadores.get(i).id);
                infoJogador[1] = jogadores.get(i).nome;
                infoJogador[2] = Character.toString(jogadores.get(i).idEspecie);
                infoJogador[3] = String.valueOf(jogadores.get(i).energia);
                if(jogadores.get(i).idEspecie == 'Z'){
                    infoJogador[4] = "1..6";
                }
                if(jogadores.get(i).idEspecie == 'E'){
                    infoJogador[4] = "1..6";
                }
                if(jogadores.get(i).idEspecie == 'T'){
                    infoJogador[4] = "1..3";
                }
                if(jogadores.get(i).idEspecie == 'L'){
                    infoJogador[4] = "4..6";
                }
                if(jogadores.get(i).idEspecie == 'P'){
                    infoJogador[4] = "5..6";
                }
                if(jogadores.get(i).idEspecie == 'U'){
                    infoJogador[4] = "3..6";
                }
            }

        }
        return infoJogador;

    }

    public String[][] getSpecies() {
        String[][] out = new String[6][7];

        Especie humano = new Especie('Z', "Tarzan", 'o');
        Especie elefante = new Especie('E', "Elefante",'h');
        Especie leao = new Especie('L', "Leao",'c');
        Especie tartaruga = new Especie('T', "Tartaruga",'o');
        Especie passaro = new Especie('P', "Passaro",'o');
        Especie unicornio = new Especie('U', "Unicornio", 'n');

        out[0][0] = String.valueOf(humano.identificador);
        out[0][1] = humano.nome;
        out[0][2] = "tarzan.png";
        out[0][3] = "70";
        out[0][4] = "2";
        out[0][5] = "20";
        out[0][6] = "1..6";


        out[1][0] = String.valueOf(elefante.identificador);
        out[1][1] = elefante.nome;
        out[1][2] = "elephant.png";
        out[1][3] = "180";
        out[1][4] = "4";
        out[1][5] = "10";
        out[1][6] = "1..6";

        out[2][0] = String.valueOf(leao.identificador);
        out[2][1] = leao.nome;
        out[2][2] = "lion.png";
        out[2][3] = "80";
        out[2][4] = "2";
        out[2][5] = "10";
        out[2][6] = "4..6";

        out[3][0] = String.valueOf(tartaruga.identificador);
        out[3][1] = tartaruga.nome;
        out[3][2] = "turtle.png";
        out[3][3] = "150";
        out[3][4] = "1";
        out[3][5] = "5";
        out[3][6] = "1..3";

        out[4][0] = String.valueOf(passaro.identificador);
        out[4][1] = passaro.nome;
        out[4][2] = "bird.png";
        out[4][3] = "70";
        out[4][4] = "4";
        out[4][5] = "50";
        out[4][6] = "5..6";

        out[5][0] = String.valueOf(unicornio.identificador);
        out[5][1] = unicornio.nome;
        out[5][2] = "unicorn.png";
        out[5][3] = "200";
        out[5][4] = "8";
        out[5][5] = "20";
        out[5][6] = "3..6";
        return out;
    }

    public String[][] getFoodTypes(){
        String[][] out = new String[5][3];
        Alimento agua = new Agua('a');
        Alimento erva = new Erva('e');
        Alimento carne = new Carne('c');
        Alimento banana = new Banana('b');
        Alimento cogumelo = new Cogumelo('m');

        out[0][0] = String.valueOf(erva.getId());
        out[0][1] = "erva";
        out[0][2] = "grass.png";

        out[1][0] = String.valueOf(agua.getId());
        out[1][1] = "agua";
        out[1][2] = "water.png";

        out[2][0] = String.valueOf(banana.getId());
        out[2][1] = "banana";
        out[2][2] = "banana.png";

        out[3][0] = String.valueOf(carne.getId());
        out[3][1] = "carne";
        out[3][2] = "meat.png";

        out[4][0] = String.valueOf(cogumelo.getId());
        out[4][1] = "cogumelo";
        out[4][2] = "mushroom.png";
        return out;
    }
    public void createInitialJungleValidations(int jungleSize, String[][] playersInfo,
                                                              String[][] foodsInfo)throws InvalidInitialJungleException{
        if (playersInfo == null) {
            throw new InvalidInitialJungleException("Invalid Player");
        }
        if(foodsInfo == null){
            throw new InvalidInitialJungleException("Invalid Player");
        }

        for (int i = 0; i < foodsInfo.length; i++){
            if (foodsInfo[i][0] == null || foodsInfo[i][0].equals("")){
                throw new InvalidInitialJungleException("Invalid Food");
            }
            if(!foodsInfo[i][0].equals("a") && !foodsInfo[i][0].equals("e") && !foodsInfo[i][0].equals("c") &&
                    !foodsInfo[i][0].equals("b") && !foodsInfo[i][0].equals("m")){
                throw new InvalidInitialJungleException("Invalid Food");
            }
            if(foodsInfo[i][1] == null || foodsInfo[i][1].equals("") ||
                    foodsInfo[i][1].matches("^[a-zA-Z]*$")){
                throw new InvalidInitialJungleException("Invalid Food");
            }
            if(Integer.parseInt(foodsInfo[i][1]) < 2 || Integer.parseInt(foodsInfo[i][1]) > jungleSize - 1){
                throw new InvalidInitialJungleException("Invalid Food");
            }
        }

        for (int i = 0; i < playersInfo.length; i++) {
            if (playersInfo[i][1] == null || playersInfo[i][1].equals("")) {
                throw new InvalidInitialJungleException("Invalid Player");
            }
            if (playersInfo[i][2] == null || playersInfo[i][0] == null || playersInfo[i][0].equals("") ||
                    playersInfo[i][0].matches("^[a-zA-Z]*$")) {
                throw new InvalidInitialJungleException("Invalid Player");
            }
            if (!playersInfo[i][2].equals("Z") && !playersInfo[i][2].equals("E") && !playersInfo[i][2].equals("L") &&
                    !playersInfo[i][2].equals("T") && !playersInfo[i][2].equals("P") && !playersInfo[i][2].equals("U")){
                throw new InvalidInitialJungleException("Invalid Player");
            }
        }
        for (int i = 1; i < playersInfo.length; i++) {
            if (playersInfo[i][0].equals(playersInfo[i - 1][0])) {
                throw new InvalidInitialJungleException("Invalid Player");
            }
            if (playersInfo[i][2].equals("Z") && playersInfo[i - 1][2].equals("Z")) {
                throw new InvalidInitialJungleException("Invalid Player");
            }
        }
        if (playersInfo.length < 2 || playersInfo.length > 4) {
            throw new InvalidInitialJungleException("Invalid Player");
        }
        if (!verificaNumeroDeCasas(jungleSize, playersInfo.length)) {
            throw new InvalidInitialJungleException("Numero de casas inválido");
        }
    }

    public void createInitialJungle(int jungleSize, String[][] playersInfo, String[][] foodsInfo)
            throws InvalidInitialJungleException{
        mapa = new Mapa(jungleSize);
        jogadores = new ArrayList<>();
        createInitialJungleValidations(jungleSize, playersInfo, foodsInfo);
        for (int i = 0; i < playersInfo.length; i++) {
            switch(playersInfo[i][2].charAt(0)){
                case 'Z':
                    jogadores.add(new Jogador(Integer.parseInt(playersInfo[i][0]), playersInfo[i][1],
                            playersInfo[i][2].charAt(0), 70));
                    jogadores.get(i).dieta = 'o';
                    jogadores.get(i).nomeEspecie = "Tarzan";
                    break;
                case 'P':
                    jogadores.add(new Jogador(Integer.parseInt(playersInfo[i][0]), playersInfo[i][1],
                            playersInfo[i][2].charAt(0), 70));
                    jogadores.get(i).dieta = 'o';
                    jogadores.get(i).nomeEspecie = "Passaro";
                    break;
                case 'E': jogadores.add(new Jogador(Integer.parseInt(playersInfo[i][0]), playersInfo[i][1],
                        playersInfo[i][2].charAt(0), 180));
                    jogadores.get(i).dieta = 'h';
                    jogadores.get(i).nomeEspecie = "Elefante";
                    break;
                case 'L': jogadores.add(new Jogador(Integer.parseInt(playersInfo[i][0]), playersInfo[i][1],
                        playersInfo[i][2].charAt(0), 80));
                    jogadores.get(i).dieta = 'c';
                    jogadores.get(i).nomeEspecie = "Leao";
                    break;
                case 'T': jogadores.add(new Jogador(Integer.parseInt(playersInfo[i][0]), playersInfo[i][1],
                        playersInfo[i][2].charAt(0), 150));
                    jogadores.get(i).dieta = 'o';
                    jogadores.get(i).nomeEspecie = "Tartaruga";
                    break;
                case 'U': jogadores.add(new Jogador(Integer.parseInt(playersInfo[i][0]), playersInfo[i][1],
                        playersInfo[i][2].charAt(0), 200));
                    jogadores.get(i).dieta = 'n';
                    jogadores.get(i).nomeEspecie = "Unicornio";
                    break;
            }}
        for(int i = 1; i <= jungleSize; i++){
            mapa.casas.add(new Casa(i));}
        for(int i = 0; i < foodsInfo.length; i++){
            if(foodsInfo[i][0].charAt(0) == 'a'){
                mapa.casas.get(Integer.parseInt(foodsInfo[i][1]) - 1).alimento = new Agua('a');
            }
            if(foodsInfo[i][0].charAt(0) == 'e'){
                mapa.casas.get(Integer.parseInt(foodsInfo[i][1]) - 1).alimento = new Erva('e');
            }
            if(foodsInfo[i][0].charAt(0) == 'c'){
                mapa.casas.get(Integer.parseInt(foodsInfo[i][1]) - 1).alimento = new Carne('c');
            }
            if(foodsInfo[i][0].charAt(0) == 'b'){
                mapa.casas.get(Integer.parseInt(foodsInfo[i][1]) - 1).alimento = new Banana('b');
            }
            if(foodsInfo[i][0].charAt(0) == 'm'){
                mapa.casas.get(Integer.parseInt(foodsInfo[i][1]) - 1).alimento = new Cogumelo('m');
            }}
        Collections.sort(jogadores, new Comparator<Jogador>() {
            @Override
            public int compare(Jogador o1, Jogador o2) {
                return Integer.valueOf(o1.id).compareTo(o2.id);
            }
        });
        id = jogadores.get(0).id;}

    public void createInitialJungle(int jungleSize, String[][] playersInfo) throws InvalidInitialJungleException{
        mapa = new Mapa(jungleSize);
        jogadores = new ArrayList<>();
        id = -1;
        if (playersInfo == null) {
            throw new InvalidInitialJungleException("Invalid Player");}
        for (int i = 0; i < playersInfo.length; i++) {
            if (playersInfo[i][1] == null ||  playersInfo[i][1].equals("")) {
                throw new InvalidInitialJungleException("Invalid Player");
            }
            if (playersInfo[i][2] == null ||  playersInfo[i][0] == null ||  playersInfo[i][0].equals("") ||
            playersInfo[i][0].matches("^[a-zA-Z]*$")) {
                throw new InvalidInitialJungleException("Invalid Player");
            }
            if (!playersInfo[i][2].equals("Z") && !playersInfo[i][2].equals("E") && !playersInfo[i][2].equals("L") &&
                    !playersInfo[i][2].equals("T") && !playersInfo[i][2].equals("P") && !playersInfo[i][2].equals("U")){
                throw new InvalidInitialJungleException("Invalid Player");
            }
        }
        for (int i = 1; i < playersInfo.length; i++) {
            if (playersInfo[i][0].equals(playersInfo[i - 1][0])) {
                throw new InvalidInitialJungleException("Invalid Player");
            }
            if (playersInfo[i][2].equals("Z") && playersInfo[i - 1][2].equals("Z")) {
                throw new InvalidInitialJungleException("Invalid Player");
            }
        }
        if (playersInfo.length < 2 || playersInfo.length > 4) {
            throw new InvalidInitialJungleException("Invalid Player");
        }
        if (!verificaNumeroDeCasas(jungleSize, playersInfo.length)) {
            throw new InvalidInitialJungleException("Número de casas inválido");
        }
        for (int i = 0; i < playersInfo.length; i++) {
            switch(playersInfo[i][2].charAt(0)){
                case 'Z':
                case 'P':
                    jogadores.add(new Jogador(Integer.parseInt(playersInfo[i][0]), playersInfo[i][1],
                            playersInfo[i][2].charAt(0), 70));
                    break;
                case 'E': jogadores.add(new Jogador(Integer.parseInt(playersInfo[i][0]), playersInfo[i][1],
                        playersInfo[i][2].charAt(0), 180));
                    break;
                case 'L': jogadores.add(new Jogador(Integer.parseInt(playersInfo[i][0]), playersInfo[i][1],
                        playersInfo[i][2].charAt(0), 80));
                    break;
                case 'T': jogadores.add(new Jogador(Integer.parseInt(playersInfo[i][0]), playersInfo[i][1],
                        playersInfo[i][2].charAt(0), 150));
                    break;
                case 'U': jogadores.add(new Jogador(Integer.parseInt(playersInfo[i][0]), playersInfo[i][1],
                        playersInfo[i][2].charAt(0), 200));
                    break;}}
        for(int i = 1; i <= jungleSize; i++){
            mapa.casas.add(new Casa(i));
        }Collections.sort(jogadores, new Comparator<Jogador>() {
            @Override
            public int compare(Jogador o1, Jogador o2) {
                return Integer.valueOf(o1.id).compareTo(o2.id);
            }
        });
        id = jogadores.get(0).id;
    }

    public String[] getCurrentPlayerEnergyInfo(int nrPositions){
        char idEspecie = infoJogador(id)[2].charAt(0);
        String[] energyInfo = new String[2];
        if(nrPositions < 0){
            nrPositions = nrPositions * (-1);
        }

        //se for tarzan
        if(idEspecie == 'Z'){
            energyInfo[0] = String.valueOf(2 * nrPositions);
            energyInfo[1] = String.valueOf(20);
        }
        //se for elefante
        if(idEspecie == 'E'){
            energyInfo[0] = String.valueOf(4 * nrPositions);
            energyInfo[1] = String.valueOf(10);
        }
        //se for leão
        if(idEspecie == 'L'){
            energyInfo[0] = String.valueOf(2 * nrPositions);
            energyInfo[1] = String.valueOf(10);
        }
        //se for tartaruga
        if(idEspecie == 'T'){
            energyInfo[0] = String.valueOf(nrPositions);
            energyInfo[1] = String.valueOf(5);
        }
        //se for pássaro
        if(idEspecie == 'P'){
            energyInfo[0] = String.valueOf(4 * nrPositions);
            energyInfo[1] = String.valueOf(50);
        }
        if(idEspecie == 'U'){
            energyInfo[0] = String.valueOf(8 * nrPositions);
            energyInfo[1] = String.valueOf(20);
        }

        return energyInfo;
    }
    public void controlaValoresEnergia(int energia, Jogador jogador){
        if(energia == 1000){
            energia = 0;
        }
        if(jogador.energia + energia > 200){
            jogador.energia = 200;
        }else if(jogador.energia + energia < 0){
            jogador.energia = 0;
        }else{
            jogador.energia += energia;
        }

    }

    public void removeEnergia(Jogador jogador, int nrSquares){
        if(nrSquares < 0){
            nrSquares = nrSquares*-1;
        }
        switch (jogador.idEspecie) {
            case 'Z', 'L' -> jogador.energia -= 2*nrSquares;
            case 'E', 'P' -> jogador.energia -= 4*nrSquares;
            case 'T' -> jogador.energia -= nrSquares;
            case 'U' -> jogador.energia -= 8*nrSquares;
        }
    }
    public void comeCogumelo(Jogador jogador, int turno, int randomN){
        int help = 0;
        if(jogador.idEspecie == 'U'){
            help = 1;
        }
        if(help == 0){
            if (turno % 2 == 0){
                jogador.energia += (jogador.getEnergia()*randomN)/100;
            }else{
                jogador.energia -=  (jogador.getEnergia()*randomN)/100;
            }
            jogador.cogumeloIngerido++;
        }
    }
    public void comeCarne(Jogador jogador, int jogada){
        switch (jogador.dieta){
            case 'o':
            case 'c':
                if (jogada <= 12){
                    jogador.addEnergia(50);
                }else{
                    jogador.energia = jogador.energia/2;
                }
                jogador.carneIngerida++;
                break;
            case 'h':
                jogador.carneIngerida++;
            case 'n':
                break;
        }

    }
    public void comeBanana(Jogador jogador, int bananasNoCacho){
        int help = 0;
        if(jogador.idEspecie == 'U'){
            help = 1;
        }
        if(help == 0) {
            if (bananasNoCacho > 0) {
                jogador.addBananasComidas(1);
                if (jogador.getBananasComidas() > 1) {
                    jogador.addEnergia(-40);
                } else {
                    jogador.addEnergia(40);
                }
                mapa.casas.get(jogador.casaAtual - 1).alimento.bananasNoCacho--;
            }
            jogador.bananaIngerida++;
        }
    }
    public void comeErva(Jogador jogador){
        switch(jogador.dieta){
            case 'o':
            case 'h':
                jogador.addEnergia(20);
                jogador.ervaIngerida++;
                break;
            case 'c':
                jogador.addEnergia(-20);
                jogador.ervaIngerida++;
                break;
            case 'n':
                break;

        }

    }
    public void beberAgua(Jogador jogador){
        switch(jogador.dieta){
            case 'o':
                if(turno % 2 == 0){
                    jogador.addEnergia(jogador.getEnergia()*0.2);
                    jogador.aguaIngerida++;
                }
                break;
            case 'h':
            case 'c':
                jogador.addEnergia(15);
                jogador.aguaIngerida++;
                break;
            case 'n':
                break;

        }
    }
    public MovementResult controlaMovimento(char idAlimento, Jogador jogador, int nrSquares){
        int help = 0;
        if(jogador.idEspecie == 'U'){
            id = getIdJogadorSeguinte(id);
            return new MovementResult(MovementResultCode.VALID_MOVEMENT,
                    null);
        }
        if(jogador.dieta == 'o' && turno % 2 != 0){
            id = getIdJogadorSeguinte(id);
            return new MovementResult(MovementResultCode.VALID_MOVEMENT,
                    null);
        }
        switch (idAlimento){
            case 'a':
                beberAgua(jogador);
                controlaValoresEnergia(1000, jogador);
                jogador.alimentosIngeridos++;
                id = getIdJogadorSeguinte(id);
                return new MovementResult(MovementResultCode.CAUGHT_FOOD,
                        "Apanhou Agua");
            case 'e':
                comeErva(jogador);
                controlaValoresEnergia(1000, jogador);
                jogador.alimentosIngeridos++;
                id = getIdJogadorSeguinte(id);
                return new MovementResult(MovementResultCode.CAUGHT_FOOD,
                        "Apanhou Erva");
            case 'c':
                if(jogador.idEspecie == 'E' || jogador.idEspecie == 'T'){
                    id = getIdJogadorSeguinte(id);
                    return new MovementResult(MovementResultCode.VALID_MOVEMENT,
                            null);
                }
                comeCarne(jogador, turno);
                controlaValoresEnergia(1000, jogador);
                jogador.alimentosIngeridos++;
                id = getIdJogadorSeguinte(id);
                return new MovementResult(MovementResultCode.CAUGHT_FOOD,
                        "Apanhou Carne");
            case 'b':
                if(mapa.casas.get(jogador.casaAtual + nrSquares - 1).bananasComidas < 3){
                    comeBanana(jogador, mapa.casas.get(jogador.casaAtual
                            + nrSquares - 1).alimento.bananasNoCacho);
                    controlaValoresEnergia(1000, jogador);
                    jogador.alimentosIngeridos++;
                    id = getIdJogadorSeguinte(id);
                    return new MovementResult(MovementResultCode.CAUGHT_FOOD,
                            "Apanhou Bananas");
                }
                id = getIdJogadorSeguinte(id);
                return new MovementResult(MovementResultCode.VALID_MOVEMENT,
                        "Movimento válido");
            case 'm':
                comeCogumelo(jogador, turno, mapa.casas.get(jogador.casaAtual + nrSquares - 1).alimento.randomN);
                controlaValoresEnergia(1000, jogador);
                jogador.alimentosIngeridos++;
                id = getIdJogadorSeguinte(id);
                return new MovementResult(MovementResultCode.CAUGHT_FOOD,
                        "Apanhou Cogumelo Magico");
        }
        return null;
    }
    public void controlaDescanso(Jogador jogador){
        switch (jogador.idEspecie){
            case 'Z':
            case 'U':
                controlaValoresEnergia(20, jogador);
                break;
            case 'E':
            case 'L':
                controlaValoresEnergia(10, jogador);
                break;
            case 'T':
                controlaValoresEnergia(5, jogador);
                break;
            case 'P':
                controlaValoresEnergia(50, jogador);
                break;
        }
    }
    public MovementResult controlaVelocidade(Jogador jogador, int nrSquares){
        helpVelo++;
        switch (jogador.idEspecie) {
            case 'Z':
            case 'E':
                if (nrSquares < -6 || nrSquares > 6) {
                    if(helpVelo % 2 == 0){
                        id = getIdJogadorSeguinte(id);
                    }
                    return new MovementResult(MovementResultCode.INVALID_MOVEMENT, null);
                }
                break;
            case 'T':
                if ((nrSquares < -3 || nrSquares > 3) && nrSquares != 0) {
                    if(helpVelo % 2 == 0){
                        id = getIdJogadorSeguinte(id);
                    }
                    return new MovementResult(MovementResultCode.INVALID_MOVEMENT, null);
                }
                break;
            case 'P':
                if ((nrSquares > -5 && nrSquares < 5 || nrSquares < -6 || nrSquares > 6) && nrSquares != 0) {
                    if(helpVelo % 2 == 0){
                        id = getIdJogadorSeguinte(id);
                    }
                    return new MovementResult(MovementResultCode.INVALID_MOVEMENT, null);
                }
                break;
            case 'L':
                if ((nrSquares > -4 && nrSquares < 4 || nrSquares < -6 || nrSquares > 6) && nrSquares != 0) {
                    if(helpVelo % 2 == 0){
                        id = getIdJogadorSeguinte(id);
                    }
                    return new MovementResult(MovementResultCode.INVALID_MOVEMENT, null);
                }
                break;
            case 'U':
                if (nrSquares > -3 && nrSquares < 3 && nrSquares != 0) {
                    if(helpVelo % 2 == 0){
                        id = getIdJogadorSeguinte(id);
                    }
                    return new MovementResult(MovementResultCode.INVALID_MOVEMENT, null);
                }
                break;
        }
        return null;
    }
    public int calculaPosAndadasF(int nrSquares, int casaAtual, int mapaSize){
        int posicoesNaoAndadas = (casaAtual + nrSquares) - mapaSize;
        return nrSquares - posicoesNaoAndadas;
    }
    public int calculaPosAndadasT(int nrSquares, int casaAtual){
        nrSquares = nrSquares*-1;
        int posicoesNaoAndadas = nrSquares - (casaAtual + 1);
        return nrSquares - posicoesNaoAndadas;
    }
    public MovementResult moveCurrentPlayer(int nrSquares, boolean bypassValidations) {
        turno++;
        if (!bypassValidations) {
            for (int i = 0; i < jogadores.size(); i++) {
                if (id == jogadores.get(i).id) {
                    if(controlaVelocidade(jogadores.get(i),nrSquares) != null){
                        return controlaVelocidade(jogadores.get(i),nrSquares);
                    }}}}
        for (int i = 0; i < jogadores.size(); i++) {
            if (id == jogadores.get(i).id) {
                switch (jogadores.get(i).idEspecie) {
                    case 'Z':
                    case 'L':
                        if (jogadores.get(i).getEnergia() < 2 * nrSquares) {
                            id = getIdJogadorSeguinte(id);
                            return new MovementResult(MovementResultCode.NO_ENERGY, "Energia insuficiente");
                        }break;
                    case 'P':
                    case 'E':
                        if (jogadores.get(i).getEnergia() < 4 * nrSquares) {
                            id = getIdJogadorSeguinte(id);
                            return new MovementResult(MovementResultCode.NO_ENERGY, "Energia insuficiente");
                        }break;
                    case 'T':
                        if (jogadores.get(i).getEnergia() < nrSquares) {
                            id = getIdJogadorSeguinte(id);
                            return new MovementResult(MovementResultCode.NO_ENERGY, "Energia insuficiente");
                        }break;
                    case 'U':
                        if (jogadores.get(i).getEnergia() < 8 * nrSquares) {
                            id = getIdJogadorSeguinte(id);
                            return new MovementResult(MovementResultCode.NO_ENERGY, "Energia insuficiente");
                        }break;}
                if(nrSquares == 0){
                    controlaDescanso(jogadores.get(i));}
                if(jogadores.get(i).casaAtual + nrSquares > mapa.n){
                    removeEnergia(jogadores.get(i),nrSquares);
                    controlaValoresEnergia(1000, jogadores.get(i));
                    jogadores.get(i).posicoesAndadas=calculaPosAndadasF(nrSquares,jogadores.get(i).casaAtual,mapa.n);
                    jogadores.get(i).casaAtual = mapa.n;
                    id = getIdJogadorSeguinte(id);
                    return new MovementResult(MovementResultCode.VALID_MOVEMENT, null);}
                if(jogadores.get(i).casaAtual + nrSquares < 1){
                    removeEnergia(jogadores.get(i),nrSquares);
                    controlaValoresEnergia(1000, jogadores.get(i));
                    jogadores.get(i).posicoesAndadas=calculaPosAndadasT(nrSquares,jogadores.get(i).casaAtual);
                    jogadores.get(i).casaAtual = 1;
                    id = getIdJogadorSeguinte(id);
                    return new MovementResult(MovementResultCode.INVALID_MOVEMENT, "Movimento inválido");}
                if(jogadores.get(i).casaAtual + nrSquares <= mapa.n){
                    removeEnergia(jogadores.get(i),nrSquares);
                    controlaValoresEnergia(1000, jogadores.get(i));
                    jogadores.get(i).casaAtual += nrSquares;
                    if(nrSquares < 0){jogadores.get(i).posicoesAndadas += nrSquares*-1;}
                    else {jogadores.get(i).posicoesAndadas += nrSquares;}
                    if((mapa.casas.get(jogadores.get(i).casaAtual - 1).alimento.id == 'a' ||
                            mapa.casas.get(jogadores.get(i).casaAtual - 1).alimento.id == 'b' ||
                            mapa.casas.get(jogadores.get(i).casaAtual - 1).alimento.id == 'c' ||
                            mapa.casas.get(jogadores.get(i).casaAtual - 1).alimento.id == 'e' ||
                            mapa.casas.get(jogadores.get(i).casaAtual - 1).alimento.id == 'm' )){
                             return controlaMovimento(mapa.casas.get(jogadores.get(i).casaAtual - 1).alimento.id,
                                     jogadores.get(i),nrSquares);
                    }else{
                        if(jogadores.get(i).idEspecie == 'U') {
                            controlaValoresEnergia(2, jogadores.get(i));
                        }
                        id = getIdJogadorSeguinte(id);
                        return new MovementResult(MovementResultCode.VALID_MOVEMENT, null);}}}}return null;}
    public String[] dadosSaveGame(){
        int count = 6;
        dados= new String[jogadores.size() * 3 + mapa.casas.size() * 2 + 3];
        dados[0] = String.valueOf(turno);
        dados[1] = String.valueOf(mapa.n);
        dados[2] = String.valueOf(id);
        dados[3] = String.valueOf(nrFoods);
        dados[4] = String.valueOf(nrJogadores);
        dados[5] = String.valueOf(jungleSize);
        for(int i = 0; i < mapa.casas.size(); i++){
            if(mapa.casas.get(i).alimento.id == 'a'){
                dados[count] = String.valueOf(mapa.casas.get(i).alimento.id);
                count++;
                dados[count] = String.valueOf(mapa.casas.get(i).nrCasa);
                count++;
                dados[3] = String.valueOf(nrFoods + 1); nrFoods++;
            }else if(mapa.casas.get(i).alimento.id == 'b'){
                dados[count] = String.valueOf(mapa.casas.get(i).alimento.id);
                count++;
                dados[count] = String.valueOf(mapa.casas.get(i).nrCasa);
                count++;
                dados[3] = String.valueOf(nrFoods + 1); nrFoods++;
            }else if(mapa.casas.get(i).alimento.id == 'c'){
                dados[count] = String.valueOf(mapa.casas.get(i).alimento.id);
                count++;
                dados[count] = String.valueOf(mapa.casas.get(i).nrCasa);
                count++;
                dados[3] = String.valueOf(nrFoods + 1); nrFoods++;
            }else if(mapa.casas.get(i).alimento.id == 'e'){
                dados[count] = String.valueOf(mapa.casas.get(i).alimento.id);
                count++;
                dados[count] = String.valueOf(mapa.casas.get(i).nrCasa);
                count++;
                dados[3] = String.valueOf(nrFoods + 1); nrFoods++;
            }else if(mapa.casas.get(i).alimento.id == 'm'){
                dados[count] = String.valueOf(mapa.casas.get(i).alimento.id);
                count++;
                dados[count] = String.valueOf(mapa.casas.get(i).nrCasa);
                count++;
                dados[3] = String.valueOf(nrFoods + 1); nrFoods++;
            }
            dados[5] = String.valueOf(jungleSize + 1);
            jungleSize++;}
        for (int i = 0; i < jogadores.size(); i++){
            dados[count] = String.valueOf(jogadores.get(i).id);
            count++;
            dados[count] = jogadores.get(i).nome;
            count++;
            dados[count] = String.valueOf(jogadores.get(i).idEspecie);
            count++;
            dados[4] = String.valueOf(nrJogadores + 1);
            nrJogadores++;}
        for(int i = 0; i < jogadores.size(); i++){
            dados[count] = String.valueOf(jogadores.get(i).bananasComidas);
            count++;
            dados[count] = String.valueOf(jogadores.get(i).casaAtual);
            count++;
            dados[count] = String.valueOf(jogadores.get(i).energia);
            count++;}
        return dados;}

    public boolean saveGame(File file){
        try {
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            dados = dadosSaveGame();
            for(int i = 0; i < dados.length; i++){
                printWriter.println(dados[i]);
            }
            printWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public boolean loadGame(File file){
        try {
            FileInputStream fis = new FileInputStream(file);
            Scanner leitorFicheiro = new Scanner(fis);
            turno = leitorFicheiro.nextInt();
            mapa.n = leitorFicheiro.nextInt();
            id = leitorFicheiro.nextInt();
            int helpId = id;
            nrFoods = leitorFicheiro.nextInt();
            nrJogadores = leitorFicheiro.nextInt();
            jungleSize = leitorFicheiro.nextInt();
            String[][] foodsInfoLoad = new String[nrFoods][2];
            String[][] playersInfoLoad = new String[nrJogadores][3];

                for (int i = 0; i < nrFoods; i++){
                    foodsInfoLoad[i][0] = leitorFicheiro.next();
                    foodsInfoLoad[i][1] = String.valueOf(leitorFicheiro.nextInt());
                }
                for(int i = 0; i < nrJogadores; i++){
                    playersInfoLoad[i][0] = String.valueOf(leitorFicheiro.nextInt());
                    playersInfoLoad[i][1] = leitorFicheiro.next();
                    playersInfoLoad[i][2] = leitorFicheiro.next();
                }

            createInitialJungle(jungleSize, playersInfoLoad, foodsInfoLoad);
                id = helpId;

                for(int i = 0; i < nrJogadores; i++){
                    jogadores.get(i).bananasComidas = leitorFicheiro.nextInt();
                    jogadores.get(i).casaAtual = leitorFicheiro.nextInt();
                    jogadores.get(i).energia = leitorFicheiro.nextInt();
                }


        } catch (IOException | InvalidInitialJungleException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean verificaNumeroDeCasas(int jungleSize, int jogadorCount) {
        if (jogadorCount * 2 > jungleSize) {
            return false;
        }
        return true;
    }

    public int[] getPlayerIds(int squareNr) {

        if (squareNr <= 0 || squareNr > mapa.n) {
            return new int[0];
        }

        ArrayList<Integer> ids = new ArrayList<>();

        for (int i = 0; i < jogadores.size(); i++) {

            if (jogadores.get(i).casaAtual == squareNr) {
                ids.add(jogadores.get(i).id);
            }

        }
        int[] playerIds = new int[ids.size()];


        for (int i = 0; i < playerIds.length; i++) {
            playerIds[i] = ids.get(i);
        }

        return playerIds;
    }

    public String[] getSquareInfo(int squareNr) {

        String[] infoCasa = new String[3];

        if (squareNr <= 0 || squareNr > mapa.n) {
            return null;
        }

        for (int i = 0; i < mapa.n; i++) {

            if (squareNr != mapa.n) {

                infoCasa[0] = "blank.png";
                infoCasa[1] = "Vazio";
            }else {
                infoCasa[0] = "finish.png";
                infoCasa[1] = "Meta";
            }
        }
        switch (mapa.casas.get(squareNr -1).alimento.id){
            case 'a':
                infoCasa[0] = "water.png";
                infoCasa[1] = "Agua : + 15U|20% energia";
                break;
            case 'b':
                infoCasa[0] = "bananas.png";
                infoCasa[1] = "Bananas : " + mapa.casas.get(squareNr - 1).alimento.bananasNoCacho +
                        " : + 40 energia";
                break;
            case 'c':
                if(turno > 12){
                    infoCasa[0] = "meat.png";
                    infoCasa[1] = "Carne toxica";
                }else{
                    infoCasa[0] = "meat.png";
                    infoCasa[1] = "Carne : + 50 energia : " + turno + " jogadas";
                }
                break;
            case 'e':
                infoCasa[0] = "grass.png";
                infoCasa[1] = "Erva : +- 20 energia";
                break;
            case 'm':
                infoCasa[0] = "mushroom.png";
                infoCasa[1] = "Cogumelo Magico : +- "+ mapa.casas.get(squareNr - 1).alimento.randomN
                        +"% energia";
                break;

        }
        // players ids

        int[] playerIds = getPlayerIds(squareNr);

        if (playerIds.length == 0) {
            infoCasa[2] = "";
        } else {
            infoCasa[2] = Arrays.toString(playerIds).replaceAll
                    ("[\\[\\]]","").replaceAll(" ", "");
        }
        return infoCasa;
    }

    public String[] getPlayerInfo(int playerId) {
        if (playerId < 0) {
            return null;
        }
        return infoJogador(playerId);
    }



    public String[] getCurrentPlayerInfo() {
        return infoJogador(id);
    }


    public int quantosJogadores() {
        int quantidadeDeJogadores;

        if (jogadores != null) {
            quantidadeDeJogadores = jogadores.size();
            return quantidadeDeJogadores;
        } else {
            return 0;
        }
    }

    public String[][] getPlayersInfo() {

        String[][] arrayVazio = new String[quantosJogadores()][4];

        if (jogadores != null) {
            String[][] infoJogadores = new String[jogadores.size()][4];
            for (int i = 0; i < jogadores.size(); i++) {
                infoJogadores[i] = infoJogador(jogadores.get(i).id);
            }
            return infoJogadores;
        }
        return arrayVazio;
    }

    public int casaAtualCurrentPlayer(int idCurrentPlayer) {
        int casaAtual = 0;
        for (int i = 0; i < jogadores.size(); i++) {
            if (jogadores.get(i).id == idCurrentPlayer) {
                casaAtual = jogadores.get(i).casaAtual;
            }
        }
        return casaAtual;
    }

    /**
     * Método só deve ser invocado dentro do move
     *
     * @param id
     * @return
     */
    private int getIdJogadorSeguinte(int id) {


        for (int i = 0; i < jogadores.size(); i++) {

            if (jogadores.get(i).id == id) {

                if (i == jogadores.size() - 1) {
                    return jogadores.get(0).id;
                }

                return jogadores.get(++i).id;

            }

        }

        return -1; // id inválido, mas o código nunca deve chegar aqui

    }


    public int[] ordenaPorCasaAtual(){
        int [] arrayOrdenado = new int[jogadores.size()];

        for(int i = 0; i < arrayOrdenado.length; i++){
            arrayOrdenado[i] = jogadores.get(i).casaAtual;
        }
        Arrays.sort(arrayOrdenado);
        return arrayOrdenado;
    }
    public boolean jogoAcabou() {
        int casaDoMeio;
        int help = 0;
        int distancia ;
        ArrayList<Jogador> jogadoresNoMeio = new ArrayList<>();
        //se chegou a ultima casa
        int segundaMetadeTabuleiro;
        for (int i = 0; i < jogadores.size(); i++) {
            if (jogadores.get(i).casaAtual == mapa.n) {
                return true;
            }
        }
        //se já vai muito longe
        distancia = ordenaPorCasaAtual()[jogadores.size()-1] - ordenaPorCasaAtual()[jogadores.size()-2];
        if(distancia > mapa.n / 2){
            return true;
        }
        //nova condição do recurso
        if(mapa.n % 2 != 0){
            casaDoMeio = mapa.n/2 + 1;
        }else{
            casaDoMeio = mapa.n/2;
        }
        segundaMetadeTabuleiro = mapa.n - casaDoMeio;

        int[] casas = new int[segundaMetadeTabuleiro];
        for(int i = 0; i < casas.length; i++){
            casas[i] = casaDoMeio + i+1;
        }
        for(int i = 0; i < jogadores.size(); i++){
            if(jogadores.get(i).casaAtual == casaDoMeio){
                jogadoresNoMeio.add(jogadores.get(i));
            }
        }
        for(int i = 0; i < casas.length; i++){
            for(int j = 0; j < jogadores.size(); j++){
                if(casas[i] == jogadores.get(j).casaAtual){
                    help = 1;
                }
            }
        }
        if (help == 1 && jogadoresNoMeio.size() == 2){
            if(jogadoresNoMeio.get(0).nome.length() < jogadoresNoMeio.get(1).nome.length()){
                jogadorGanhou = jogadoresNoMeio.get(0);
            }else{
                jogadorGanhou = jogadoresNoMeio.get(1);
            }
            return true;
        }
        return false;
    }

    public String[] getWinnerInfo() {
        String[] infoWinner = new String[4];
        int menorId = Integer.MAX_VALUE;
        int maiorCasa = 0;
        int distancia = ordenaPorCasaAtual()[jogadores.size()-1] - ordenaPorCasaAtual()[jogadores.size()-2];

        if (!jogoAcabou()) {
            return null;
        }
        for (int i = 0; i < jogadores.size(); i++) {
            if (jogadores.get(i).casaAtual == mapa.n) {//Se o jogador chegou à meta

                infoWinner = infoJogador(jogadores.get(i).id);
                return infoWinner;
            }else {
                if (jogadores.get(i).casaAtual> maiorCasa) {
                    maiorCasa = jogadores.get(i).casaAtual;
                    infoWinner = infoJogador(jogadores.get(i).id);

                    if (jogadores.get(i).id < menorId) {
                        menorId = jogadores.get(i).id;
                        infoWinner = infoJogador(jogadores.get(i).id);
                    }
                }
            }
        }
        if(distancia > mapa.n / 2){
            for(int i = 0; i < jogadores.size(); i++){
                if(jogadores.get(i).casaAtual == ordenaPorCasaAtual()[jogadores.size()-2]){
                    infoWinner = infoJogador(jogadores.get(i).id);
                    return infoWinner;
                }
            }
        }else{
            infoWinner = infoJogador(jogadorGanhou.id);
        }

        return infoWinner;
    }

    public String getNomeEspecie(char idEspecie) {
        String nomeEspecie = "";
        for (int i = 0; i < getSpecies().length; i++) {
            if (idEspecie == getSpecies()[i][0].charAt(0)) {
                nomeEspecie = getSpecies()[i][1];
            }
        }
        return nomeEspecie;
    }

    public ArrayList<String> getGameResults() {

        ArrayList<String> resultados = new ArrayList<>();
        String info = "";
        int count = 1;
        int nrJogadores = 0;
        if(!jogoAcabou()){
            return resultados;
        }
        for(int i = 0; i < jogadores.size(); i++){
            if(nrJogadores == 0){
                if(jogadores.get(i).id == Integer.parseInt(getWinnerInfo()[0])){
                    info = "#" + count + " " + jogadores.get(i).nome + ", " +
                            getNomeEspecie(jogadores.get(i).idEspecie) + ", " + jogadores.get(i).casaAtual + ", " +
                            jogadores.get(i).posicoesAndadas + ", " + jogadores.get(i).alimentosIngeridos;
                    resultados.add(info);
                    jogadores.remove(jogadores.get(i));
                    nrJogadores++;
                }
            }

        }
        Collections.sort(jogadores, new Comparator<Jogador>() {
            @Override
            public int compare(Jogador o1, Jogador o2) {
                return Integer.valueOf(o2.casaAtual).compareTo(o1.casaAtual);
            }
        });

        for (int i = 0; i < jogadores.size(); i++) {
                    count++;
                    info = "#" + count + " " + jogadores.get(i).nome + ", " +
                            getNomeEspecie(jogadores.get(i).idEspecie) + ", " + jogadores.get(i).casaAtual + ", " +
                            jogadores.get(i).posicoesAndadas + ", " + jogadores.get(i).alimentosIngeridos;
                    resultados.add(info);
                }
        return resultados;
    }

    public JPanel getAuthorsPanel() {
        return null;
    }

    public String whoIsTaborda() {
        return "Wrestling";
    }

}