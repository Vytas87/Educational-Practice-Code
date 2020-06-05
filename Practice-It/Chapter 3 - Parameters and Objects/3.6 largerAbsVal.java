/**********************************************************************************************
Write a method called largerAbsVal that takes two integers as parameters and returns the larger
of the two absolute values. A call of largerAbsVal(11, 2) would return 11, and a call of
largerAbsVal(4, -5) would return 5.
***********************************************************************************************/

public static int largerAbsVal(int a, int b) {
    if (a < 0) {
        a = -a;
    }
    if (b < 0) {
        b = -b;
    }
    if (a <= b) {
        return b;
    } else {
        return a;
    }
}
