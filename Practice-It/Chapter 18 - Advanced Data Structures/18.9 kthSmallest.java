/**********************************************************************************************
Write a method called kthSmallest that accepts a PriorityQueue of integers and an integer k as
parameters and returns the kth-smallest integer from the priority queue (where k=1 would
represent the very smallest). For example, if the queue passed stores the integers
[42, 50, 45, 78, 61] and k is 4, return the fourth-smallest integer, which is 61. If k is 0 or
negative or greater than the size of the queue, throw an IllegalArgumentException. If your
method modifies the state of the queue during its computation, it should restore the queue
before it returns. You may use one stack or queue as auxiliary storage.
***********************************************************************************************/

public int kthSmallest(PriorityQueue<Integer> set, int k) {
    if (k <= 0 || k > set.size()) {
        throw new IllegalArgumentException();
    }
    Deque<Integer> stack = new ArrayDeque(set.size());
    int i = 1;
    while (i < k) {
        stack.push(set.poll());
        i++;
    }
    int result = set.peek();
    while (!stack.isEmpty()) {
        set.add(stack.pop());
    }
    return result;
}
