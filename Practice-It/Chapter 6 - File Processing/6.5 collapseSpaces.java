/**********************************************************************************************
Write a static method named collapseSpaces that accepts a Scanner representing a file as a
parameter and writes that file's text to the console, with multiple spaces or tabs reduced to
single spaces between words that appear on the same line. For example, if a Scanner variable
named input is reading an input file containing the following text:

                    four      score   and

                    seven               years ago         our

                    fathers brought             forth
                        on this          continent
                    a         new

                    nation

then the call collapseSpaces(input); should produce the following output:

                    four score and

                    seven years ago our

                    fathers brought forth
                    on this continent
                    a new

                    nation

Each word is to appear on the same line in output as it appears in the file. Notice that lines
can be blank.
***********************************************************************************************/

public static void collapseSpaces(Scanner file) {
    String line;
    while (file.hasNextLine()) {
        line = file.nextLine();
        Scanner words = new Scanner(line);
        while (words.hasNext()) {
            System.out.print(words.next() + " ");
        }
        System.out.println();
    }
}
