/**********************************************************************************************
Write a Java program called DollarFigure that produces the following output. Use nested for
loops to capture the structure of the figure.

                    $$$$$$$**************$$$$$$$
                    **$$$$$$************$$$$$$**
                    ****$$$$$**********$$$$$****
                    ******$$$$********$$$$******
                    ********$$$******$$$********
                    **********$$****$$**********
                    ************$**$************

***********************************************************************************************/

public class DollarFigure {
    public static final int SIZE = 7;
    
    public static void main(String[] args) {
        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= 2 * (i - 1); j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= SIZE - i + 1; j++) {
                System.out.print("$");
            }
            for (int j = 1; j <= 2 * (SIZE - i + 1); j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= SIZE - i + 1; j++) {
                System.out.print("$");
            }
            for (int j = 1; j <= 2 * (i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
