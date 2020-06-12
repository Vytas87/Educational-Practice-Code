/**********************************************************************************************
Write a method called isMagicSquare that accepts a two-dimensional array of integers as a
parameter and returns true if it is a magic square. A square matrix is a magic square if it is
square in shape (same number of rows as columns, and every row the same length), and all of its
row, column, and diagonal sums are equal. For example, [[2, 7, 6], [9, 5, 1], [4, 3, 8]] is a
magic square because all eight of the sums are exactly 15.
***********************************************************************************************/

public static boolean isMagicSquare(int[][] a) {
    for (int i = 0; i < a.length; i ++) {
        if (a[i].length != a.length) {
            return false;
        }
    }

    int sum = 0;
    int size = a.length;

    for (int i = 0; i < size; i++) {
        sum += a[0][i];
    }

    int temp = 0;

    for (int i = 1; i < size; i++) {
        for (int j = 0; j < size; j++) {
            temp += a[i][j];
        }
        if (temp != sum) {
            return false;
        }
        temp = 0;
    }

    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            temp += a[j][i];
        }
        if (temp != sum) {
            return false;
        }
        temp = 0;
    }

    for (int i = 0; i < size; i++) {
        temp += a[i][i];
    }
    if (temp != sum) {
        return false;
    }
    temp = 0;

    for (int i = 0; i < size; i++) {
        temp += a[(size - 1) - i][i];
    }
    if (temp != sum) {
        return false;
    }

    return true;
}
