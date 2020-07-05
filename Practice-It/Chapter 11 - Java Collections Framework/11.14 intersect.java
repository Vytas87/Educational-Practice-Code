/**********************************************************************************************
Write a method intersect that takes two Maps of strings to integers as parameters and that
returns a new map whose contents are the intersection of the two. The intersection of two maps
is defined here as the set of keys and values that exist in both maps. So if some key K maps to
value V in both the first and second map, include it in your result. If K does not exist as a key
in both maps, or if K does not map to the same value V in both maps, exclude that pair from your
result. For example, consider the following two maps:

            {Janet=87, Logan=62, Whitaker=46, Alyssa=100, Stefanie=80, Jeff=88, Kim=52, Sylvia=95}
            {Logan=62, Kim=52, Whitaker=52, Jeff=88, Stefanie=80, Brian=60, Lisa=83, Sylvia=87}

Calling your method on the preceding maps would return the following new map (the order of the
key/value pairs does not matter):

            {Logan=62, Stefanie=80, Jeff=88, Kim=52}

***********************************************************************************************/

public static Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {

    Map<String, Integer> result = new HashMap<String, Integer>();
    Map<String, Integer> smallMap = map1.size() <= map2.size() ? map1 : map2;
    Map<String, Integer> largeMap = map1.size() <= map2.size() ? map2 : map1;
    
    Set<String> smallMapKeys = smallMap.keySet();
    for (String key: smallMapKeys) {
        if (largeMap.containsKey(key) && smallMap.get(key) == largeMap.get(key)) {
            result.put(key, smallMap.get(key));
        }
    }
    
    return result;
}
