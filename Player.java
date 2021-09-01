public abstract class Player {

  private char token;

  public abstract int getPlayerInput();

  public Player(char token){ //constructor
    this.token = token;
  }

  public char getToken(){
    return token;
  }
}