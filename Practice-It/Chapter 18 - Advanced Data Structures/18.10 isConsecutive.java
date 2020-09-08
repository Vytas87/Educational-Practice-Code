/**********************************************************************************************
Write a method called isConsecutive that accepts a PriorityQueue of integers as a parameter and
returns true if the queue contains a sequence of consecutive integers starting from the front
of the queue. Consecutive integers are integers that come one after the other, as in 5, 6, 7, 8, 
9, etc., so if the queue stores [7, 8, 9, 10, 11], your method should return true. (Also return
true if passed an empty queue.) If your method modifies the state of the queue during its
computation, it should restore the queue before it returns. You may use one stack or queue as
auxiliary storage.
***********************************************************************************************/

public boolean isConsecutive (PriorityQueue<Integer> q) {
    int size = q.size();
    if (size == 0) {
        return true;
    } else {
        Deque<Integer> stack = new ArrayDeque<Integer>(size);
        boolean isConsecutive = true;
        int current = q.poll();
        stack.push(current);
        while (isConsecutive && q.peek() != null) {
            if (q.peek() - current != 1) {
                isConsecutive = false;
            } else {
                current = q.poll();
                stack.push(current);
            }
        }
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }
        return isConsecutive;
    }
}
