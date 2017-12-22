import java.security.KeyStore.Entry;
import java.util.Scanner;
public class GuessMyNumber
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      String entry = "";
      do
      {
         System.out.println("Enter the upper limit for the number. Try at least 100!");
         int upperLimit = input.nextInt();
         if (upperLimit < 100)
            System.out.println("Try a higher number next time!");
         else
            ;
         int winNum = (int)(Math.random()*upperLimit) + 1;
         System.out.println("Enter the amount of guesses");
         int maxGuesses = input.nextInt();
         
         int guessCounter = 0;
         int guess = 0;
         while(guess != winNum && guessCounter < maxGuesses)
         {
            System.out.println("Enter a guess from 1 to " + upperLimit + ".");
            System.out.println((maxGuesses-guessCounter) + " guesses remaining.");
            guess = input.nextInt();
            guessCounter++;
            if (guess < winNum)
               System.out.println("Higher.");
            else if (guess > winNum)
               System.out.println("Lower.");
         }
         if (guess != winNum)
            System.out.println("The winning number was " + winNum + ". Try again?");
         else
            System.out.println("You guessed it in " + guessCounter + " guesses. You used " + ((double)guessCounter/(double)maxGuesses)*100 + "% of your guesses.");

         System.out.print("Play again?(Y/N) :");
         input.nextLine();
         entry = input.nextLine();
         
      }while(entry.equalsIgnoreCase("Y"));
   }
}
