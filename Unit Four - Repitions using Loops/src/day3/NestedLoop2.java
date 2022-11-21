package day3;

public class NestedLoop2 {

   public static void main(String[] args) {
      int counter = 0;
      for (int i = 0; i < 5; i++) {
         for (int j = 0; j < i; j++) {
            System.out.print("+");
         }
         System.out.println();
      }

      // for (int i = 0; i < 5; i++) {

      // for (int j = 0; j < i; j++) {
      // System.out.print("+");
      // }
      // System.out.println();
      // }

   }
}