/**********************************************************************************************
Write a complete Java program in a class named Spikey that prints the following output:
    
                      \/
                     \\//
                    \\\///
                    ///\\\
                     //\\
                      /\
                                      
***********************************************************************************************/

public class Spikey {
    public static void main(String[] args) {
        spikeyTop();
        spikeyBottom();
    }
    
    public static void spikeyTop() {
        for (int line = 1; line <= 3; line++) {
            for (int i = 1; i <= 3 - line; i++) {
                System.out.print(" ");
            }
            for (int i = 1; i <= line; i++) {
                System.out.print("\\");
            }
            for (int i = 1; i <= line; i++) {
                System.out.print("/");
            }
            System.out.println();
        }
    }
    
    public static void spikeyBottom() {
        for (int line = 1; line <= 3; line++) {
            for (int i = 1; i <= line - 1; i++) {
                System.out.print(" ");
            }
            for (int i = 1; i <= 4 - line; i++) {
                System.out.print("/");
            }
            for (int i = 1; i <= 4 - line; i++) {
                System.out.print("\\");
            }
          System.out.println();
        }
    }    
}
