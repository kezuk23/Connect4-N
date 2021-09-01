import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HumanPlayer extends Player {

  private BufferedReader userInput; 

  public HumanPlayer(char token){
    super(token);
    userInput = new BufferedReader(new InputStreamReader(System.in));
  }

  public int getPlayerInput(){

    String input = null;
	  try{		
		  input = userInput.readLine();
	  }
	  catch(Exception e){
	  }
    int position = Integer.parseInt(input);
    return position;
	}
}