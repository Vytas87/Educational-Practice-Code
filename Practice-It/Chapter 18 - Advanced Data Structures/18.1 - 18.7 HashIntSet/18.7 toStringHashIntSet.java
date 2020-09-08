/**********************************************************************************************
Write a method in the HashIntSet class called toString that returns a string representation of
the elements in the set, such as "[-2, 3, 5, 6, 8]". The order of the elements in the string
does not matter as long as they are all present in the proper format. Do not use any other
auxiliary collections to help you. Do not list any empty or meaningless indexes in the string.
Do not modify the state of the set.
***********************************************************************************************/

public String toString() {
    StringBuilder result = new StringBuilder("[");
    boolean first = true;
    for (Node node : elementData) {
        Node current = node;
        while (current != null) {
            if (!first) {
                result.append(", ");
            }
            result.append(current.data);
            first = false;
            current = current.next;
        }
    }
    result.append("]");
    return new String(result);
}
