//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P08 DNA Transcription
// Course: CS 300 Spring 2022
//
// Author: Gaurav chopra
// Email: gmchopra@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:
// Partner Email:
// Partner Lecturer's Name:
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X_ Write-up states that pair programming is allowed for this assignment.
// _X_ We have both read and understand the course Pair Programming Policy.
// _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////

import java.util.NoSuchElementException;

/**
 * A generic implementation of a linkedQueue
 */
public class LinkedQueue<T> extends Object implements QueueADT<T> {

  protected Node<T> back; // The node at the back of the queue, added MOST recently
  protected Node<T> front; // The node at the front of the queue, added LEAST recently
  private int n; // Number of Elements in the queue

  /**
   * Adds the given data to this queue; every addition to a queue is made at the back
   * 
   * @param data - the data to add
   */
  @Override
  public void enqueue(T data) {
    Node<T> temp = new Node<T>(data, null);
    if (isEmpty() == true) {
      front = temp;
    }

    else {
      back.setNext​(temp);
    }

    back = temp;
    n++;                                                                                                                                    
  }

  /**
   * Removes and returns the item from this queue that was least recently added
   * 
   * @returns (T) the item from this queue that was least recently added
   * @throws NoSuchElementException - if this queue is empty
   */
  @Override
  public T dequeue() throws NoSuchElementException {
    T data;
    if (isEmpty() == true) {
      throw new NoSuchElementException("There is no node present to remove");
    }

    data = front.getData();
    
    front = front.getNext();
    if (front == null) {
      back = null;
    }
    n--;
    return data;
  }

  /**
   * Returns the item least recently added to this queue without removing it
   * 
   * @returns (T) the item least recently added to this queue
   * @throws NoSuchElementException - if this queue is empty
   */
  @Override
  public T peek() throws NoSuchElementException {
    if (isEmpty() == true) {
      throw new NoSuchElementException("There is no node to peek");
    } else {
      return front.getData();
    }
  }

  /**
   * Checks whether the queue contains any elements
   * 
   * @returns (boolean) true if this queue is empty; false otherwise
   */
  @Override
  public boolean isEmpty() {
    if (this.n != 0) {
      return false;
    }
    return true;
  }

  /**
   * Returns the number of items in this queue
   * 
   * @returns (int) the number of items in this queue
   */
  @Override
  public int size() {
    return this.n;
  }

  /**
   * Returns a string representation of this queue, beginning at the front (least recently added) of
   * the queue and ending at the back (most recently added). An empty queue is represented as an
   * empty string; otherwise items in the queue are represented using their data separated by spaces
   * 
   * @returns (String) the sequence of items in FIFO order, separated by spaces
   */
  @Override
  public String toString() {
    String s = "";

    if (isEmpty() == true) {
      return "";
    }

    Node<T> variable = front;
    for (int i = 0; i < n; i++) {
      s = s + variable.getData() + " ";
      variable = variable.getNext();
    }
    return s;
  }
}
