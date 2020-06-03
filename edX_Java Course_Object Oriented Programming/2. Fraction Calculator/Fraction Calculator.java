import java.util.Scanner;

public class FractionCalculator {
    public static void main (String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("This program is a fraction calculator.");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q (or q) to quit.");
        System.out.println("Valid operations are of the form \"[FRAC] [OPERATION] [FRAC]\".");
        System.out.println("[FRAC] can be of the form a/b, where a is any integer and b is any positive integer.");
        System.out.println("[OPERATION] can be +, -, /, * or =.");
        System.out.println("--------------------------------------------------------------------------------------------------");

        String entry = getEntry(console);

        while (!entry.equals("Q") && !entry.equals("q")) {

            Fraction f1 = fraction1(entry);
            String operation = operation(entry);
            Fraction f2 = fraction2(entry);

            switch (operation) {
                case "+":
                    System.out.println(f1 + " + " + f2 + " = " + f1.add(f2).toLowestTerms());
                    break;

                case "-":
                    System.out.println(f1 + " - " + f2 + " = " + f1.subtract(f2).toLowestTerms());
                    break;

                case  "*":
                    System.out.println(f1 + " * " + f2 + " = " + f1.multiply(f2).toLowestTerms());
                    break;

                case "/":
                    if (f2.getNumerator() == 0){ // division by 0 is undefined
                        System.out.println(f1 + " / " + f2 + " = Undefined");
                    } else {
                        System.out.println(f1 + " / " + f2 + " = " + f1.divide(f2).toLowestTerms());
                    }
                    break;

                case "=":
                    System.out.println(f1 + " = " + f2 + " is " + f1.equals(f2));
                    break;
            }

            System.out.println("--------------------------------------------------------------------------------------------------");
            entry = getEntry(console);
        }
    }

    public static String getEntry(Scanner console){

        System.out.print("Enter an operation (Q or q to quit): ");
        String entry = console.nextLine();

        while (!validEntry(entry)){
            System.out.println("Invalid operation. Must be \"[FRAC] [OPERATION] [FRAC]\".");
            System.out.println("--------------------------------------------------------------------------------------------------");
            System.out.print("Enter an operation (Q or q to quit): ");
            entry = console.nextLine();
        }

        return entry;
    }

    private static boolean validEntry(String input){
        // If entry is to quit
        if (input.equals("q") || input.equals("Q")){
            return true;
        // If there is no entry
        } else if (input.length() == 0){
            return false;
        }

        // The entry should only have two spaces
        int spaces = 0;

        for (int i = 0; i <= input.length() - 1; i++){
            if (input.charAt(i) == ' '){
                spaces++;
            }
        }

        if (spaces != 2){
            return false;
        }

        // The entry cannot start and/or end with a space, and the spaces cannot be adjacent
        int space1 = input.indexOf(" ");
        int space2 = input.lastIndexOf(" ");

        if (space1 == 0 || space2 == input.length() - 1 || space2 - space1 == 1 ){
            return false;
        }

        // The entry is now of the valid form. The contents has to be valid as well
        String fraction1 = input.substring(0, space1);
        String operation = input.substring(space1 + 1, space2);
        String fraction2 = input.substring(space2 + 1);

        return validFraction(fraction1) && validFraction(fraction2) && validOperation(operation);
    }

    private static boolean validFraction(String input){

        if (input.length() == 0){ // if no entry
            return false;

        } else if (!input.contains("/")){ // if entry is possibly a whole number
            if (input.charAt(0) == '-' && input.length() > 1) { // if negative
                input = input.substring(1);
                return isNumber(input);
            } else { // if non-negative
                return isNumber(input);
            }

        } else { // if entry is possibly a fraction

            int i = input.indexOf('/');

            if (input.charAt(0) == '-' && i == 1 || i == 0){ // non-empty numerator (in cases of the following entries:)
                return false;                                // 1) "-/ <...>" or 2) "/ <...>"

            } else if (i == input.length() - 1){ // non-empty denominator
                return false;

            } else {
                String n; // numerator
                if (input.charAt(0) == '-'){
                    n = input.substring(1, i); //  if negative numerator
                } else {
                    n = input.substring(0, i); // if non-negative numerator
                }
                String m = input.substring(i + 1); // denominator
                return isNumber(n) && isNumber(m) && !m.equals("0");
            }
        }
    }

    private static boolean isNumber(String input){

        String digit = "0123456789";

        int digitsFound = 0;
        for (int i = 0; i <= input.length() - 1; i++){
            for (int j = 0; j <= 9; j++){
                if (input.charAt(i) == digit.charAt(j)){
                    digitsFound++;
                }
            }
        }

        return digitsFound == input.length();
    }

    private static boolean validOperation(String input){

        return  input.equals("+") ||
                input.equals("-") ||
                input.equals("/") ||
                input.equals("*") ||
                input.equals("=");
    }

    private static Fraction fraction1 (String input){

        int space = input.indexOf(" ");
        String fraction1 = input.substring(0, space);

        return convertStringToFraction(fraction1);
    }

    private static Fraction fraction2 (String input){

        int space = input.lastIndexOf(" ");
        String fraction2 = input.substring(space + 1);

        return convertStringToFraction(fraction2);
    }

    private static Fraction convertStringToFraction (String input) {

        if (!input.contains("/")) {
            int numerator = Integer.parseInt(input);
            return new Fraction(numerator);

        } else {
            int j = input.indexOf('/');
            int numerator = Integer.parseInt(input.substring(0, j));
            int denominator = Integer.parseInt(input.substring(j + 1));
            return new Fraction(numerator, denominator);
        }
    }

    private static String operation (String input){

        int space1 = input.indexOf(" ");
        int space2 = input.lastIndexOf(" ");

        return input.substring(space1 + 1, space2);
    }
}
