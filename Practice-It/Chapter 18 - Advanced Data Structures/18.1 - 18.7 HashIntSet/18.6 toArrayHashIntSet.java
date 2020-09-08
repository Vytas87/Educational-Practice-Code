/**********************************************************************************************
Write a method in the HashIntSet class called toArray that returns the elements of the set as a
filled array. The order of the elements in the array is not important as long as all elements
from the set are present in the array, with no extra empty slots before or afterward.
***********************************************************************************************/

public int[] toArray() {
    int[] output = new int[size];
    int i = 0;
    for (Node node : elementData) {
        Node current = node;
        while (current != null) {
            output[i] = current.data;
            current = current.next;
            i++;
        }
    }
    return output;
}
