/**********************************************************************************************
Write a method called stdev that returns the standard deviation of an array of integers. Stan-
dard deviation is computed by taking the square root of the sum of the squares of the differen-
ces between each element and the mean, divided by one less than the number of elements.

More concisely and mathematically, the standard deviation of an array a is written as follows:

                                    a.length - 1
                    stdev(a) = sqrt(    SUM    (a[i] - average(a))^2 / (a.length - 1))
                                         0

For example, if the array passed contains the values {1, -2, 4, -4, 9, -6, 16, -8, 25, -10}, your
method should return approximately 11.237. You may assume that the array passed is non-null and
contains at least two values, because the standard deviation is undefined otherwise.
***********************************************************************************************/

public static double stdev(int[] a) {
    int sum = 0;
    for (int i = 0; i < a.length; i++) {
        sum += a[i];
    }
    
    double mean = 1.0 * sum / a.length;
    
    double nominator = 0.0;
    for (int i = 0; i < a.length; i++) {
        nominator += Math.pow((a[i] - mean), 2);
    }
    
    return Math.sqrt(nominator / (a.length - 1));
}
