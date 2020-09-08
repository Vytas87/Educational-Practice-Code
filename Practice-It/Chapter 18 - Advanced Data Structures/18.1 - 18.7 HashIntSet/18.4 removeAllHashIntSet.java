/**********************************************************************************************
Write a method in the HashIntSet class called removeAll that accepts another hash set as a
parameter and ensures that this set does not contain any of the elements from the other set. For
example, if the set stores [-2, 3, 5, 6, 8] and the method is passed [2, 3, 6, 8, 11], your set
would store [-2, 5] after the call.
***********************************************************************************************/

public void removeAll(HashIntSet other) {
    for (Node node : other.elementData) {
        Node current = node;
        while (current != null) {
            if (contains(current.data)) {
                remove(current.data);
            }
            current = current.next; // the node itself with the data value to be removed is not removed,
                                    // so it still works to use the pointer from it to move to the next value
        }
    }
}
