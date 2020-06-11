/**********************************************************************************************
Modify the preceding wordWrap method into a new wordWrap2 method that accepts a second parameter
for a PrintStream to write the data, and outputs the newly wrapped text to that PrintStream
rather than to the console. Also, modify it to use a local variable to store the maximum line
length rather than hard-coding 60.
***********************************************************************************************/

public static void wordWrap2(Scanner input, PrintStream output) {
    String line;
    int maxLineLength = 60;
    while (input.hasNextLine()) {
        line = input.nextLine();
        while (line.length() > maxLineLength) {
            output.println(line.substring(0, maxLineLength));
            line = line.substring(maxLineLength);
        }
        output.println(line);
    }        
}
