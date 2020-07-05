/**********************************************************************************************
Write a method contains3 that accepts a List of strings as a parameter and returns true if any
single string occurs at least 3 times in the list, and false otherwise. Use a map as auxiliary
storage.
***********************************************************************************************/

public static boolean contains3(List<String> list) {
    Iterator<String> i = list.iterator();
    Map<String, Integer> map = new HashMap<String, Integer>();
    
    while (i.hasNext()) {
        String word = i.next();
        if (map.containsKey(word)) {
            int count = map.get(word);
            map.put(word, count + 1);
            if (count + 1 == 3) {
                return true;
            }
        } else {
            map.put(word, 1);
        }
    }
    
    return false;
}
