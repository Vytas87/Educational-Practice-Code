/**********************************************************************************************
Write a method in the HeapIntPriorityQueue class called toArray that returns the elements of the
queue as a filled array. The order of the elements in the array is not important as long as all
elements from the queue are present in the array, with no extra empty slots before or afterward.
***********************************************************************************************/

public int[] toArray() {
    int[] a = new int[size()];
    for (int i = 0; i < a.length; i++) {
        a[i] = elementData[i+1]; // "+1" because the heap array is filled from index '1' to
                                 // to make the implementation easier with indexes
    }
    return a;
}
