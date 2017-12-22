package intro_pd6;

import java.util.Scanner;

public class SlopeTester
{

   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      
      System.out.println("Enter x1: ");
      int x1 = input.nextInt();
      System.out.println("Enter y1: ");
      int y1 = input.nextInt();
      System.out.println("Enter x2: ");
      int x2 = input.nextInt();
      System.out.println("Enter y2: ");
      int y2 = input.nextInt();
      double slope = (double)(y2 - y1)/(double)(x2 - x1);
      System.out.println(slope);
      
      
      String equation = "";
      
      if (x2==x1)
      {
         System.out.println("Vertical Line");
         equation = "x = " + x1;
      }
      else if (slope>0)
      {
         System.out.println("Positive slope");
         equation = "y = " + slope + "x + " + y1 - slope*x1;
      }
      else if (slope<0)
      {
         System.out.println("Negative slope");
         equation = "y = ";
      }
      else
      {
         System.out.println("Horizontal Line");
         equation = "y = " + y1;
      }
      System.out.println(equation);
      
   }

}
