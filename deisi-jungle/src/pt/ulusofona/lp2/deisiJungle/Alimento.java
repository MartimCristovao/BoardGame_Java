package pt.ulusofona.lp2.deisiJungle;

import java.util.Random;

public class Alimento {
    char id;
    int bananasNoCacho = 3;
    Random rand = new Random();
    int randomN = rand.nextInt(10, 50);
    public Alimento(){
    }
    public Alimento(char id){
        this.id = id;
    }

    char getId(){
        return id;
    }

}

class Agua extends Alimento{
    public Agua(char id){
        super(id);
    }

}

class Erva extends Alimento{
    public Erva(char id){
        super(id);
    }

}
class Banana extends Alimento{

    public Banana(char id){
        super(id);
    }

}
class Carne extends Alimento{
    public Carne(char id){
        super(id);
    }

}
class Cogumelo extends Alimento{
    public Cogumelo(char id){
    super(id);
}

}