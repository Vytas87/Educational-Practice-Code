/**********************************************************************************************
Write a complete program called "TheNameGame", where the user inputs a first and last name and
a song in the following format is printed about their first, then last, name. Use a method to
avoid redundancy.

                    What is your name? Fifty Cent
                    Fifty Fifty, bo-Bifty
                    Banana-fana fo-Fifty
                    Fee-fi-mo-Mifty
                    FIFTY!

                    Cent Cent, bo-Bent
                    Banana-fana fo-Fent
                    Fee-fi-mo-Ment
                    CENT!

***********************************************************************************************/

public class TheNameGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("What is your name? ");
        String fullName = input.nextLine();
        
        int index = fullName.indexOf(" ");
        String frstName = fullName.substring(0, index);
        String lstName = fullName.substring(index + 1);
        
        song(frstName);
        song(lstName);
    }
    
    public static void song(String word) {
        System.out.println(word + " " + word + ", bo-B" + word.substring(1));
        System.out.println("Banana-fana fo-F" + word.substring(1));
        System.out.println("Fee-fi-mo-M" + word.substring(1));
        System.out.println(word.toUpperCase() + "!");
        System.out.println();
    }
}
