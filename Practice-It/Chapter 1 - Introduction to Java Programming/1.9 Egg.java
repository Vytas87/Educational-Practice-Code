/**********************************************************************************************
    Write a complete Java program in a class named Egg that displays the following output:

                      _______
                     /       \
                    /         \
                    -"-'-"-'-"-
                    \         /
                     \_______/

***********************************************************************************************/

public class Egg {
    public static void main(String[] args) {
        line();
        top();
        middle();
        bottom();
    }
    
    public static void line() {
        System.out.println("  _______");
    }
    
    public static void top() {
        for (int line = 1; line <= 2; line++) {
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
