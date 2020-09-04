/**********************************************************************************************
Write a method stutter that doubles the size of a list by replacing every integer in the list
with two of that integer. For example, suppose a variable list stores the following sequence of
integers:

                    [1, 8, 19, 4, 17]

After a call of list.stutter(), it should store the following sequence of integers:

                    [1, 1, 8, 8, 19, 19, 4, 4, 17, 17]

Assume that you are adding this method to the LinkedIntList class as defined below:

                    public class LinkedIntList {
                        private ListNode front;   // null for an empty list
                        ...
                    }

***********************************************************************************************/

public void stutter() {
    ListNode current = front;
    while (current != null) {
        ListNode copy = new ListNode(current.data, current.next);
        current.next = copy;
        current = current.next.next;
    }
}
