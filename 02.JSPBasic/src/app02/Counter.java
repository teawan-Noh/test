package app02;

public class Counter {
   public static int count = 1;
   
   public static int getCount() {
      return count++;
   }
}