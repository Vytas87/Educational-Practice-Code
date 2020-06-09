/**********************************************************************************************
Write a method named toBinary that accepts an integer as a parameter and returns a string of
that number's representation in binary. For example, the call of toBinary(42) should return
"101010".
***********************************************************************************************/

public static String toBinary(int x) {
    if (x == 0) {
        return "0";
    }
    
    String result = "";
    while (x != 0) {
        result = x % 2 + result;
        x = x / 2;
    }
    return result;
}
