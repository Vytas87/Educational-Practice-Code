/**********************************************************************************************
Modify your code from the previous exercise so that it could easily be modified to display a
different range of numbers (instead of 1234567890) and a different number of repetitions of
those numbers (instead of 60 total characters), with the vertical bars still matching up cor-
rectly. Write a complete class named NumbersOutput. Use two class constants instead of "magic
numbers,", with one constant set to 6 for the number of repetitions, and the other set to 10
for the range of numbers. Put the for loop code in your class's main method.

For example, if your number-of-repetitions constant is set to 7 and your range constant is set
to 5, the output should be the following:

                        |    |    |    |    |    |    |
                    12340123401234012340123401234012340

***********************************************************************************************/

public class NumbersOutput {
    public static final int NO_OF_COLUMNS = 6;
    public static final int COLUMN_WIDTH = 10;

    public static void main(String[] args) {
        
        for (int i = 1; i <= NO_OF_COLUMNS; i++) {
            for (int j = 1; j <= COLUMN_WIDTH - 1; j++) {
                System.out.print(" ");
            }
            System.out.print("|");
        }
       
        System.out.println();
        
        for (int i = 1; i <= NO_OF_COLUMNS; i++) {
            for (int j = 1; j <= COLUMN_WIDTH - 1; j++) {
                System.out.print(j);
            }
            System.out.print("0");
        }
    }
}
