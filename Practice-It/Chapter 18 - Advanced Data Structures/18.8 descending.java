/**********************************************************************************************
Write a method called descending that accepts an array of integers and rearranges the integers
in the array to be in descending order using a PriorityQueue as a helper. For example, if the
array passed stores [42, 9, 22, 17, -3, 81], after the call the array should store
[81, 42, 22, 17, 9, -3].
***********************************************************************************************/

public void descending(int[] array) {
    int size = array.length;
    if (size > 0) {
        Queue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 0; i < size; i++) {
            queue.add(array[i]);
        }
        /*
            The following loop fills in the array from the back
            because the values returned from the priority queue
            come in ascending order.
            
            It would be possible to fill in the array from the
            beginning, but then the priority queue has to be
            created with a reverse comparator passed in (as in
            Queue<Integer> queue = new PriorityQueue<Integer>(
            size, Collections.reverseOrder());) to make it a
            max-heap.
        */
        for (int i = size - 1; i >= 0; i--) {
            array[i] = queue.poll();
        }
    }
}
