/**********************************************************************************************
Write a method called removeDuplicates that accepts a PriorityQueue of integers as a parameter
and modifies the queue's state so that any element that is equal to another element in the queue
is removed. For example, if the queue stores [7, 7, 8, 8, 8, 10, 45, 45], your method should
modify the queue to store [7, 8, 10, 45]. You may use one stack or queue as auxiliary storage.
***********************************************************************************************/

public void removeDuplicates(PriorityQueue<Integer> q) {
    ArrayDeque<Integer> stack = new ArrayDeque<Integer>(q.size());
    while (!q.isEmpty()) {
        if (stack.peek() != q.peek()) {
            stack.push(q.poll());
        } else {
            q.poll();
        }
    }
    while (!stack.isEmpty()) {
        q.add(stack.pop());
    }
