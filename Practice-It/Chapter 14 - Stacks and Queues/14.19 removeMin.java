/**********************************************************************************************
Write a method removeMin that accepts a Stack of integers as a parameter and removes and returns
the smallest value from the stack. For example if a variable s stores these values:

                    bottom [2, 8, 3, 19, 7, 3, 2, 3, 2, 7, 12, -8, 4] top

and we make the following call:

                    int n = removeMin(s);

The method removes and returns -8, so n will store -8 after the call and s will store the
following values:

                    bottom [2, 8, 3, 19, 7, 3, 2, 3, 2, 7, 12, 4] top

If the minimum value appears more than once, all occurrences of it should be removed. For
example, given the stack above, if we again call removeMin(s), it would return 2 and leave the
stack as follows:

                    bottom [8, 3, 19, 7, 3, 3, 7, 12, 4] top

You may use one queue as auxiliary storage. You may not use any other structures to solve this
problem, although you can have as many primitive variables as you like. You may not solve the
problem recursively.
***********************************************************************************************/

public static int removeMin(Stack<Integer> s) {
    Queue<Integer> q = new LinkedList<Integer>();
    int min = s.peek();
    
    while (!s.isEmpty()) {
        int num = s.pop();
        if (num < min) {
            min = num;
        }
        q.add(num);
    }
    
    while (!q.isEmpty()) {
        int num = q.remove();
        if (num != min) {
            s.push(num);
        }
    }
    
    s2q(s, q);
    q2s(q, s);
    
    return min;
}
