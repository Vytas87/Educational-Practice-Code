/**********************************************************************************************
Write a method maxOccurrences that accepts a List of integers as a parameter and returns the
number of times the most frequently occurring integer (the "mode") occurs in the list. Solve
this problem using a Map as auxiliary storage. If the list is empty, return 0.
***********************************************************************************************/

public static int maxOccurrences(List<Integer> list) {
    if (list.size() == 0) {
        return 0;
    } else {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer i : list) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        
        Collection<Integer> values = map.values();
        Iterator<Integer> iterator = values.iterator();
        int maxOccur = 0;
        while (iterator.hasNext()) {
            int current = iterator.next();
            if (current > maxOccur) {
                maxOccur = current;
            }
        }
        
        return maxOccur;
    }
}
