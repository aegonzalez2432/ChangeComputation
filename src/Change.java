import java.util.Random;
import java.lang.Math.*;

/**
 * This class is to implement a cash register and record multiple transactions or until the
 * register runs out of change
 */
public class Change {
        protected static double yourChange, registerBalance;
        protected static double price, payment, register;
        protected static Random rand = new Random();
        protected static int numTwenties, numTens, numFives, numOnes, numQuarters, numDimes, numNickels, numPennies;
        protected static boolean gameInProgress = true;
        protected static int regNumTwenties, regNumTens, regNumFives, regNumOnes, regNumQuarters, regNumDimes, regNumNickels, regNumPennies;

        /**countChange implements the easy part of the program, which takes in the price of the item being bought and
         * the payment being made. It then prints out the change the user gets back. When countChange() is called, the register initializes
         * random values to the register and informs the user of how much of each bill is in the register. This method is of type void
         * so there is no return
         */

        protected static void countChange(){

            regNumTwenties = rand.nextInt(16);
            regNumTens = rand.nextInt(16);
            regNumFives = rand.nextInt(16);
            regNumOnes = rand.nextInt(16);
            regNumQuarters = rand.nextInt(16);
            regNumNickels = rand.nextInt(16);
            regNumPennies = rand.nextInt(16);
            regNumDimes = rand.nextInt(16);
            register = moneyInRegister();

            System.out.println("There is: $" + register + " in the register");
            System.out.println("Twenties: " + regNumTwenties + "\t\tTens: " + regNumTens + "\t\tFives: " + regNumFives + "\t\tOnes: "
                    + regNumOnes + "\t\tQuarters: " + regNumQuarters + "\t\tDimes: " + regNumDimes + "\t\tNickels: " + regNumNickels + "\t\tPennies: " + regNumPennies);

        }

        /** moneyInRegister sums up the number of each kind of bill and returns the amount of money in the register
         *  register is added to sum up to be the number of each bill times the quantity of the bill
         *  after, register is multiplied by 100, rounded, and divided by 100 to eliminate decimal points larger than two hundredths
         * @return       the total amount of money in the register
         */
        protected static double moneyInRegister(){
            register = regNumTwenties*20 + regNumTens*10 + regNumFives*5 + regNumOnes*1 + regNumQuarters*.25 + regNumDimes*.1 + regNumNickels*.05 + regNumPennies*.01;
            register = register*100;
            if(register - Math.floor(register) >= 0.5) {
                register = Math.ceil(register);
            }else{ register = Math.floor(register);}

            register = register/100;

            return (register);

        }


        /**transaction handles whenever a customer wants to purchase an item.
        *
        * @param prc                price of item being purchased
        * @param pmnt               the total amount of money the customer is using to pay
         *
         *this method starts off adding the register money and the payment per bill and then calculates the change owed
         *If there is not enough money in register, throws an exception or a warning saying the register is out of change and
         *needs exact change. Otherwise, this method calculates the change owed to the customer and pays the customer based
         *off the bills in the register
         *transaction is a void type method so has no return variable
        */
        protected static void transaction(double prc, double pmnt){

            regNumTwenties += numTwenties;//add the payment to the register
            regNumTens += numTens;
            regNumFives += numFives;
            regNumOnes += numOnes;
            regNumQuarters += numQuarters;
            regNumDimes += numDimes;
            regNumNickels += numNickels;
            regNumPennies += numPennies;

            yourChange = pmnt - prc;
            //Allows for only two decimal places
            yourChange = yourChange*100;
            if(yourChange - Math.floor(yourChange) >= 0.5) {
                yourChange = Math.ceil(yourChange);
            }else{ yourChange = Math.floor(yourChange);}
            yourChange = yourChange/100;
            register = moneyInRegister();           //update register
            if(register < yourChange){
                throw new NullPointerException("Not enough money in the register");

            } else if(register == yourChange){ System.out.println("Register is now empty \n your next purchase must be an exact amount");}

            int howMany;//number of each bill
            System.out.print("Your change is: " + (pmnt - prc) + "\n");

            if(yourChange >= 20) {
                howMany = (int)(yourChange/20);
                if(regNumTwenties >= howMany) {
                    yourChange -= 20*howMany;
                    regNumTwenties -= howMany;
                    System.out.print("20's: " + howMany + "\t\t");
                }

            } if(yourChange >= 10){
                howMany = (int)(yourChange/10);
                if(regNumTens >= howMany) {
                    yourChange -= 10*howMany;
                    regNumTens -= howMany;
                    System.out.print("10's: " + howMany + "\t\t");
                }
            } if(yourChange >= 5){
                howMany = (int)(yourChange/5);
                if(regNumFives > howMany) {
                    yourChange -= 5*howMany;
                    regNumFives -= howMany;
                    System.out.print("5's: " + howMany + "\t\t");
                }
            } if(yourChange >= 1){
                howMany = (int)(yourChange/1);
                if(regNumOnes >= howMany) {
                    yourChange -= howMany;
                    regNumOnes -= howMany;
                    System.out.print("1's: " + howMany + "\t\t");
                }
            } if(yourChange >= .25){
                howMany = (int)(yourChange/.25);
                if(regNumQuarters >= howMany) {
                    yourChange -= .25 * howMany;
                    regNumQuarters -= howMany;
                    System.out.print("Quarters: " + howMany + "\t\t");
                }
            } if(yourChange >= .1){
                howMany = (int)(yourChange/.1);
                if(regNumDimes >= howMany) {
                    yourChange -= .1 * howMany;
                    regNumDimes -= howMany;
                    System.out.print("Dimes: " + howMany + "\t\t");
                }
            } if(yourChange >= .05){
                howMany = (int)(yourChange/.05);
                if(regNumNickels >= howMany) {
                    yourChange -= .05 * howMany;
                    regNumNickels -= howMany;
                    System.out.print("Nickels: " + howMany + "\t\t");
                }
            } if(yourChange >= .01){
                howMany = (int)(yourChange/.01);
                if(regNumPennies >= howMany) {
                    yourChange -= .01 * howMany;
                    regNumPennies -= howMany;
                    System.out.print("Pennies: " + howMany);
                }

            }
            register = moneyInRegister();
            // }
            System.out.println("\nThere is now $" + register + " in the register:\n");
            System.out.println("Twenties: " + regNumTwenties + "\t\tTens: " + regNumTens + "\t\tFives: " + regNumFives + "\t\tOnes: "
                    + regNumOnes + "\t\tQuarters: " + regNumQuarters + "\t\tDimes: " + regNumDimes + "\t\tNickels: " + regNumNickels + "\t\tPennies: " + regNumPennies);
        }
}
