/**********************************************************************************************
Write a method named readEntireFile that accepts a Scanner representing an input file as its
parameter, then reads that file and returns the entire text contents of that file as a String.
***********************************************************************************************/

public static String readEntireFile(Scanner input) {
    String file = "";
    while (input.hasNextLine()) {
        file += input.nextLine() + "\n";
    }
    
    return file;
}
