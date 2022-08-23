
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

/**
 * This class uses a linked queue to implement DNA transcription. DNA transcription is performed by
 * first transcribing a string of DNA characters to their mRNA complements, and then translating
 * those mRNA characters in groups of three (called "codons") to corresponding amino acids, which
 * finally fold up into proteins. To make this happen, you'll begin with a String containing a
 * sequence of DNA characters (A, C, G, and T) and use this to create a LinkedQueue of Characters.
 * Then, you'll write a method to traverse that LinkedQueue (without an iterator! gasp!) and create
 * a NEW LinkedQueue of mRNA characters (A->U, T->A, C->G, G->C). Finally, given that LinkedQueue of
 * mRNA, you'll use the provided mRNAtoProteinMap to traverse the queue three letters at a time and
 * find the associated amino acid - or if you've found a STOP codon, end your translation and return
 * the string of amino acids.
 */
public class DNA {

  // A two-dimensional array containing the mRNA codons in index 0 and the
  // corresponding amino acid (or STOP) in index 1
  protected static String[][] mRNAtoProteinMap =
      {{"UUU", "F"}, {"UUC", "F"}, {"UUA", "L"}, {"UUG", "L"}, {"UCU", "S"}, {"UCC", "S"},
          {"UCA", "S"}, {"UCG", "S"}, {"UAU", "Y"}, {"UAC", "Y"}, {"UAA", "STOP"}, {"UAG", "STOP"},
          {"UGU", "C"}, {"UGC", "C"}, {"UGA", "STOP"}, {"UGG", "W"}, {"CUU", "L"}, {"CUC", "L"},
          {"CUA", "L"}, {"CUG", "L"}, {"CCU", "P"}, {"CCC", "P"}, {"CCA", "P"}, {"CCG", "P"},
          {"CAU", "H"}, {"CAC", "H"}, {"CAA", "Q"}, {"CAG", "Q"}, {"CGU", "R"}, {"CGC", "R"},
          {"CGA", "R"}, {"CGG", "R"}, {"AUU", "I"}, {"AUC", "I"}, {"AUA", "I"}, {"AUG", "M"},
          {"ACU", "T"}, {"ACC", "T"}, {"ACA", "T"}, {"ACG", "T"}, {"AAU", "N"}, {"AAC", "N"},
          {"AAA", "K"}, {"AAG", "K"}, {"AGU", "S"}, {"AGC", "S"}, {"AGA", "R"}, {"AGG", "R"},
          {"GUU", "V"}, {"GUC", "V"}, {"GUA", "V"}, {"GUG", "V"}, {"GCU", "A"}, {"GCC", "A"},
          {"GCA", "A"}, {"GCG", "A"}, {"GAU", "D"}, {"GAC", "D"}, {"GAA", "E"}, {"GAG", "E"},
          {"GGU", "G"}, {"GGC", "G"}, {"GGA", "G"}, {"GGG", "G"}};

  // The queue containing the original DNA sequence
  protected LinkedQueue<Character> DNA;

  /**
   * Creates the DNA queue from the provided String. Each Node contains a single Character from the
   * sequence.
   *
   * @param sequence - a String containing the original DNA sequence
   */
  public DNA(String sequence) {
    DNA = new LinkedQueue<Character>();
    for (int i = 0; i < sequence.length(); i++) {
      char data = sequence.charAt(i);
      this.DNA.enqueue(data);
    }
  }

  /**
   * Creates and returns a new queue of mRNA characters from the stored DNA. The transcription is
   * done one character at a time, as (A->U, T->A, C->G, G->C).
   * 
   * @returns (LinkedQueue<Character>) the queue containing the mRNA sequence corresponding to the
   *          stored DNA sequence
   */
  public LinkedQueue<Character> transcribeDNA() {
    LinkedQueue<Character> mRNASequence = new LinkedQueue<Character>();
    String s = "";
    for (int i = 0; i < DNA.size(); i++) {

      if (DNA.peek() == 'A') {
        mRNASequence.enqueue('U');
      }

      if (DNA.peek() == 'T') {
        mRNASequence.enqueue('A');
      }

      if (DNA.peek() == 'C') {
        mRNASequence.enqueue('G');
      }

      if (DNA.peek() == 'G') {
        mRNASequence.enqueue('C');
      }

      char removed = DNA.dequeue();
      DNA.enqueue(removed);
    }
    return mRNASequence;
  }

  /**
   * Creates and returns a new queue of amino acids from a provided queue of mRNA characters. The
   * translation is done three characters at a time, according to the static mRNAtoProteinMap
   * provided above. Translation ends either when you run out of mRNA characters OR when a STOP
   * codon is reached (i.e. the three-character sequence corresponds to the word STOP in the map,
   * rather than a single amino acid character).
   * 
   * @param mRNA - a queue containing the mRNA sequence corresponding to the stored DNA sequence
   * 
   * @return (LinkedQueue<String>) the queue containing the amino acid sequence corresponding to the
   *         provided mRNA sequence
   */
  public LinkedQueue<String> mRNATranslate(LinkedQueue<Character> mRNA) {
    // Do any exceptions need to be considered?
    LinkedQueue<String> aminoAcidChain = new LinkedQueue<String>();
    String Codons = "";
    while (!mRNA.isEmpty() && mRNA.size() >= 3) {
      Codons = "";
      for (int i = 0; i < 3; i++) {
        Codons = Codons + mRNA.dequeue();
      }

      for (int i = 0; i < mRNAtoProteinMap.length; i++) {
        if (Codons.equals(mRNAtoProteinMap[i][0])) {
          if (!mRNAtoProteinMap[i][1].equals("STOP")) {
            aminoAcidChain.enqueue(mRNAtoProteinMap[i][1]);
          }

          else {
            return aminoAcidChain;
          }
        }
      }
    }
    return aminoAcidChain;
  }

  /**
   * A shortcut method that translates the stored DNA sequence to a queue of amino acids using the
   * other two methods in this class
   * 
   * @return (LinkedQueue<String>) the queue containing the amino acid sequence corresponding to the
   *         stored DNA sequence, via its mRNA transcription
   */
  public LinkedQueue<String> translateDNA() {
    LinkedQueue<Character> mRNA; // Should I equate this to null?
    LinkedQueue<String> aminoAcidChain; // Should I equate this to null?
    mRNA = transcribeDNA();
    aminoAcidChain = mRNATranslate(mRNA);
    return aminoAcidChain;
  }
}
