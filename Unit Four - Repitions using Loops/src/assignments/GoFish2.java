package assignments;

import java.util.Scanner;

public class GoFish2 {

   public static final int NUM_SUITS = 4;
   public static final int NUM_FACES = 13;
   public static final int NUM_CARDS_TO_START = 5;

   public static void main(String[] args) {
      goFish();
   }

   private static String takeTurn(String reqHand, String respHand, String card) {

      if (hasCard(respHand, card)) {
         String respCard = getCard(respHand, card);
         if (hasCard(reqHand, card)) {
            reqHand = removeCard(reqHand, card);
            respHand = removeCard(respHand, card);
         } else {
            respHand = removeCard(respHand, card);
            reqHand += respCard + " ";
         }
      } else {
         reqHand += getCard() + " ";
      }

      return reqHand + "_" + respHand;

   }

   /*
    * Returns the card with suit from cards.
    * This function only works if the card is there.
    */
   private static String getCard(String cards, String card) {
      int startIndex = cards.indexOf(card);

      if (card.equals("10"))
         return cards.substring(startIndex, startIndex + 3);
      else
         return cards.substring(startIndex, startIndex + 2);
   }

   private static String removeCard(String cards, String card) {
      String temp = cards.replaceFirst(card + "H ", "");

      if (temp.length() != cards.length())
         return temp;

      temp = cards.replaceFirst(card + "C ", "");

      if (temp.length() != cards.length())
         return temp;

      temp = cards.replaceFirst(card + "S ", "");

      if (temp.length() != cards.length())
         return temp;

      temp = cards.replaceFirst(card + "D ", "");

      return temp;

   }

   /*
    * returns true if card is in cards
    */
   private static boolean hasCard(String cards, String card) {
      return cards.indexOf(card) >= 0;
   }

   private static void goFish() {
      Scanner in = new Scanner(System.in);
      String playerHand = "";
      String computerHand1 = "";
      String computerHand2 = "";
      String computerHand3 = "";

      int playerScore = 0;
      int cpScore1 = 0;
      int cpScore2 = 0;
      int cpScore3 = 0;

      for (int i = 1; i <= NUM_CARDS_TO_START; i++) {
         playerHand += getCard() + " ";
         computerHand1 += getCard() + " ";
         computerHand2 += getCard() + " ";
         computerHand3 += getCard() + " ";
      }

      displayHand("Player", playerHand, false, playerScore);
      displayHand("Computer 1", computerHand1, false, cpScore1);
      displayHand("Computer 2", computerHand2, false, cpScore2);
      displayHand("Computer 3", computerHand3, false, cpScore3);

      System.out.print("What card are you looking for: ");
      String card = in.nextLine();

      String result = takeTurn(computerHand2, computerHand1, card);

      cpScore2 += pointsReceived(computerHand2, result);

      computerHand2 = result.substring(0, result.indexOf("_"));
      computerHand1 = result.substring(result.indexOf("_") + 1);

      displayHand("Player", playerHand, false, playerScore);
      displayHand("Computer 1", computerHand1, false, cpScore1);
      displayHand("Computer 2", computerHand2, false, cpScore2);
      displayHand("Computer 3", computerHand3, false, cpScore3);

   }

   private static int pointsReceived(String playerHandBefore, String result) {
      String playerHandAfter = result.substring(0, result.indexOf("_"));
      if (playerHandBefore.length() > playerHandAfter.length()) {
         return 1;
      } else {
         return 0;
      }

   }

   private static void displayHand(String playerName, String hand, boolean isHidden, int score) {

      System.out.print(playerName + " (" + score + "): ");

      if (isHidden) {
         int i = 0;
         while (hand.indexOf(" ", i) >= 0) {
            System.out.print("XX ");
            i = hand.indexOf(" ", i) + 1;
         }
         System.out.println();
      } else {
         System.out.println(hand);
      }

   }

   public static String getCard() {
      return getFace() + getSuit();
   }

   public static String getFace() {
      int x = (int) (Math.random() * NUM_FACES) + 2;

      if (x <= 10)
         return "" + x;
      else if (x == 11)
         return "J";
      else if (x == 12)
         return "Q";
      else if (x == 13)
         return "K";
      else
         return "A";

   }

   public static String getSuit() {
      int x = (int) (Math.random() * NUM_SUITS);
      if (x == 0)
         return "S";
      else if (x == 1)
         return "D";
      else if (x == 2)
         return "H";
      else
         return "C";
   }
}