import java.util.Random;

public class AI_Player extends Player {

  private int low;
  private int high;
  private int result;

  public AI_Player(char token){
    super(token);
  }

  public int getPlayerInput(){
    Random r = new Random();
    low = 1;
    high = 8;
    result = r.nextInt(high-low)+low;
    return result;
  }
}