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

/**
 * Contains all fields and methods to create a TileStack
 * 
 *
 */
public class TileStack implements Iterable<Tile>, StackADT<Tile> {
  private Node top; // Top of the stack
  private int size; // Number of elements in the stack

  /**
   * Default constructor sets size to 0;
   */
  public TileStack() {
    size = 0;
  }

  @Override
  /**
   * Adds element to the stack
   * 
   * @param element to add to stack
   */
  public void push(Tile element) {
    // If size is 0, then just make element the top, else, make a new node, set its next to top,
    // then set top to newNode
    if (size == 0) {
      top = new Node(element);
      size++;
    } else {
      Node newNode = new Node(element);
      newNode.setNext(top);
      top = newNode;
      size++;
    }
  }

  @Override
  /**
   * Removes top element of the stack
   * 
   * @return Tile of the top element of the stack
   * @throws EmptyStackException if the stack is empty
   */
  public Tile pop() throws EmptyStackException {
    // Create temp variable for top, then set the next element to top, then decrease size, and
    // return the temp variable containing the old top
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    Node old = top;
    top = top.getNext();
    size--;
    return old.getTile();
  }

  /**
   * Returns the top element of the stack
   * 
   * @return Tile of the top element of the stack
   * @throws EmptyStackException if the stack is empty
   */
  @Override
  public Tile peek() throws EmptyStackException {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return top.getTile();
  }

  @Override
  /**
   * Whether or not the stack is empty
   * 
   * @return true if size is 0, else return false
   */
  public boolean isEmpty() {
    if (size == 0) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  /**
   * Getter for the size field
   * 
   * @return size of the stack
   */
  public int size() {
    return size;
  }

  @Override
  /**
   * Return iterator for going through the stack
   * 
   * @return Iterator<Tile> for stack
   */
  public Iterator<Tile> iterator() {
    TileListIterator iterator = new TileListIterator(top);
    return iterator;
  }
}
