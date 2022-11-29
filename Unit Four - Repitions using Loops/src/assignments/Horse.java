package assignments;

import java.io.IOException;

public class Horse {
   public static void main(String[] args) throws IOException, InterruptedException {

      int[] horsePos = { 1, 1, 1, 1, 1, 1 };
      int j = 0;
      while (j < 100) {
         for (int i = 0; i < horsePos.length; i++) {
            horsePos[i] += (int) (Math.random() * 3);
         }

         for (int i = 0; i < horsePos.length; i++) {
            System.out.printf("%" + horsePos[i] + "s" + "\n", "o");

         }
         j++;
         Thread.sleep(200);
         clrscr();
      }
   }

   public static void clrscr() {
      // Clears Screen in java
      try {
         if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
         else
            Runtime.getRuntime().exec("clear");
      } catch (IOException | InterruptedException ex) {
      }
   }
}
