/**********************************************************************************************
Write a method named inputStats that takes a Scanner representing a file as a parameter and that
reports various statistics about the file's text. In particular, your method should report the
number of lines in the file, the longest line, the number of tokens on each line, and the length
of the longest token on each line. You may assume that the input file has at least one line of
input and that each line has at least one token. For example, if a Scanner named input on file
carroll.txt contains the following text:

                    "Beware the Jabberwock, my son,
                    the jaws that bite, the claws that catch,
                    Beware the JubJub bird and shun
                    the frumious bandersnatch."

then the call inputStats(input); should produce the following output:

                    Line 1 has 5 tokens (longest = 11)
                    Line 2 has 8 tokens (longest = 6)
                    Line 3 has 6 tokens (longest = 6)
                    Line 4 has 3 tokens (longest = 14)
                    Longest line: the jaws that bite, the claws that catch,

***********************************************************************************************/

public static void inputStats(Scanner input) {
    String lineOfTokens;
    String longestLine = "";
    int lines = 0;
    
    while (input.hasNextLine()) {
        lines++;
        lineOfTokens = input.nextLine();
        if (lineOfTokens.length() > longestLine.length()) {
            longestLine = lineOfTokens;
        }
        Scanner line = new Scanner(lineOfTokens);
        
        String token;
        int tokens = 0;
        int longest = 0;
        while (line.hasNext()) {
            tokens++;
            token = line.next();
            if (token.length() > longest) {
                longest = token.length();
            }
        }
        
        System.out.println("Line " + lines + " has " + tokens + " tokens (longest = " + longest + ")");
    }
    
    System.out.println("Longest line: " + longestLine);
}
