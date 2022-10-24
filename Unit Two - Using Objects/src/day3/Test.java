package day3;

public class Test {
   public static void main(String[] args) {
      CoffeeCup cup1 = new CoffeeCup(16, true);
      CoffeeCup cup2 = new CoffeeCup(20, false);
      CoffeeCup cup3;

      cup1.isFull();
      cup2.isFull();

      System.out.println(CoffeeCup.num);

      CoffeeCup.addOne();
      CoffeeCup.addOne();

      System.out.println(CoffeeCup.num);

      // cup1.isFull();

   }
}
