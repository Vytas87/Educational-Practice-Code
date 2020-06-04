/**********************************************************************************************
Write a Java program in a class named Window that produces the preceding figure as output. Use
nested for loops to print the repeated parts of the figure. Once you get it to work, add one
class constant to your program so that the size of the figure can be changed simply by changing
that constant's value. The example output shown is at a constant size of 3, but if you change
the constant, the figure should grow larger and wider proportionally.

                    +===+===+
                    |   |   |
                    |   |   |
                    |   |   |
                    +===+===+
                    |   |   |
                    |   |   |
                    |   |   |
                    +===+===+

(You must solve this problem using only ONE public static final constant, not multiple constants;
and its value must be used in the way described in this problem.)
***********************************************************************************************/

public class Window {
    public static final int SIZE = 3;
    
    public static void main(String[] args) {
        horizontalBar();
        verticalBars();
        horizontalBar();
        verticalBars();
        horizontalBar();
    }
    
    public static void horizontalBar() {
        System.out.print("+");
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= SIZE; j++) {
                System.out.print("=");
            }
            System.out.print("+");
        }
        System.out.println();
    }
    
    public static void verticalBars() {
        for (int i = 1; i <= SIZE; i++) {
            System.out.print("|");
            for (int j = 1; j <= 2; j++) {
                for (int k = 1; k <= SIZE; k++) {
                    System.out.print(" ");
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }
}
