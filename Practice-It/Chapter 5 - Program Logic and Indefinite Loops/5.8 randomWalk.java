/**********************************************************************************************
Write a method named randomWalk that performs a random one-dimensional walk, reporting each
position reached and the maximum position reached during the walk. The random walk should begin
at position 0. On each step, you should either increase or decrease the position by 1 (with equal
probability). The walk stops when 3 or -3 is hit. The output should look like this:

                    position = 0
                    position = 1
                    position = 0
                    position = -1
                    position = -2
                    position = -1
                    position = -2
                    position = -3
                    max position = 1

***********************************************************************************************/

public static void randomWalk() {
    Random random = new Random();
    int max = 0;
    int position = 0;
    int step;
    int rnd;
    System.out.println("position = " + position);
    while (position != 3 && position != -3) {
        rnd = random.nextInt(2);
        if (rnd == 0) {
            step = 1;
        } else {
            step = -1;
        }
        position += step;
        System.out.println("position = " + position);
        if (position > max) {
            max = position;
        }
    }
    System.out.println("max position = " + max);
}
