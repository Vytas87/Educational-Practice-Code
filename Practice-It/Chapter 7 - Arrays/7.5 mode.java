/**********************************************************************************************
Write a method called mode that returns the most frequently occurring element of an array of
integers. Assume that the array has at least one element and that every element in the array
has a value between 0 and 100 inclusive. Break ties by choosing the lower value.

For example, if the array passed contains the values {27, 15, 15, 11, 27}, your method should
return 15.
***********************************************************************************************/

public static int mode(int[] a) {
    int[] tally = new int[101];
    
    for (int i = 0; i < a.length; i++) {
        tally[a[i]]++;
    }
    
    int mode = 0;
    for (int i = 1; i < 101; i++) {
        if (tally[i] > tally[mode]) {
            mode = i;
        }
    }
    return mode;
}
