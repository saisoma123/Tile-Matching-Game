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

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * Contains tester methods to check correctness of TileMatchingGame, TileStack, and TileListIterator
 *
 */
public class TileMatchingTester {
  /**
   * Checkes correctness of tileEquals method
   * 
   * @return true if all tests pass, false otherwise
   */
  public static boolean tileEqualsTester() {
    // Checks if comparing to string will not return false, and checks if comparisons to colors are
    // correct
    try {
      Tile blue = new Tile(Color.BLUE);
      String wrong = "wrong";
      Tile black = new Tile(Color.BLACK);
      Tile blue1 = new Tile(Color.BLUE);
      if (!blue.equals(wrong) == false && !blue.equals(black) == false
          && !blue.equals(blue1) == true) {
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }

    return true;

  }

  /**
   * Checks correctness of TileListIterator
   * 
   * @return true if all tests pass, false otherwise
   */
  public static boolean tileListIteratorTester() {
    try {
      // Checks if the iterator goes through the linked stack correctly
      Node tile1 = new Node(new Tile(Color.BLUE),
          new Node(new Tile(Color.BLACK), new Node(new Tile(Color.YELLOW),
              new Node(new Tile(Color.BLUE), new Node(new Tile(Color.ORANGE), null)))));
      TileListIterator iterator = new TileListIterator(tile1);
      while (iterator.hasNext()) {
        Tile check = iterator.next();
        Tile check1 = iterator.next();
        Tile check2 = iterator.next();
        Tile check3 = iterator.next();
        Tile check4 = iterator.next();
        if (check.getColor() != Color.BLUE) {
          return false;
        }
        if (check1.getColor() != Color.BLACK) {
          return false;
        }
        if (check2.getColor() != Color.YELLOW) {
          return false;
        }
        if (check3.getColor() != Color.BLUE) {
          return false;
        }
        if (check4.getColor() != Color.ORANGE) {
          return false;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * Checks correctness of TileStack
   * 
   * @return true if all tests pass, false otherwise
   */
  public static boolean tileStackTester() {
    // Checks if stack has correct nodes and size
    try {
      TileStack stack = new TileStack();
      if (stack.isEmpty() != true) {
        return false;
      }
      if (stack.size() != 0) {
        return false;
      }

      stack.push(new Tile(Color.BLACK));
      if (stack.isEmpty() != false) {
        return false;
      }
      if (stack.size() != 1) {
        return false;
      }
      stack.push(new Tile(Color.BLUE));
      if (stack.isEmpty() != false) {
        return false;
      }
      if (stack.size() != 2) {
        return false;
      }
      if (stack.peek().getColor() != Color.BLUE) {
        return false;
      }
      if (stack.pop().getColor() != Color.BLUE) {
        return false;
      }
      stack.push(new Tile(Color.BLUE));
      Iterator<Tile> iterator = stack.iterator();
      while (iterator.hasNext()) {
        Color head = iterator.next().getColor();
        Color tail = iterator.next().getColor();
        if (head != Color.BLUE) {
          return false;
        }
        if (tail != Color.BLACK) {
          return false;
        }
      }
    } catch (EmptyStackException e) {
      e.printStackTrace();
      return false;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * Checks correctness of TileMatchingGame
   * 
   * @return true if all tests pass, false otherwise
   */
  public static boolean tileMatchingGameTester() {
    // Checks if TileMatchingGame has the correct representations
    try {
      TileMatchingGame game = new TileMatchingGame(2);
      if (game.getColumnsNumber() != 2) {
        return false;
      }
      game.dropTile(new Tile(Color.BLACK), 0);
      game.dropTile(new Tile(Color.BLUE), 0);
      game.dropTile(new Tile(Color.YELLOW), 1);
      game.dropTile(new Tile(Color.ORANGE), 1);
      if (!game.toString().equals("GAME COLUMNS: \n0: BLUE BLACK \n" + "1: ORANGE YELLOW \n")) {
        return false;
      }
      if (!game.column(0).equals("BLUE BLACK ")) {
        return false;
      }
      if (game.getColumnsNumber() != 2) {
        return false;
      }
      game.dropTile(new Tile(Color.BLUE), 0);
      if (!game.column(0).equals("BLACK ")) {
        return false;
      }
      game.clearColumn(0);
      if (!game.toString().equals("GAME COLUMNS: \n0: \n" + "1: ORANGE YELLOW \n")) {
        return false;
      }
      game.restartGame();
      if (!game.toString().equals("GAME COLUMNS: \n0: \n" + "1: \n"))
        return false;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * Prints the results of all the tester methods
   * 
   * @param args
   */

  public static void main(String[] args) {
    System.out.println(tileEqualsTester());
    System.out.println(tileListIteratorTester());
    System.out.println(tileStackTester());
    System.out.println(tileMatchingGameTester());
  }

}
