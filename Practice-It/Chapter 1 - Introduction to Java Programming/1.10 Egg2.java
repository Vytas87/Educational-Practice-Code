/**********************************************************************************************
Write a complete Java program in a class named Egg2 that generates the following output. Use
static methods to show structure and eliminate redundancy in your solution.

                      _______
                     /       \
                    /         \
                    \         /
                     \_______/
                    -"-'-"-'-"-
                      _______
                     /       \
                    /         \
                    \         /
                     \_______/
                    -"-'-"-'-"-
                    \         /
                     \_______/
                      _______
                     /       \
                    /         \
                    -"-'-"-'-"-
                    \         /
                     \_______/

***********************************************************************************************/

public class Egg2 {
    public static void main(String[] args) {
        top();
        bottom();
        middle();
        top();
        bottom();
        middle();
        bottom();
        top();
        middle();
        bottom();
    }
    
    public static void top() {
        for (int line = 0; line <= 2; line++) {
            if (line == 0) {
                System.out.println("  _______");
            }
            if (line != 0) {
                for (int i = 1; i <= 2 - line; i++) {
                    System.out.print(" ");
                }
                System.out.print("/");
                for (int i = 1; i <= 5 + 2 * line; i++) {
                    System.out.print(" ");
                }
                System.out.println("\\");
            }
        }
    }
    
    public static void middle() {
        for (int i = 1; i <= 2; i++) {
            System.out.print("-\"-'");
        }
        System.out.println("-\"-");
    }

    public static void bottom() {
        for (int line = 1; line <= 2; line++) {
            if (line != 2) {
                for (int i = 1; i <= line - 1; i++) {
                    System.out.print(" ");
                }
                System.out.print("\\");
                for (int i = 1; i <= 11 - 2 * line; i++) {
                    System.out.print(" ");
                }
                System.out.println("/");
            }
            if (line == 2) {
                for (int i = 1; i <= line - 1; i++) {
                    System.out.print(" ");
                }
                System.out.print("\\");
                for (int i = 1; i <= 11 - 2 * line; i++) {
                    System.out.print("_");
                }
                System.out.println("/");
            }
        }
    }
}
