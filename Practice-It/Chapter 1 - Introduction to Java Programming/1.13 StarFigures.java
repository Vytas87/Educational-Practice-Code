/**********************************************************************************************
Write a complete Java program in a class named StarFigures that generates the following output.
Use static methods to show structure and eliminate redundancy in your solution.

                    *****
                    *****
                     * *
                      *
                     * *

                    *****
                    *****
                     * *
                      *
                     * *
                    *****
                    *****

                      *
                      *
                      *
                    *****
                    *****
                     * *
                      *
                     * *

***********************************************************************************************/

public class StarFigures {
    public static void main(String[] args) {
        starFigure();
        System.out.println("");
        starFigure();
        starLines();
        System.out.println("");
        starColumn();
        starFigure();
    }
    
    public static void starFigure() {
        for (int line = 1; line <= 5; line++) {
            if (line == 1 || line == 2) {
                System.out.println("*****");
            } else if (line == 3 || line == 5) {
                for (int i = 1; i <= 5; i++) {
                    if (i % 2 == 1) {
                        System.out.print(" ");
                    } else {
                        System.out.print("*");
                    }
                }
                System.out.println("");
            } else {
                for (int i = 1; i <= 5; i++) {
                    if (i == 3) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }                
                System.out.println("");
            }
        }
    }
    
    public static void starLines() {
        System.out.println("*****");
        System.out.println("*****");
    }
    
    public static void starColumn() {
        System.out.println("  *");
        System.out.println("  *");
        System.out.println("  *");
    }
}
