/**********************************************************************************************
Write a method stretch that takes an integer n as a parameter and that increases a list of
integers by a factor of n by replacing each integer in the original list with n copies of that
integer. For example, if a variable called list stores this sequence of values:

                    [18, 7, 4, 24, 11]

And we make the following call:

                    list.stretch(3);

The list should store the following values after the method is called:

                    [18, 18, 18, 7, 7, 7, 4, 4, 4, 24, 24, 24, 11, 11, 11]

If the value of n is less than or equal to 0, the list should be empty after the call.

Assume that you are adding this method to the LinkedIntList class as defined below:

                    public class LinkedIntList {
                        private ListNode front;   // null for an empty list
                        ...

                        // your code goes here
                    }

***********************************************************************************************/

public void stretch(int n) {
    if (n <= 0) {
        front = null;
    } else {
        ListNode current = front;
        while (current != null) {
            for (int i = 1; i < n; i++) {
                ListNode copy = new ListNode(current.data, current.next);
                current.next = copy;
                current = current.next;
            }
            current = current.next;
        }
    }
}
