/**********************************************************************************************
    Another introductory interactive project. This time it is a program to play the famous game
    Odds and Evens. The user is asked to pick odds or evens. The opposite is then computer's
    choice. The user is asked to put out a number of fingers, a computer selects a random number
    to represent its play and the outcome is determined by looking at the sum of the two -
    whether it is odd or even.
***********************************************************************************************/

import java.util.*;

public class OddsAndEvens {
    public static void main (String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Let's play a game called \"Odds and Evens\"");
        System.out.print("What is your name? ");
        String name = input.next();
        System.out.print("Hi, " + name + "! Which do you choose: (O)dds or (E)vens? ");
        String userPick = input.next();
        if (userPick.equals("O")) {
            System.out.println(name + " has picked Odds! The computer will be Evens.");
        } else {
            System.out.println(name + " has picked Evens! The computer will be Odds.");
        }
        System.out.println("-----------------------------------------------------------");

        System.out.print("How many \"fingers\" do you put out? ");
        int userNumber = input.nextInt();
        Random rand = new Random();
        int computerNumber = rand.nextInt(6);
        System.out.println("The computer plays " + computerNumber + " \"fingers\".");
        System.out.println("-----------------------------------------------------------");

        int sum = userNumber + computerNumber;
        System.out.println(userNumber + " + " + computerNumber + " = " + sum);
        if (sum % 2 == 0) {
            System.out.println(sum + " is... " + "even!");
            if (userPick.equals("O")){
                System.out.println("This means computer wins! :)");
            } else {
                System.out.println("This means " + name + " wins! :)");
            }
        } else {
            System.out.println(sum + " is... " + "odd!");
            if (userPick.equals("O")){
                System.out.println("This means " + name + " wins! :)");
            } else {
                System.out.println("This means computer wins! :)");
            }
        }
        System.out.println("-----------------------------------------------------------");
    }
}
