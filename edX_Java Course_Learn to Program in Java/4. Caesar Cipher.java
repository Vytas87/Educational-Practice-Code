/**********************************************************************************************
    Slightly more challenging project for an introductory class. It takes in the text to be
    encoded and ciphers it by a given shift value (Caesar's Cipher). In addition, the program
    normalizes the text of off any punctuation marks and white space, then puts an "OB" in
    front of every vowel, then encodes the text by the shift value and, finally, groups it
    into "words" of given length.
    
    The commented code was given.
***********************************************************************************************/

import java.util.Scanner;

public class Crypto {
    public static void main(String[] args) {

        System.out.print("What is the text that you would like to be encrypted? ");
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        System.out.print("What is the integer number that should be used as a shift value in Caesar encryption? ");
        int k = input.nextInt();
        System.out.print("What is the integer number that should be used to group the encrypted text? ");
        int j = input.nextInt();

        encryptText(text, k, j);
    }

    public static String encryptText(String text, int k, int j) {
        String normalizedText = normalizeText(text);
        String obifiedText = obify(normalizedText);
        String caesarifiedText = caesarify(obifiedText, k);
        String groupifiedText = groupify(caesarifiedText, j);
        return groupifiedText;
    }

    public static String normalizeText(String text) {

        text = text.replace(" ", "");
        text = text.replace(".", "");
        text = text.replace(",", "");
        text = text.replace(":", "");
        text = text.replace(";", "");
        text = text.replace("'", "");
        text = text.replace("\"", "");
        text = text.replace("!", "");
        text = text.replace("?", "");
        text = text.replace("(", "");
        text = text.replace(")", "");

        String normalizedText = text.toUpperCase();

        return normalizedText;
    }

    public static String obify(String normalizedText) {

        String temp;
        String obifiedText = "";

        for (int i = 0; i <= normalizedText.length() - 1; i++) {

            if (normalizedText.substring(i, i+1).equals("A") ||
                    normalizedText.substring(i, i+1).equals("E") ||
                    normalizedText.substring(i, i+1).equals("I") ||
                    normalizedText.substring(i, i+1).equals("O") ||
                    normalizedText.substring(i, i+1).equals("U") ||
                    normalizedText.substring(i, i+1).equals("Y")) {
                temp = "OB" + normalizedText.substring(i, i+1);
            } else {
                temp = normalizedText.substring(i, i+1);
            }

            obifiedText += temp;
        }

        return obifiedText;
    }

    public static String caesarify(String obifiedText, int k) {

        String caesarifiedText = "";

        for (int i = 0; i <= obifiedText.length() - 1; i++) {
            int index = shiftAlphabet(0).indexOf(obifiedText.substring(i, i + 1));
            char caesarifiedChar = shiftAlphabet(k).charAt(index);
            caesarifiedText = caesarifiedText + caesarifiedChar;
        }

        return caesarifiedText;
    }

    // This method was provided
    public static String shiftAlphabet(int shift) {

        int start;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }

        String result = "";
        char currChar = (char) start;

        for (; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }

        if (result.length() < 26) {
            for (currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }

        return result;
    }

    public static String groupify (String caeserifiedText, int j) {

        String groupifiedText = caeserifiedText.substring(0, j);
        int n = caeserifiedText.length();

        for (int i = 1; i < n/j; i++) {
            groupifiedText = groupifiedText + " " + caeserifiedText.substring(i * j, (i + 1) * j);
        }

        if (n%j != 0) {
            int m = j - n%j;
            String x = "";
            for (int i = 1; i <= m; i++) {
                x = x + "x";
            }
            groupifiedText = groupifiedText + " " + caeserifiedText.substring(n - n % j) + x;
        }

        System.out.println(groupifiedText);
        return groupifiedText;
    }
}
