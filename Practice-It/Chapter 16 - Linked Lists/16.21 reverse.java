/**********************************************************************************************
Write a method reverse that reverses the order of the elements in the list. For example, if the
variable list initially stores this sequence of integers:

                    [1, 8, 19, 4, 17]

It should store the following sequence of integers after reverse is called:

                    [17, 4, 19, 8, 1]

Assume that you are adding this method to the LinkedIntList class as defined below:

                    public class LinkedIntList {
                        private ListNode front;   // null for an empty list
                        ...
                    }

***********************************************************************************************/

public void reverse() {
    if (front != null && front.next != null) {
        ListNode prev = front;
        ListNode curr = front.next;
        while (curr != null) {
            front.next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front.next;
        }
        front = prev;
    }
}
