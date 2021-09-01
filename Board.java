public class Board {

private char[][] board;
private int playCount = 0; //tracks the number of turns
private int N;

  public Board(int N){ //constructor initialises the board with N from user input at GameLogic class
  this.board = new char[6][7];
  this.N = N;
  }

  public void printBoard(){
    int i, j;
		for(i=0; i<board.length; i++){ 
			for(j=0; j<board[i].length; j++){
				if(board[i][j] == 'r'){ // if a r has been placed, print it
					System.out.print("|(r)");
				}
				else if(board[i][j] == 'y'){ //if a y has been placed, print it
					System.out.print("|(y)");
				}
        else if(board[i][j] == 'b'){ //if a b has been placed, print it
					System.out.print("|(b)");
				}
				else{ // if space is empty, print blank space
					System.out.print("|   ");
				}
			}
      System.out.println("|");
	  }
    System.out.println("  1   2   3   4   5   6   7");
  }

  public boolean checkWin(char token){
    	int count = 0;
      //player reminder win criteria 
      System.out.println("Aim: "+N+" in a row.");
      boolean win = false;
			// check horizontal
			for(int i=0; i<board.length; i++){
        for(int j=0; j<board[i].length; j++){
					if(board[i][j] == token){
						count = count + 1;
						if(count >= N){
							win = true;
              System.out.println("Horizontal win!");
						}
					}
					else{
						count = 0;
					}
				}
			}
			// check vertical 
			count = 0;
			for(int i=0; i<board[0].length; i++){
				for(int j=0; j<board.length; j++){
					if(board[j][i] == token){
						count = count + 1;
						if(count == N){
							win = true;
              System.out.println("Vertical winner!");
						}
					}
					else{
						count = 0; 
					}
				}
      }
      //check diagonal downward
      for(int i=0; i<=7-N; i++){
        for(int j=0; j<=6-N; j++){
          if (N==3){
            if (board[j][i] == token && board[j+1][i+1] == token && board[j+2][i+2] == token){
              win = true;
              System.out.println("Downward diagonal winner!");
            }
          }
          else if (N==4){
            if (board[j][i] == token && board[j+1][i+1] == token && board[j+2][i+2] == token && board[j+3][i+3] == token){
              win = true;
              System.out.println("Downward diagonal winner!");
            }
          }
          else if (N==5){
            if (board[j][i] == token && board[j+1][i+1] == token && board[j+2][i+2] == token && board[j+3][i+3] == token && board[j+4][i+4] == token){
              win = true;
              System.out.println("Downward diagonal winner!");
            }
          }
          else if (N==6){
            if (board[j][i] == token && board[j+1][i+1] == token && board[j+2][i+2] == token && board[j+3][i+3] == token && board[j+4][i+4] == token && board[j+5][i+5] == token){
              win = true;
              System.out.println("Downward diagonal winner!");
            } 
          }
        }
      }
      //check diagonal upward
      for(int i=0; i<=6-(N-1); i++){
        for(int j=5; j>=N-1; j--){
          if (N==3){
            if (board[j][i] == token && board[j-1][i+1] == token && board[j-2][i+2] == token){
              win = true;
              System.out.println("Upward diagonal winner!");
            }
          }
          else if (N==4){
            if (board[j][i] == token && board[j-1][i+1] == token && board[j-2][i+2] == token && board[j-3][i+3] == token){
              win = true;
              System.out.println("Upward diagonal winner!");
            }
          }
          else if (N==5){
            if (board[j][i] == token && board[j-1][i+1] == token && board[j-2][i+2] == token && board[j-3][i+3] == token && board[j-4][i+4] == token){
              win = true;
              System.out.println("Upward diagonal winner!");
            }
          }
          else if (N==6){ //needs checking
            if (board[j][i] == token && board[j-1][i+1] == token && board[j-2][i+2] == token && board[j-3][i+3] == token && board[j-4][i+4] == token && board[j-5][i+5] == token){
              win = true;
              System.out.println("Upward diagonal winner!");
            }
          }
        }
      }
    return win;
  }

  public void makeMove(char token, int position){
		boolean placed = false;
			for(int i=board.length-1; i>=0; i--){
				if(!placed){
					if((board[i][position-1] == 'r')||(board[i][position-1] == 'y')||(board[i][position-1] == 'b')){
						// if counter already in place - skip
          }
					else {
						board[i][position-1] = token;
						placed = true;
					}
				}
			}
      printBoard();
      playCount = playCount + 1;
		}
  
  public boolean checkDraw(){
    boolean draw = false;
    //max number of counters played = draw
    if (playCount==42){ //board size 6x7
      draw=true;
    }
    return draw;
  }

  public boolean checkColFull(int position){
    boolean full = false;
    if (board[0][position-1] == 'r'|board[0][position-1] == 'y'|board[0][position-1] == 'b'){
      return true;
    }
    return full;
  }
}