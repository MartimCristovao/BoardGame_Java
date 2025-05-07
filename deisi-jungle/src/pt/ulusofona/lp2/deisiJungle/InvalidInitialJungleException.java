package pt.ulusofona.lp2.deisiJungle;

public class InvalidInitialJungleException extends Exception {
    String message;

    public InvalidInitialJungleException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public boolean isInvalidPlayer() {
        return message.equals("Invalid Player");
    }
    public boolean isInvalidFood(){
        return message.equals("Invalid Food");
    }
    public boolean hasDuplicateIds(){
      return true;
    }
}
