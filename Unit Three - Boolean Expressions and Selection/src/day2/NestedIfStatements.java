package day2;

public class NestedIfStatements {
   public static void main(String[] args) {
      // nested means inside something
      // nested if statements - an if statement inside an if statement

      boolean isRed = true;
      boolean isBig = true;
      int x = 7;
      int y = 8;

      if (x > 8) {
         if (isRed)
            y++;
      } else {
         y--;
      }

      if (x > 8 && isRed) {
         y++;
      } else {
         y--;
      }

      // if (x > 8)
      // if (isRed)
      // y++;
      // else {
      // y--;
      // }

      System.out.println(y);

   }
}
