/**********************************************************************************************
    The goal of the project was to help user navigate the maze given its parameters and provide
    with appropriate warnings, messages and, eventually, the outcome of the attempt to find the
    exit in a given number of steps.
***********************************************************************************************/

import java.util.Scanner;

public class MazeRunner {

    public static void main (String[] args) {
        try {
            MazeRunner obj = new MazeRunner ();
            obj.run (args);
        }
        catch (Exception e) {
            e.printStackTrace ();
        }
    }

    Maze myMap = new Maze();

    public void run (String[] args) throws Exception {
        intro();
        userMove();
    }

    public void intro (){
        System.out.println("Welcome to Maze Runner!");
        System.out.println("Here's your current position:");
        myMap.printMap();
        System.out.println("----------------------------------------");
    }

    public void userMove () {
        System.out.println("Where would you like to move?\nR - right\nL - left\nU - up\nD - down");
        Scanner input = new Scanner(System.in);
        String userMove = input.next();

        int movesCount = 1;

        while (myMap.didIWin() == false && movesCount <= 100) {

            while (userMove.length() > 1 ||
                    (userMove.charAt(0) != 'R' &&
                            userMove.charAt(0) != 'L' &&
                            userMove.charAt(0) != 'U' &&
                            userMove.charAt(0) != 'D')) {
                System.out.println("Invalid entry! Please, try one of the capital letters: R, L, U or D.");
                System.out.println("Where would you like to move? ");
                userMove = input.next();
            }

            if (myMap.isThereAPit(userMove)) {
                navigatePit(userMove);
            }

            if (userMove.equals("R") && myMap.canIMoveRight()) {
                myMap.moveRight();
                myMap.printMap();
                System.out.println("----------------------------------------");
            } else if (userMove.equals("L") && myMap.canIMoveLeft()) {
                myMap.moveLeft();
                myMap.printMap();
                System.out.println("----------------------------------------");
            } else if (userMove.equals("U") && myMap.canIMoveUp()) {
                myMap.moveUp();
                myMap.printMap();
                System.out.println("----------------------------------------");
            } else if (userMove.equals("D") && myMap.canIMoveDown()) {
                myMap.moveDown();
                myMap.printMap();
                System.out.println("----------------------------------------");
            } else {
                System.out.println("Sorry, you've hit a wall");
            }

            if (myMap.didIWin()) {
                System.out.println("Congratulations, you made it out alive!");
            } else if (movesCount < 100){
                movesMessage(movesCount);
                System.out.println("Where would you like to move next? ");
                userMove = input.next();
                movesCount += 1;
            } else {
                movesMessage(movesCount);
                movesCount += 1;
            }
        }
    }

    public void movesMessage (int movesCount) {
        if (movesCount == 50) {
            System.out.println("----------------------------------------");
            System.out.println("Warning! You have made 50 moves, you have 50 remaining before the maze exit closes.");
            System.out.println("----------------------------------------");
        } else if (movesCount == 75) {
            System.out.println("----------------------------------------");
            System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
            System.out.println("----------------------------------------");
        } else if (movesCount == 90) {
            System.out.println("----------------------------------------");
            System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
            System.out.println("----------------------------------------");
        } else if (movesCount == 100) {
            System.out.println("----------------------------------------");
            System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
            System.out.println("Sorry, but you didn't escape in time - you lose!");
            System.out.println("----------------------------------------");
        }
    }

    public void navigatePit(String userMove) {
        System.out.println("Watch out! There's a pit ahead, jump it? ");
        Scanner input = new Scanner(System.in);
        String jump = input.next();

        if (jump.startsWith("y") || jump.startsWith("Y")) {
            myMap.jumpOverPit(userMove);
        } else {
            System.out.println("You don't want to jump it. Where would you like to move instead?");
            userMove = input.next();
        }
    }
}
