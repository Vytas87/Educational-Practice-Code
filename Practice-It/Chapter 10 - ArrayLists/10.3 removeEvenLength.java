/**********************************************************************************************
Write a method removeEvenLength that takes an ArrayList of Strings as a parameter and that
removes all of the strings of even length from the list.
***********************************************************************************************/

public static ArrayList<String> removeEvenLength (ArrayList<String> list) {
    for(int i = list.size() - 1; i >= 0; i--) {
        if (list.get(i).length() % 2 == 0) {
            list.remove(i);
        }
    }
    return list;
}
