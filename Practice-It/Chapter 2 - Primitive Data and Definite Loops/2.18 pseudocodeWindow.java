/**********************************************************************************************
Write a pseudocode algorithm that will produce the following figure as output:

                    +===+===+
                    |   |   |
                    |   |   |
                    |   |   |
                    +===+===+
                    |   |   |
                    |   |   |
                    |   |   |
                    +===+===+

***********************************************************************************************/

public class Window {
    public static final int SIZE = 3;
    
    public static void main(String[] args) {
        horizontalBar();
        verticalBars();
        horizontalBar();
        verticalBars();
        horizontalBar();
    }
    
    public static void horizontalBar() {
        print "+";
        on the same line, 2-times print "===+",
            where the number of "=" is equal to the SIZE;
        print a new line;
    }
    
    public static void verticalBars() {
        for the number of times SIZE, print the following lines:
            print "|";
            on the same line, 2-times print "   |",
                where the number of " " (spaces) is equal to the SIZE;
            print a new line;
    }
}
