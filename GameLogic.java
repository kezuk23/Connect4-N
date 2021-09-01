import java.util.Scanner;

public class GameLogic {

  private HumanPlayer player1;
  private AI_Player player2;
  private AI_Player player3;
  private int position;

	public GameLogic(){
    player1 = new HumanPlayer('r');
    player2 = new AI_Player('y');
    player3 = new AI_Player('b');
		playGame();
	}
  
	public void playGame(){
    //initialise board and print print instructions
    printInstructions();
    int N;
    //user can change N to a number between 2 and 7
    try{
      Scanner scan = new Scanner(System.in);
      N = scan.nextInt();
      while (N<3 || N>6){
        System.out.println("Sorry, please enter either 3, 4, 5, or 6.");
        N = scan.nextInt();
      }
    }
    catch (Exception e){ //non integer input 
      System.out.println("Sorry, input not recognised. Default mode Connect 4 activated.");
      N = 4;
    }
    //begin the game
    System.out.println("Welcome to Connect "+N+".");
    System.out.println("");
		Board board = new Board(N);
    board.printBoard(); 
    
    //game logic
		boolean gameWin = false;
    boolean draw = board.checkDraw();
    //take turns until win or draw is true
		while(!gameWin|!draw){
    
		  //player1 turn
      System.out.println("Your turn:");
      //get user input  between 1 and 7
      position = 0;
      while (position<1 || position>7){
        System.out.println("Enter a number from 1 to 7");
        try{
          position = player1.getPlayerInput();
        }
        catch (NumberFormatException e){
          System.out.println("Please try again.");
        }
      }
      //check valid or not - do not continue until valid choice
      while(board.checkColFull(position)==true){
        System.out.println("Column full, please try again.");
        try{
          position = player1.getPlayerInput();
        }
        catch (NumberFormatException e){
          System.out.println("Please try again. Enter a valid number.");
          position = player1.getPlayerInput();
        }
      }
      //place counter
      board.makeMove(player1.getToken(), position);
      //check win player1 
      if (board.checkWin(player1.getToken()) == true){
        gameWin = true;
        System.out.println("You win!!");
        break; //exit while loop without additional turns
      }

      //player2 turn 
      System.out.println("Bot 1's move:");
      //get computer input
      position = player2.getPlayerInput();
      //check valid or not - do not continue until valid choice
      while(board.checkColFull(position)==true){
        position = player2.getPlayerInput();
      }
      //place counter
      board.makeMove(player2.getToken(),position);
      //check win player2
      if (board.checkWin(player2.getToken()) == true){
        gameWin = true;
        System.out.println("You lose!! Bot 1 wins!");
        break;
      }

      //player3 turn 
      System.out.println("Bot 2's move:");
      //get computer input
      position = player3.getPlayerInput();
      //check valid or not - do not continue until valid choice
      while(board.checkColFull(position)==true){
        position = player3.getPlayerInput();
      }
      //place counter
      board.makeMove(player3.getToken(),position);
      //check win player3
      if (board.checkWin(player3.getToken()) == true){
        gameWin = true;
        System.out.println("You lose!! Bot 2 wins!");
        break;
      }
      if (board.checkDraw()){
        System.out.println("It's a tie!");
        break;
      }
    }
    System.out.println("Game over.");
  }

  public void printInstructions(){
    System.out.println("Welcome to Connect N!\n");		
		System.out.println("There are 3 players Red, Yellow, and Blue.");
		System.out.println("Player 1 is Red, Bot 1 is Yellow, Bot 2 is Blue.");
		System.out.println("To play the game type in the number of the column you want to drop your counter in.");
		System.out.println("A player wins by connecting N counters in a row - vertically, horizontally or diagonally.\n");
    System.out.println("What would you like N to be? Choose a number from 3 to 6.");
  }
}