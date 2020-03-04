/**********************************************************************************************
    A program that simulates another famous game "Rock, Paper, Scissors" by asking choices of
    twp players and giving an outcome on which player wins.
    
    The commented out section is another working version of the simulated game. It is shorter,
    but less readable.
***********************************************************************************************/

import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Does Player 1 choose rock, paper or scissors? ");
        String playerOne = input.next();
        System.out.print("Does Player 2 choose rock, paper or scissors? ");
        String playerTwo = input.next();

        /*
        if ((playerOne.equals("rock") && playerTwo.equals("scissors")) ||
            (playerOne.equals("scissors") && playerTwo.equals("paper")) ||
            (playerOne.equals("paper") && playerTwo.equals("rock"))) {
            System.out.println("Player 1 wins.");
        } else if ((playerOne.equals("rock") && playerTwo.equals("rock")) ||
            (playerOne.equals("paper") && playerTwo.equals("paper")) ||
            (playerOne.equals("scissors") && playerTwo.equals("scissors"))) {
            System.out.println("Tie.");
        } else {
            System.out.println("Player 2 wins.");
        }
        */


        if (playerOne.equals("rock")) {
            if (playerTwo.equals("scissors")) {
                System.out.println("Player 1 wins.");
            } else if (playerTwo.equals("paper")) {
                System.out.println("Player 2 wins.");
            } else { // playerTwo.equals("rock")
                System.out.println("Tie.");
            }
        } else if (playerOne.equals("paper")) {
            if (playerTwo.equals("scissors")) {
                System.out.println("Player 2 wins.");
            } else if (playerTwo.equals("paper")) {
                System.out.println("Tie.");
            } else { // playerTwo.equals("rock")
                System.out.println("Player 1 wins.");
            }
        } else { //playerOne.equals("scissors")
            if (playerTwo.equals("scissors")) {
                System.out.println("Tie.");
            } else if (playerTwo.equals("paper")) {
                System.out.println("Player 1 wins.");
            } else { // playerTwo.equals("rock")
                System.out.println("Player 2 wins.");
            }

        }
    }
}
