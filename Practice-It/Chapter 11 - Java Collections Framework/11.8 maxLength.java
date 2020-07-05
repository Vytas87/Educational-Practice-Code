/**********************************************************************************************
Write a method maxLength that takes a Set of strings as a parameter and that returns the length
of the longest string in the set. If your method is passed an empty set, it should return 0.
***********************************************************************************************/

public static int maxLength(Set<String> s) {
    Iterator<String> i = s.iterator();
    int maxLength = 0;
    while (i.hasNext()) {
        String word = i.next();
        if (word.length() > maxLength) {
            maxLength = word.length();
        }
    }
    
    return maxLength;
}
