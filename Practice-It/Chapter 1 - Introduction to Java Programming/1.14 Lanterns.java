/**********************************************************************************************
Write a complete Java program in a class named Lanterns that generates the following three
figures of output. Use static methods to show structure and eliminate redundancy in your
solution.

In particular, make sure that main contains no System.out.println statements except for blank
lines, that any System.out.println statement(s) repeated are captured in a method that is called
just once, and that the same System.out.println statement never appears in two places in the code.

                        *****
                      *********
                    *************

                        *****
                      *********
                    *************
                    * | | | | | *
                    *************
                        *****
                      *********
                    *************

                        *****
                      *********
                    *************
                        *****
                    * | | | | | *
                    * | | | | | *
                        *****
                        *****

***********************************************************************************************/

public class Lanterns {
    public static void main(String[] args) {
        starCone();
        emptyLine();
        starCone();
        barLine();
        starLineLong();
        starCone();
        emptyLine();
        starCone();
        starLineShort();
        barLine();
        barLine();
        starLineShort();
        starLineShort();
    }
    
    public static void starCone() {
        for (int line = 1; line <= 3; line++) {
            for (int i = 1; i <= 2 * (3 - line); i++) {
                System.out.print(" ");
            }
            for (int i = 2 * (3 - line) + 1; i <= 13 - 2 * (3 - line); i++) {
                System.out.print("*");
            }
            emptyLine();
        }
    }
    
    public static void emptyLine() {
        System.out.println("");
    }

    public static void barLine() {
        System.out.println("* | | | | | *");
    }
    
    public static void starLineLong() {
        System.out.println("*************");
    }

    public static void starLineShort() {
        System.out.println("    *****");
    }
}
