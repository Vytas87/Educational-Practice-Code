/**********************************************************************************************
Write a method named hopscotch that accepts an integer parameter for a number of "hops" and
prints a hopscotch board of that many hops. A "hop" is defined as the split into two numbers
and then back together again into one. For example, hopscotch(3); should print:

                       1
                    2     3
                       4
                    5     6
                       7
                    8     9
                       10

***********************************************************************************************/

public static void hopscotch(int n) {
    for (int i = 1; i <= n; i++) {
        System.out.println("   " + (3 * i - 2));
        System.out.println((3 * i - 1) + "     " + 3 * i);
    }
    System.out.println("   " + (3 * n + 1));
}
