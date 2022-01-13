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
import java.util.NoSuchElementException;

/**
 * 
 * Contains methods and fields for TileListIterator
 *
 */
public class TileListIterator implements Iterator<Tile> {
  private Node head; // contains the beginning node and subsequent nodes

  /**
   * Sets paramter to the head field
   * 
   * @param head starting node for the list
   */
  public TileListIterator(Node head) {
    // Creates a new iterator to iterate through a list of tiles starting from its head
    // head is a reference to the head of the linked list of tiles
    this.head = head;
  }

  @Override
  /**
   * Keeps returning true if there is still a element in the list
   * 
   * @return true if element is not null, false otherwise
   */
  public boolean hasNext() {
    if (head != null) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  /**
   * Return next element in the list
   * 
   * @return next element in the list
   */
  public Tile next() throws NoSuchElementException {
    if (head == null) {
      throw new NoSuchElementException("There are no more elements");
    }
    Tile before = head.getTile();
    head = head.getNext();
    return before;
  }

}
