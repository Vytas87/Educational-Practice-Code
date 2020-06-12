/**********************************************************************************************
Write a static method named vowelCount that accepts a String as a parameter and returns an array
of integers representing the counts of each vowel in the String. The array returned by your
method should hold 5 elements: the first is the count of As, the second is the count of Es, the
third Is, the fourth Os, and the fifth Us. Assume that the string contains no uppercase letters.

For example, the call vowelCount("i think, therefore i am") should return the array {1, 3, 3, 1, 0}.
***********************************************************************************************/

public static int[] vowelCount(String s) {
    int[] vowels = new int[5];
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == 'a' ) {
            vowels[0]++;
        } else if (s.charAt(i) == 'e' ) {
            vowels[1]++;
        } else if (s.charAt(i) == 'i' ) {
            vowels[2]++;
        } else if (s.charAt(i) == 'o' ) {
            vowels[3]++;
        } else if (s.charAt(i) == 'u' ) {
            vowels[4]++;
        }
    }
    return vowels;
}
