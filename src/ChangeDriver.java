
import java.util.InputMismatchException;
import java.util.Scanner;

public class ChangeDriver extends Change{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double price = 0;
        double payment = 0;
        countChange();
        while(gameInProgress == true) {
            System.out.println("Please input the price of your item");
            price = scanner.nextDouble();
            System.out.println("Please input the number of $20's you are paying with");
            numTwenties = scanner.nextInt();
            System.out.println("Please input the number of $10's you are paying with");
            numTens = scanner.nextInt();
            System.out.println("Please input the number of $5's you are paying with");
            numFives = scanner.nextInt();
            System.out.println("Please input the number of $1's you are paying with");
            numOnes = scanner.nextInt();
            System.out.println("Please input the number of quarters you are paying with");
            numQuarters = scanner.nextInt();
            System.out.println("Please input the number of dimes you are paying with");
            numDimes = scanner.nextInt();
            System.out.println("Please input the number of nickels you are paying with");
            numNickels = scanner.nextInt();
            System.out.println("Please input the number of pennies you are paying with");
            numPennies = scanner.nextInt();

            payment = numTwenties * 20 + numTens * 10 + numFives * 5 + numOnes * 1 + numQuarters * .25 + numDimes * .1 + numNickels * .05 + numPennies * .01;

            transaction(price, payment);
            System.out.println("Would you like to purchase another item? (true/false)");
            try{
                gameInProgress = scanner.nextBoolean();
            } catch(Exception e){
                boolean x = true;
                while(x==true) {
                    System.out.println("Input either true or false");
                    gameInProgress = scanner.nextBoolean();
                    if(gameInProgress == true || gameInProgress == false){
                        x = false;
                    }else { x = true;}


                }

            }
        }
    }
}