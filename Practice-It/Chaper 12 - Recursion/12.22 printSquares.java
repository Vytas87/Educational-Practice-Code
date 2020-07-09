/**********************************************************************************************
Write a method printSquares that uses recursive backtracking to find all ways to express an in-
teger as a sum of squares of unique positive integers. For example, the call of printSquares(200);
should produce the following output:

                    1^2 + 2^2 + 3^2 + 4^2 + 5^2 + 8^2 + 9^2
                    1^2 + 2^2 + 3^2 + 4^2 + 7^2 + 11^2
                    1^2 + 2^2 + 5^2 + 7^2 + 11^2
                    1^2 + 3^2 + 4^2 + 5^2 + 6^2 + 7^2 + 8^2
                    1^2 + 3^2 + 4^2 + 5^2 + 7^2 + 10^2
                    2^2 + 4^2 + 6^2 + 12^2
                    2^2 + 14^2
                    3^2 + 5^2 + 6^2 + 7^2 + 9^2
                    6^2 + 8^2 + 10^2

Some numbers (such as 128 or 0) cannot be represented as a sum of squares, in which case your
method should produce no output. Keep in mind that the sum has to be formed with unique integers.
Otherwise you could always find a solution by adding 1^2 together until you got to whatever number
you are working with.

As with any backtracking problem, this one amounts to a set of choices, one for each integer whose
square might or might not be part of your sum. In many of our backtracking problems we store the
choices in some kind of collection. In this problem you can instead generate the choices by doing
a for loop over an appropriate range of numbers. Note that the maximum possible integer that can
be part of a sum of squares for an integer n is the square root of n.

Like with other backtracking problems, you still need to keep track of which choices you have
made at any given moment. In this case, the choices you have made consist of some group of inte-
gers whose squares may be part of a sum that will add up to n. Represent these chosen integers
as an appropriate collection where you add the integer i to the collection to consider it as
part of an answer. If you ever create such a collection whose values squared add up to n, you
have found a sum that should be printed.

To help you solve this problem, assume there already exists a method printHelper that accepts
any Java collection of integers (such as a list, set, stack, queue, etc.) and prints the collec-
tion's elements in order. For example, if a set s stores the elements [1, 4, 8, 11], the call of
printHelper(s); would produce the following output:

                    1^2 + 4^2 + 8^2 + 11^2

***********************************************************************************************/

public static void printSquares(int n) {
    if (n < 0) {
        throw new IllegalArgumentException("Error: Only positive integers can be expressed as a sum of other positive integers");
    }
    printSquares(n, 1, new TreeSet<Integer>());
}

public static void printSquares(int n, int index, TreeSet<Integer> squares) {
    if (n == 0) {
        printHelper(squares);
    } else {
        int max = (int) Math.sqrt(n);
        for (int i = index; i <= max; i++) {
            if (n - i * i >= 0) {
                squares.add(i);
                printSquares(n - i * i, i + 1, squares);
                squares.remove(i);
            }
        }
    }
}
