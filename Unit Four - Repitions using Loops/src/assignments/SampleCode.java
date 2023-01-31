package assignments;

public class SampleCode {
   public static void main(String[] args) {

      String str = "abcdef";
      System.out.println("Before method: " + str);
      String temp = testMethod(str);

      str = temp.substring(0, temp.indexOf("~"));

      int numPoints = Integer.parseInt(temp.substring(temp.indexOf("~") + 1));

      System.out.println("After method: " + str);

   }

   private static String testMethod(String str) {

      int numPoints = 1;

      System.out.println("Inside method: " + str);
      str += "hello";
      System.out.println("Inside method: " + str);
      return str + "~" + numPoints;
   }
}
