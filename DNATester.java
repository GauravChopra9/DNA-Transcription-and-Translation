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
 * Test methods to verify your implementation of the methods for P08.
 */
public class DNATester {

  /**
   * Tests the transcribeDNA() method
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testTranscribeDNA() {
    try {
      DNA testDNA = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
      String mRNA = "CCUCAGUCAAUUCGCUGGCCCUGUAUGACAGAACCAUUAGAGGCUCGAUCUUUCAGAGAC";
      // System.out.println(testDNA.transcribeDNA().toString());
      if (testDNA.transcribeDNA().toString().replaceAll(" ", "").equals(mRNA)) {
        return true;
      }
      return false;
    }

    catch (Exception e) {
      return false;
    }
  }

  /**
   * Tests the translateDNA() method
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testTranslateDNA() {
    try {
      DNA testDNA = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
      // System.out.println(testDNA.translateDNA().toString());
      if (testDNA.translateDNA().toString().replaceAll(" ", "").equals("PQSIRWPCMTEPLEARSFRD")) {
        return true;
      }
      return false;
    }

    catch (Exception e) {
      return false;
    }
  }

  /**
   * Tests the MRNATranslateDNA() method
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testMRNATranslate() {
    try {
      // Test case 1: When testDNA is in a multiple of 3
      DNA testDNA = new DNA("GGA");
      // System.out.println(testDNA.transcribeDNA().toString());
      LinkedQueue<Character> mRNA = testDNA.transcribeDNA();
      LinkedQueue<String> expected = testDNA.mRNATranslate(mRNA);

      if (!(expected.toString().replaceAll(" ", "").equals("P"))) {
        return false;
      }

      // Test case 2: When testDNA is not in a multiple of 3
      DNA testDNA2 = new DNA("GATTACA");
      LinkedQueue<Character> mRNA2 = testDNA2.transcribeDNA();
      LinkedQueue<String> expected2 = testDNA2.mRNATranslate(mRNA2);
      if (!(expected2.toString().replaceAll(" ", "").equals("LM"))) {
        return false;
      }

      // Test case 3: When there is a stop Codon present
      DNA testDNA3 = new DNA("CCGGCCCTCCGGTGGATCCAA");
      LinkedQueue<Character> mRNA3 = testDNA3.transcribeDNA();
      LinkedQueue<String> expected3 = testDNA3.mRNATranslate(mRNA3);
      // System.out.println(expected3);
      if (!(expected3.toString().replaceAll(" ", "").equals("GREAT"))) {
        return false;
      }
      return true;
    }

    catch (Exception e) {
      return false;
    }
  }

  /**
   * Tests the EnqueueDequeue() method
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testEnqueueDequeue() {
    try {
      LinkedQueue<String> obj = new LinkedQueue<String>();
      if (!obj.toString().replace(" ", "").equals("")) {
        return false;
      }

      if (obj.front != null || obj.back != null) {
        return false;
      }

      obj.enqueue("x");

      if (!(obj.front.getData().replaceAll(" ", "").equals("x")
          && obj.back.getData().replaceAll(" ", "").equals("x"))) {
        return false;
      }

      obj.enqueue("y");
      obj.enqueue("z");

      if (!obj.toString().replace(" ", "").equals("xyz")) {
        return false;
      }

      obj.dequeue();
      if (!obj.toString().replace(" ", "").equals("yz")) {
        return false;
      }

      LinkedQueue<String> obj2 = new LinkedQueue<String>();
      try {
        obj2.dequeue();
      }

      catch (NoSuchElementException n) {
        if (n.getMessage() == null || n.getMessage().equals("")) {
          return false;
        }
      }

      catch (Exception e) {
        return false;
      }
    }

    catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Tests the QueueSize() method and the isEmpty() method
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testQueueSize() {
    try {
      LinkedQueue<Character> obj = new LinkedQueue<Character>();
      // Testing when size is 0
      if (obj.size() != 0) {
        return false;
      }
      obj.enqueue('a');
      obj.enqueue('b');
      obj.enqueue('c');
      // Testing when size is greater than O
      if (obj.size() != 3) {
        return false;
      }

      obj.dequeue();
      if (obj.size() != 2) {
        return false;
      }

      // Testing for the isEmpty() method
      LinkedQueue<String> obj2 = new LinkedQueue<String>();

      if (obj2.isEmpty() != true) {
        return false;
      }

      obj2.enqueue("Hello");

      if (obj2.isEmpty() != false) {
        return false;
      }
    }

    catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Tests the Peek() method
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testPeek() {
    try {
      LinkedQueue<Character> obj = new LinkedQueue<Character>();
      obj.enqueue('a');
      obj.enqueue('b');
      obj.enqueue('c');
      if (!obj.peek().toString().replaceAll(" ", "").equals("a")) {
        return false;
      }

      LinkedQueue<String> obj2 = new LinkedQueue<String>();
      try {
        obj2.peek();
      }

      catch (NoSuchElementException n) {
        if (n.getMessage() == null || n.getMessage().equals("")) {
          return false;
        }
      }

      catch (Exception e) {
        return false;
      }
      return true;
    }

    catch (Exception e) {
      return false;
    }

  }

  /**
   * Tests the toString() method
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testToString() {
    try {
      LinkedQueue<String> obj = new LinkedQueue<String>();
      if (!obj.toString().replaceAll(" ", "").equals("")) {
        return false;
      }
      obj.enqueue("Hello");
      obj.enqueue("my");
      obj.enqueue("name");
      obj.enqueue("is");
      obj.enqueue("Gaurav");
      if (!obj.toString().replaceAll(" ", "").equals("HellomynameisGaurav")) {
        return false;
      }
      return true;
    }

    catch (Exception e) {
      return false;
    }
  }

  /**
   * Tests the Node() method
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testNode() {
    try {
      Node obj = new Node("abc", null);
      if (!obj.getData().equals("abc")) {
        return false;
      }

      if (obj.getNext() != null) {
        return false;
      }

      return true;
    }

    catch (Exception e) {
      return false;
    }
  }

  /**
   * Main method - use this to run your test methods and output the results (ungraded)
   * 
   * @param args unused
   */
  public static void main(String[] args) {
    System.out.println("testNode() " + testNode());
    System.out.println("transcribeDNA: " + testTranscribeDNA());
    System.out.println("testMRNATranslate() " + testMRNATranslate());
    System.out.println("translateDNA: " + testTranslateDNA());
    System.out.println("testQueueSize() " + testQueueSize());
    System.out.println("testEnqueueDequeue() " + testEnqueueDequeue());
    System.out.println("testPeek() " + testPeek());
    // System.out.println("testisEmpty() " + testisEmpty());
    System.out.println("testToString() " + testToString());
  }
}
