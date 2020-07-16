/**********************************************************************************************
Write a method equals that takes as parameters two stacks of integers and returns true if the
two stacks are equal and that returns false otherwise. To be considered equal, the two stack
would have to store the same sequence of integer values in the same order. Your method is to
examine the two stacks but must return them to their original state before terminating. You ma
use one stack as auxiliary storage.
***********************************************************************************************/

public static boolean equals(Stack<Integer> s, Stack<Integer> p) {
    Stack<Integer> temp = new Stack<Integer>();
    
    boolean equal = true;
    
    if (s.size() != p.size()) {
        equal = false;
    }
    
    while (equal && !s.isEmpty()) {
        if (s.peek() == p.peek()) {
            temp.push(s.pop());
            temp.push(p.pop());
        } else {
            equal = false;
        }
    }
    
    while (!temp.isEmpty()) {
        p.push(temp.pop());
        s.push(temp.pop());
    }
    
    return equal;
}
