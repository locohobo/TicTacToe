package finalProject;

import java.util.*;

/**
 * ##Comment this code##
 */
public class Game
{
  
  private String[][] gameBoard;
  private final int GAME_WIDTH = 3;
  private final int GAME_HEIGHT = 3;
  char piece = 'x';
    
  
  
 /**
 * ##Comment this code##
 * Creates the space for a 3x3 game board in memory 
 */
  public Game()
  {
    int counter = 1;

    gameBoard = new String[GAME_HEIGHT][GAME_WIDTH];
    
    for( int i = 0; i < gameBoard.length; i++)
    {
      for( int j = 0; j < gameBoard[i].length; j++)
      {
        gameBoard[i][j] = String.valueOf(counter);
        counter++;
      }
    }
    
  }

  /**
 * ##Comment this code##
 * display the board, makes sure its a 3x3 and not some other size
 */
  public void displayBoard()
  {
    String aLine = "";
    
    for( int i = 0; i < gameBoard.length; i++)
    {
      for( int j = 0; j < gameBoard[i].length; j++)
      {
        aLine = aLine + gameBoard[i][j];
        if( j < 2)
        {
          aLine = aLine + "|";
        }
      }
      
      System.out.println( aLine );
      if( i < gameBoard.length - 1 )
      {
         aLine = "-----";
         System.out.println( aLine);
      }
      aLine = "";
    }
    
    System.out.println();
  }
  
  /******************************************************
    * isValidNumber
    *    passed: the cell number to check
    * 
    * This method returns true if the cell number passed is
    * valid to play.  It should also check to make sure that
    * the number is in a valid range.
    * Otherwise, it returns false.
    * 
    *
    * ***************************************************
    * */
  public boolean isValidNumber( int cellNumber)
  {
    //TODO
	if (cellNumber > 0 && cellNumber <10 )  
		return true;
	
	
    boolean retVal = false;

    return retVal;
  }
  
  /*****************************************************
    * Method makeMove
    *     passed:  the column number to add the piece to.
    *              the type of player piece to add
    * 
    * Adds the piece to the valid cell
    * 
    * **************************************************
    * */
  public void makeMove( int cellNumber, String piece)
  {
    //TODO
	
		  int move = 0;
		  int col = 0;
				if (cellNumber < 4)
		  			{
					move = 3;
					col = cellNumber-1;
		  			}
	  
	  			else if (cellNumber > 3 & cellNumber < 7)
	  			{
	  				move = 2;
	  				col = cellNumber-3;
	  			}
	  				
	  
	  			else if (cellNumber > 6 && cellNumber < 10)
					{
	  				move = 1;
					col = cellNumber-6;
					}
				
					gameBoard[move][col] = piece; 
	 
	
	  
	  
	
  }
  
  
  /*****************************************************
    * Method winner
    *       passed:  the player piece being processed
    * 
    * Runs the winning condition methods and returns true of the user has won.
    * **************************************************
    * */
  public boolean winner( String piece )
  {
     return rowWin(piece) || colWin(piece) || diagRight(piece) || diagLeft(piece);
  }
  
  /****************************************************
    * Method rowWin
    *      passed: the player's piece
    * 
    * Checks to see if there are 3 in a row of the same piece
    * 
    * Return true: if there are!
    ***********************************************
    * */
  public boolean rowWin( String piece)
  {
    //TODO
	  //three in a row
	  for (int row=0; row<gameBoard.length; row++) 
	  {
			if(gameBoard[row][0].equals(gameBoard[row][1]) & gameBoard[row][0].equals(gameBoard[row][2]))
				return true;
	  }
	return false;
  }
  
  

public boolean colWin( String piece)
  {
    //TODO
	  //three in a col
	for (int col=0; col<gameBoard.length-1; col++) 
	{
		if(gameBoard[0][col].equals(gameBoard[1][col]) & gameBoard[0][col].equals(gameBoard[2][col]))
					return true;
	}
			
	
    return false;
  }
  
  public boolean diagRight( String piece)
  {
    //TODO
	 if (gameBoard[0][0].equals(gameBoard[1][1]) & gameBoard[0][0].equals(gameBoard[2][2])) 
			return true;
		
    return false;
  }
  
  public boolean diagLeft(String piece)
  {
    //TODO
	  if (gameBoard[0][2].equals(gameBoard[1][1]) & gameBoard[0][2].equals(gameBoard[2][0])) 
			return true;
	  
    return false;
  } 

}
