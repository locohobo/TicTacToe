package finalProject;

import java.util.*;

/**
 * ##Comment this code##\
 * This code creates the Player, with the set name
 */
public class Player
{
  private String name;               
  private boolean autoPlayer;
  private Scanner in;
  private String playerPiece;
  
/**
 * ##Comment this code##
 * This is the object constructor that creates the player
 */
  public Player (String name, boolean autoPlayer, String piece) {
    this.name = name;
    this.autoPlayer = autoPlayer;
    this.playerPiece = piece;
    
    this.in = new Scanner(System.in);
  }
  
/**
 * ##Comment this code##
 * get the players name
 */
  public String getName ()
  {
    return name;
  }
  
/**
 * ##Comment this code##
 * Set the players name
 */
  public void setName (String inName)
  {
    name = inName;
  }
 
  
  
}
