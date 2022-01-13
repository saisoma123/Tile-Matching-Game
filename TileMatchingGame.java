//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P09 Tile Matching Game
// Course: CS 300 Fall 2021
//
// Author: Surya Somayyajula
// Email: somayyajula@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////
import java.util.Iterator;

/**
 * Contains all methods and fields to create TileMatchingGame
 * 
 * @author sai2003
 *
 */
public class TileMatchingGame {
  private TileStack[] columns; // Game board

  /**
   * Initializes and sets elements to TileStacks
   * 
   * @param columnCount number of columns in array
   * @throws IllegalArgumentException if columnCount is less than or equal to zero
   */
  public TileMatchingGame(int columnCount) throws IllegalArgumentException {
    if (columnCount <= 0) {
      throw new IllegalArgumentException("Enter a valid columnCount");
    }
    columns = new TileStack[columnCount];
    for (int i = 0; i < columns.length; i++) {
      columns[i] = new TileStack();
    }
  }

  /**
   * Getter for length of the columns array
   * 
   * @return length of the columns array
   */
  public int getColumnsNumber() {
    return columns.length;
  }

  /**
   * Adds a tile to a particular column
   * 
   * @param tile  to add to column
   * @param index which column to add it to
   * @throws IndexOutOfBoundsException if index is not in range
   */
  public void dropTile(Tile tile, int index) throws IndexOutOfBoundsException {
    if (index < 0 || index >= columns.length) {
      throw new IndexOutOfBoundsException("Index is invalid");
    }
    // If size is 0, then push tile normally, if tile is equal to the top tile, then pop off top
    // tile
    if (columns[index].size() == 0) {
      columns[index].push(tile);
    } else if (columns[index].peek().equals(tile)) {
      columns[index].pop();
    } else {
      columns[index].push(tile);
    }

  }

  /**
   * Clears a particular column in the array
   * 
   * @param index picks a particular column in the array
   * @throws IndexOutOfBoundsException if index is not in range
   */
  public void clearColumn(int index) throws IndexOutOfBoundsException {
    // Pops off all the elements until the column is of size 0
    if (index < 0 || index >= columns.length) {
      throw new IndexOutOfBoundsException("Index is invalid");
    }
    int size = columns[index].size();
    while (size != 0) {
      columns[index].pop();
      size--;
    }
  }

  /**
   * Clears all the columns to restart the game
   */
  public void restartGame() {
    // Calls clearColumn for all columns
    for (int i = 0; i < columns.length; i++) {
      clearColumn(i);
    }
  }

  /**
   * Prints out a particular column
   * 
   * @param index particular column to print
   * @return each Tile in the column in String form
   * @throws IndexOutOfBoundsException index is not in range
   */
  public String column(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index >= columns.length) {
      throw new IndexOutOfBoundsException("Index is invalid");
    }
    // If empty, then return empty string, else use iterator to print all Tiles in the column
    if (columns[index].isEmpty()) {
      return "";
    } else {
      String stack = "";
      Iterator<Tile> print = columns[index].iterator();
      while (print.hasNext()) {
        stack = stack + print.next() + " ";
      }
      return stack;
    }
  }

  @Override
  /**
   * Prints out the matching game board
   */
  public String toString() {
    // Prints out by calling column method to print each column
    String game = "GAME COLUMNS: \n";
    for (int i = 0; i < columns.length; i++) {
      game = game + i + ": " + column(i) + "\n";
    }
    return game;
  }
}
