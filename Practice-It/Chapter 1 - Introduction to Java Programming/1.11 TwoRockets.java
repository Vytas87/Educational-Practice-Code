/**********************************************************************************************
Write a complete Java program in a class named TwoRockets that generates the following output.
Use static methods to show structure and eliminate redundancy in your solution.

Note that there are two rocket ships next to each other. What redundancy can you eliminate
using static methods? What redundancy cannot be eliminated?

                       /\       /\
                      /  \     /  \
                     /    \   /    \
                    +------+ +------+
                    |      | |      |
                    |      | |      |
                    +------+ +------+
                    |United| |United|
                    |States| |States|
                    +------+ +------+
                    |      | |      |
                    |      | |      |
                    +------+ +------+
                       /\       /\
                      /  \     /  \
                     /    \   /    \

***********************************************************************************************/

public class TwoRockets {
    public static final int NUM_OF_ROCKETS = 2;
    
    public static void main (String[] args) {
        triangle(NUM_OF_ROCKETS);
        box(NUM_OF_ROCKETS);
        boxUS(NUM_OF_ROCKETS);
        box(NUM_OF_ROCKETS);
        triangle(NUM_OF_ROCKETS);
    }
    
    public static void triangle(int n) {
        for (int line = 1; line <=3; line++) {
            for (int numOfRockets = 1; numOfRockets <= n; numOfRockets++) {
                for (int i = 1; i <= 4 - line; i++) {
                    System.out.print(" ");
                }
                System.out.print("/");
                for (int i = 1; i <= 2 * (line - 1); i++) {
                    System.out.print(" ");
                }
                System.out.print("\\");
                for (int i = 1; i <= 3 - line; i++) {
                    System.out.print(" ");
                }
                if (numOfRockets < n) {
                    System.out.print("  ");
                } else {
                    System.out.println("");
                }
            }
        }
    }
    
    public static void box(int n) {
        for (int line = 1; line <= 4; line++) {
            for (int numOfRockets = 1; numOfRockets <= n; numOfRockets++) {
                if (line == 1 || line == 4) {
                    System.out.print("+------+");
                }
                if (line != 1 && line != 4) {
                    System.out.print("|      |");
                }
                if (numOfRockets < n) {
                    System.out.print(" ");
                } else {
                    System.out.println("");
                }
            }
        }
    }
    
    public static void boxUS(int n) {
        for (int line = 1; line <= 2; line++) {
            for (int numOfRockets = 1; numOfRockets <= n; numOfRockets++) {
                if (line == 1) {
                    System.out.print("|United|");
                }                
                if (line == 2) {
                    System.out.print("|States|");
                }                
                if (numOfRockets < n) {
                    System.out.print(" ");
                } else {
                    System.out.println("");
                }            
            }
        }
    }
}
