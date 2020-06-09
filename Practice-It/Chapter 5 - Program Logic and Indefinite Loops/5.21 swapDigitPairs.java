/**********************************************************************************************
Write a method named swapDigitPairs that accepts a positive integer n as a parameter and returns
a new integer whose value is similar to n's but with each pair of digits swapped in order. For
example, the call of swapDigitPairs(482596) would return 845269. Notice that the 9 and 6 are
swapped, as are the 2 and 5, and the 4 and 8. If the number contains an odd number of digits,
leave the leftmost digit in its original place. For example, the call of swapDigitPairs(1234567)
would return 1325476. You should solve this problem without using a String.
***********************************************************************************************/

public static int swapDigitPairs(int n) {
    if (n / 10 == 0) {
        return n;
    }

    int newN = 0;
    int i = 1;
    
    while (n / 10 != 0) {
        int firstDigit = n % 10;
        int secondDigit = n % 100 / 10;
        n /= 100;
        newN += firstDigit * Math.pow(10, i) + secondDigit * Math.pow(10, i - 1);
        i += 2;
    }
    
    newN += n * Math.pow(10, i - 1);

    return newN;
}
