/**********************************************************************************************
Write a method isPalindrome that takes a queue of integers as a parameter and returns true if
the numbers in the queue represent a palindrome (and false otherwise). A sequence of numbers is
considered a palindrome if it is the same in reverse order. For example, suppose a queue called
q stores these values:

                    front [3, 8, 17, 9, 17, 8, 3] back

Then the call of isPalindrome(q); should return true because this sequence is the same in
reverse order. If the queue had instead stored these values:

                    front [3, 8, 17, 9, 4, 17, 8, 3] back

The call on isPalindrome would instead return false because this sequence is not the same in
reverse order (the 9 and 4 in the middle don't match). The empty queue should be considered a
palindrome. You may not make any assumptions about how many elements are in the queue and your
method must restore the queue so that it stores the same sequence of values after the call as
it did before. You may use one stack as auxiliary storage.
***********************************************************************************************/

public static boolean isPalindrome(Queue<Integer> q) {
    Stack<Integer> s = new Stack<Integer>();
    int size = q.size();
    
    for (int i = 0; i < size; i++) {
        int num = q.remove();
        s.push(num);
        q.add(num);
    }
    
    boolean isPalindrome = true;
    while (!s.isEmpty()) {
        int num = q.remove();
        if (s.pop() != num) {
            isPalindrome = false;
        }
        q.add(num);
    }
    
    return isPalindrome;
}
