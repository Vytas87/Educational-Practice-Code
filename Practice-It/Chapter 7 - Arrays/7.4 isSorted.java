/**********************************************************************************************
Write a static method named isSorted that accepts an array of doubles as a parameter and returns
true if the list is in sorted (nondecreasing) order and false otherwise. For example, if arrays
named list1 and list2 store {16.1, 12.3, 22.2, 14.4} and {1.5, 4.3, 7.0, 19.5, 25.1, 46.2} res-
pectively, the calls isSorted(list1) and isSorted(list2) should return false and true respec-
tively. Assume the array has at least one element. A one-element array is considered to be sorted.
***********************************************************************************************/

public static boolean isSorted(double[] a) {
    if (a.length == 1) {
        return true;
    } else {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i + 1] < a[i]) {
                return false;
            }
        }
    }
    return true;
}
