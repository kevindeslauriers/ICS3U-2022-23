package assignments;

import java.util.Scanner;

public class Hangman {

   public static final int MAX_BODY_PARTS = 7;
   public static Scanner in = new Scanner(System.in);
   public static final String VALID_CHARS = "ABCDEFGHIOJKLMNOPQRSTUVWXYZ";
   private static final int LETTER = 0;

   public static void main(String[] args) {
      String phrase = getPhrase();
      int numWrong = 0;
      String chosenLetters = "";

      while (numWrong < MAX_BODY_PARTS) {
         displayEncodedPhrase(phrase, chosenLetters);

         // int option = getPlayerOption();
         // if (option == LETTER) {
         String letter = getLetter(chosenLetters);
         chosenLetters += letter;
         if (!isInPhrase(letter, phrase)) {
            numWrong++;
            drawHangman(numWrong);
         }
         // } else {
         // get solution
         // }

         if (numWrong == MAX_BODY_PARTS)
            System.out.println("You Lose!");
      }

   }

   private static int getPlayerOption() {
      // 1 for letter
      // 2 for solve
      // create constants for these

      return 1;
   }

   private static boolean isInPhrase(String letter, String phrase) {
      return phrase.indexOf(letter) >= 0;
   }

   private static String getLetter(String chosenLetters) {

      while (true) {
         System.out.print("Please enter a letter. Chosen Letter are: ");
         getLettersString(chosenLetters);

         String letter = in.nextLine().toUpperCase();

         if (letter.length() > 1)
            System.out.println("Only one letter please!");
         else if (VALID_CHARS.indexOf(letter) < 0)
            System.out.println("Only valid letters please (A-Z)!");
         else if (chosenLetters.indexOf(letter) >= 0)
            System.out.println("You already chose that letter!");
         else
            return letter;

      }

   }

   private static void getLettersString(String chosenLetters) {
      displayEncodedPhrase(VALID_CHARS, chosenLetters);
   }

   private static void displayEncodedPhrase(String phrase, String chosenLetters) {
      /*
       * Phrase: THIS IS GOOD
       * ENCODED: _ _ I _ / I _ / _ _ _ _
       * 
       * 
       * 
       */

      String result = "";
      for (int i = 0; i < phrase.length(); i++) {
         String letter = phrase.substring(i, i + 1);
         if (letter.equals(" "))
            result += "/ ";
         else if (chosenLetters.indexOf(letter) >= 0)
            result += (letter + " ");
         else
            result += "_ ";
      }

      System.out.println(result);

   }

   private static String getPhrase() {
      boolean validPhrase = false;
      String phrase = "";
      while (!validPhrase) {
         System.out.println("Please enter a valid phrase (letters and spaces only): ");
         phrase = in.nextLine().toUpperCase();
         validPhrase = true;
         for (int i = 0; i < phrase.length(); i++) {
            String letter = phrase.substring(i, i + 1);
            if ((VALID_CHARS + " ").indexOf(letter) < 0)
               validPhrase = false;
         }
      }

      return phrase;

   }

   public static void drawHangman(int numBodyParts) {
      if (numBodyParts == 7) {
         System.out.println(" _______");
         System.out.println("|       |");
         System.out.println("|       o");
         System.out.println("|      /|\\");
         System.out.println("|       |");
         System.out.println("|     _/ \\_");
         System.out.println("|");
         System.out.println("----------------");
      } else if (numBodyParts == 6) {
         System.out.println(" _______");
         System.out.println("|       |");
         System.out.println("|       o");
         System.out.println("|      /|\\");
         System.out.println("|       |");
         System.out.println("|     _/");
         System.out.println("|");
         System.out.println("----------------");
      } else if (numBodyParts == 5) {
         System.out.println(" _______");
         System.out.println("|       |");
         System.out.println("|       o");
         System.out.println("|      /|\\");
         System.out.println("|       |");
         System.out.println("|");
         System.out.println("|");
         System.out.println("----------------");
      } else if (numBodyParts == 4) {
         System.out.println(" _______");
         System.out.println("|       |");
         System.out.println("|       o");
         System.out.println("|      /|\\");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("----------------");
      } else if (numBodyParts == 3) {
         System.out.println(" _______");
         System.out.println("|       |");
         System.out.println("|       o");
         System.out.println("|      /|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("----------------");
      } else if (numBodyParts == 2) {
         System.out.println(" _______");
         System.out.println("|       |");
         System.out.println("|       o");
         System.out.println("|       |");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("----------------");
      } else if (numBodyParts == 1) {
         System.out.println(" _______");
         System.out.println("|       |");
         System.out.println("|       o");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("----------------");
      } else if (numBodyParts == 0) {
         System.out.println(" _______");
         System.out.println("|       |");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("----------------");
      }
   }
}
