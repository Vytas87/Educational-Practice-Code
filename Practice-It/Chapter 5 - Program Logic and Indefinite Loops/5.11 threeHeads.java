/**********************************************************************************************
Write a method named threeHeads that repeatedly flips a coin until three heads in a row are
seen. You should use a Random object to give an equal chance to a head or a tail appearing.
Each time the coin is flipped, what is seen is displayed (H for heads, T for tails). When 3
heads in a row are flipped a congratulatory message is printed. Here are possible outputs of
two calls to threeHeads:

                    T T T H T H H H
                    Three heads in a row!

***********************************************************************************************/

public static void threeHeads() {
    Random rnd = new Random();
    int count = 0;
    char flip = rnd.nextBoolean() ? 'T' : 'H';
    while (count < 3) {
        System.out.print(flip + " ");
        if (flip == 'H') {
            count++;
        } else {
            count = 0;
        }
        flip = rnd.nextBoolean() ? 'T' : 'H';
    }
    System.out.println();
    System.out.println("Three heads in a row!");
}
