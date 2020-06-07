/**********************************************************************************************
Write a method called stutter that accepts a parameter and returns the String with its
characters returns repeated twice. For example, stutter("Hello!") returns "HHeelllloo!!"
***********************************************************************************************/

public static String stutter(String input) {
    String result = "";
    for (int i = 0; i < input.length(); i++) {
        result += input.charAt(i);
        result += input.charAt(i);
    }
    return result;
}
