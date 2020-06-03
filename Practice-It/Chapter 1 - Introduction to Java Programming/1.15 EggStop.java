/**********************************************************************************************
Write a complete Java program in a class named EggStop that generates the following output. Use
static methods to show structure and eliminate redundancy in your solution.

                      ______
                     /      \
                    /        \
                    \        /
                     \______/

                      ______
                     /      \
                    /        \
                    \        /
                     \______/
                    +--------+

                      ______
                     /      \
                    /        \
                    |  STOP  |
                    \        /
                     \______/
                    +--------+

***********************************************************************************************/

public class EggStop {
    public static void main(String[] args) {
        top();
        bottom();
        System.out.println("");
        top();
        bottom();
        middle();
        System.out.println("");
        top();
        stop();
        bottom();
        middle();
    }
    
    public static void top() {
        for (int line = 0; line <= 2; line++) {
            if (line == 0) {
                System.out.println("  ______");
            }
            if (line != 0) {
                for (int i = 1; i <= 2 - line; i++) {
                    System.out.print(" ");
                }
                System.out.print("/");
                for (int i = 1; i <= 4 + 2 * line; i++) {
                    System.out.print(" ");
                }
                System.out.println("\\");
            }
        }
    }
    
    public static void middle() {
        System.out.println("+--------+");
    }
    
    public static void stop() {
        System.out.println("|  STOP  |");
    }    

    public static void bottom() {
        for (int line = 1; line <= 2; line++) {
            if (line != 2) {
                System.out.print("\\");
                for (int i = 1; i <= 10 - 2 * line; i++) {
                    System.out.print(" ");
                }
                System.out.println("/");
            }
            if (line == 2) {
                for (int i = 1; i <= line - 1; i++) {
                    System.out.print(" ");
                }
                System.out.print("\\");
                for (int i = 1; i <= 10 - 2 * line; i++) {
                    System.out.print("_");
                }
                System.out.println("/");
            }
        }
    }
}
