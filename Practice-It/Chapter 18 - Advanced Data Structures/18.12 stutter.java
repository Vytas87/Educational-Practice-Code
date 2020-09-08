/**********************************************************************************************
Write a method called stutter that accepts a PriorityQueue of integers as a parameter and
replaces every value in the queue with two occurrences of that value. For example, if the queue
stores [7, 8, 10, 45], your method should modify the queue to store [7, 7, 8, 8, 10, 10, 45, 45].
You may use one stack or queue as auxiliary storage.
***********************************************************************************************/

public void stutter(PriorityQueue<Integer> q) {
    ArrayDeque<Integer> stack = new ArrayDeque(q.size());
    while (!q.isEmpty()) {
        stack.push(q.poll());
    }
    while (!stack.isEmpty()) {
        int current = stack.pop();
        q.add(current);
        q.add(current);
    }
}
