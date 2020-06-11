/**********************************************************************************************
Write a method called stripComments that accepts a Scanner representing an input file containing
a Java program as its parameter, reads that file, and then prints the file's text with all com-
ments removed. A comment is any text on a line from // to the end of the line, and any text be-
tween /* and */ characters. For example, consider the following text:

                    import java.util.*;
                    /* My program
                    by Suzy Student */
                    public class Program {
                        public static void main(String[] args) {
                            System.out.println("Hello, world!"); // a println
                        }

                        public static /* Hello there */ void foo() {
                            System.out.println("Goodbye!"); // comment here
                        } /* */
                    }

If the file contained this text, your program should output the following text:

                    import java.util.*;

                    public class Program {
                        public static void main(String[] args) {
                            System.out.println("Hello, world!");
                        }

                        public static  void foo() {
                            System.out.println("Goodbye!");
                        }
                    }

***********************************************************************************************/

public static void stripComments(Scanner input) {
    String line;
    while (input.hasNextLine()) {
        line = input.nextLine();
        int start;
        int end;
        if (line.startsWith("/*")) {
            while (!line.endsWith("*/")) {
                line = input.nextLine();
            }
            line = "";
        } else if (line.contains("/*")) {
            start = line.indexOf("/*");
            end = line.indexOf("*/");
            line = line.substring(0, start) + line.substring(end + 2);
        } else if (line.contains("//")) {
            start = line.indexOf("//");
            line = line.substring(0, start);
        }
        System.out.println(line);
    }
}
