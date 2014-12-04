package finalProject;

import java.util.*;

/**
 * A simple text-based user interface for the game of
 * simple Connect four, played user vs. computer.
 * 
 * ##Comment this code##
 * 
 */
public class TicTacToeTUI 
{
  
  private static final int NO_CHOICE = 0;
  private static final int PLAY_GAME = 1;
  private static final int EXIT = 2;
  
  private Player user1;  
  private Player user2;

  private Game game;
  private Scanner in;
  
  private int curPlayer;
  private static final int USER1 = 0;
  private static final int USER2 = 1;
  
  /**
 * ##Comment this code##
 * Creates two players
 */
  public TicTacToeTUI () 
  {
    this.user1 = new Player("Player 1", false, "X");
    this.user2 = new Player("Player 2", false, "O");
    this.game = null;
    this.in = new Scanner(System.in);
  }
  
/**
 * ##Comment this code##
 * the start method, makes the user choose to start or exit the game from the main menu
 */
  public void start () 
  {
    int choice = NO_CHOICE;
    while (choice != EXIT) 
    {
      displayMainMenu();
      choice = readIntWithPrompt("Enter choice: ");
      executeChoice(choice);
    }
  }
  
/**
 * ##Comment this code##
 */
  private void playGame ( boolean userPlaysFirst) 
  {
    int numToPlay;
    boolean gameOver = false;
    String gameWinner = "";
    
    game = new Game();
    game.displayBoard();
    
    if (userPlaysFirst)
      curPlayer = USER1;
    else
      curPlayer = USER2;
  
    while (!gameOver) 
    {
      if( curPlayer == USER1 )
      {
         numToPlay = readIntWithPrompt("Player 1: Enter number to play");
         while( !game.isValidNumber(numToPlay) )
         {
           System.out.println("Not a valid number");
           numToPlay = readIntWithPrompt("Player 1: Enter number to play");
         }
         game.makeMove( numToPlay, "X");
         if(game.winner("X"))
         {
           gameOver = true;
           gameWinner = "User 1";
         }
         curPlayer = USER2;
      }
      else
      {
         numToPlay = readIntWithPrompt("Player 2: Enter number to play");
         while( !game.isValidNumber(numToPlay) )
         {
           System.out.println("Not a valid number");
           numToPlay = readIntWithPrompt("Player 2: Enter number to play");
         }
         game.makeMove( numToPlay, "O");
         if(game.winner("O"))
         {
           gameOver = true;
           gameWinner = "User 2";
         }
         curPlayer = USER2;
      }
      game.displayBoard();
    }
      
    reportWinner(gameWinner);
    
  }
  
/**
 * ##Comment this code##
 * displays the main menu that has 2 choices
 */
  private void displayMainMenu () 
  {
    System.out.println();
    System.out.println("Enter the number denoting the action to perform: ");
    System.out.println("Run game..............." + PLAY_GAME);
    System.out.println("Exit..................." + EXIT);
  }
  
/**
 * ##Comment this code##
 * executes that choice
 */
  private void executeChoice (int choice) 
  {
    
    System.out.println();
    if (choice == PLAY_GAME) 
    {  
      boolean userPlaysFirst = readYes("Player 1 plays first? (Key yes or no): ");
      playGame(userPlaysFirst);
    } 
    else if (choice == EXIT)
    {
      System.out.println("Good-bye.");
    }
  }
  
  
/**
 * ##Comment this code##
 */
  private boolean readYes (String prompt) 
  {
    String input = "";
    while (!(input.equals("yes") || input.equals("no"))) 
    {
      System.out.print(prompt); System.out.flush();
      input = in.next();
      input = input.toLowerCase();
      in.nextLine();
    }
    return input.equals("yes");
  }
  
/**
 * ##Comment this code##
 * reports the winner
 */
  private void reportWinner (String player) 
  {
    System.out.println();
    System.out.println("Player " + player + " wins.");
    System.out.println();
  }
  
/**
 * ##Comment this code##
 * this prints the prompts and then accepts the input from them
 */
  private int readIntWithPrompt (String prompt) 
  {
    System.out.print(prompt); System.out.flush();
    while (!in.hasNextInt()) 
    {
      in.nextLine();
      System.out.print(prompt); System.out.flush();
    }
    int input = in.nextInt();
    in.nextLine();
    return input;
  }
  
}

