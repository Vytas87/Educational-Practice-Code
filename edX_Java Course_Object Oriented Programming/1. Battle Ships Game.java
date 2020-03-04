/**********************************************************************************************
    Following the introductory course Learn to Program in Java, the projects get a little more
    complex.
    
    This one is a program simulating a well known game of Battle Ships. Both the user and
    computer deploy their ships and start shooting one shot at a time and in turn until one of
    the players sinks all of the other's ships.
***********************************************************************************************/

import java.awt.*;
import java.util.*;

public class BattleShipsGame {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        Random r = new Random();

        // Create the ocean map
        System.out.println("**** Welcome to the Battle Ships game ****");
        System.out.println("Right now, the ocean is empty:");
        String[][] ocean = new String[10][10];
        oceanMap (ocean);

        // Deploy user ships
        oceanMap(deployUserShips(ocean, input));

        // Deploy computer ships
        deployComputerShips(ocean, r);

        // Play the game
        System.out.println("All the ships are now deployed and you can start playing the game.");

        ArrayList<Point> computerAllMoves = new ArrayList<>();
        Point computerNewMove = new Point ();

        while (getScore(ocean)[0] != 0 && getScore(ocean)[1] != 0) {
            userMove(ocean, input);
            oceanMap(ocean);
            scoreStatus(ocean);

            if (getScore(ocean)[0] == 0){
                System.out.println("Sorry! You have been defeated.");
                System.out.println();
            } else if ( getScore(ocean)[1] == 0){
                System.out.println("Hurray! You won the battle!");
                System.out.println();
            } else {
                String computerHits = computerMove(ocean, r, computerAllMoves, computerNewMove);
                if (computerHits != null && (computerHits.equals("x") || computerHits.equals("!"))) {
                    oceanMap(ocean);
                    scoreStatus(ocean);
                }

                if (getScore(ocean)[0] == 0) {
                    System.out.println("Sorry! You have been defeated.");
                    System.out.println();
                } else if (getScore(ocean)[1] == 0) {
                    System.out.println("Hurray! You won the battle!");
                    System.out.println();
                }
            }
        }
    }

    public static void oceanMap(String[][] ocean) {
        System.out.println();
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        System.out.println("  - - - - - - - - - -");
        for (int i = 0; i < ocean.length; i++){
            System.out.print(i + "|");
            for (int j = 0; j < ocean[i].length; j++){
                if (ocean[i][j] == null || ocean[i][j].equals("2")) {
                    System.out.print("  ");
                } else if (ocean[i][j].equals("1")) {
                    System.out.print("@ ");
                } else if (ocean[i][j].equals("x")) {
                    System.out.print("x ");
                } else if (ocean[i][j].equals("!")) {
                    System.out.print("! ");
                } else if (ocean[i][j].equals("-")) {
                    System.out.print("- ");
                }
            }
            System.out.println("|" + i);
        }
        System.out.println("  - - - - - - - - - -");
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        System.out.println();
    }

    public static String[][] deployUserShips(String[][] userShips, Scanner input) {
        System.out.println("You have 5 ships, which you can deploy anywhere in the ocean.");
        System.out.println("Deploy your ships:");
        for (int i = 1; i <= 5; i++) {
            getUserCoordinates(i, userShips, input);
        }
        return userShips;
    }

    public static void getUserCoordinates(int i, String[][] userShips, Scanner input){

        System.out.print("Enter X coordinate for your " + i + " ship: ");
        int x = enterLegalX(input);

        System.out.print("Enter Y coordinate for your " + i + " ship: ");
        int y = enterLegalY(input);


        if (userShips[x][y] == null) {
            userShips[x][y] = "1";

        } else {
            System.out.println("You already have a ship deployed at coordinates (" + x + ", " + y + ").");
            System.out.println("Please, try again!");
            getUserCoordinates(i, userShips, input);
        }
    }

    public static int enterLegalX(Scanner input){
        int x = input.nextInt();
        while (x < 0 || x > 9){
            System.out.print("Coordinate out of ocean bounds. Please, try again: ");
            x = input.nextInt();
        }
        return x;
    }

    public static int enterLegalY(Scanner input){
        int y = input.nextInt();
        while (y < 0 || y > 9){
            System.out.print("Coordinate out of ocean bounds. Please, try again: ");
            y = input.nextInt();
        }
        return y;
    }

    public static void deployComputerShips(String[][] computerShips, Random r) {
        System.out.println("Computer is deploying ships:");
        for (int i = 1; i <= 5; i++) {
            getComputerCoordinates(computerShips, r);
            System.out.println("Computer has deployed " + i + " ship.");
        }
        System.out.println();

    }

    public static void getComputerCoordinates(String[][] computerShips, Random r){
        int x = r.nextInt(10);
        int y = r.nextInt(10);

        if (computerShips[x][y] == null) {
            computerShips[x][y] = "2";
        } else {
            getComputerCoordinates(computerShips, r);
        }
    }

    public static void userMove(String[][] ocean, Scanner input){
        System.out.println("YOUR TURN");

        System.out.print("Enter X coordinate: ");
        int x = enterLegalX(input);

        System.out.print("Enter Y coordinate: ");
        int y = enterLegalY(input);

        while (ocean[x][y] != null && (ocean[x][y].equals("-") || ocean[x][y].equals("x") || ocean[x][y].equals("!"))){
            System.out.println("You have already made a shot to or the ship has been sunk at coordinates (" + x + ", " + y + ").");
            System.out.println("Please, try again!");

            System.out.print("Enter X coordinate: ");
            x = enterLegalX(input);

            System.out.print("Enter Y coordinate: ");
            y = enterLegalY(input);
        }

        if (ocean[x][y] == null) {
            System.out.println("Sorry, you missed.");
            ocean[x][y] = "-";

        } else if (ocean[x][y].equals("1")){
            System.out.println("Oh no, you sunk your own ship!");
            ocean[x][y] = "x";

        } else if (ocean[x][y].equals("2")){
            System.out.println("Boom! You sunk the enemy ship!");
            ocean[x][y] = "!";
        }
    }

    public static String computerMove(String[][] ocean, Random r, ArrayList<Point> computerAllMoves, Point computerNewMove){
        System.out.println("COMPUTER'S TURN");

        int x = r.nextInt(10);
        int y = r.nextInt(10);
        computerNewMove.move(x, y);
        while (!computerAllMoves.isEmpty() && (computerAllMoves.contains(computerNewMove) || ocean[x][y].equals("x") || ocean[x][y].equals("!"))){
            x = r.nextInt(10);
            y = r.nextInt(10);
            computerAllMoves.add(computerNewMove);
        }

        if (ocean[x][y] == null || ocean[x][y].equals("-")) {
            System.out.println("Computer missed.");
            System.out.println();

        } else if (ocean[x][y].equals("2")){
            System.out.println("The computer sunk one of its own ships!");
            ocean[x][y] = "!";

        } else if (ocean[x][y].equals("1")){
            System.out.println("The computer sunk one of your ships!!");
            ocean[x][y] = "x";
        }

        return ocean[x][y];
    }

    public static int[] getScore (String[][] ocean){
        int[] score = new int[2];
        for (String[] i : ocean){
            for (String j : i){
                if (j != null && j.equals("1")){
                    score[0]++;
                } else if (j != null && j.equals("2")){
                    score[1]++;
                }
            }
        }
        return score;
    }

    public static void scoreStatus (String[][] ocean){
        System.out.println("Your ships: " + getScore(ocean)[0] + " | " + "Computer ships: " + getScore(ocean)[1]);
        System.out.println();
    }
}
