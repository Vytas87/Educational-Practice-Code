/**********************************************************************************************
Write a method named randomX that keeps printing lines, where each line contains a random number
of x characters between 5 and 19 inclusive, until it prints a line with 16 or more characters.
For example, the output from your method might be the following. Notice that the last line has
17 x characters.

                    xxxxxxx
                    xxxxxxxxxxxxx
                    xxxxxx  
                    xxxxxxxxxxx
                    xxxxxxxxxxxxxxxxx

***********************************************************************************************/

public static void randomX() {
    Random random = new Random();
    int n = 0;
    while (n <= 16) {
        n = random.nextInt(15) + 5;
        for (int i = 1; i <= n; i++) {
            System.out.print("x");
        }
        System.out.println();
    }
}
