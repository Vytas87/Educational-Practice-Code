/**********************************************************************************************
Write a method called wordLengths that accepts a Scanner representing an input file as its
argument. Your method should read from the given file, count the number of letters in each token
in the file, and output a result diagram of how many words contain each number of letters. Use
tabs before the asterisks so that they'll line up. If there are no words of a given length, omit
that line from the output.

For example, if the file contains the following text:

                    Before sorting:
                    13 23 480 -18 75
                    hello how are you feeling today

                    After sorting:
                    -18 13 23 75 480
                    are feeling hello how today you

your method should produce the following output to the console:

                    2: 6    ******
                    3: 10   **********
                    5: 5    *****
                    6: 1    *
                    7: 2    **
                    8: 2    **

You may assume that no token in the file is more than 80 characters in length.
***********************************************************************************************/

public static void wordLengths(Scanner file) {
    int[] wordCollate = new int[81];
    int letterCount;
    
    while (file.hasNext()) {
        wordCollate[file.next().length()]++;
    }
    
    for (int i = 0; i < 81; i++) {
        if (wordCollate[i] > 0) {
            System.out.print(i + ": " + wordCollate[i] + "\t");
            for (int j = 0; j < wordCollate[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
