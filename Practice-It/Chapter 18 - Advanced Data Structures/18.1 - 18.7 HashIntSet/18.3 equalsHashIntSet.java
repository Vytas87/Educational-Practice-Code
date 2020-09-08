/**********************************************************************************************
Write a method in the HashIntSet class called equals that accepts another object as a parameter
and returns true if the object is another HashIntSet that contains exactly the same elements.
The internal hash table size and ordering of the elements does not matter, only the sets of
elements themselves.
***********************************************************************************************/

public boolean equals(Object other) {
    if (other instanceof HashIntSet) {
        HashIntSet o = (HashIntSet) other;
        for (Node node : o.elementData) {
            Node current = node;
            while (current != null) {
                if (!contains(current.data)) {
                    return false;
                }
                current = current.next;
            }
        }
        for (Node node : elementData) {
            Node current = node;
            while (current != null) {
                if (!o.contains(current.data)) {
                    return false;
                }
                current = current.next;
            }
        }
        return true;
    } else {
        return false;
    }
}
