/**********************************************************************************************
Write a method called append that accepts two integer arrays as parameters and returns a new
array that contains the result of appending the second array's values at the end of the first
array. For example, if arrays list1 and list2 store {2, 4, 6} and {1, 2, 3, 4, 5} respectively,
the call of append(list1, list2) should return a new array containing {2, 4, 6, 1, 2, 3, 4, 5}.
If the call instead had been append(list2, list1), the method would return an array containing
{1, 2, 3, 4, 5, 2, 4, 6}.
***********************************************************************************************/

public static int[] append(int[] a, int[] b) {
    int[] c = new int[a.length + b.length];
    for (int i = 0; i < a.length; i++) {
        c[i] = a[i];
    }
    for (int j = 0; j < b.length; j++) {
        c[a.length + j] = b[j];
    }
    return c;
}
